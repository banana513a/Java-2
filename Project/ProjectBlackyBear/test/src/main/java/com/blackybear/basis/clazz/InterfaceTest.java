package com.blackybear.basis.clazz;

/**
 * Description: 接口
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class InterfaceTest {
    public static void main(String[] args) {

    }
}

class InterfaceImplClass implements TestInterface{
    public void testMethod() {
        System.out.println(intValue);
    }
}

interface TestInterface{
    //Modifier of this variant is "public final"
    int intValue = 10;
    void testMethod();

//	//Only	JDK8 and higher release allows static method for interface
//	public static void testStatic(){
//		System.out.println("Static class method!");
//	}

//	//Only JDK8 and higher release allows default method for interface
//	default void testDefault(){
//		System.out.println("Default method");
//	}
}
