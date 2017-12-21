package com.blackybear.test.basis.clazz;

/**
 * Description: 匿名类
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class AnonymousClassTest {
    private int value = 10;
    private static int sValue = 100;

    public static void main(String[] args) {
        AnonymousClassTest test = new AnonymousClassTest();
        test.printAnonymousTest();
    }

    private void printAnonymousTest() {
        //Cannot refer to the non-final local variable defined in an enclosing scope
        final int localvalue = 1000;
        callAnonymousClassInterface(new AnonymousInterface() {
            public void print() {
                System.out.println(value);
                System.out.println(sValue);
                System.out.println(localvalue);
            }
        });
        callAnonymousClassSuperClass(new AnonymousAbstractClass() {
            @Override
            public void print() {
                System.out.println(value);
                System.out.println(sValue);
                System.out.println(localvalue);
            }
        });
    }
    private void callAnonymousClassInterface(AnonymousInterface anonymousInterface) {
        anonymousInterface.print();
    }
    private void callAnonymousClassSuperClass(AnonymousAbstractClass anonymousAbstractClass){
        anonymousAbstractClass.print();
    }
}

interface AnonymousInterface{
    void print();
}

abstract class AnonymousAbstractClass{
    public abstract void print();
}
