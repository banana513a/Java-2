package com.blackybear.basis.collection;

import java.util.*;

/**
 * Description: Set
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 *
 *
 * 集合（非线程安全）：
 * 1. 集合不允许添加相同的元素，所以添加相同的元素会导致添加失败
 * 2. 集合不允许添加非同类对象，否则可能引发ClassCastException异常
 * 3. 尽量不要修改集合对象，否则有可能导致集合无法准确访问对象
 * 4. HashSet采用Hash算法来存储元素，判断对象相同的条件：equals返回true；hashCode相同
 * 5. LinkedHashSet采用双向链表链表维护元素，会按照元素的添加顺序存储元素，因为要维护插入顺序，效率比HashSet略低
 * 6. TreeSet采用红黑树数据结构来存储元素，判断对象相同的条件：compareTo方法返回值（重写方法时应与equals返回的结果一致）
 * 7. EnumSet不允许添加null元素，否则可能引发ClassCastException异常
 */
public class SetTest {
    private static HashSet<HashSetElement> hashSet = null;
    private static LinkedHashSet<Integer> linkedHashSet = null;
    private static TreeSet<TreeSetElement> treeSet = null;
    private static EnumSet<SetSeason> enumSet = null;

    static{
        hashSet = new HashSet<>();
        hashSet.add(new HashSetElement(0));
        hashSet.add(new HashSetElement(1));
        hashSet.add(new HashSetElement(2));
        hashSet.add(new HashSetElement(3));

        linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(10);
        linkedHashSet.add(20);
        linkedHashSet.add(30);
        linkedHashSet.add(40);

        treeSet = new TreeSet<>();
        enumSet = EnumSet.noneOf(SetSeason.class);
        enumSet.add(SetSeason.AUTUMN);
        enumSet.add(SetSeason.WINTER);
    }

    public static void main(String[] args) {
//		testHashSet();
//		testLinkedHashSet();
//		testTreeSetAddSameElement();
//		testTreeSetModify();
//		testEnumSet();
    }
    //HashSet：修改集合对象导致元素定位不准确
    @SuppressWarnings("unused")
    private static void testHashSet() {
        //不要修改集合中的元素，否则集合可能出现无法准确定位到元素的情况
        Iterator<HashSetElement> iterator = hashSet.iterator();
        HashSetElement r = iterator.next();
        r.mCount = 1;	//修改第一个元素mCount值
        System.out.println(hashSet);
        //删除mCount为1的元素（第二个元素）：根据hashCode查找元素，根据equals确定元素
        hashSet.remove(new HashSetElement(1));
        System.out.println(hashSet);
        //无法准确定位集合元素
        System.out.println(hashSet.contains(new HashSetElement(0)));//false；hashCode相同，但equals()不同;
        System.out.println(hashSet.contains(new HashSetElement(1)));//false；equals()相同，但hashCode不同;
    }

    //LinkedHashSet：删除集合元素
    @SuppressWarnings("unused")
    private static void testLinkedHashSet(){
        System.out.println(linkedHashSet);
        linkedHashSet.remove(20);
        System.out.println(linkedHashSet);
    }

    //TreeSet：添加相同对象
    @SuppressWarnings("unused")
    private static void testTreeSetAddSameElement(){
        TreeSetElement treeSetElement = new TreeSetElement(100);
        treeSet.add(treeSetElement);
        //是否能够添加同一个对象需要取决于实现的比较器返回值是否为0
        System.out.println("添加相同对象成功："+treeSet.add(treeSetElement));
        System.out.println("当比较器返回值不为0时，相同对象也会被添加到集合：\n"+treeSet +"\n");
    }

    //TreeSet：修改集合对象导致元素定位不准确
    //修改集合后，红黑树（TreeSet底层实现为红黑树）在检索节点时，按照原来算法比较节点时有可能无法找到需要删除的节点
    //这时如果进行类似删除的操作，可能会出现删除不确定性
    //如果删除的节点恰好仍然可以检索到，则可以删除，否则则无法删除
    @SuppressWarnings("unused")
    private static void testTreeSetModify(){
        TreeSetElement.sComparatorFlag = 1;
        treeSet = new TreeSet<>();
        treeSet.add(new TreeSetElement(5));
        treeSet.add(new TreeSetElement(-3));
        treeSet.add(new TreeSetElement(9));
        treeSet.add(new TreeSetElement(-2));
        System.out.println("初始集合：\n"+treeSet);

        TreeSetElement first = treeSet.first();
        first.mCount = 20;
        TreeSetElement last = treeSet.last();
        last.mCount = -2;
        System.out.println("修改集合：\n"+treeSet);

        System.out.println(treeSet.remove(new TreeSetElement(-2))); //红黑树检索不到-2节点
        System.out.println(treeSet);
        System.out.println(treeSet.remove(new TreeSetElement(5))); //红黑树检索不到5节点
        System.out.println(treeSet);
        System.out.println(treeSet.remove(new TreeSetElement(-2))); //红黑树在删除调整后，可以检索到-2节点，这时删除成功
        System.out.println(treeSet);
    }

    //EnumSet：删除集合元素
    @SuppressWarnings("unused")
    private static void testEnumSet() {
        System.out.println(enumSet);
        enumSet.remove(SetSeason.AUTUMN);
        System.out.println(enumSet);
    }
}

enum SetSeason{
    SPRING, SUMMER, AUTUMN, WINTER
}

class TreeSetElement implements Comparable<TreeSetElement>{
    public static int sComparatorFlag;	//Flag of comparator
    int mCount;

    static{
        sComparatorFlag = 0;
    }

    public TreeSetElement() { }
    public TreeSetElement(int count) {
        mCount = count;
    }

    @Override
    public int hashCode() {
        return mCount;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(obj!=null && obj.getClass()==TreeSetElement.class){
            TreeSetElement tElement = (TreeSetElement)obj;
            return tElement.mCount == this.mCount;
        }
        return false;
    }
    @Override
    public String toString() {
        return "T["+ mCount + "]";
    }
    @Override
    public int compareTo(TreeSetElement o) {
        if(sComparatorFlag == 0)
            return 1;
        return mCount < o.mCount ? -1 : mCount > o.mCount ? 1 : 0;
    }
}


class HashSetElement{
    int mCount;
    public HashSetElement() { }
    public HashSetElement(int count) {
        mCount = count;
    }

    @Override
    public String toString() {
        return "HashSetElement[mCount:"+ mCount+"]===hashCode:"+hashCode();
    }
    @Override
    public int hashCode() {
        return this.mCount;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(obj!=null && obj.getClass()==HashSetElement.class){
            HashSetElement r = (HashSetElement)obj;
            return this.mCount == r.mCount;
        }
        return false;
    }
}

