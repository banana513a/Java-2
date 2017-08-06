package com.blackybear.basis.clazz;

/**
 * Description: 面向对象
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class ObjectOrientedTest {
    public static void main(String[] args) {
//		printInherit();									//Different instance of class between build and runtime
//		printInitialization();						//Order of class constructor initialization
//		printMethodParameterPass();		//Difference between value parameter and reference parameter which passed to method
    }

    public static void printInherit() {
        BaseClass bc = new BaseClass();
        DerivedClass dc = new DerivedClass();
        BaseClass dcType = new DerivedClass();
        BaseClass bcType = (BaseClass)new DerivedClass();
        bc.print();
        dc.print();
        dcType.print();
        bcType.print();
        System.out.println(bc.baseValue);
        System.out.println(dc.baseValue);
        System.out.println(dc.derviedValue);
//		Build Error : derivedValue cannot be resolved or is not a field
//		System.out.println(bcdc.derivedValue);
        System.out.println(bcType.baseValue);
    }
    @SuppressWarnings("unused")
    public static void printInitialization() {
        InitializationClass ic = new InitializationClass();
        InitializationClass ic1 = new InitializationClass();
        InitializationClass ic2 = new InitializationClass();
    }
    public static void printMethodParameterPass() {
        ReferenceClass rc = new ReferenceClass();
        System.out.println(rc.hashCode());
        swap(rc);
        System.out.println(rc.hashCode());
    }

    private static void swap(ReferenceClass rc) {
        System.out.println(rc.hashCode());
        ReferenceClass rc2 = new ReferenceClass();
        System.out.println(rc2.hashCode());
        rc = rc2;
        System.out.println(rc.hashCode());
    }
}

class ReferenceClass{
    int a;
    int b;
}

class InitializationClass{
    private static int staticValue = 1;
    private int localValue = 10;

    static {
        staticValue++;
        System.out.println("After static initialization----->staticvalue : "+staticValue);
    }
    {
        staticValue++;
        localValue++;
        System.out.println("After instance initialization----->staticvalue : "+staticValue + " localvalue : " + localValue);
    }
    public InitializationClass() {
        System.out.println("Constructor----->staticvalue : "+ staticValue + " localvalue : "+ localValue);
    }
}

class BaseClass{
    public int baseValue = 10;

    public BaseClass() { }

    public void print() {
        System.out.println("BaseClass----->print()");
    }
}

class DerivedClass extends BaseClass{
    public int derviedValue = 20;
    public String derviedStringValue = null;

    public DerivedClass() {
        super();
    }
    public DerivedClass(int derviedValue) {
        this();
        this.derviedValue = derviedValue;
        System.out.println("");
    }

    public DerivedClass(String derviedStringValue, int derviedValue){
        this(derviedValue);
        this.derviedStringValue = derviedStringValue;
    }

    @Override
    public void print() {
        System.out.println("DerivedClass----->print()");
    }

    public void derivedPrint(){
        System.out.println("DerivedClass----->print()");
    }
}