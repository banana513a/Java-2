package com.blackybear.designpattern.creational;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * Description:
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class Singleton {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println(SingletonByInnerClass.getInstance());
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(SingletonByEnum.INSTANCE.hashCode());
		}
//		breakSingletonByReflect();
//		breakSingletonBySerialize();
	}
	
	public static void breakSingletonBySerialize() {
		try {
			System.out.println(SingletonByInnerClass.getInstance().hashCode());
			
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(SingletonByInnerClass.getInstance());
			
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			SingletonByInnerClass singletonByInnerClass1 = (SingletonByInnerClass)objectInputStream.readObject();
			System.out.println(singletonByInnerClass1.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void breakSingletonByReflect() {
		try {
			System.out.println(SingletonByInnerClass.getInstance().hashCode());

			Class clazz = SingletonByInnerClass.class;
			Constructor constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			SingletonByInnerClass singletonByInnerClass1 = (SingletonByInnerClass)constructor.newInstance();
			SingletonByInnerClass singletonByInnerClass2 = (SingletonByInnerClass)constructor.newInstance();
			System.out.println(singletonByInnerClass1.hashCode());
			System.out.println(singletonByInnerClass2.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void print(){
		System.out.println(SingletonByInnerClass.getInstance());
		System.out.println(SingletonByEnum.INSTANCE.hashCode());
	}
}

//Singleton implemented by inner class
class SingletonByInnerClass implements Serializable{
	private static final long serialVersionUID = 1L;
	private static boolean flag = true;
	private SingletonByInnerClass(){
		if(flag){ 
			flag = !flag; 
		}else {
			try {  
                throw new Exception("Duplicate instance create error!" + SingletonByInnerClass.class.getName());  
            } catch (Exception e) {  
                e.printStackTrace();  
            } 
		}
	}
	private static class SingletonHolder{
		private static final SingletonByInnerClass instance = new SingletonByInnerClass();
	}
	public static SingletonByInnerClass getInstance() {
		return SingletonHolder.instance;
	}
	//Add this method to prevent create another instance
	private Object readResolve() {
		return getInstance();
	}
}

//Singleton implemented by enumeration
enum SingletonByEnum {
	INSTANCE;

	public void print(){
		System.out.println("This is a method in a singleton!");
	}
}