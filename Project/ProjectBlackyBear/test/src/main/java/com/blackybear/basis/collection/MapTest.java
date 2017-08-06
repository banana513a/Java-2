package com.blackybear.basis.collection;

import java.util.*;

/**
 * Description: 哈希表
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 *
 *
 * Map（除Hashtable外，非线程安全）:
 * 1. HashMap允许value重复，但若添加键值对时key重复，那么对应的value会覆盖原先的value，并且返回原先的value值
 * 2. HashMap非线程安全，Hashtable线程安全，所以HashMap比Hashtable效率更高，	但多线程访问Map对象时，使用Hashtable实现类会更好
 * 3. Hashtable不允许使用null作为key和value，否则引发NullPointerException，
 * 		HashMap可以，但由于HashMap中的key不能重复，所以key只能有一个为null，但可以有多个value为null
 * 4. HashMap和Hashtable的key是自定义类时，重写equals()方法和hashCode()方法判断标准应该一致
 * 		判断两个key相等的条件是：equals()返回值为true；hashCode()返回值相等
 * 		判断两个value相等的条件仅仅是：equals()返回值为true
 * 5. 与集合类似，尽量不要修改Map中的对象，否则可能导致Map无法准确访问对象
 * 6. LinkedHashMap采用双向链表保存元素，维护插入顺序，效率上比HashMap略低，但高于TreeMap
 * 7. TreeMap采用红黑树数据结构来存储元素，判断对象相同的条件：compareTo方法返回值（重写方法时应与equals返回的结果一致）
 * 8. WeakHashMap保存key的弱引用，若没有其他的强引用变量引用key对象，那么GC时系统会回收key的对象，
 * 		同时也会自动从WeakHashMap中删除对应key的键值对
 * 9. IdentityHashMap实现与HashMap实现相似，只是其对于元素的判等条件为：key1==key2严格相等，而不是equals和hashCode判等
 * 10. EnumMap采用内部数组的形式存储元素，实现形式非常紧凑高效，但是
 * 		EnumMap创建时需要关联枚举类作为key的自然顺序，以便维护键值对，
 * 		EnumMap不允许使用null作为key，否则引起NullPointerException
 */

public class MapTest {
    private static HashMap<String, Integer> hashMap = null;
    private static Hashtable<String, Integer> hashtable = null;
    private static LinkedHashMap<String, Integer> linkedHashMap = null;
    private static TreeMap<String, Integer> treeMap = null;
    private static WeakHashMap<String, String> weakHashMap = null;
    private static IdentityHashMap<String, Integer>identityHashMap = null;
    private static EnumMap<MapSeason, String>enumMap = null;

    static{
        hashMap = new HashMap<>();
        hashMap.put("1", 1000);
        hashMap.put("2", 2000);
        hashMap.put("3", 1000);
        hashMap.put("4", 4000);

        hashtable = new Hashtable<>();
        linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("1", 1000);
        linkedHashMap.put("2", 2000);
        linkedHashMap.put("3", 3000);
        linkedHashMap.put("4", 4000);

        treeMap = new TreeMap<>();
        treeMap.put("1", 1000);
        treeMap.put("2", 2000);
        treeMap.put("3", 3000);
        treeMap.put("4", 4000);
        treeMap.put("5", 5000);

        weakHashMap = new WeakHashMap<>();
        weakHashMap.put(new String("1"), new String("1000"));
        weakHashMap.put(new String("2"), new String("2000"));
        weakHashMap.put(new String("3"), new String("3000"));
        weakHashMap.put("4", new String("4000"));	//添加一个系统缓存强引用的字符串key

        identityHashMap = new IdentityHashMap<>();
        identityHashMap.put("0", 100);
        identityHashMap.put("0", 500);	//系统字符串常量相同，满足IdentityHashMap对于key的判等条件
        identityHashMap.put(new String("1"), 200);
        identityHashMap.put(new String("1"), 800);

        enumMap = new EnumMap<>(MapSeason.class);
        enumMap.put(MapSeason.SPRING, "春天");
        enumMap.put(MapSeason.SUMMER, "夏天");
        enumMap.put(MapSeason.AUTUMN, "秋天");
        enumMap.put(MapSeason.WINTER, "冬天");
    }

    public static void main(String[] args) {
//		testHashMap();
//		testNullHashtable();
//		testLinkedHashMap();
//		testTreeMap();
//		testWeakHashMap();
//		testIdentityHashMap();
//		testEnumMap();
    }

    @SuppressWarnings("unused")
    private static void testHashMap() {
        System.out.println(hashMap);
        System.out.println("放入重复key时，新value会覆盖旧value，且返回旧的value值：" + hashMap.put("2", 5000));
        System.out.println("是否存在key：2 ----" + hashMap.containsKey("2"));
        System.out.println("是否存在value：2000 ----" + hashMap.containsValue(2000));
        System.out.println("删除key为3的键值对：" + hashMap.remove("3"));
        System.out.println(hashMap);
        System.out.println("遍历HashMap：");
        for (String key : hashMap.keySet()) {
            System.out.println("Key : " + key + "  Value : "+hashMap.get(key));
        }
    }

    @SuppressWarnings("unused")
    private static void testNullHashtable() {
        hashMap = new HashMap<>();
        hashMap.put(null, 100);
        hashMap.put("0", 200);
        hashMap.put(null, 300);
        hashMap.put("1", null);
        hashMap.put("2", null);
        System.out.println(hashMap);
        try {
            hashtable.put(null, null);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    private static void testLinkedHashMap() {
        System.out.println("遍历LinkedHashMap：");
        linkedHashMap.forEach((k,v)->System.out.println("key : " + k + " ---> " + "value : " + v));
    }

    @SuppressWarnings("unused")
    private static void testTreeMap() {
        System.out.println(treeMap);
        System.out.println(treeMap.firstEntry());
        System.out.println(treeMap.lastEntry());
        System.out.println(treeMap.higherEntry(new String("2")));
        System.out.println(treeMap.lowerEntry(new String("4")));
        System.out.println(treeMap.subMap(new String("2"), new String("4")));
    }

    @SuppressWarnings("unused")
    private static void testWeakHashMap() {
        System.out.println(weakHashMap);
        System.gc();
        System.runFinalization();
        System.out.println(weakHashMap);
    }

    @SuppressWarnings("unused")
    private static void testIdentityHashMap() {
        System.out.println(identityHashMap);
    }

    @SuppressWarnings("unused")
    private static void testEnumMap(){
        System.out.println(enumMap);
    }
}

enum MapSeason {
    SPRING, SUMMER, AUTUMN, WINTER
}
