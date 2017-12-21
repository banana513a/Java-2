package com.blackybear.test.designpattern.creational.Singleton;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * Description: 单例模式-SingletonPattern Pattern
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */

/**
 * 单例模式(SingletonPattern Pattern)：【学习难度：★☆☆☆☆，使用频率：★★★★☆】
 * 确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例，这个类称为单例类，它提供全局访问的方法。
 * 单例模式是一种对象创建型模式。
 */

//单例模式作为一种目标明确、结构简单、理解容易的设计模式，在软件开发中使用频率相当高，在很多应用软件和框架中都得以广泛应用。
//        优点
//        (1) 单例模式提供了对唯一实例的受控访问。因为单例类封装了它的唯一实例，所以它可以严格控制客户怎样以及何时访问它。
//        (2) 由于在系统内存中只存在一个对象，因此可以节约系统资源，对于一些需要频繁创建和销毁的对象单例模式无疑可以提高系统的性能。
//        (3) 允许可变数目的实例。基于单例模式我们可以进行扩展，使用与单例控制相似的方法来获得指定个数的对象实例，既节省系统资源，又解决了单例单例对象共享过多有损性能的问题。

//        缺点
//        (1) 由于单例模式中没有抽象层，因此单例类的扩展有很大的困难。
//        (2) 单例类的职责过重，在一定程度上违背了“单一职责原则”。因为单例类既充当了工厂角色，提供了工厂方法，同时又充当了产品角色，包含一些业务方法，将产品的创建和产品的本身的功能融合到一起。
//        (3) 现在很多面向对象语言(如Java、C#)的运行环境都提供了自动垃圾回收的技术，因此，如果实例化的共享对象长时间不被利用，系统会认为它是垃圾，会自动销毁并回收资源，下次利用时又将重新实例化，这将导致共享的单例对象状态的丢失。

//        适用场景
//        (1) 系统只需要一个实例对象，如系统要求提供一个唯一的序列号生成器或资源管理器，或者需要考虑资源消耗太大而只允许创建一个对象。
//        (2) 客户调用类的单个实例只允许使用一个公共访问点，除了该公共访问点，不能通过其他途径访问该实例。

public class SingletonPattern {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println(Singleton.getInstance());
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(EnumSingleton.INSTANCE.hashCode());
		}
//		breakSingletonByReflect();
//		breakSingletonBySerialize();
	}

	/**
	 * 序列化破坏单例唯一性
	 */
	public static void breakSingletonBySerialize() {
		try {
			System.out.println(Singleton.getInstance().hashCode());
			
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(Singleton.getInstance());
			
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			Singleton singletonByInnerClass1 = (Singleton)objectInputStream.readObject();
			System.out.println(singletonByInnerClass1.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

    /**
     * 反射破坏单例唯一性
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void breakSingletonByReflect() {
		try {
			System.out.println(Singleton.getInstance().hashCode());

			Class clazz = Singleton.class;
			Constructor constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			Singleton singleton1 = (Singleton)constructor.newInstance();
			Singleton singleton2 = (Singleton)constructor.newInstance();
			System.out.println(singleton1.hashCode());
			System.out.println(singleton2.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * 单例类：饿汉实现
 */
class EagerSingleton{
    private final static EagerSingleton instance = new EagerSingleton();
    private EagerSingleton() {}
    public static EagerSingleton getInstance(){
        return instance;
    }
}

/**
 * 单例类：懒汉实现
 */
class LazySingleton{
    private static LazySingleton instance;
    private LazySingleton(){}
    public static LazySingleton getInstance(){
        if (instance == null){
            synchronized (LazySingleton.class){
                if (instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

/**
 * 单例类：IoDH实现（Initialization on Demand Holder）
 */
class IoDHSingleton {
    private IoDHSingleton() {}
    private static class IoDHSingletonHolder {
        public final static IoDHSingleton INSTANCE = new IoDHSingleton();
    }

    public static IoDHSingleton getInstance(){
        return IoDHSingletonHolder.INSTANCE;
    }
}

/**
 * 单例类：IoDH实现（反射攻击+反序列化攻击处理）
 */
class Singleton implements Serializable{
    //单例唯一性标识
	private static boolean flag = true;
	private Singleton(){
	    synchronized (Singleton.class){
            if(flag){
                flag = false;
            }else {
                try {
                    throw new Exception("Duplicate instance create error!" + Singleton.class.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
	private static class SingletonHolder{
		private static final Singleton instance = new Singleton();
	}
	public static Singleton getInstance() {
		return SingletonHolder.instance;
	}
	//防止反序列化造成的单例不唯一
	private Object readResolve() {
	    return getInstance();
	}
}

/**
 * 单例类：枚举实现
 */
enum EnumSingleton {
	INSTANCE;

	public void print(){
		System.out.println("This is a method in a singleton!");
	}
}