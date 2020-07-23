package com.rails.async;

import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.WaitStrategy;

/**
 * 异步通知时间间隔
 * 
 * @author qiaodj
 * @version V1.0
 * @date: 2020年5月26日 上午10:21:14
 */
public class YTWaitStrategy implements WaitStrategy {

	@Override
	public long computeSleepTime(@SuppressWarnings("rawtypes") Attempt failedAttempt) {
		long number = failedAttempt.getAttemptNumber();
		// if (number == 1) {
		// return 5 * 1000;// 5秒
		// } else if (number == 2) {
		// return 10 * 1000;// 10秒
		// } else if (number == 3) {
		// return 30 * 1000;// 30秒
		// } else if (number == 4) {
		// return 60 * 1000;// 1分钟
		// } else if (number == 5) {
		// return 300 * 1000;// 5分钟
		// } else if (number == 6) {
		// return 600 * 1000;// 10分钟
		// } else if (number == 7) {
		// return 1800 * 1000;// 30分钟
		// } else if (number == 8) {
		// return 7200 * 1000;// 2小时
		// } else if (number == 9) {
		// return 14400 * 1000;// 4小时
		// } else {
		// return 28800 * 1000;// 8小时
		// }

		if (number == 1) {
			return 5 * 1000;// 5秒
		} else if (number == 2) {
			return 1 * 1000;// 10秒
		} else if (number == 3) {
			return 1 * 1000;// 30秒
		} else if (number == 4) {
			return 1 * 1000;// 1分钟
		} else if (number == 5) {
			return 1 * 1000;// 5分钟
		} else {
			return 1 * 1000;
		}
	}
}
