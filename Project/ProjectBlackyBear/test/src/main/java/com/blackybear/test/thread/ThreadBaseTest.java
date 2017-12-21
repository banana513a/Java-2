package com.blackybear.test.thread;

/**
 * Description: 多线程基础
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 *
 *
 * 线程基础
 * 	1. 线程调度并发级别：阻塞、无饥饿、无障碍、无锁、无等待
 * 		阻塞：其他线程释放临界区资源前，当前线程无法继续执行
 * 		无饥饿：阻塞调度，所有线程都有机会执行，与线程优先级无关
 * 		无障碍：最弱非阻塞调度，所有线程均可以使用临界区资源，无需等待其他线程释放，一旦临界区资源冲突，回滚操作
 * 		无锁：无障碍调度基础上，保证必然有一个线程能够在有限步骤执行完毕，实现方式一般为线程无限循环操作临界区数据，
 * 				  线程之间相互竞争，直到有线程胜出，其他线程可能会出现饥饿情况
 * 		无等待：无锁调度基础上，保证每个线程都在有限步骤内完成
 * 2. 加速比定义：加速比 = 优化前系统耗时 / 优化后系统 耗时
 * 							 加速比 = T1 /Tn
 * 										 = T1 /(T1 * ( F + 1/n (1-F) ) )
 * 									     =  1 / （F + 1/n (1 - F) ）
 * 3. 多线程的原子性：确保一个线程的操作不可被其他线程中断或干扰
 * 4. 多线程的一致性：确保线程修改临界区数据后，其他线程能够立即觉察到数据的修改
 * 5. 多线程的有序性：确保指令重排不会对线程执行顺序有所影响
 *
 * 线程操作
 * 1. 线程创建：
 *		（1）继承Thread类创建（2）实现Runnable接口创建（3）实现Callable接口和FutureTask创建
 * 		方式（2）（3）创建线程时实现类会作为target对象创建Thread，所以实现类的成员数据共享
 * 2. 线程启动：
 * 		启动新线程调用start（）方法，直接调用run（）方法并不会启动线程，而是在当前线程中串行执行run（）方法代码
 * 		线程状态包括：NEW，RUNNABLE，TERMINATED，BLOCKED，WAITING，TIMED_WAITING
 * 3. 线程终止：
 * 		终止线程需要使用标记变量指示线程是否需要退出，不能直接调用stop（）方法
 * 		因为调用stop（）方法会直接终止线程，释放线程所有持有锁，导致临界区数据不一致
 * 4. 线程中断：
 * 		中断线程不会使线程直接退出，而是向目标线程发送通知，设置中断标记，目标线程可以通过检查中断标志进行后续处理
 * 		中断线程类似标记变量终止线程，但功能更为强大，如果线程中有类似Sleep（）或者wait（）操作时，则只能通过中断识别
 * 5. 线程等待和通知：
 * 		Object类中的wait（）和notify（）用来使线程获取或释放Object对象锁，以实现线程在Object对象上等待和唤醒
 * 		wait（）和notify（）的调用必须首先获得目标对象锁，所以必须包含在synchronized中
 * 		Object.wait（）和Thread.sleep（）方法都可以让线程等待，除了wait（）可以被唤醒外，另一个区别是Object.wait（）
 * 		调用时会释放目标对象锁，而Thread.sleep（）不会释放任何资源
 * 6. 线程挂起和继续执行：
 * 		线程挂起和恢复需要使用标记变量，Object的wait（）和notify（）方法进行实现
 * 		不推荐使用suspend（）方法挂起线程，因为它在线程挂起时，不会释放资源直到线程调用resume（）方法，线程状态仍然是Runnable
 * 		如果resume（）意外在suspend（）前执行则，被挂起的线程很难有机会被继续执行，而且相关锁不会被释放
 * 7. 线程谦让和等待线程结束
 * 		调用Thread.join（）方法可以一直阻塞当前线程等待，直到目标线程执行完毕
 * 		Thread.join（）方法本质是让调用线程在目标线程对象实例上等待，被等待线程执行完毕会调用notifyAll（）通知所有等待线程继续执行
 * 		所以不要在目标线程实例上使用wait()或notify()方法，否则会影响系统API
 * 		调用Thread.yield（）方法可以使当前线程让出CPU，但是当前线程还会进行CPU争夺，而且不会释放资源
 * 	8. Thread.sleep（）与Thread.yield（）区别
 * 		sleep（）暂停线程后，所有线程均有机会执行，不会理会线程的优先级，yield（）只会给优先级相同或者更高的线程执行机会（多CPU并行时表现不明显）
 * 		sleep（）暂停线程后，线程会进入BLOCKED状态，暂停时间过后会进入RUNNABLE状态，而yield（）暂停线程后线程直接进入RUNNABLE状态
 * 		sleep（）方法会抛出异常，yield（）方法不会抛出异常
 * 9. Daemon线程（守护线程/后台线程/精灵线程）
 *		在所有前台线程结束后结束，但从Daemon线程收到结束指令到结束需要一定时间
 * 		设置线程为守护线程必须在调用start方法前调用setDaemon（true）
 * 		守护线程创建的线程仍然是守护线程，前台线程创建的子线程仍然是前台线程
 */
