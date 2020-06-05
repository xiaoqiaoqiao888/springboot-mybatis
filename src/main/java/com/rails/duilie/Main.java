package com.rails.duilie;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	private final int EXE_COUNT = 10;
	private final int WAIT_INTERVAL = 1000;
	private ArrayList<MyTimeTask> taskList = new ArrayList<>();

	private static class SingletonHolder {
		private static final Main singleton = new Main();

	}

	public static Main getInstance() {
		return SingletonHolder.singleton;
	}

	public ArrayList<MyTimeTask> getTaskList() {
		return taskList;
	}

	public void addTask(String msg, TaskListener taskListener) {
		MyTimeTask timeTask = new MyTimeTask(WAIT_INTERVAL, new CustomTimerTask(EXE_COUNT, msg, taskListener));
		timeTask.start();
		taskList.add(timeTask);
	}

	public void removeTask(String msg) {
		for (MyTimeTask timeTask : taskList) {
			if (timeTask.getTask().msg.equals(msg)) {
				timeTask.stop();
				taskList.remove(timeTask);
				break;
			}
		}
	}

	public interface TaskListener {
		void run();
	}

	public static void main(String[] args) {
		Main.getInstance().addTask("abc", new TaskListener() {
			@Override
			public void run() {
				System.out.println("abc");
			}

		});
		Main.getInstance().addTask("123", new TaskListener() {
			@Override
			public void run() {
				System.out.println("123");
			}

		});

		Timer timer = new Timer();// 实例化Timer类
		timer.schedule(new TimerTask() {
			public void run() {
				Main.getInstance().removeTask("123");
				this.cancel();
			}
		}, 1500);// 这里百毫秒

//		Timer timer1 = new Timer();// 实例化Timer类
//		timer1.schedule(new TimerTask() {
//			public void run() {
//				System.out.println("任务列表数" + Main.getInstance().getTaskList().size());
//				this.cancel();
//			}
//		}, 4000);// 这里百毫秒

	}

}
