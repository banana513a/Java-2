package com.blackybear.test.basis.clazz;

/**
 * Description: 抽象类
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class AbstractClassTest {
    public static void main(String[] args) {

    }
}
abstract class BaseAbstractClass{
    int intValue = 10;
    public int getIntValue() {
        return intValue;
    }
    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }
    public void print() {
        System.out.println("This is a instance method!");
    }
    public abstract void printAbstract();
}

class DerivedAbstractClass extends BaseAbstractClass{
    @Override
    public void printAbstract() {
        intValue = 10;
        System.out.println(intValue);
    }
}