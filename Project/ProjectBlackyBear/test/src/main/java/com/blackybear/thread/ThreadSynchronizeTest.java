package com.blackybear.thread;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Description: 线程同步控制
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 *
 *
 * 线程同步控制
 * 1. 内部锁Synchronized
 * 		配合Object类的wait（）和notify（）同步控制线程，使用synchronized的线程要么保持等待，要么执行，不会被中断
 * 2. 重入锁ReenterLock
 * 		需要显示的加锁和释放，比synchronized灵活，允许反复加锁，但加锁和释放次数需一致
 * 		退出临界区时必须要释放重入锁（一般在finally块中释放），否则其他线程无法访问临界区
 * 		（1）中断锁：调用ReenterrantLock.interrupt（）方法可以中断重入锁，通过try/catch可以捕获InterruptException异常
 * 		（2）等待锁：调用ReenterrantLock.tryLock（）方法可以申请锁等待（包括限时等待、立即返回），获取锁成功返回true，失败返回false 调用立即返回的ReenterrantLock.tryLock（）方法可以避免死锁情况
 * 		（3）公平锁：公平锁维护有序排队，实现成本较高，性能较低，虽然线程有公平机会得到资源，但是非特殊需求不推荐使用
 * 3. 条件Condition
 * 		调用ReentrantLock.newCondition生成Condition对象，通过该对象可以让线程在合适的时间进行等待或者唤醒
 * 		无论调用Condition.await（）方法还是signal（）方法后，都需要调用ReentrantLock.unlock（）方法释放重入锁，否则其他线程无法获取锁
 * 		JDK并发容器ArrayBlockingQueue就是通过重入锁和Condition对象实现的
 * 4. 信号量Semaphore
 * 		控制多个线程同时访问临界区资源，由于多线程同时操作临界区数据，故无法保证临界区数据操作的原子性
 * 		当允许线程数量达到上限时，其他线程无法获得准入许可，也就无法操作临界区数据
 * 		与重入锁一样，Semaphore也提供了acquireUninterruptibly（）方法和tryAquire（）方法，用法与重入锁基本一致
 * 5. 读写锁ReadWriteLock
 * 		锁分离机制减少锁竞争提高效率，读-读线程之间非阻塞（不互斥），读-写、写-写线程之间阻塞（互斥）
 * 6. 倒计时器CountDownLatch
 * 		控制线程等待，直到倒计时结束，再开始执行
 * 7. 循环栅栏CyclicBarrier
 * 		控制线程等待，直到计数器到达指标，并且可以循环反复使用
 * 		CyclicBarrier实例构造方法提供定义Runnable类型的barrierAction，用于响应计数器到达指标时的行为
 * 		调用CyclicBarrier.await（）方法可以让线程等待计数器到达指标，CyclicBarrier.await（）方法会抛出两种异常：
 * 		（1）InterruptException异常，它会在线程等待时被中断时抛出
 * 		（2）BrokenBarrierException异常，它会在CyclicBarrier破损，无法等待所有线程都完成时抛出
 * 8. 线程阻塞工具类LockSupport：
 * 		控制线程等待，类似信号量机制，不同点是它为每一个线程准备了一个许可，而信号量是为临界区资源准备多个许可
 * 		使用LockSupport.park（）和LockSupport.unpark（）方法可以代替Thread.suspend（）和Thread.resume（）方法，不会发生线程永久挂起情况
 * 		LockSupport.unpark（）方法可以使许可变成可用，但每个 线程最多只能有一个可用许可
 * 		LockSupport.park（）方法会检测许可状态，如果可用则消费，不可用则阻塞线程等待
 * 		LockSupport.park（）方法支持中断响应，它不会抛出InterruptException，但会设置中断标记，通过Thread.isInterrupted（）方法可以获得中断标记状态
 */
public class ThreadSynchronizeTest {
    private static volatile Object objLock = new Object();
    private static volatile int intStatic = 0;
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static ReentrantLock reentrantLock1 = new ReentrantLock();
    private static ReentrantLock reentrantLock2 = new ReentrantLock();
    private static ReentrantLock fairLock = new ReentrantLock(true);
    private static Condition condition = reentrantLock.newCondition();
    private static Semaphore semaphore = new Semaphore(5);
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
    private static final int LATCHCOUNT = 5;
    private static CountDownLatch countDownLatch = new CountDownLatch(LATCHCOUNT);
    private static final int CYCLICBARRIERCOUNT = 5;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(CYCLICBARRIERCOUNT, new BarrierRun(CYCLICBARRIERCOUNT));

