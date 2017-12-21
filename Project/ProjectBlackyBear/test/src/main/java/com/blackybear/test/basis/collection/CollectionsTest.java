package com.blackybear.test.basis.collection;


import java.util.*;
import java.util.stream.IntStream;

/**
 * Description: 集合
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 *
 *
 * Collections
 * 1.Stream提供了大量的聚集方法，对于大部分聚集方法而言，每个Stream只能执行一次
 */
public class CollectionsTest {
    private static Collection<Integer> collectionTest = null;
    private static IntStream.Builder intStreamBuilder = null;
    private static List<Integer> collectionsList = null;

    static {
        collectionTest = new HashSet<>();
        intStreamBuilder = IntStream.builder();
        collectionsList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            collectionTest.add(i);
            intStreamBuilder.add(i);
            collectionsList.add(i);
        }
    }

    public static void main(String[] args) {
//		testIterator();
//		testPredicateOperation();
//		testStreamOperation();
//		testCollections();
    }

    @SuppressWarnings("unused")
    private static void testIterator(){
        collectionTest.forEach( obj -> System.out.println(obj));

        for (Iterator<Integer> iterator = collectionTest.iterator(); iterator.hasNext();) {
            Integer value = (Integer) iterator.next();
            System.out.println(value);
            //遍历集合过程中不能直接删除元素，应该使用迭代器的删除，否则会触发ConcurrentModificationException异常
//			collectionTest.remove(value);
            iterator.remove();
        }
        System.out.println(collectionTest);
    }

    @SuppressWarnings("unused")
    private static void testPredicateOperation(){
        collectionTest.removeIf(obj->(Integer)obj<=10);
        System.out.println(collectionTest);
    }

    @SuppressWarnings("unused")
    private static void testStreamOperation(){
        IntStream intStream = intStreamBuilder.build();
        IntStream newIntStream = intStream.filter(obj->(Integer)obj>15);
        newIntStream.forEach(obj->System.out.println(obj));	//newIntSteam已经被使用，不能再次使用

        System.out.println("集合是否有元素小于10："+ collectionTest.stream().anyMatch(obj->(Integer)obj<10));
    }

    @SuppressWarnings("unused")
    private static void testCollections(){
        System.out.println("原始List : \n" + collectionsList);
        Collections.reverse(collectionsList);
        System.out.println("Reverse逆序: \n" + collectionsList);

        resetCollectionList();
        Collections.shuffle(collectionsList);
        System.out.println("Shuffle乱序：\n" + collectionsList);

        resetCollectionList();
        Collections.swap(collectionsList, 2, 17);
        System.out.println("Swap元素： \n" + collectionsList);

        resetCollectionList();
        Collections.rotate(collectionsList, -4);
        System.out.println("将集合前的4个元素整体移动到最后： \n" + collectionsList);

        resetCollectionList();
        Collections.rotate(collectionsList, 4);
        System.out.println("将集合后的4个元素整体移动到最前： \n" + collectionsList);

        resetCollectionList();
        System.out.println("集合中最大元素：" + Collections.max(collectionsList));
        System.out.println("集合中最小元素：" + Collections.min(collectionsList));
        System.out.println("集合元素10的出现次数：" + Collections.frequency(collectionsList, 10));
        System.out.println("集合元素12被替换为21：" + Collections.replaceAll(collectionsList, 12, 21));
        System.out.println(collectionsList);
        //未排序集合调用二分搜索可能得到不正确的索引
        System.out.println("未排序查找指定元素索引：\n" + Collections.binarySearch(collectionsList, 13));
        Collections.sort(collectionsList);
        System.out.println("排序后的集合： \n" + collectionsList);
        System.out.println("排序后查找指定元素索引：\n" + Collections.binarySearch(collectionsList, 13));
        List<Integer> target = new ArrayList<Integer>();
        target.add(3);
        target.add(4);
        System.out.println("集合中第一次出现target集合的位置索引：\n" + Collections.indexOfSubList(collectionsList, target));
        System.out.println("集合中最后一次出现target集合的位置索引：\n" + Collections.lastIndexOfSubList(collectionsList, target));
        Collections.replaceAll(collectionsList, 2, 20);
        System.out.println("替换集合中元素2为20： \n" + collectionsList);
    }

    private static void resetCollectionList() {
        collectionsList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            collectionsList.add(i);
        }
    }
}
