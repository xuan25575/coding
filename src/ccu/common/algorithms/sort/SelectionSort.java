package ccu.common.algorithms.sort;

import java.util.Arrays;

public class SelectionSort {

    /**
     * 原地不稳定的
     * 选择排序
     * 它的工作原理如下。首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，
     * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     * @param arr
     */
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length-1;i++){
            int minIndex  = i;
            for (int j = i+1; j < arr.length; j++) {
                // 在未排序元素中继续寻找最小元素，并保存其下标
                if(arr[j] < arr[minIndex]){
                    minIndex = j; //并保存其下标
                }
            }
            // 将未排序列中最小元素放到已排序列末尾
            swap(arr,minIndex,i);// 每一趟循环选出最小的值i的位置上，选完了数组有序
        }
    }
    public static void swap(int[] arr,int a ,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]=temp;
    }
    public static void printArray(int[] arr){
        if(arr == null){
            return;
        }
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    //比数器的实现。

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

   public static int[] copyArray(int[] arr){
       if(arr == null){
           return null;
       }
       int[] tar  = new int[arr.length];
       for(int i=0; i< arr.length;i++){
           tar[i]  = arr[i];
       }
      return tar;
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


    public static void main(String[] args) {
//        int [] arr  = {3,42,1,5,7,27};
//        selectionSort(arr);
//        printArray(arr);

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selectionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }
}
