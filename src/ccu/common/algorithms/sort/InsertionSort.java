package ccu.common.algorithms.sort;

import java.util.Arrays;

/**
 * 插入 排序
 *  最差时间复杂度：O(n^2)
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，
 * 找到相应位置并插入。插入排序在实现上，
 * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 */
public class InsertionSort {

    public static void insertionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i =1;i<arr.length;i++){  //1 是开始位置
             for(int j=i-1;j>=0&&arr[j]>arr[j+1];j--){  // 确定i位置后，前面两数两两比较找到合适的位置。
                 swap(arr,j+1,j);
             }
        }
    }

    public static void swap(int[] arr,int i,int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // for test

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if((arr1 == null&& arr2 != null) || (arr1 == null&&arr2 != null)){
            return false;
        }
        if(arr1 == null && arr2 == null){
            return false;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        for(int i =0;i<arr1.length;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
       return true;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void printArray(int[] arr){
        if(arr == null){
            return;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }

    public static int[] copyArray(int [] arr){
        if(arr == null){
            return null;
        }
        int[]  temp =  new int[arr.length];
        for(int i =0;i<arr.length;i++){
            temp[i] = arr[i];
        }
        return temp;
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
//        int[] arr = {2,5,1,7,8,4};
//        insertionSort(arr);
//        printArray(arr);

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            insertionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }
}
