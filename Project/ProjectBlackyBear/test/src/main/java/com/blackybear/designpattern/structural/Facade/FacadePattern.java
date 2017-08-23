package com.blackybear.designpattern.structural.Facade;

/**
 * Description: 外观模式-Facade Pattern
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */

/**
 * 外观模式：【学习难度：★☆☆☆☆，使用频率：★★★★★】
 * 为子系统中的一组接口提供一个统一的入口。外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
 * 外观模式是迪米特法则的一种具体实现，通过引入一个新的外观角色可以降低原有系统的复杂度，同时降低客户类与子系统的耦合度。
 * 外观模式又称为门面模式，它是一种对象结构型模式。
 */

//外观模式是一种使用频率非常高的设计模式，它通过引入一个外观角色来简化客户端与子系统之间的交互，为复杂的子系统调用提供一个统一的入口，使子系统与客户端的耦合度降低，且客户端调用非常方便。外观模式并不给系统增加任何新功能，它仅仅是简化调用接口。在几乎所有的软件中都能够找到外观模式的应用，如绝大多数B/S系统都有一个首页或者导航页面，大部分C/S系统都提供了菜单或者工具栏，在这里，首页和导航页面就是B/S系统的外观角色，而菜单和工具栏就是C/S系统的外观角色，通过它们用户可以快速访问子系统，降低了系统的复杂程度。所有涉及到与多个业务对象交互的场景都可以考虑使用外观模式进行重构。
//        优点
//        (1) 它对客户端屏蔽了子系统组件，减少了客户端所需处理的对象数目，并使得子系统使用起来更加容易。通过引入外观模式，客户端代码将变得很简单，与之关联的对象也很少。
//        (2) 它实现了子系统与客户端之间的松耦合关系，这使得子系统的变化不会影响到调用它的客户端，只需要调整外观类即可。
//        (3) 一个子系统的修改对其他子系统没有任何影响，而且子系统内部变化也不会影响到外观对象。

//        缺点
//        (1) 不能很好地限制客户端直接使用子系统类，如果对客户端访问子系统类做太多的限制则减少了可变性和灵活 性。
//        (2) 如果设计不当，增加新的子系统可能需要修改外观类的源代码，违背了开闭原则。

//        适用场景
//        (1) 当要为访问一系列复杂的子系统提供一个简单入口时可以使用外观模式。
//        (2) 客户端程序与多个子系统之间存在很大的依赖性。引入外观类可以将子系统与客户端解耦，从而提高子系统的独立性和可移植性。
//        (3) 在层次化结构中，可以使用外观模式定义系统中每一层的入口，层与层之间不直接产生联系，而通过外观类建立联系，降低层之间的耦合度。
public class FacadePattern {
    public static void main(String[] args){
        Facade facade = new ConcreteFacade();
        facade.methodCall();
    }
}

//抽象外观类
abstract class Facade{
    public abstract void methodCall();
}

//具体外观类
class ConcreteFacade extends Facade{
    private SystemA mSystemA;
    private SystemB mSystemB;
    @Override
    public void methodCall() {
        mSystemA.methodCallA();
        mSystemB.methodCallB();
    }
}

//子系统A
class SystemA{
    public void methodCallA(){
        System.out.println("SystemA======>methodCallA");
    }
}

//子系统B
class SystemB{
    public void methodCallB(){
        System.out.println("SystemB======>methodCallB");
    }
}