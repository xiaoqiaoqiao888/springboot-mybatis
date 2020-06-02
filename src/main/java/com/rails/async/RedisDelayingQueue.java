package com.rails.async;

import java.lang.reflect.Type;
import java.util.Set;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;

import redis.clients.jedis.Jedis;

public class RedisDelayingQueue<T> {

	static class Taskitem<T> {
		public String id;
		public T msg;
	}

	private Jedis jedis;
	private String queueKey;
	private Type TaskType = new TypeReference<Taskitem<T>>() {
	}.getType(); // 自定义序列化转换对象

	public RedisDelayingQueue(Jedis jedis, String queueKey) {
		this.jedis = jedis;
		this.queueKey = queueKey;
	}

	// 延时任务的时间单位为秒
	public void delay(T msg, Integer delayTime) {
		Taskitem<T> task = new Taskitem<T>();
		task.id = UUID.randomUUID().toString();
		task.msg = msg;
		String s = JSON.toJSONString(task);
		jedis.zadd(queueKey, System.currentTimeMillis() + delayTime * 1000, s);
	}

	@SuppressWarnings("unused")
	public void loop() {
		while (true || !Thread.interrupted()) {
			Set<String> values = jedis.zrangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
			if (values.isEmpty()) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					break;
				}
				continue;
			}
			String s = values.iterator().next();
			if (jedis.zrem(queueKey, s) > 0) {
				Taskitem<T> taskitem = JSON.parseObject(s, TaskType);
				handleMsg(taskitem.msg);
			}
		}
	}

	public void handleMsg(T msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		// 连接redis
		Jedis jedis = new Jedis("localhost");
		// jedis.auth("123456");
		RedisDelayingQueue<String> queue = new RedisDelayingQueue<>(jedis, "delayQueue");
		// 生产者
		Thread product = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					queue.delay("redis" + i, 5);
				}
			}
		};
		// 消费者
		Thread consume = new Thread() {
			@Override
			public void run() {
				queue.loop();
			}
		};
		product.start();
		consume.start();
		try {
			product.join();
			Thread.sleep(6000);
			consume.interrupt(); // 关闭消费者线程
			consume.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