    public static void main(String[] args) {
        // testSynchronizedLock();
        // testReenterantLock();
        // testReenterantLockInterrupt();
        // testReenterrantLockTryLock();
        // testReenterrantLockTryLockDeadLock();
        // testReenterrantLockFairLock();
        // testReenterrantLockCondition();
        // testSemaphoreInterrupt();
        // testSemaphoreTryLock();
        // testSemaphoreUnsafe();
        // testReadWriteLock();
        // testCountDownLatch();
        // testCyclicBarrier();
        // testLockSupport();
        // testLockSupportInterrupt();
    }

    /**
     * 使用Object.wait（）和Object.notify（）方法等待和唤醒线程
     */
    @SuppressWarnings("unused")
    private static void testSynchronizedLock() {
        Thread wait = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(
                        "[" + System.currentTimeMillis() + "]" + Thread.currentThread().getName() + " : Start");
                synchronized (objLock) {
                    try {
                        System.out.println(
                                "[" + System.currentTimeMillis() + "]" + Thread.currentThread().getName() + " : Wait");
                        objLock.wait();
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
                System.out
                        .println("[" + System.currentTimeMillis() + "]" + Thread.currentThread().getName() + " : End");
            }
        });
        Thread notify = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(
                        "[" + System.currentTimeMillis() + "]" + Thread.currentThread().getName() + " : Start");
                synchronized (objLock) {
                    try {
                        objLock.notify();
                        Thread.sleep(3000L);
                        System.out.println("[" + System.currentTimeMillis() + "]" + Thread.currentThread().getName()
                                + " : Notify");
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
                System.out
                        .println("[" + System.currentTimeMillis() + "]" + Thread.currentThread().getName() + " : End");
            }
        });
        wait.start();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        notify.start();
    }

    /**
     * 重入锁使用
     */
    @SuppressWarnings("unused")
    private static void testReenterantLock() {
        Runnable target = new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 100000; j++) {
                    // 可重复加锁，但加锁和解锁必须成对出现
                    reentrantLock.lock();
                    reentrantLock.lock();
                    try {
                        intStatic++;
                        System.out.println(Thread.currentThread().getName() + " : " + intStatic);
                    } finally {
                        reentrantLock.unlock();
                        reentrantLock.unlock();
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
        System.out.println(Thread.currentThread().getName() + " : " + intStatic);
    }

    /**
     * 重入锁，中断锁，通过中断 消除死锁
     */
    @SuppressWarnings("unused")
    private static void testReenterantLockInterrupt() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " : Start");
                    reentrantLock1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + " : Sleep");
                    Thread.sleep(3000L);
                    System.out.println(Thread.currentThread().getName() + " : WakeUp");
                    reentrantLock2.lockInterruptibly();
                } catch (InterruptedException exception) {
                    System.out.println(Thread.currentThread().getName() + " : isInterrupted == "
                            + Thread.currentThread().isInterrupted());
                    exception.printStackTrace();
                } finally {
                    if (reentrantLock1.isHeldByCurrentThread())
                        reentrantLock1.unlock();
                    if (reentrantLock2.isHeldByCurrentThread())
                        reentrantLock2.unlock();
                }
                System.out.println(Thread.currentThread().getName() + " : Exit");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " : Start");
                    reentrantLock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + " : Sleep");
                    Thread.sleep(2000L);
                    System.out.println(Thread.currentThread().getName() + " : WakeUp");
                    reentrantLock1.lockInterruptibly();
                } catch (InterruptedException exception) {
                    System.out.println(Thread.currentThread().getName() + " : isInterrupted == "
                            + Thread.currentThread().isInterrupted());
                    exception.printStackTrace();
                } finally {
                    if (reentrantLock1.isHeldByCurrentThread())
                        reentrantLock1.unlock();
                    if (reentrantLock2.isHeldByCurrentThread())
                        reentrantLock2.unlock();
                }
                System.out.println(Thread.currentThread().getName() + " : Exit");
            }
        });
        thread1.start();
        thread2.start();
        thread1.interrupt();
    }

    /**
     * 重入锁，等待锁
     */
    @SuppressWarnings("unused")
    private static void testReenterrantLockTryLock() {
        Runnable target = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : Start");
                try {
                    if (reentrantLock.tryLock(3, TimeUnit.SECONDS)) {
                        // 立即返回获取锁的结果
                        // if (reEntrantLock.tryLock()) {
                        System.out.println(Thread.currentThread().getName() + " : Sleep");
                        Thread.sleep(5000L);
                        System.out.println(Thread.currentThread().getName() + " : WakeUp");
                    } else {
                        System.out.println("Get Enterrant Lock Failed!");
                    }
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                } finally {
                    if (reentrantLock.isHeldByCurrentThread())
                        reentrantLock.unlock();
                }
                System.out.println(Thread.currentThread().getName() + " : Exit");
            }
        };
        Thread thread1 = new Thread(target);
        Thread thread2 = new Thread(target);
        thread1.start();
        thread2.start();
    }

    /**
     * 重入锁，等待锁，通过循环请求锁，避免死锁，但是可能出现活锁的情况
     */
    @SuppressWarnings("unused")
    private static void testReenterrantLockTryLockDeadLock() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : Start");
                try {
                    while (true) {
                        if (reentrantLock1.tryLock()) {
                            try {
                                try {
                                    Thread.sleep(500L);
                                } catch (InterruptedException exception) {
                                    exception.printStackTrace();
                                }
                                if (reentrantLock2.tryLock()) {
                                    try {
                                        System.out.println(Thread.currentThread().getName() + " Get two lock ok");
                                        return;
                                    } finally {
                                        System.out.println(
                                                Thread.currentThread().getName() + " Release reenterrantlock 2");
                                        reentrantLock2.unlock();
                                    }
                                } else {
                                    System.out.println(
                                            Thread.currentThread().getName() + " Get reenterrantlock 2 failed");
                                }
                            } finally {
                                System.out.println(Thread.currentThread().getName() + " Release reenterrantlock 1");
                                reentrantLock1.unlock();
                            }
                        } else {
                            System.out.println(Thread.currentThread().getName() + " Get reenterrantlock 1 failed");
                        }
                    }
                } finally {
                    System.out.println(Thread.currentThread().getName() + " : Exit");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : Start");
                try {
                    while (true) {
                        if (reentrantLock2.tryLock()) {
                            try {
                                try {
                                    Thread.sleep(500L);
                                } catch (InterruptedException exception) {
                                    exception.printStackTrace();
                                }
                                if (reentrantLock1.tryLock()) {
                                    try {
                                        System.out.println(Thread.currentThread().getName() + " Get two lock ok");
                                        return;
                                    } finally {
                                        System.out.println(
                                                Thread.currentThread().getName() + " Release reenterrantlock 1");
                                        reentrantLock1.unlock();
                                    }
                                } else {
                                    System.out.println(
                                            Thread.currentThread().getName() + " Get reenterrantlock 1 failed");
                                }
                            } finally {
                                System.out.println(Thread.currentThread().getName() + " Release reenterrantlock 2");
                                reentrantLock2.unlock();
                            }
                        } else {
                            System.out.println(Thread.currentThread().getName() + " Get reenterrantlock 2 failed");
                        }
                    }
                } finally {
                    System.out.println(Thread.currentThread().getName() + " : Exit");
                }
            }
        });
        thread1.start();
        thread2.start();
    }

    /**
     * 重入锁，公平锁，线程无饥饿
     */
    @SuppressWarnings("unused")
    private static void testReenterrantLockFairLock() {
        Runnable target = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : Start");
                for (int i = 0; i < 100; i++) {
                    try {
                        fairLock.lock();
                        System.out.println(Thread.currentThread().getName() + " : " + i);
                    } finally {
                        fairLock.unlock();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " : Exit");
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
    }

    /**
     * 重入锁，Condition对象，阻塞和唤醒线程
     */
    @SuppressWarnings("unused")
    private static void testReenterrantLockCondition() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : Start");
                try {
                    reentrantLock.lock();
                    try {
                        condition.await();
                        System.out.println(Thread.currentThread().getName() + " : Wake up");
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                } finally {
                    System.out.println(Thread.currentThread().getName() + " : Release lock");
                    reentrantLock.unlock();
                }
                System.out.println(Thread.currentThread().getName() + " : Exit");
            }
        });
        thread.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + " : Signal");
        condition.signal();
        // 如果不调用ReentrantLock.unlock（）方法，线程thread不会继续执行
        System.out.println(Thread.currentThread().getName() + " : Release lock");
        reentrantLock.unlock();
    }

    /**
     * 信号量，带中断异常捕获的信号量
     */
    @SuppressWarnings("unused")
    private static void testSemaphoreInterrupt() {
        Runnable target = new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    // 调用Semaphore.acquireUninterruptibly()方法，不响应中断
                    // semaphore.acquireUninterruptibly();
                    System.out.println(Thread.currentThread().getName() + " : Acquire");
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                    System.out.println(Thread.currentThread().getName() + " : Interrupted");
                } finally {
                    System.out.println(Thread.currentThread().getName() + " : Release");
                    semaphore.release();
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(target);
            thread.start();
            if (i < 5)
                thread.interrupt();
        }
    }

    @SuppressWarnings("unused")
    private static void testSemaphoreTryLock() {
        Runnable target = new Runnable() {
            @Override
            public void run() {
                try {
                    // 调用Semaphore.tryAcquire（）方法会立即返回结果
                    // if(semaphore.tryAcquire())
                    if (semaphore.tryAcquire(1L, TimeUnit.SECONDS)) {
                        System.out.println(Thread.currentThread().getName() + " : Acquire ok");
                        Thread.sleep(2000L);
                        System.out.println(Thread.currentThread().getName() + " : Release");
                        semaphore.release();
                    } else
                        System.out.println(Thread.currentThread().getName() + " : Acquire failed");
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                    System.out.println(Thread.currentThread().getName() + ": Interrupt");
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(target);
            thread.start();
        }
    }

    /**
     * 信号量，临界区未加锁，数据出现错误
     */
    @SuppressWarnings("unused")
    private static void testSemaphoreUnsafe() {
        Runnable target = new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " : Acquire");
                    // 如果不加锁，临界区数据会出现错误，没有保证线程的原子性
                    reentrantLock.lock();
                    System.out.println(Thread.currentThread().getName() + " : Before sleep == " + intStatic);
                    Thread.sleep(3000L); // 模拟耗时操作
                    intStatic++;
                    System.out.println(Thread.currentThread().getName() + " : After sleep == " + intStatic);
                    reentrantLock.unlock();
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + " : Release");
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(target);
            thread.start();
        }
    }

    /**
     * 读写锁，相比于内部锁和重入锁，读写锁减少锁竞争，效率更高
     */
    @SuppressWarnings("unused")
    private static void testReadWriteLock() {
        //使用重入锁的读写线程
        Runnable commonReadTarget = new Runnable(){
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    Thread.sleep(1000L); // 耗时操作
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : common read " + intStatic);
                reentrantLock.unlock();
            }
        };
        Runnable commonWriteTarget = new Runnable(){
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    Thread.sleep(1000L); // 耗时操作
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                intStatic++;
                System.out.println(Thread.currentThread().getName() + " : common  write " + intStatic);
                reentrantLock.unlock();
            }
        };
        //使用读写锁的读写线程
        Runnable readTarget = new Runnable() {
            @Override
            public void run() {
                readLock.lock();
                try {
                    Thread.sleep(1000L); // 耗时操作
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : read " + intStatic);
                readLock.unlock();
            }
        };

        Runnable writeTarget = new Runnable() {
            @Override
            public void run() {
                writeLock.lock();
                try {
                    Thread.sleep(1000L); // 耗时操作
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                intStatic++;
                System.out.println(Thread.currentThread().getName() + " :  write " + intStatic);
                writeLock.unlock();
            }
        };
        //使用读写锁读写
        for (int i = 0; i < 20; i++) {
            if (i < 2) {
                Thread thread = new Thread(writeTarget);
                thread.start();
            } else {
                Thread thread = new Thread(readTarget);
                thread.start();
            }
        }
        //使用重入锁读写
        for (int i = 0; i < 20; i++) {
            if (i < 2) {
                Thread thread = new Thread(commonWriteTarget);
                thread.start();
            } else {
                Thread thread = new Thread(commonReadTarget);
                thread.start();
            }
        }
    }

    /**
     * 倒计时器，等待倒计时完成后执行线程
     */
    @SuppressWarnings("unused")
    private static void testCountDownLatch() {
        Runnable target = new Runnable(){
            @Override
            public void run() {
                try {
                    long completeTime = new Random().nextInt(5);
                    Thread.sleep(completeTime * 1000L);
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName() + " : Complete task waste time : " + completeTime);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        };
        for (int i = 0; i < LATCHCOUNT; i++) {
            new Thread(target).start();
        }
        try {
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + " : All task has been executed");
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 循环栅栏，循环等待线程计数完成后执行线程
     */
    @SuppressWarnings("unused")
    private static void testCyclicBarrier() {
        Thread thread = null;
        for (int i = 0; i < CYCLICBARRIERCOUNT; i++) {
            thread = new Thread(new Soldier("Soldier " + i , cyclicBarrier));
            thread.start();
        }
    }

    /**
     * 线程阻塞工具类，代替线程挂起
     */
    @SuppressWarnings("unused")
    private static void testLockSupport() {
        Runnable target = new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " : Synchronized block begin");
                synchronized (objLock) {
                    System.out.println(Thread.currentThread().getName() + " : Before park");
                    LockSupport.park();
                    System.out.println(Thread.currentThread().getName() + " : After park");
                }
                System.out.println(Thread.currentThread().getName() + " : Synchronized block end");
            }
        };
        Thread thread1 = new Thread(target);
        Thread thread2 = new Thread(target);
        thread1.start();
        thread2.start();
        //尽管LockSupport.unpark（）方法在LockSupport.park（）之前调用，但是鉴于信号量机制，线程不会永久挂起
        System.out.println(Thread.currentThread().getName() + " : Before unpark threads");
        LockSupport.unpark(thread1);
        LockSupport.unpark(thread2);
        System.out.println(Thread.currentThread().getName() + " : After unpark threads");
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 线程阻塞工具类，中断响应
     */
    @SuppressWarnings("unused")
    private static void testLockSupportInterrupt(){
        Runnable target = new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : Synchronized block begin");
                synchronized (objLock) {
                    System.out.println(Thread.currentThread().getName() + " : Before park");
                    //LockSupport.park（）方法支持中断响应，但不会抛出异常，只会设置中断标记
                    LockSupport.park();
                    System.out.println(Thread.currentThread().getName() + " : After park");
                    if(Thread.interrupted()){
                        System.out.println(Thread.currentThread().getName() + " : Interrupt");
                    }
                }
                System.out.println(Thread.currentThread().getName() + " : Synchronized block end");
            }
        };
        Thread thread1 = new Thread(target);
        Thread thread2 = new Thread(target);
        thread1.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        thread2.start();
        thread1.interrupt();
        LockSupport.unpark(thread2);
    }
}
/**
 * 测试类声明
 * @author Dell_Blacky8
 */
class BarrierRun implements Runnable{
    private int count;
    private boolean flag;

    public BarrierRun(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        if(flag)
            System.out.println(Thread.currentThread().getName() + " : All soldier (" + count + ") have been finished tasks");
        else{
            System.out.println(Thread.currentThread().getName() + " : All soldier (" + count + ") have been ready");
            flag = true;
        }
    }
}

class Soldier implements Runnable{
    private String name;
    private CyclicBarrier cyclicBarrier;

    public Soldier(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            getReady();
            cyclicBarrier.await();
            completeTask();
            cyclicBarrier.await();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } catch (BrokenBarrierException exception) {
            exception.printStackTrace();
        }
    }

    private void getReady() {
        long time = new Random().nextInt(5);
        try {
            Thread.sleep(time *1000L);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : [" + name + " ] Get ready in " + time);
    }

    private void completeTask() {
        long time = new Random().nextInt(5);
        try {
            Thread.sleep(time *1000L);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : [" + name + " ] Complete task in " + time);
    }
}