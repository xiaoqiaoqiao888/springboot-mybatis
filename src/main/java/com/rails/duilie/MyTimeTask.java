package com.rails.duilie;

import java.util.Timer;

public class MyTimeTask {
	private Timer timer;
	private CustomTimerTask task;
	private long time;
	private boolean isStart;

	public MyTimeTask(long time, CustomTimerTask task) {
		this.task = task;
		this.time = time;
		if (timer == null) {
			timer = new Timer();
		}
	}

	public CustomTimerTask getTask() {
		return task;
	}

	public void start() {
		timer.schedule(task, 0, time);
		isStart = true;
	}

	public boolean isStart() {
		return isStart;
	}

	public void stop() {
		if (timer != null) {
			timer.cancel();
			isStart = false;
			if (task != null) {
				task.cancel();
			}
		}
	}

}
