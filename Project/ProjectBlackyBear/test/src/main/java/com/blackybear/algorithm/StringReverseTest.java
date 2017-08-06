package com.blackybear.algorithm;

import java.util.Stack;

/**
 * Description: String Reverse Test
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class StringReverseTest {
    private static String reverse = "123456";
    public static void main(String[] args) {
//		BitReverse();
//		StackReverse();
//		ArrayReverse();
//		StringBuilderReverse();
//		RecursiveReverse();
    }

    /**
     * 位操作逆序
     */
    @SuppressWarnings("unused")
    private static void BitReverse() {
        char[] arrayChar = reverse.toCharArray();
        for (int i = 0, len = arrayChar.length - 1; i < len; i++, len--) {
            arrayChar[i]^=arrayChar[len];
            arrayChar[len]^=arrayChar[i];
            arrayChar[i]^=arrayChar[len];
        }
        System.out.println(arrayChar);
    }

    /**
     * 栈逆序
     */
    @SuppressWarnings("unused")
    private static void StackReverse() {
        char[] arrayChar = reverse.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int len = arrayChar.length;
        char[] result = new char[len];
        for (int i = 0; i < len; i++) {
            stack.push(arrayChar[i]);
        }
        for (int i = 0; i < len; i++) {
            result[i] = stack.pop();
        }
        System.out.println(new String(result));
    }

    /**
     * 数组逆序
     */
    @SuppressWarnings("unused")
    private static void ArrayReverse() {
        char[] arrayChar = reverse.toCharArray();
        int len = arrayChar.length;
        char[] result = new char[len];
        for (int i = 0; i < len / 2; i++) {
            result[i] = arrayChar[len - 1 - i];
            result[len - 1 - i] = arrayChar[i];
        }
        System.out.println(result);
    }

    /**
     * StringBuilder逆序
     */
    @SuppressWarnings("unused")
    private static void StringBuilderReverse() {
        char[] arrayChar = reverse.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = arrayChar.length - 1; i >=0; i--) {
            stringBuilder.append(arrayChar[i]);
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * 递归逆序
     */
    @SuppressWarnings("unused")
    private static void RecursiveReverse() {
        System.out.println(reverseLoop(reverse));
    }
    private static String reverseLoop(String source) {
        int len = source.toCharArray().length;
        if(len == 1 )
            return source;
        else
            return reverseLoop(source.substring(1)) + source.toCharArray()[0];
    }
}
