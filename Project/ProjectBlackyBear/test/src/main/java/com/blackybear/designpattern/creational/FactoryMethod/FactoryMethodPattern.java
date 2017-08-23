package com.blackybear.designpattern.creational.FactoryMethod;

/**
 * Description: 工厂方法模式-Factory Method Pattern
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */

/**
 * 工厂方法模式(Factory Method Pattern)：【学习难度：★★☆☆☆，使用频率：★★★★★】
 * 定义一个用于创建对象的接口，让子类决定将哪一个类实例化。工厂方法模式让一个类的实例化延迟到其子类。
 * 工厂方法模式又简称为工厂模式(Factory Pattern)，
 * 又可称作虚拟构造器模式(Virtual Constructor Pattern)或多态工厂模式(Polymorphic Factory Pattern)。
 * 工厂方法模式是一种类创建型模式。
 */

//工厂方法模式是简单工厂模式的延伸，它继承了简单工厂模式的优点，同时还弥补了简单工厂模式的不足。工厂方法模式是使用频率最高的设计模式之一，是很多开源框架和API类库的核心模式。
//        优点
//        (1) 在工厂方法模式中，工厂方法用来创建客户所需要的产品，同时还向客户隐藏了哪种具体产品类将被实例化这一细节，用户只需要关心所需产品对应的工厂，无须关心创建细节，甚至无须知道具体产品类的类名。
//        (2) 基于工厂角色和产品角色的多态性设计是工厂方法模式的关键。它能够让工厂可以自主确定创建何种产品对象，而如何创建这个对象的细节则完全封装在具体工厂内部。工厂方法模式之所以又被称为多态工厂模式，就正是因为所有的具体工厂类都具有同一抽象父类。
//        (3) 使用工厂方法模式的另一个优点是在系统中加入新产品时，无须修改抽象工厂和抽象产品提供的接口，无须修改客户端，也无须修改其他的具体工厂和具体产品，而只要添加一个具体工厂和具体产品就可以了，这样，系统的可扩展性也就变得非常好，完全符合“开闭原则”。

//        缺点
//        (1) 在添加新产品时，需要编写新的具体产品类，而且还要提供与之对应的具体工厂类，系统中类的个数将成对增加，在一定程度上增加了系统的复杂度，有更多的类需要编译和运行，会给系统带来一些额外的开销。
//        (2) 由于考虑到系统的可扩展性，需要引入抽象层，在客户端代码中均使用抽象层进行定义，增加了系统的抽象性和理解难度，且在实现时可能需要用到DOM、反射等技术，增加了系统的实现难度。

//        适用场景
//        (1) 客户端不知道它所需要的对象的类。在工厂方法模式中，客户端不需要知道具体产品类的类名，只需要知道所对应的工厂即可，具体的产品对象由具体工厂类创建，可将具体工厂类的类名存储在配置文件或数据库中。
//        (2) 抽象工厂类通过其子类来指定创建哪个对象。在工厂方法模式中，对于抽象工厂类只需要提供一个创建产品的接口，而由其子类来确定具体要创建的对象，利用面向对象的多态性和里氏代换原则，在程序运行时，子类对象将覆盖父类对象，从而使得系统更容易扩展。
public class FactoryMethodPattern {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactoryA(); //配置文件+反射实现
        Product product = factory.create();
        product.methodSame();
        product.methodDiff();
    }
}

interface Factory{
    Product create();
}

class ConcreteFactoryA implements Factory {
    @Override
    public Product create() {
        System.out.println("ConcreteFactoryA======>create");
        return new ConcreteProductA();
    }
}

class ConcreteFactoryB implements Factory{
    @Override
    public Product create() {
        System.out.println("ConcreteFactoryB======>create");
        return new ConcreteProductB();
    }
}


abstract class Product{
    public void methodSame(){
        System.out.println("Product======>methodSame");
    }
    public abstract void methodDiff();
}


class ConcreteProductA extends Product {
    @Override
    public void methodDiff() {
        System.out.println("ConcreteProductA======>methodDiff");
    }
}

class ConcreteProductB extends Product {
    @Override
    public void methodDiff() {
        System.out.println("ConcreteProductB======>methodDiff");
    }
}
