package com.rails.async;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;

import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicates;

/**
 * Created by wanggenshen Date: on 2019/1/4 00:42. Description: XXX
 */
public class Test {

	static Retryer<Boolean> retryer;

	static {
		retryer = RetryerBuilder.<Boolean>newBuilder().retryIfException() // 抛出异常会进行重试
				.retryIfResult(Predicates.equalTo(null)) // 如果接口返回的结果不符合预期,也需要重试
				.retryIfResult(Predicates.equalTo("".equals(""))) // 如果接口返回的结果不符合预期,也需要重试
				.withWaitStrategy(WaitStrategies.fibonacciWait(2, 2, TimeUnit.SECONDS)) // 重试策略,
				.withStopStrategy(StopStrategies.stopAfterAttempt(8)) // 重试次数
				.build();
	}

	@Async
	public boolean notify(String fileName) {
		try {

			return retryer.call(new Callable<Boolean>() {
				int count = 1;

				@Override
				public Boolean call() throws Exception {

					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
					Date date = new Date();
					System.out.println("第" + count++ + "次通知，时间为：" + sf.format(date));
					int i = 1 / 0;
					return i == 1;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static void main(String[] args) {
		new Test().notify("testFile");
	}
}
