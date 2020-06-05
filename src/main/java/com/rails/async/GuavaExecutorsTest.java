//package com.rails.async;
//
//import java.util.Random;
//import java.util.concurrent.Callable;
//
//import com.google.common.util.concurrent.FutureCallback;
//import com.google.common.util.concurrent.Futures;
//import com.google.common.util.concurrent.ListenableFuture;
// 
//public class GuavaExecutorsTest {
// 
//	public static void main(String[] args) {
//		Long t1 = System.currentTimeMillis();
// 
//		// 任务1
//		ListenableFuture<Boolean> booleanTask = JayGuavaExecutors.getDefaultCompletedExecutorService()
//				.submit(new Callable<Boolean>() {
// 
//					@Override
//					public Boolean call() throws Exception {
//						return true;
//					}
// 
//				});
//		Futures.addCallback(booleanTask, new FutureCallback<Boolean>() {
// 
//			@Override
//			public void onSuccess(Boolean result) {
//				System.out.println("BooleanTask : " + result);
//			}
// 
//			@Override
//			public void onFailure(Throwable t) {
//				System.out.println("BooleanTask 执行失败 【" + t.getMessage() + "】 ");
//			}
//		});
// 
////		// 任务2
////		ListenableFuture<String> stringTask = JayGuavaExecutors.getDefaultCompletedExecutorService()
////				.submit(new Callable<String>() {
////					@Override
////					public String call() throws Exception {
////						return "Hello World";
////					}
////				});
//// 
////		Futures.addCallback(stringTask, new FutureCallback<String>() {
////			@Override
////			public void onSuccess(String result) {
////				System.err.println("StringTask: " + result);
////			}
//// 
////			@Override
////			public void onFailure(Throwable t) {
////				System.err.println("StringTask 执行失败 【" + t.getMessage() + "】 ");
////			}
////		});
//// 
////		// 任务3
////		ListenableFuture<Integer> integerTask = JayGuavaExecutors.getDefaultCompletedExecutorService()
////				.submit(new Callable<Integer>() {
////					@Override
////					public Integer call() throws Exception {
////						return new Random().nextInt(100);
////					}
////				});
////		Futures.addCallback(integerTask, new FutureCallback<Integer>() {
////			@Override
////			public void onSuccess(Integer result) {
////				try {
////					Thread.sleep(500);
////				} catch (InterruptedException e) {
////					e.printStackTrace();
////				}
////				System.err.println("IntegerTask: " + result);
////			}
//// 
////			@Override
////			public void onFailure(Throwable t) {
////				System.err.println("IntegerTask 执行失败 【" + t.getMessage() + "】 ");
////			}
////		});
//// 
////		Long t2 = System.currentTimeMillis();
////		
////		 // 执行时间
////        System.err.println("time: " + (t2 - t1));
//	}
// 
//	public static void main1(String[] args) {
//		for (int i = 0; i < 10; i++) {
//			JayGuavaExecutors.getDefaultCompletedExecutorService().submit(new Runnable() {
// 
//				@Override
//				public void run() {
//					System.out.println("xxxxx");
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println("xxxxx1");
//				}
//			});
//		}
//	}
//}
