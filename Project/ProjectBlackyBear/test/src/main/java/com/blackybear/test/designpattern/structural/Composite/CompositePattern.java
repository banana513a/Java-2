package com.blackybear.test.designpattern.structural.Composite;

/**
 * Description: 组合模式-Composite Pattern
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式(Composite Pattern)：【学习难度：★★★☆☆，使用频率：★★★★☆】
 * 组合多个对象形成树形结构以表示具有“整体—部分”关系的层次结构。
 * 组合模式对单个对象（即叶子对象）和组合对象（即容器对象）的使用具有一致性。
 * 组合模式又可以称为“整体—部分”(Part-Whole)模式，它是一种对象结构型模式。
 */

//组合模式使用面向对象的思想来实现树形结构的构建与处理，描述了如何将容器对象和叶子对象进行递归组合，实现简单，灵活性好。由于在软件开发中存在大量的树形结构，因此组合模式是一种使用频率较高的结构型设计模式。
//        优点
//        (1) 组合模式可以清楚地定义分层次的复杂对象，表示对象的全部或部分层次，它让客户端忽略了层次的差异，方便对整个层次结构进行控制。
//        (2) 客户端可以一致地使用一个组合结构或其中单个对象，不必关心处理的是单个对象还是整个组合结构，简化了客户端代码。
//        (3) 在组合模式中增加新的容器构件和叶子构件都很方便，无须对现有类库进行任何修改，符合“开闭原则”。
//        (4) 组合模式为树形结构的面向对象实现提供了一种灵活的解决方案，通过叶子对象和容器对象的递归组合，可以形成复杂的树形结构，但对树形结构的控制却非常简单。

//        缺点
//        在增加新构件时很难对容器中的构件类型进行限制。
//        有时候我们希望一个容器中只能有某些特定类型的对象，例如在某个文件夹中只能包含文本文件，使用组合模式时，不能依赖类型系统来施加这些约束，因为它们都来自于相同的抽象层，在这种情况下，必须通过在运行时进行类型检查来实现，这个实现过程较为复杂。

//        适用场景
//        (1) 在具有整体和部分的层次结构中，希望通过一种方式忽略整体与部分的差异，客户端可以一致地对待它们。
//        (2) 在一个使用面向对象语言开发的系统中需要处理一个树形结构。
//        (3) 在一个系统中能够分离出叶子对象和容器对象，而且它们的类型不固定，需要增加一些新的类型。

public class CompositePattern {
    public static void main(String[] args){
        Component compositeWhole = new Composite();
        Component compositePart = new Composite();

        Component leaf11 = new Leaf();
        Component leaf12 = new Leaf();
        Component leaf13 = new Leaf();
        compositeWhole.add(leaf11);
        compositeWhole.add(leaf12);
        compositeWhole.add(leaf13);
        compositeWhole.add(compositePart);

        Component leaf21 = new Leaf();
        Component leaf22 = new Leaf();
        Component leaf23 = new Leaf();
        compositePart.add(leaf21);
        compositePart.add(leaf22);
        compositePart.add(leaf23);

        compositeWhole.operation();
    }
}

//抽象构件
abstract class Component{
    //region 管理和访问成员构件的方法
    public void add(Component component){
        System.out.println("Component======>add");
    }
    public void remove(Component component){
        System.out.println("Component======>remove");
    }
    public Component getChild(int i){
        System.out.println("Component======>getChild");
        return null;
    }
    //endregion
    public abstract void operation();
}

//叶子构件
class Leaf extends Component{
    @Override
    public void operation() {
        System.out.println("Leaf======>operation : " + hashCode());
    }
}

//容器构件
class Composite extends Component{
    List<Component> mComponents = new ArrayList<>();
    @Override
    public void add(Component component) {
        mComponents.add(component);
    }

    @Override
    public void remove(Component component) {
        mComponents.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return mComponents.get(i);
    }

    @Override
    public void operation() {
        System.out.println("Composite======>operation : " + hashCode());
        for (int i = 0, len = mComponents.size(); i < len; i++) {
            mComponents.get(i).operation();
        }
    }
}

