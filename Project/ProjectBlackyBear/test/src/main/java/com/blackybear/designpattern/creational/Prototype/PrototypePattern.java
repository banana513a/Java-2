package com.blackybear.designpattern.creational.Prototype;

/**
 * Description: 原型模式-Prototype Pattern
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */

import java.io.*;

/**
 *  原型模式(Prototype Pattern)：【学习难度：★★★☆☆，使用频率：★★★☆☆】
 *  使用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 *  原型模式是一种对象创建型模式。
 */

//原型模式作为一种快速创建大量相同或相似对象的方式，在软件开发中应用较为广泛，很多软件提供的复制(Ctrl + C)和粘贴(Ctrl + V)操作就是原型模式的典型应用，下面对该模式的使用效果和适用情况进行简单的总结。
//        优点
//        (1) 当创建新的对象实例较为复杂时，使用原型模式可以简化对象的创建过程，通过复制一个已有实例可以提高新实例的创建效率。
//        (2) 扩展性较好，由于在原型模式中提供了抽象原型类，在客户端可以针对抽象原型类进行编程，而将具体原型类写在配置文件中，增加或减少产品类对原有系统都没有任何影响。
//        (3) 原型模式提供了简化的创建结构，工厂方法模式常常需要有一个与产品类等级结构相同的工厂等级结构，而原型模式就不需要这样，原型模式中产品的复制是通过封装在原型类中的克隆方法实现的，无须专门的工厂类来创建产品。
//        (4) 可以使用深克隆的方式保存对象的状态，使用原型模式将对象复制一份并将其状态保存起来，以便在需要的时候使用（如恢复到某一历史状态），可辅助实现撤销操作。

//        缺点
//        (1) 需要为每一个类配备一个克隆方法，而且该克隆方法位于一个类的内部，当对已有的类进行改造时，需要修改源代码，违背了“开闭原则”。
//        (2) 在实现深克隆时需要编写较为复杂的代码，而且当对象之间存在多重的嵌套引用时，为了实现深克隆，每一层对象对应的类都必须支持深克隆，实现起来可能会比较麻烦。

//        适用场景
//        (1) 创建新对象成本较大（如初始化需要占用较长的时间，占用太多的CPU资源或网络资源），新的对象可以通过原型模式对已有对象进行复制来获得，如果是相似对象，则可以对其成员变量稍作修改。
//        (2) 如果系统要保存对象的状态，而对象的状态变化很小，或者对象本身占用内存较少时，可以使用原型模式配合备忘录模式来实现。
//        (3) 需要避免使用分层次的工厂类来创建分层次的对象，并且类的实例对象只有一个或很少的几个组合状态，通过复制原型对象得到新实例可能比使用构造函数创建一个新实例更加方便。

public class PrototypePattern {
    public static void main(String[] args){
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAttribute("test");
        ConcretePrototype newPrototype = prototype.prototypeClone();
        System.out.println(newPrototype.getAttribute());

        shallowClone();
        deepClone();
    }

    /**
     * 浅克隆
     */
    private static void shallowClone(){
        RefPrototype refPrototype = new RefPrototype();
        refPrototype.setRefAttribute("RefAttribute");

        ShallowClonePrototype shallowClonePrototype = new ShallowClonePrototype();
        shallowClonePrototype.setAttribute("ShallowAttribute");
        shallowClonePrototype.setRefPrototype(refPrototype);

        ShallowClonePrototype newShallowClonePrototype = null;
        try {
            newShallowClonePrototype = shallowClonePrototype.shallowClone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("ShallowClonePrototype =======> obj : " + shallowClonePrototype.hashCode() + ", objRef : " + shallowClonePrototype.getRefPrototype().hashCode());
        System.out.println("ShallowClonePrototype =======> newObj : " + (newShallowClonePrototype != null ? newShallowClonePrototype.hashCode() : null) + ", objRef : " + newShallowClonePrototype.getRefPrototype().hashCode());
    }

    /**
     * 深克隆
     */
    private static void deepClone(){
        RefPrototype refPrototype = new RefPrototype();
        refPrototype.setRefAttribute("RefAttribute");

        DeepClonePrototype deepClonePrototype = new DeepClonePrototype();
        deepClonePrototype.setAttribute("ShallowAttribute");
        deepClonePrototype.setRefPrototype(refPrototype);

        DeepClonePrototype newDeepClonePrototype = null;
        try {
            newDeepClonePrototype = deepClonePrototype.deepClone();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("DeepClonePrototype =======> obj : " + deepClonePrototype.hashCode() + ", objRef : " + deepClonePrototype.getRefPrototype().hashCode());
        System.out.println("DeepClonePrototype =======> newObj : " + (newDeepClonePrototype != null ? newDeepClonePrototype.hashCode() : null) + ", objRef : " + newDeepClonePrototype.getRefPrototype().hashCode());
    }
}

//抽象原型
interface Prototype{
    Prototype prototypeClone();
}

//原型实现
class ConcretePrototype implements Prototype{
    private String attribute;
    public String getAttribute() {
        return attribute;
    }
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public ConcretePrototype prototypeClone() {
        ConcretePrototype concretePrototype = new ConcretePrototype();
        concretePrototype.setAttribute(attribute);
        return concretePrototype;
    }
}

/**
 * 浅克隆实现，引用类型成员对象只复制引用地址
 */
class ShallowClonePrototype implements Cloneable{
    private String mAttribute;
    private RefPrototype mRefPrototype;

    public String getAttribute() {
        return mAttribute;
    }

    public void setAttribute(String attribute) {
        this.mAttribute = attribute;
    }

    public RefPrototype getRefPrototype() {
        return mRefPrototype;
    }

    public void setRefPrototype(RefPrototype refPrototype) {
        mRefPrototype = refPrototype;
    }

    public ShallowClonePrototype shallowClone() throws CloneNotSupportedException {
        return (ShallowClonePrototype)super.clone();
    }
}

/**
 * 深克隆实现：引用类型成员对象完全复制
 */
class DeepClonePrototype implements Serializable{
    private String mAttribute;
    private RefPrototype mRefPrototype;

    public String getAttribute() {
        return mAttribute;
    }

    public void setAttribute(String attribute) {
        mAttribute = attribute;
    }

    public RefPrototype getRefPrototype() {
        return mRefPrototype;
    }

    public void setRefPrototype(RefPrototype refPrototype) {
        mRefPrototype = refPrototype;
    }

    public DeepClonePrototype deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (DeepClonePrototype) ois.readObject();
    }
}


//引用成员类
class RefPrototype implements Serializable{
    private String mRefAttribute;
    public String getRefAttribute() {
        return mRefAttribute;
    }
    public void setRefAttribute(String refAttribute) {
        this.mRefAttribute = refAttribute;
    }
}