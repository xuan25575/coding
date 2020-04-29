package ccu.common.algorithms.sort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * 冒泡排序   从第一个数开始，每次循环把最大的数放到最后。
     * 冒泡排序的基本思想就是：从无序序列头部开始，进行两两比较，根据大小交换位置，
     * 直到最后将最大（小）的数据元素交换到了无序队列的队尾，从而成为有序序列的一部分；
     * 下一次继续这个过程，直到所有数据元素都排好序。
     *
     *  算法的核心在于每次通过两两比较交换位置，选出剩余无序序列里最大（小）的数据元素放到队尾。
     *  时间复杂度  最好是O（n）, 最坏是（O(n^2)）
     * @param arr
     */
    public static void bubbleSort(int arr []){
        if (arr == null || arr.length < 2) {
            return;
        }
        for(int end = arr.length-1; end > 0;end--){  //减少比较次数
            for(int i=0; i<end;i++){
                if(arr[i] > arr[i+1] ){
                    swap(arr,i,i+1);
                }
            }
        }
    }

    /**
     * 正向冒泡排序
     * @param arr
     */
    public static void bubbleSort2(int[] arr) {
        //一定要记住判断边界条件，很多人不注意这些细节，面试官看到你的代码的时候都懒得往下看，你的代码哪个项目敢往里面加？
        if (arr == null || arr.length < 2) {
            return;
        }
        //需要进行arr.length趟比较
        for (int i = 0; i < arr.length - 1; i++) {
            //第i趟比较
            for (int j = 0; j < arr.length - i - 1; j++) {
                //开始进行比较，如果arr[j]比arr[j+1]的值大，那就交换位置
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
    }


    private  static void swap(int arr[] ,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    //比数器的实现。


    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test

    /**
     * 生成随机数组
     * @param maxSize  数组长度的最大值
     * @param maxValue  随机的值的最大值
     * @return int[]
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
//        int arr[]  = {2,5,3,7,15,4,10};
//        bubbleSort(arr);
//        printArray(arr);

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            bubbleSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
