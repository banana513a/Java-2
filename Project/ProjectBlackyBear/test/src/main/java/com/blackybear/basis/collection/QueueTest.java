package com.blackybear.basis.collection;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Description:
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 *
 *
 * Queue（非线程安全）:
 * 1. PriorityQueue采用最小二叉堆来存储对象，并不是先进先出的队列顺序，所以队列每次取出的头部对象是队列里最小的对象
 * 2. Deque接口实现类既可以作为双端队列使用，也可以作为栈来使用
 * 3. LinkedList实现Deque、List接口，所以它不仅可以作为List集合使用，也可以作为双端队列或者栈来使用
 * 4. LinkedList实现与ArrayList和ArrayDeque不同：
 * 		（1）LinkedList底层使用的是链表结构，而ArrayList和ArrayDeque使用数组
 * 		（2）在随机访问性要求较高时使用ArrayList和ArrayDeque，在需要频繁插入删除时使用LinkedList
 * 		（3）遍历List集合元素时，LinkedList使用iterator来遍历，ArrayList和ArrayDeque使用随机访问get来遍历
 * 		（4）多线程编程中，需要使用Collections.synchronizedList()将集合包装成线程安全的集合来使用
 */
public class QueueTest {
    private static PriorityQueue<Integer> priorityQueue = null;
    private static ArrayDeque<Integer> arrayDequeStack = null;
    private static ArrayDeque<Integer> arrayDequeQueue = null;
    private static LinkedList<Integer> linkedList = null;

    static{
        priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(6);
        priorityQueue.offer(-3);
        priorityQueue.offer(20);
        priorityQueue.offer(18);
        priorityQueue.offer(9);
        priorityQueue.offer(4);

        arrayDequeStack = new ArrayDeque<>();
        arrayDequeStack.push(0);
        arrayDequeStack.push(1);
        arrayDequeStack.push(2);
        arrayDequeStack.push(3);

        arrayDequeQueue = new ArrayDeque<>();
        arrayDequeQueue.offer(10);
        arrayDequeQueue.offer(20);
        arrayDequeQueue.offer(30);
        arrayDequeQueue.offer(40);

        linkedList = new LinkedList<>();
        linkedList.offer(100);
        linkedList.push(200);
        linkedList.offerFirst(300);
        linkedList.push(400);
    }

    public static void main(String[] args) {
//		testPriorityQueue();
//		testArrayDequeASStack();
//		testArrayDequeASQueue();
//		testLinkedList();
    }

    @SuppressWarnings("unused")
    private static void testPriorityQueue() {
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.poll());
    }

    @SuppressWarnings("unused")
    private static void testArrayDequeASStack() {
        System.out.println(arrayDequeStack);
        System.out.println(arrayDequeStack.peek());
        System.out.println(arrayDequeStack.pop());
        System.out.println(arrayDequeStack);
    }

    @SuppressWarnings("unused")
    private static void testArrayDequeASQueue() {
        System.out.println(arrayDequeQueue);
        System.out.println(arrayDequeQueue.peek());
        System.out.println(arrayDequeQueue.pop());
        System.out.println(arrayDequeQueue);
    }

    @SuppressWarnings("unused")
    private static void testLinkedList() {
        System.out.println(linkedList);
        System.out.println(linkedList.peek());
        System.out.println(linkedList.poll());
        System.out.println(linkedList);
    }
}

