package com.blackybear.test.designpattern.structural.Proxy;

/**
 * Description: 代理模式-Proxy Pattern
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */

/**
 * 代理模式：【学习难度：★★★☆☆，使用频率：★★★★☆】
 * 给某一个对象提供一个代理或占位符，并由代理对象来控制对原对象的访问。
 * 在代理模式中引入了一个新的代理对象，代理对象在客户端对象和目标对象之间起到中介的作用，它去掉客户不能看到的内容和服务或者增添客户需要的额外的新服务。
 * 代理模式是一种对象结构型模式。
 */

//代理模式是常用的结构型设计模式之一，它为对象的间接访问提供了一个解决方案，可以对对象的访问进行控制。代理模式类型较多，其中远程代理、虚拟代理、保护代理等在软件开发中应用非常广泛。+
//        优点
//        代理模式的共同优点如下：
//        (1) 能够协调调用者和被调用者，在一定程度上降低了系统的耦合度。
//        (2) 客户端可以针对抽象主题角色进行编程，增加和更换代理类无须修改源代码，符合开闭原则，系统具有较好的灵活性和可扩展性。
//        此外，不同类型的代理模式也具有独特的优点，例如：
//        (1) 远程代理为位于两个不同地址空间对象的访问提供了一种实现机制，可以将一些消耗资源较多的对象和操作移至性能更好的计算机上，提高系统的整体运行效率。
//        (2) 虚拟代理通过一个消耗资源较少的对象来代表一个消耗资源较多的对象，可以在一定程度上节省系统的运行开销。
//        (3) 缓冲代理为某一个操作的结果提供临时的缓存存储空间，以便在后续使用中能够共享这些结果，优化系统性能，缩短执行时间。
//        (4) 保护代理可以控制对一个对象的访问权限，为不同用户提供不同级别的使用权限。
//        缺点
//        (1) 由于在客户端和真实主题之间增加了代理对象，因此有些类型的代理模式可能会造成请求的处理速度变慢，例如保护代理。
//        (2) 实现代理模式需要额外的工作，而且有些代理模式的实现过程较为复杂，例如远程代理。
//        适用场景
//        (1) 当客户端对象需要访问远程主机中的对象时可以使用远程代理。
//        (2) 当需要用一个消耗资源较少的对象来代表一个消耗资源较多的对象，从而降低系统开销、缩短运行时间时可以使用虚拟代理，例如一个对象需要很长时间才能完成加载时。
//        (3) 当需要为某一个被频繁访问的操作结果提供一个临时存储空间，以供多个客户端共享访问这些结果时可以使用缓冲代理。通过使用缓冲代理，系统无须在客户端每一次访问时都重新执行操作，只需直接从临时缓冲区获取操作结果即可。
//        (4) 当需要控制对一个对象的访问，为不同用户提供不同级别的访问权限时可以使用保护代理。
//        (5) 当需要为一个对象的访问（引用）提供一些额外的操作时可以使用智能引用代理。
public class ProxyPattern {
    public static void main(String[] args){
        Proxy proxy = new Proxy();
        proxy.request();
    }
}

//主题接口
interface Subject{
    void request();
}

//真实主题角色
class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("RealSubject======>request");
    }
}

//代理主题角色
class Proxy implements Subject{
    private RealSubject mRealSubject = new RealSubject();

    @Override
    public void request() {
        preRequest();
        mRealSubject.request();
        postRequest();
    }

    public void preRequest(){
        System.out.println("Proxy======>preRequest");
    }

    public void postRequest(){
        System.out.println("Proxy======>postRequest");
    }
}
