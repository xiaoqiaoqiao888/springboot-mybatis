package com.rails.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
	public static void main(String[] args) {
		// creating timer task, timer
		Timer timer = new Timer();

		// scheduling the task at fixed rate delay
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
			}
		}, 500, 1000);
	}

	// this method performs the task
	public void run() {
		System.out.println("working at fixed rate delay");
	}
}