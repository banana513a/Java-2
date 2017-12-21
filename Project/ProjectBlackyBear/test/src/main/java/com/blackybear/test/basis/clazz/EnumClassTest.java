package com.blackybear.test.basis.clazz;

/**
 * Description: 枚举类
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class EnumClassTest {
    public static void main(String[] args) {
        EnumClassTest test = new EnumClassTest();
//		test.printEnum();
//		test.printEnumInterface();
        test.printEnumAbstractMethod();
    }

    public void printEnum() {
        Season season = Season.AUTUMN;
        System.out.println(season.toString());
        System.out.println(season.ordinal());
        for (Season s : Season.values()) {
            System.out.println(s.getName());
        }
    }

    public void printEnumInterface() {
        for (Light l : Light.values()) {
            l.print();
        }
    }

    public void printEnumAbstractMethod() {
        System.out.println(Operation.PLUS.eval(100, 40));
        System.out.println(Operation.MINUS.eval(100, 40));
        for (Operation operation : Operation.values()) {
            System.out.println(operation.eval(10, 4));
        }
    }
}

enum Operation {
    PLUS {
        @Override
        public double eval(double a, double b) {
            return a + b;
        }
    },
    MINUS {
        @Override
        public double eval(double a, double b) {
            return a - b;
        }
    };

    public abstract double eval(double a, double b);
}


interface EnumInterface {
    void print();
}

enum Light implements EnumInterface {
    RED {
        public void print() {
            System.out.println("This is red!");
        }
    },
    YELLOW {
        public void print() {
            System.out.println("This is yellow!");
        }
    },
    GREEN {
        public void print() {
            System.out.println("This is green!");
        }
    };
}


enum Season {
    SPRING("chun"),
    SUMMER("xia"),
    AUTUMN("qiu"),
    WINTER("dong");
    private final String mName;

    private Season(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
}
