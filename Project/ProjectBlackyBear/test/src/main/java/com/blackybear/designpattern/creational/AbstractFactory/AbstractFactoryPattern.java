package com.blackybear.designpattern.creational.AbstractFactory;

/**
 * Description: 抽象工厂模式-Abstract Factory Pattern
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */

/**
 * 抽象工厂模式(Abstract Factory Pattern)：【学习难度：★★★★☆，使用频率：★★★★★】
 * 提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。
 * 抽象工厂模式又称为Kit模式，它是一种对象创建型模式。
 */

//抽象工厂模式是工厂方法模式的进一步延伸，由于它提供了功能更为强大的工厂类并且具备较好的可扩展性，在软件开发中得以广泛应用，尤其是在一些框架和API类库的设计中，例如在Java语言的AWT（抽象窗口工具包）中就使用了抽象工厂模式，它使用抽象工厂模式来实现在不同的操作系统中应用程序呈现与所在操作系统一致的外观界面。抽象工厂模式也是在软件开发中最常用的设计模式之一。
//        优点
//        (1) 抽象工厂模式隔离了具体类的生成，使得客户并不需要知道什么被创建。由于这种隔离，更换一个具体工厂就变得相对容易，所有的具体工厂都实现了抽象工厂中定义的那些公共接口，因此只需改变具体工厂的实例，就可以在某种程度上改变整个软件系统的行为。
//        (2) 当一个产品族中的多个对象被设计成一起工作时，它能够保证客户端始终只使用同一个产品族中的对象。
//        (3) 增加新的产品族很方便，无须修改已有系统，符合“开闭原则”。

//        缺点
//        增加新的产品等级结构麻烦，需要对原有系统进行较大的修改，甚至需要修改抽象层代码，这显然会带来较大的不便，违背了“开闭原则”。

//        适用场景
//        (1) 一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节，这对于所有类型的工厂模式都是很重要的，用户无须关心对象的创建过程，将对象的创建和使用解耦。
//        (2) 系统中有多于一个的产品族，而每次只使用其中某一产品族。可以通过配置文件等方式来使得用户可以动态改变产品族，也可以很方便地增加新的产品族。
//        (3) 属于同一个产品族的产品将在一起使用，这一约束必须在系统的设计中体现出来。同一个产品族中的产品可以是没有任何关系的对象，但是它们都具有一些共同的约束，如同一操作系统下的按钮和文本框，按钮与文本框之间没有直接关系，但它们都是属于某一操作系统的，此时具有一个共同的约束条件：操作系统的类型。
//        (4) 产品等级结构稳定，设计完成之后，不会向系统中增加新的产品等级结构或者删除已有的产品等级结构。
public class AbstractFactoryPattern {
    public static void main(String[] args){
        AbstractFactory factory = new ConcreteFactory1();
        ProductA productA = factory.createProductA();
        ProductB productB = factory.createProductB();
        productA.methodSame();
        productA.methodDiff();
        productB.methodSame();
        productB.methodDiff();
    }
}

//抽象工厂（产品族）
interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

class ConcreteFactory1 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        System.out.println("ConcreteFactoryA======>createProductA");
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createProductB() {
        System.out.println("ConcreteFactoryB======>createProductB");
        return new ConcreteProductB1();
    }
}

class ConcreteFactory2 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        System.out.println("ConcreteFactoryA======>createProductA");
        return new ConcreteProductA2();
    }

    @Override
    public ProductB createProductB() {
        System.out.println("ConcreteFactoryB======>createProductB");
        return new ConcreteProductB2();
    }
}


//抽象产品A系列（产品结构）
abstract class ProductA{
    public void methodSame(){
        System.out.println("ProductA======>methodSame");
    }
    public abstract void methodDiff();
}


class ConcreteProductA1 extends ProductA {
    @Override
    public void methodDiff() {
        System.out.println("ConcreteProductA1======>methodDiff");
    }
}

class ConcreteProductA2 extends ProductA {
    @Override
    public void methodDiff() {
        System.out.println("ConcreteProductA2======>methodDiff");
    }
}


//抽象产品B系列（产品结构）
abstract class ProductB{
    public void methodSame(){
        System.out.println("ProductB======>methodSame");
    }
    public abstract void methodDiff();
}


class ConcreteProductB1 extends ProductB {
    @Override
    public void methodDiff() {
        System.out.println("ConcreteProductB1======>methodDiff");
    }
}

class ConcreteProductB2 extends ProductB {
    @Override
    public void methodDiff() {
        System.out.println("ConcreteProductB2======>methodDiff");
    }
}