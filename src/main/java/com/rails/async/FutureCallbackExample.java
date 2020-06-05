//package com.rails.async;
//
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//import java.util.concurrent.TimeUnit;
//
//import com.google.common.util.concurrent.FutureCallback;
//import com.google.common.util.concurrent.Futures;
//import com.google.common.util.concurrent.ListenableFuture;
//import com.google.common.util.concurrent.ListeningExecutorService;
//import com.google.common.util.concurrent.MoreExecutors;
//
///**
// * 
// * 使用guava实现异步回调 {@link java.util.concurrent.Future}
// * {@link com.google.common.util.concurrent.ListenableFuture}
// * {@link com.google.common.util.concurrent.FutureCallback}
// * 
// * @author landon
// * 
// */
//public class FutureCallbackExample {
//	public static void main(String[] args) throws Exception {
//        // 原生的Future模式,实现异步
//        ExecutorService nativeExecutor = Executors.newSingleThreadExecutor();
//        Future<String> nativeFuture = nativeExecutor
//                .submit(new Callable<String>() {
//
//                    @Override
//                    public String call() throws Exception {
//                        // 使用sleep模拟调用耗时
//                        TimeUnit.SECONDS.sleep(1);
//                        return "This is native future call.not support async callback";
//                    }
//                });
//
//        // Future只实现了异步，而没有实现回调.所以此时主线程get结果时阻塞.或者可以轮训以便获取异步调用是否完成
//        System.out.println(nativeFuture.get());
//
//        // 好的实现应该是提供回调,即异步调用完成后,可以直接回调.本例采用guava提供的异步回调接口,方便很多.
//        ListeningExecutorService guavaExecutor = MoreExecutors
//                .listeningDecorator(Executors.newSingleThreadExecutor());
//        final ListenableFuture<String> listenableFuture = guavaExecutor
//                .submit(new Callable<String>() {
//
//                    @Override
//                    public String call() throws Exception {
//                        Thread.sleep(1000);
//                        return "this is guava future call.support async callback";
//                    }
//                });
//
//        // 注册监听器,即异步调用完成时会在指定的线程池中执行注册的监听器
//        listenableFuture.addListener(new Runnable() {
//
//            @Override
//            public void run() {
//                try {
//                    System.out.println("async complete.result:"
//                            + listenableFuture.get());
//                } catch (Exception e) {
//                }
//            }
//        }, Executors.newSingleThreadExecutor());
//
//        // 主线程可以继续执行,异步完成后会执行注册的监听器任务.
//        System.out.println("go on execute.asyn complete will callback");
//
//        // 除了ListenableFuture,guava还提供了FutureCallback接口,相对来说更加方便一些.
//        ListeningExecutorService guavaExecutor2 = MoreExecutors
//                .listeningDecorator(Executors.newSingleThreadExecutor());
//        final ListenableFuture<String> listenableFuture2 = guavaExecutor2
//                .submit(new Callable<String>() {
//
//                    @Override
//                    public String call() throws Exception {
//                        Thread.sleep(1000);
//                        System.out.println("asyncThreadName:"
//                                + Thread.currentThread().getName());
//                        return "this is guava future call.support async callback using FutureCallback";
//                    }
//                });
//        // 注意这里没用指定执行回调的线程池,从输出可以看出，默认是和执行异步操作的线程是同一个.
//        Futures.addCallback(listenableFuture2, new FutureCallback<String>() {
//
//            @Override
//            public void onSuccess(String result) {
//                System.out
//                        .println("async callback(using FutureCallback) result:"
//                                + result);
//                System.out.println("execute callback threadName:"
//                        + Thre            }ad.currentThread().getName());
//
//
//            @Override
//            public void onFailure(Throwable t) {
//            }
//        });
//    }
//}
