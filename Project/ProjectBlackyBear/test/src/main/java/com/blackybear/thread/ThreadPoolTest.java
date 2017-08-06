package com.blackybear.thread;

import java.util.concurrent.*;

/**
 * Description: 线程池
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 *
 *
 * 线程池
 * 1. 线程池工厂Executors
 * 2. ExecutorService, AbstractExecutorService, ScheduledExecutorService
 * 3. 4种线程池实现
 * 4. 4种BlockingQueue
 * 5. 4种拒绝策略handler
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//		testStackTraceThreadPool();
    }

    //使用线程池导致某些异常被忽略，自定义带堆栈的线程池
    @SuppressWarnings("unused")
    private static void testStackTraceThreadPool() {
        StackTranceThreadPool pool = new StackTranceThreadPool(
                0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new SynchronousQueue<>());

        for (int i = 0; i < 5; i++) {
            pool.execute(new DivTask(100, i));
        }
    }
}
//除法任务（testStackTraceThreadPool）
class DivTask implements Runnable{
    int a,b;
    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        double result = a/b;		//Throw exception which divided by zero
        System.out.println(result);
    }
}

//堆栈线程池（testStackTraceThreadPool）
class StackTranceThreadPool extends ThreadPoolExecutor {
    public StackTranceThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                                 BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable command) {
        super.execute(
                wrap(command, clientStackTrace(),Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(
                wrap(task, clientStackTrace(), Thread.currentThread().getName()));
    }

    private Exception clientStackTrace(){
        return new Exception("Client Stack Trace");
    }

    private Runnable wrap(Runnable task, Exception clientStack, String threadName){
        return new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                } catch (Exception exception) {
                    clientStack.printStackTrace();
                    throw exception;
                }
            }
        };
    }
}
