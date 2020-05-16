package com.rails.async;

import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.WaitStrategy;

public class AlipayWaitStrategy implements WaitStrategy {

	@Override
	public long computeSleepTime(Attempt failedAttempt) {
		long number = failedAttempt.getAttemptNumber();
		if (number == 1) {
			return 1 * 1000;
		}
		if (number == 2) {
			return 10 * 1000;
		}
		return 20 * 1000;
	}

}
