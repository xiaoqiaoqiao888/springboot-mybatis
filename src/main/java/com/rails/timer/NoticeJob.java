package com.rails.timer;

import java.io.Serializable;

public class NoticeJob implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6350502675140661131L;

	String jobId;

	int adder;
	long limter = 0;
	long lastTime = System.currentTimeMillis() - 2000L;

	public boolean isMeets() {
		return System.currentTimeMillis() - lastTime > limter;
	}

	/**
	 * @return true-发送成功，false-发送失败
	 */
	public boolean send() {

		return false;
	}

	/**
	 * @return true-重试成功，false-无须重试
	 */
	public boolean retry() {
		if (++adder > 5) {
			return false;
		}
		
		System.out.println("adder"+adder);
		lastTime = System.currentTimeMillis();
		switch (adder) {
		case 1:
			limter = 1000L;
			break;
		case 2:
			limter = 2000L;
			break;
		case 3:
			limter = 3000L;
			break;
		case 4:
			limter = 4000L;
			break;
		default:
			return false;
		}
		return true;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

}
