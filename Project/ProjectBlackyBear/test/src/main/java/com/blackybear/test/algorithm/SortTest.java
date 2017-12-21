package com.blackybear.test.algorithm;

import java.util.Arrays;

/**
 * Description: Sort Test
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class SortTest {
    private static int [] intArray = { 1, 3, 2, 4, 6, 10, 3};
    public static void main(String[] args) {
//		bubbleSort(intArray);
//		selectSort(intArray);
//		insertSort(intArray);
//		shellSort(intArray);
//		heapSort(intArray);
//		quickSort(intArray, 0, intArray.length - 1);
//		mergeSort(intArray, 0, intArray.length -1, new int[intArray.length]);
//		RadixSort(intArray, 10);
        System.out.println(Arrays.toString(intArray));
    }

    /**
     * 冒泡排序
     * 1. 比较相邻的前后二个数据，如果前面数据大于后面的数据，就将二个数据交换。
     * 2. 这样对数组的第0个数据到N-1个数据进行一次遍历后，最大的一个数据就“沉”到数组第N-1个位置。
     * 3. N=N-1，如果N不为0就重复前面二步，否则排序完成。
     */
    @SuppressWarnings("unused")
    private static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    array[j] ^= array[j - 1];
                    array[j - 1] ^= array[j];
                    array[j] ^= array[j - 1];
                }
            }
        }
    }

    /**
     * 选择排序
     * 1. 初始时，数组全为无序区为a[0..n-1]。令i=0
     * 2. 在无序区a[i…n-1]中选取一个最小的元素，将其与a[i]交换。交换之后a[0…i]就形成了一个有序区。
     * 3. i++并重复第二步直到i==n-1。排序完成。
     */
    @SuppressWarnings("unused")
    private static void selectSort(int[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[minIndex] > array[j])
                    minIndex = j;
            }
            if(minIndex != i ){
                array[minIndex] ^= array[i];
                array[i] ^= array[minIndex];
                array[minIndex] ^= array[i];
            }
        }
    }

    /**
     * 插入排序
     * 1. 初始时，a[0]自成1个有序区，无序区为a[1..n-1]。令i=1
     * 2. 将a[i]并入当前的有序区a[0…i-1]中形成a[0…i]的有序区间。
     * 3. i++并重复第二步直到i==n-1。排序完成。
     */
    @SuppressWarnings("unused")
    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >=0 && array[j+1] < array[j]; j--) {
                array[j+1]^=array[j];
                array[j]^=array[j+1];
                array[j+1]^=array[j];
            }
        }
    }

    /**
     * 希尔排序—分组插入排序
     * 1. 先将整个待排元素序列分割成若干个子序列（由相隔某个“增量”的元素组成的）
     * 2. 分别进行直接插入排序
     * 3. 依次缩减增量再进行排序，待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序。
     因为直接插入排序在元素基本有序的情况下（接近最好情况），效率是很高的，因此希尔排序在时间效率上比前两种方法有较大提高。
     * @param array
     */
    @SuppressWarnings("unused")
    private static void shellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i - gap; j >= 0 && array[j + gap] < array[j]; j -= gap) {
                    array[j + gap] ^= array[j];
                    array[j] ^= array[j + gap];
                    array[j + gap] ^= array[j];
                }
            }
        }
    }

    /**
     * 快速排序—O(N*logN)
     * 1.先从数列中取出一个数作为基准数。
     * 2.分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     * 3.再对左右区间重复第二步，直到各区间只有一个数。
     * 对挖坑填数进行总结
     * 1. i =L; j = R; 将基准数挖出形成第一个坑a[i]。
     * 2. j--由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
     * 3. i++由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
     * 4. 再重复执行2，3二步，直到i==j，将基准数填入a[i]中。
     */
    @SuppressWarnings("unused")
    private static void quickSort(int[] array, int left, int right){
        if (left < right) {
            int i = left;
            int j = right;
            int x = array[left];	//基准数位置i
            while (i < j) {	//循环找出基准数位置
                while (i < j && array[j] >= x)	//向左寻找比x小的数字，进行交换
                    j--;
                if (i < j)
                    array[i++] = array[j];

                while (i < j && array[i] < x)		//向右寻找比x大的数字，进行交换
                    i++;
                if (i < j)
                    array[j--] = array[i];
            }
            array[i] = x;
            quickSort(array, left, i - 1);
            quickSort(array, i + 1, right);
        }
    }

    /**
     * 归并排序—O(N*logN)
     * 先递归的分解数列，再合并数列就完成了归并排序
     * @param array
     * @param first
     * @param last
     * @param temp
     */
    @SuppressWarnings("unused")
    private static void mergeSort(int[] array, int first, int last, int[] temp){
        if(first< last){
            int mid = (first + last) / 2;
            mergeSort(array, first, mid, temp);	//左边数组有序
            mergeSort(array, mid+1, last, temp);	//右边数组有序
            //合并左右两个有序数组
            int i=first;
            int j=mid+1;
            int k=0;
            while (i<=mid && j<=last) {
                if(array[i]<array[j])
                    temp[k++] = array[i++];
                else
                    temp[k++] = array[j++];
            }
            while (i<=mid)
                temp[k++] = array[i++];

            while (j<=last)
                temp[k++] = array[j++];

            for (int m = 0; m < k; m++)
                array[first + m] = temp[m];
        }
    }

    /**
     * 堆排序—O(N*logN)
     * 1. 堆化数组，形成最小堆或最大堆
     * 2. 交换A[0]和A[n-1]，然后恢复堆，直到只剩A[0]
     */
    @SuppressWarnings("unused")
    private static void heapSort(int[] array){
        //堆化数组（叶节点默认为合法堆，只从最后一个叶节点的父节点开始调整）
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapFixdown(array, i, array.length);
        //交换A[0]（最小或最大元素）和数组最后元素的位置，然后重新调整堆
        for (int i = array.length - 1 ; i >=1 ; i--) {
            array[0] ^= array[i];
            array[i] ^= array[0];
            array[0] ^= array[i];
            heapFixdown(array, 0, i);
        }
    }
    private static void heapFixdown(int[] array, int i, int n) {
        for (int j = 2 * i + 1; j < n; i = j, j = 2 * i + 1) {
            if (j+1<n && array[j + 1] > array[j] && array[j + 1] > array[i]) {
                array[j + 1] ^= array[i];
                array[i] ^= array[j + 1];
                array[j + 1] ^= array[i];
            } else if (j<n  && array[j] > array[i]) {
                array[j] ^= array[i];
                array[i] ^= array[j];
                array[j] ^= array[i];
            }
        }
//		int j, temp;
//		temp = a[i];
//		j = 2 * i + 1;
//		while (j < n) {
//			if (j + 1 < n && a[j + 1] > a[j])
//				j++;
//			if (a[j] < temp)
//				break;
//			a[i] = a[j];
//			i = j;
//			j = 2 * i + 1;
//		}
//		a[i] = temp;
    }

    /**
     * 基数排序
     * 1. 获取最大数位
     * 2. 按最低数位到最高数位，收集数字出现个数，并记录对应数字
     * 3. 按照每位数字大小重新收集排列数组，直到最大数位
     */
    @SuppressWarnings("unused")
    private static void RadixSort(int[] array, int radix) {
        int[][] bucket = new int[radix][array.length];
        //获取最大数字
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max < array[i])
                max = array[i];
        }
        //获取最大数位
        int distance = 0;
        for (int i = max; i !=0 ; i/=radix)
            distance++;

        int temp =1;
        int round=1;
        while (round++<=distance) {
            int [] counter = new int[radix];
            //统计数位数字个数，记录在counter[]中
            for (int i = 0; i < array.length; i++) {
                int num = (array[i] / temp) % radix;
                bucket[num][counter[num]] = array[i];
                counter[num]++;
            }
            //重新收集数组
            int index = 0;
            for (int i = 0; i < radix; i++) {
                if(counter[i]!=0)
                    for (int j = 0; j < counter[i]; j++) {
                        array[index++] = bucket[i][j];
                    }
                counter[i]=0;
            }
            temp *= radix;
        }
    }
}
