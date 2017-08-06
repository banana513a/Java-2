package com.blackybear.basis.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Description: 列表
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 *
 *
 * List：
 * 1. List两个元素相同判定条件为：equals()方法返回值为true
 * 2. ArrayList是非线程安全的，Vector及其子类Stack是线程安全的，但比前者效率低，所以不推荐使用
 */
public class ListTest {
    private static List<String> list = null;
    static {
        list = new ArrayList<>();
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        list.add("Test4");
    }
    public static void main(String[] args) {
//		testListLambda();
//		testListIterator();
//		testArraysAsList();
    }

    @SuppressWarnings("unused")
    private static void testListLambda(){
        System.out.println(list);
        list.sort((o1, o2)-> o1.length() - o2.length());
        System.out.println(list);
        list.replaceAll(ele-> String.valueOf(ele.length()));
        System.out.println(list);
    }

    @SuppressWarnings("unused")
    private static void testListIterator(){
        ListIterator<String> listIterator = list.listIterator();
        System.out.println("正向迭代遍历:");
        while (listIterator.hasNext()) {
            String item = listIterator.next();
            System.out.println(item);
        }
        System.out.println("反向迭代遍历:");
        while (listIterator.hasPrevious()) {
            String item = listIterator.previous();
            System.out.println(item);
        }
    }

    //Arrays类的asList方法返回的是Arrays内部类ArrayList的实例，只能访问，不能添加和删除
    @SuppressWarnings("unused")
    private static void testArraysAsList() {
        List<String> arrayList = Arrays.asList("Test1", "Test2", "Test3");
        ListIterator<String> listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            String item = listIterator.next();
            System.out.println(item);
        }
        try {
            arrayList.add("New test!");
            arrayList.remove("Test1");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

