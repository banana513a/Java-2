package com.blackybear.test.thread;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Description: 多线程容器
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 *
 *
 * 线程并发容器
 * 1. 并发下的ArrayList
 * 		由于ArrayList在扩容的过程中没有锁保护，多线程访问时出现了不一致的内部状态，可能导致出现ArrayIndexOutOfBoundsException
 * 		如果多线程访问统一位置，并对改位置进行修改，可能导致结果不正确
 * 2. 并发下的HashMap
 * 		由于HashMap存储结构Entry<K,V>，当多线程冲突时，有可能使得对HashMap遍历操作变成一个无限的死循环，导致程序无法结束
 * 3. 高效线程安全的ConcurrentHashMap
 * 		ConcurrentHashMap内部细分若干小HashMap（段：segment）
 * 		新增表项时不会对整个HashMap进行加锁，而是通过hashCode得到表项的存储段，然后对该段加锁，这样可以减小锁粒度
 * 4. 高效读取不变模式下的CopyOnWriteArrayList
 * 5. 高效读写队列ConcurrentLinkedQueue
 * 6. 数据共享通道BlockingQueue
 * 		ArrayBlockingQueue
 * 		LinkedBlockingQueue：采用了链表存储结构，使用锁分离机制将take（）和put（）操作分离开，减少了锁竞争
 * 7. 随机数据结构跳表ConcurrentSkiListMap
 */
public class ThreadContainerTest {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
        queue.offer("1111");
    }
}
