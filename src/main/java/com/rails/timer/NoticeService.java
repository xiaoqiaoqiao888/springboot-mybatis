package com.rails.timer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

//import com.icitic.logger.Logger;
//import com.icitic.logger.LoggerFactory;
//import com.icitic.utils.date.SystemClock;

@Component
public class NoticeService extends TimerTask implements InitializingBean {

	static final Logger logger = LoggerFactory.getLogger(NoticeService.class);

	Timer timer;
	final LinkedList<NoticeJob> queue;

	public NoticeService() {
		queue = new LinkedList<>();
	}

	public boolean add(NoticeJob job) {
		queue.addLast(job);
		// if (logger.isDebugEnabled()) {
		logger.debug("> +添加了一个JOB：{}", job);
		// }
		return true;
	}

	@Override
	public void run() {
		// if (logger.isDebugEnabled()) {
		logger.debug("开始发送通知……");
		// }
		if (queue.isEmpty()) {
			logger.debug("队列为空。。。。");
			return;
		}
		Iterator<NoticeJob> iterator = queue.iterator();
		while (iterator.hasNext()) {
			NoticeJob job = iterator.next();
			if (!job.isMeets()) {
				logger.debug("当前不满足：{}", job);
				continue;
			}
			if (job.send()) {
				// if (logger.isDebugEnabled()) {
				logger.debug("通知发送成功！{}", job);
				// }
				queue.remove(job);
				logger.debug("通知发送成功,删除{}", job);
				continue;
			}
			if (!job.retry()) {
				queue.remove(job);
				logger.debug("通知重试成功,删除{}", job);
			}
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.timer = new Timer("SendTool", true);
		this.timer.scheduleAtFixedRate(this, 1000L, 1000L);

	}
}
