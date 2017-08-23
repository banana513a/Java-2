package com.blackybear.designpattern.creational.SimpleFactory;


/**
 * Description: 简单工厂模式-Simple Factory Pattern
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */

/**
 * 简单工厂模式(Simple Factory Pattern)：【学习难度：★★☆☆☆，使用频率：★★★☆☆】
 * 定义一个工厂类，它可以根据参数的不同返回不同类的实例，被创建的实例通常都具有共同的父类。
 * 因为在简单工厂模式中用于创建实例的方法是静态(static)方法，
 * 因此简单工厂模式又被称为静态工厂方法(Static Factory Method)模式，它属于类创建型模式。
 */

//简单工厂模式提供了专门的工厂类用于创建对象，将对象的创建和对象的使用分离开，它作为一种最简单的工厂模式在软件开发中得到了较为广泛的应用。
//        优点
//        (1) 工厂类包含必要的判断逻辑，可以决定在什么时候创建哪一个产品类的实例，客户端可以免除直接创建产品对象的职责，而仅仅“消费”产品，简单工厂模式实现了对象创建和使用的分离。
//        (2) 客户端无须知道所创建的具体产品类的类名，只需要知道具体产品类所对应的参数即可，对于一些复杂的类名，通过简单工厂模式可以在一定程度减少使用者的记忆量。
//        (3) 通过引入配置文件，可以在不修改任何客户端代码的情况下更换和增加新的具体产品类，在一定程度上提高了系统的灵活性。

//        缺点
//        (1) 由于工厂类集中了所有产品的创建逻辑，职责过重，一旦不能正常工作，整个系统都要受到影响。
//        (2) 使用简单工厂模式势必会增加系统中类的个数（引入了新的工厂类），增加了系统的复杂度和理解难度。
//        (3) 系统扩展困难，一旦添加新产品就不得不修改工厂逻辑，在产品类型较多时，有可能造成工厂逻辑过于复杂，不利于系统的扩展和维护。
//        (4) 简单工厂模式由于使用了静态工厂方法，造成工厂角色无法形成基于继承的等级结构。

//        适用场景
//        在以下情况下可以考虑使用简单工厂模式：
//        (1) 工厂类负责创建的对象比较少，由于创建的对象较少，不会造成工厂方法中的业务逻辑太过复杂。
//        (2) 客户端只知道传入工厂类的参数，对于如何创建对象并不关心
public class SimpleFactoryPattern {
	public static void main(String[] args) {
        Product product = Factory.getProduct("A");
        product.methodSame();
        product.methodDiff();
	}
}

class Factory{
    public static Product getProduct(String productName){
        Product product = null;
        if (productName.equals("A")){
            product = new ConcreteProductA();
        }
        else if (productName.equals("B")){
            product = new ConcreteProductB();
        }
        return product;
    }
}

abstract class Product{
    public void methodSame(){
        System.out.println("Product======>methodSame");
    }
    public abstract void methodDiff();
}


class ConcreteProductA extends Product{
    @Override
    public void methodDiff() {
        System.out.println("ConcreteProductA======>methodDiff");
    }
}

class ConcreteProductB extends Product{
    @Override
    public void methodDiff() {
        System.out.println("ConcreteProductB======>methodDiff");
    }
}