public class ThreadBaseTest {
    private static Integer intVal = 0;
    private static volatile int val = 0;
    private static volatile UserThread userThreadStop = new UserThread();
    public static void main(String[] args) {
//		testExtendThread();
//		testImplementsThread();
//		testStopThread();
//		testYieldInterrupt();
//		testWaitNotify();
//		testIncreaseSafe();
//		testIntegerSafe();
    }

    /**
     * 继承Thread类方式创建线程
     */
    @SuppressWarnings("unused")
    private static void testExtendThread() {
        for (int i = 0; i < 100	; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            if(i == 20){
                new ThreadClass().start();
                new ThreadClass().start();
            }
        }
    }

    /**
     * 实现Runnable接口方式创建线程
     */
    @SuppressWarnings("unused")
    private static void testImplementsThread(){
        for (int i = 0; i < 100	; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            if(i == 20){
                //同一Runnable实例的成员变量线程间数据共享
                ThreadRunnable threadRunnable = new ThreadRunnable();
                new Thread(threadRunnable).start();
                new Thread(threadRunnable).start();
            }
        }
    }

    /**
     * 调用Thread.stop（）终止线程引起临界区数据被破坏
     */
    @SuppressWarnings({ "unused", "deprecation" })
    private static void testStopThread(){
        Runnable writeTarget = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (userThreadStop) {
                        int value = (int)(System.currentTimeMillis()/1000);
                        userThreadStop.setId(value);
                        //模拟线程切换时被stop
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException exception) {
                            exception.printStackTrace();
                        }
                        userThreadStop.setName(String.valueOf(value));
                    }
                    Thread.yield();
                }
            }
        };
        Runnable readTarget = new Runnable(){
            @Override
            public void run() {
                while (true) {
                    synchronized (userThreadStop) {
                        //由于写线程stop时可能会正在写
                        if (userThreadStop.getId() != Integer.parseInt(userThreadStop.getName())) {
                            System.out.println(userThreadStop.toString());
                            break;
                        }
                    }
                    Thread.yield();
                }
            }
        };
        Thread readThread = new Thread(readTarget);
        readThread.start();

        while(true){
            Thread thread = new Thread(writeTarget);
            thread.start();
            try {
                Thread.sleep(150L);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            thread.stop();
            if(userThreadStop.getId()!=Integer.parseInt(userThreadStop.getName()))
                break;
        }
    }

    /**
     * 线程Sleep后，中断线程
     */
    @SuppressWarnings("unused")
    private static void testSleepInterrupt(){
        Thread threadInterrupt = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "==>Run");
                    if (Thread.interrupted()) {
                        System.out.println(Thread.currentThread().getName() + "==>Interrupted!");
                        break;
                    }
                    try {
                        Thread.sleep(10000L);
                    } catch (InterruptedException exception) {
                        System.out.println(Thread.currentThread().getName() + "==>Catch interrupt exception!");
                        //Sleep（）方法由于中断而抛出异常，此时会清除中断标记
                        System.out.println(Thread.currentThread().getName() + "==>Interrupt flag : " + Thread.interrupted());
                        Thread.currentThread().interrupt();
                        exception.printStackTrace();
                    }
                }
            }
        });
        threadInterrupt.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        threadInterrupt.interrupt();
    }

    /**
     * 线程Yield后，中断线程
     */
    @SuppressWarnings("unused")
    private static void testYieldInterrupt() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName() +  "Set interrupt flag");
                        break;
                    }
                    Thread.yield();
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        thread.interrupt();
    }

    /**
     * 线程必须先得到Object锁，才能够执行wait（）和notify（）方法
     */
    @SuppressWarnings("unused")
    private static void testWaitNotify() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (userThreadStop) {
                    System.out.println("[" + System.currentTimeMillis() + "]" + Thread.currentThread().getName() + ": Start");
                    try {
                        System.out.println("[" + System.currentTimeMillis() + "]" + Thread.currentThread().getName() + ": Wait");
                        userThreadStop.wait();
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                    System.out.println("[" + System.currentTimeMillis() + "]" + Thread.currentThread().getName() + ": Wake up");
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (userThreadStop) {
                    System.out.println("[" + System.currentTimeMillis() + "]" + Thread.currentThread().getName() + ": Start");
                    userThreadStop.notify();
                    System.out.println("[" + System.currentTimeMillis() + "]" + Thread.currentThread().getName() + ": Notify");
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        thread2.start();
    }

    /**
     * 调用Thread.Join（）方法使当前线程等待目标线程执行完毕后执行
     */
    @SuppressWarnings("unused")
    private static void testJoinThread() {
        ThreadClass thread1 = new ThreadClass();
        thread1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            if(i == 20){
                ThreadClass thread2 = new ThreadClass();
                thread2.start();
                try {
                    //主线程会等待thread2执行完成后执行，而thread1则不会
                    thread2.join();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }


    /**
     * 调用yield（）方法使当前线程谦让，重新进入就绪状态
     */
    @SuppressWarnings("unused")
    private static void testYieldThread() {
        Thread yieldThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread.MAX_PRIORITY : " + i);
                    if (i == 20) {
                        Thread.yield();
                    }
                }
            }
        });
        yieldThread1.setPriority(Thread.MAX_PRIORITY);
        Thread yieldThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread.MIN_PRIORITY : " + i);
                    if (i == 20) {
                        Thread.yield();
                    }
                }
            }
        });
        yieldThread2.setPriority(Thread.MIN_PRIORITY);
        yieldThread1.start();
        yieldThread2.start();
    }

    /**
     * 创建守护线程，主线程结束后守护线程自动结束
     */
    @SuppressWarnings("unused")
    private static void testDaemonThread() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : "  + i);
            if(i == 2){
                Thread threadDaemon = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 1000; i++) {
                            System.out.println(Thread.currentThread().getName() + " : " + i);
                        }
                    }
                });
                threadDaemon.setDaemon(true);
                threadDaemon.start();
            }
        }
    }


    /**
     * 单目++操作不是线程安全
     */
    @SuppressWarnings("unused")
    private static void testIncreaseSafe() {
        Runnable target = new Runnable() {
            @Override
            public void run() {
                //如果不加synchronized同步控制，结果会小于200000
//				synchronized (this) {
                for (int i = 0; i < 100000; i++) {
                    val++;
                }
//				}
            }
        };
        Thread thread1 = new Thread(target);
        Thread thread2 = new Thread(target);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("多线程计算结果 ： " + val);
    }

    /**
     * Integer对象的错误加锁
     */
    @SuppressWarnings("unused")
    private static void testIntegerSafe() {
        Runnable target = new Runnable(){
            @Override
            public void run() {
//				synchronized (this) {
                synchronized (intVal) {
                    for (int i = 0; i < 10000; i++) {
                        //Integer是不可变类，一旦创建对象不可改变
                        //intVal++本质是创建一个新的Integer对象，并将引用赋给intVal
                        //线程锁实际加在不同的临界区对象上
                        intVal++;
                    }
                }
            }
        };
        Thread thread1 = new Thread(target);
        Thread thread2 = new Thread(target);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("多线程计算结果 : " + intVal);
    }
}

/**
 * 测试类声明
 * @author Dell_Blacky8
 */
class ThreadClass extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " : " + i);
        }
    }
}

class ThreadRunnable implements Runnable {
    private int i = 0;
    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

class UserThread{
    private int id = 0;
    private String name = "0";

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User [ id="+ id + ", name=" + name + "]";
    }
}
