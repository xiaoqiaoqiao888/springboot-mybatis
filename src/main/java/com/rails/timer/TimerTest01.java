package com.rails.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class TimerTest01 {
	Timer timer;

	public TimerTest01(int time, int i) {
		timer = new Timer();
		timer.schedule(new TimerTaskTest01(), time * 1000);
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		System.out.println("第" + i + "次通知，时间为：" + sf.format(date));
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 10 };
		// System.out.println("timer begin....");
		// SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		for (int i = 0; i < arr.length; i++) {

			new TimerTest01(arr[i], i);
		}
	}

}