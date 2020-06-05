package com.rails.duilie;

import java.util.TimerTask;

import com.rails.duilie.Main.TaskListener;

public class CustomTimerTask extends TimerTask {
	public String msg;
	private int count = 0;
	private TaskListener taskListener;

	public CustomTimerTask(int exeCount, String msg, TaskListener taskListener) {
		this.msg = msg;
		this.count = exeCount;
		this.taskListener = taskListener;
	}

	@Override
	public void run() {
		if (count > 0) {
			taskListener.run();
			count--;
		} else {
			Main.getInstance().removeTask(msg);
			this.cancel();
		}

	}

}
