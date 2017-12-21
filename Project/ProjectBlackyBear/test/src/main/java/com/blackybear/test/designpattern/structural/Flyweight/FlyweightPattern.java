package com.blackybear.test.designpattern.structural.Flyweight;

/**
 * Description: 享元模式-Flyweight Pattern
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */

import com.alibaba.fastjson.JSON;

import java.util.Hashtable;

/**
 * 享元模式(Flyweight Pattern)：【学习难度：★★★★☆，使用频率：★☆☆☆☆】
 * 运用共享技术有效地支持大量细粒度对象的复用。系统只使用少量的对象，而这些对象都很相似，状态变化很小，可以实现对象的多次复用。
 * 由于享元模式要求能够共享的对象必须是细粒度对象，因此它又称为轻量级模式，它是一种对象结构型模式。
 */
/**
 * 单纯享元模式：在单纯享元模式中，所有的具体享元类都是可以共享的，不存在非共享具体享元类。
 * 复合享元模式：将一些单纯享元对象使用组合模式加以组合，形成复合享元对象，这样的复合享元对象本身不能共享，但是它们可以分解成单纯享元对象，而后者则可以共享。
 */

//当系统中存在大量相同或者相似的对象时，享元模式是一种较好的解决方案，它通过共享技术实现相同或相似的细粒度对象的复用，从而节约了内存空间，提高了系统性能。相比其他结构型设计模式，享元模式的使用频率并不算太高，但是作为一种以“节约内存，提高性能”为出发点的设计模式，它在软件开发中还是得到了一定程度的应用。
//        优点
//        (1) 可以极大减少内存中对象的数量，使得相同或相似对象在内存中只保存一份，从而可以节约系统资源，提高系统性能。
//        (2) 享元模式的外部状态相对独立，而且不会影响其内部状态，从而使得享元对象可以在不同的环境中被共享。

//        缺点
//        (1) 享元模式使得系统变得复杂，需要分离出内部状态和外部状态，这使得程序的逻辑复杂化。
//        (2) 为了使对象可以共享，享元模式需要将享元对象的部分状态外部化，而读取外部状态将使得运行时间变长。

//        适用场景
//        (1) 一个系统有大量相同或者相似的对象，造成内存的大量耗费。
//        (2) 对象的大部分状态都可以外部化，可以将这些外部状态传入对象中。
//        (3) 在使用享元模式时需要维护一个存储享元对象的享元池，而这需要耗费一定的系统资源，因此，应当在需要多次重复使用享元对象时才值得使用享元模式。

public class FlyweightPattern {
    public static void main(String[] args){
        ExtrinsicState extrinsicState1 = new ExtrinsicState("ExtrinsicState1");
        ExtrinsicState extrinsicState2 = new ExtrinsicState("ExtrinsicState2");

        Flyweight flyweight1 = FlyweightFactory.getFlyweight("Flyweight1");
        Flyweight flyweight2 = FlyweightFactory.getFlyweight("Flyweight1");
        System.out.println("是否为同一个享元 : " + (flyweight1 == flyweight2));
        Flyweight flyweight3 = FlyweightFactory.getFlyweight("Flyweight2");
        System.out.println("是否为同一个享元 : " + (flyweight1 == flyweight3));

        flyweight1.operation(extrinsicState1);
        flyweight3.operation(extrinsicState2);
    }
}

//外部状态
class ExtrinsicState{
    private String mExtrinsicState;

    public String getExtrinsicState() {
        return mExtrinsicState;
    }

    public void setExtrinsicState(String extrinsicState) {
        mExtrinsicState = extrinsicState;
    }

    public ExtrinsicState(String extrinsicState) {
        mExtrinsicState = extrinsicState;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

//抽象享元接口
interface Flyweight{
    void operation(ExtrinsicState extrinsicState);
}

//具体享元类
class ConcreteFlyweight implements Flyweight{
    //内部状态intrinsicState作为成员变量，同一个享元对象其内部状态是一致的
    private String mIntrinsicState;

    public String getIntrinsicState() {
        return mIntrinsicState;
    }

    public ConcreteFlyweight(String intrinsicState) {
        mIntrinsicState = intrinsicState;
    }

    @Override
    public void operation(ExtrinsicState extrinsicState) {
        System.out.println("ConcreteFlyweight======>ExtrinsicState : " + extrinsicState);
    }
}

//非共享具体享元类
class UnsharedConcreteFlyweight implements Flyweight{
    //不共享的状态unsharedState，每一个享元对象有各自的状态
    private String mUnsharedState;

    public String getUnsharedState() {
        return mUnsharedState;
    }

    public void setUnsharedState(String unsharedState) {
        mUnsharedState = unsharedState;
    }

    @Override
    public void operation(ExtrinsicState extrinsicState) {
        System.out.println("UnsharedConcreteFlyweight======>operation extrinsicState : " + extrinsicState);
    }
}

class FlyweightFactory{
    //享元池集合
    private static Hashtable<String, Flyweight> mFlyweights;

    //region Singleton
    private static FlyweightFactory instance = new FlyweightFactory();
    private FlyweightFactory(){
        mFlyweights = new Hashtable<>();
        //初始化享元池
        Flyweight flyweight1 = new ConcreteFlyweight("FlyweightIntrinsicState1");
        mFlyweights.put("Flyweight1", flyweight1);
        Flyweight flyweight2 = new ConcreteFlyweight("FlyweightIntrinsicState2");
        mFlyweights.put("Flyweight2", flyweight2);
    }

    public static FlyweightFactory getInstance(){
        return instance;
    }
    //endregion

    public static Flyweight getFlyweight(String key){
        return mFlyweights.get(key);
    }
}
