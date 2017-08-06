package com.blackybear.basis.clazz;

/**
 * Description: 内部类
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class InnerClassTest {
    public static void main(String[] args) {
        printInnerClass();
    }
    public static void printInnerClass() {
        OutClass outClass = new OutClass();
        OutClass.printStatic();
        outClass.print();
    }
}

class OutClass{
    private static int outClassStaticValue = 10;
    private int outClassValue = 20;

    private static int sameNameStaticValue = 30;
    private int sameNameValue = 40;

    protected static class StaticInnerClass{
        private static int innerClassStaticValue = 100;
        private int innerClassValue = 200;
        private static int sameNameValue = 300;

        private void printInnerClassStatic() {
            int sameNameValue = 3000;
            System.out.println(outClassStaticValue);
//			//Cannot make a static reference to the non-static field outClassValue
//			System.out.println(outClassValue);
            System.out.println(sameNameValue);
            System.out.println(StaticInnerClass.sameNameValue);
            System.out.println(OutClass.sameNameStaticValue);
        }
    }
    protected class InnerClass{
        //		//Static field cannot be declared static in a non-static inner type, unless initialized with a constant expression
//		private static int innerClassStaticValue = 100;
        private final static int innerClassStaticValue = 100;
        private int innerClassValue = 200;
        private int sameNameValue = 400;

//		//Static method cannot be declared; static methods can only be declared in a static or top level type
//		private static void printInnerClassStatic(){ }

        private void printInnerClass() {
            int sameNameValue = 4000;
            System.out.println(outClassStaticValue);
            System.out.println(outClassValue);

            System.out.println(sameNameValue);
            System.out.println(this.sameNameValue);
            System.out.println(OutClass.this.sameNameValue);
        }
    }

    public void print() {
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        System.out.println(StaticInnerClass.innerClassStaticValue);
        System.out.println(staticInnerClass.innerClassValue);
        staticInnerClass.printInnerClassStatic();

        InnerClass innerClass = new InnerClass();
        System.out.println(InnerClass.innerClassStaticValue);
        System.out.println(innerClass.innerClassValue);
        innerClass.printInnerClass();
    }
    public static void printStatic() {
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        System.out.println(StaticInnerClass.innerClassStaticValue);
        System.out.println(staticInnerClass.innerClassValue);
        staticInnerClass.printInnerClassStatic();
    }
}

class SubClass extends OutClass.InnerClass{
    public SubClass(OutClass outClass) {
        //Sub class should call the constructor of non-static class InnerClass with outer class instance
        outClass.super();
    }
}

class SubClassStatic extends OutClass.StaticInnerClass{
    public SubClassStatic() {
        super();
    }
}

