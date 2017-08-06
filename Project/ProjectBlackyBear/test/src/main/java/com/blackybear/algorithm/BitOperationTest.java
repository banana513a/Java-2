package com.blackybear.algorithm;

/**
 * Description:Bit Operation Test
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class BitOperationTest {
    public final static int number = 3520;	//0000 0000 0000 0000 0000 1101 1100 0000
    public final static int [] noRepeatArray = {3,2,3,2,8,3,2};

    public static void main(String[] args) {
    }

    /**
     * 取绝对值
     * @param num
     * @return
     */
    public static int abs(int num) {
        int sign = num >> 31;
        return sign == 0 ? num : (~num + 1);
    }

    /**
     * 判断数字是不是2的幂
     * @param number
     * @return
     */
    public static boolean isPowOf2(int number) {
        return (number & (number - 1)) == 0;
    }

    /**
     * 获取大于等于正数的最小2的幂
     * @param num
     * @return
     */
    public static  int getMinPowOf2(int num) {
        // 判断是否为2的幂
        if ((num & (num - 1)) == 0) {
            return num;
        }
        //最高位一定为1，归并使所有位为1
        num |= (num >> 1);
        num |= (num >> 2);
        num |= (num >> 4);
        num |= (num >> 8);
        num |= (num >> 16);
        num++;
        return num;
    }

    /**
     * 二进制逆序
     * @param number
     * @return
     */
    public static String reverseBinary(int number) {
        number = ((number & 0xAAAA) >> 1) | ((number & 0x5555) << 1);
        number = ((number & 0xCCCC) >> 2) | ((number & 0x3333) << 2);
        number = ((number & 0xF0F0) >> 4) | ((number & 0x0F0F) << 4);
        number = ((number & 0xFF00) >> 8) | ((number & 0x00FF) << 8);
        number = ((number & 0xFFFF0000) >> 16) | ((number & 0x0000FFFF) << 16);
        return Integer.toBinaryString(number);
    }

    /**
     * 二进制中1的个数
     * @param number
     * @return
     */
    public static int countBinaryOne(int number){
        number = ((number & 0xAAAA) >> 1) + (number & 0x5555);
        number = ((number & 0xCCCC) >> 2) + (number & 0x3333);
        number = ((number & 0xF0F0) >> 4) + (number & 0x0F0F);
        number = ((number & 0xFF00) >> 8) + (number & 0x00FF);
        number = ((number & 0xFFFF0000) >> 16) + (number & 0x0000FFFF);
        return number;
    }

    /**
     * 查找没有出现过N次的数字
     * @param array
     */
    public static int findNumber(int [] array, int times) {
        int[] bit = new int[32];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < bit.length; j++) {
                bit[j]+= ((array[i]>>j) & 1);
            }
        }
        int result = 0;
        for (int i = 0; i < bit.length; i++) {
            if((bit[i] % times) !=0)
                result += (1<<i);
        }
        return result;
    }
}