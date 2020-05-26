package com.rails.async;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.google.common.base.Predicates;

@Service
public class AsyncService {

	Retryer<String> retryer;

	{
		retryer = RetryerBuilder.<String>newBuilder().retryIfException() // 抛出异常会进行重试
				.retryIfResult(Predicates.equalTo(null)) // 如果接口返回的结果不符合预期,也需要重试
				.retryIfResult(Predicates.equalTo("999999")) // 如果接口返回的结果不符合预期,也需要重试
				// .withWaitStrategy(WaitStrategies.fixedWait(5, TimeUnit.SECONDS)) // 重试策略,
				.withWaitStrategy(new YTWaitStrategy()).withStopStrategy(StopStrategies.stopAfterAttempt(7)) // 重试次数
				.build();
	}

	@Async
	public void hello() {
		try {

			retryer.call(new Callable<String>() {
				int count = 0;

				@Override
				public String call() throws Exception {
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
					Date date = new Date();
					System.out.println("第" + count++ + "次通知，时间为：" + sf.format(date));
					return "999999";
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			// return "999999999";
			System.out.println("数据正在处理中。。。。");

		}
	}
}
