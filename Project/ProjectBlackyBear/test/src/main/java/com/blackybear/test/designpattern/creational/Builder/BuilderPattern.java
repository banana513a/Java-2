package com.blackybear.test.designpattern.creational.Builder;

/**
 * Description: 建造者模式-Builder Pattern
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */

import com.alibaba.fastjson.JSON;

/**
 * 建造者模式(Builder Pattern)：【学习难度：★★★★☆，使用频率：★★☆☆☆】
 * 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * 建造者模式是一种对象创建型模式。
 */

//建造者模式的核心在于如何一步步构建一个包含多个组成部件的完整对象，使用相同的构建过程构建不同的产品，在软件开发中，如果我们需要创建复杂对象并希望系统具备很好的灵活性和可扩展性可以考虑使用建造者模式。
//        优点
//        (1) 在建造者模式中，客户端不必知道产品内部组成的细节，将产品本身与产品的创建过程解耦，使得相同的创建过程可以创建不同的产品对象。
//        (2) 每一个具体建造者都相对独立，而与其他的具体建造者无关，因此可以很方便地替换具体建造者或增加新的具体建造者，用户使用不同的具体建造者即可得到不同的产品对象。由于指挥者类针对抽象建造者编程，增加新的具体建造者无须修改原有类库的代码，系统扩展方便，符合“开闭原则”
//        (3) 可以更加精细地控制产品的创建过程。将复杂产品的创建步骤分解在不同的方法中，使得创建过程更加清晰，也更方便使用程序来控制创建过程。

//        缺点
//        (1) 建造者模式所创建的产品一般具有较多的共同点，其组成部分相似，如果产品之间的差异性很大，例如很多组成部分都不相同，不适合使用建造者模式，因此其使用范围受到一定的限制。
//        (2) 如果产品的内部变化复杂，可能会导致需要定义很多具体建造者类来实现这种变化，导致系统变得很庞大，增加系统的理解难度和运行成本。

//        适用场景
//        (1) 需要生成的产品对象有复杂的内部结构，这些产品对象通常包含多个成员属性。
//        (2) 需要生成的产品对象的属性相互依赖，需要指定其生成顺序。
//        (3) 对象的创建过程独立于创建该对象的类。在建造者模式中通过引入了指挥者类，将创建过程封装在指挥者类中，而不在建造者类和客户类中。+
//        (4) 隔离复杂对象的创建和使用，并使得相同的创建过程可以创建不同的产品。

public class BuilderPattern {
    public static void main(String[] args){
        Builder builder = new ConcreteBuilder1();
        Director director = new Director(builder);
        Product product = director.construct();
        System.out.println(product);
    }
}

//建造者抽象
interface Builder{
    Product product = new Product();

    void buildPartA();
    void buildPartB();
    void buildPartC();
    //钩子方法用于控制建造过程
    boolean isCanBuildPartB();
    Product getResult();
}

class ConcreteBuilder1 implements Builder{
    @Override
    public void buildPartA() {
        product.setPartA("Builder1======>SetPartA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("Builder1======>SetPartB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("Builder1======>SetPartC");
    }

    @Override
    public boolean isCanBuildPartB() {
        return false;
    }

    @Override
    public Product getResult() {
        return product;
    }
}

class ConcreteBuilder2 implements Builder{
    @Override
    public void buildPartA() {
        product.setPartA("Builder2======>SetPartA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("Builder2======>SetPartB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("Builder2======>SetPartC");
    }

    @Override
    public boolean isCanBuildPartB() {
        return true;
    }

    @Override
    public Product getResult() {
        return product;
    }
}

//导演类
class Director{
    private Builder mBuilder;
    public void setBuilder(Builder builder) {
        mBuilder = builder;
    }

    public Director(Builder builder) {
        mBuilder = builder;
    }

    public Product construct(){
        mBuilder.buildPartA();
        if(mBuilder.isCanBuildPartB())
            mBuilder.buildPartB();
        mBuilder.buildPartC();
        return mBuilder.getResult();
    }
}

class Product{
    private String mPartA;
    private String mPartB;
    private String mPartC;

    public String getPartA() {
        return mPartA;
    }

    public void setPartA(String partA) {
        mPartA = partA;
    }

    public String getPartB() {
        return mPartB;
    }

    public void setPartB(String partB) {
        mPartB = partB;
    }

    public String getPartC() {
        return mPartC;
    }

    public void setPartC(String partC) {
        mPartC = partC;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}