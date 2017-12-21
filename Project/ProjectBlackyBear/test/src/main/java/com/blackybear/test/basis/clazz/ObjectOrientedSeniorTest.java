package com.blackybear.test.basis.clazz;

/**
 * Description: 面向对象进阶
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class ObjectOrientedSeniorTest {
    public static void main(String[] args) {
//		printBaseDeriveClass();
//		printFinal();
//		printWrapClass();
    }

    @SuppressWarnings("unused")
    private static void printBaseDeriveClass() {
        BaseClassSenior class1 = new DerivedClassSenior();
        System.out.println(class1.a);
    }
    @SuppressWarnings("unused")
    private static void printFinal() {
        FinalClass finalClass = new FinalClass();
        finalClass.print();
    }
    @SuppressWarnings("unused")
    private static void printWrapClass() {
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
        //Cache array of integer : -128-127
        Integer integer1 = 100;
        Integer integer2 = 100;
        Integer integer11 = 128;
        Integer integer12 = 128;
        System.out.println(integer1==integer2);
        System.out.println(integer11==integer12);
    }
}

class BaseClassSenior{
    int a = 5;
    public BaseClassSenior() {
        add('a');//System has decided to call base class method in build time
    }
    public void add(int m) {
        System.out.println("Base add");
        a++;
        System.out.println(a);
    }
}
class DerivedClassSenior extends BaseClassSenior{
    int a = 11;
    public DerivedClassSenior() { }
    public void add(char m) {
        System.out.println("Derived add");
        System.out.println(a);
        a++;
        System.out.println(a);
    }
}

class FinalClass{
    private final String FINALSTR = "hello";
    private final String value;
    {
        value = "hello";
    }
    public void print(){
        String s = "hello";
        String str1 = "hell";
        String str2 = "o";
        String str3 = "hell"+"o";
        String str4 = str1 + str2;

        System.out.println(s==value);//true
        System.out.println(s==FINALSTR);//true
        System.out.println(s==str3);//true
        System.out.println(s==str4);//false
    }
}