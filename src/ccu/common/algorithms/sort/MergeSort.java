package ccu.common.algorithms.sort;

import java.util.Arrays;

/**
 * 归并操作（merge），也叫归并算法，指的是将两个已经排序的序列合并成一个序列的操作。归并排序算法依赖归并操作
 * 递归法
 *   1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 *   2.设定两个指针，最初位置分别为两个已经排序序列的起始位置
 *   3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 *   4.重复步骤3直到某一指针到达序列尾
 *   5.将另一序列剩下的所有元素直接复制到合并序列尾
 */
public class MergeSort {


    public static void mergeSort(int[] arr){
       if(arr == null || arr.length <2){
           return;
       }
       mergerSort(arr,0,arr.length-1);
    }

    /**
     *  递归实现
     * @param arr  数组
     * @param L  左边界
     * @param R  右边界
     */
    public static void mergerSort(int[] arr,int L,int R){
        int mid = L + (R -L)/2;   //防止整型溢出
        if(L == R){  // 递归结束条件  当数组中只有一个数return
            return;
        }
        mergerSort(arr,L,mid);
        mergerSort(arr,mid+1,R);
        merge(arr,L,R,mid);
    }


    /**
     *  合并数组
     * @param arr
     * @param L
     * @param R
     * @param mid 中间
     */
    public static void merge(int[] arr,int L,int R ,int mid){
        int p1  = L ;
        int p2 = mid +1;
        int [] extra  = new int[R-L+1];  //申请空间merge数组
        int i = 0; // 标识extra数组的下标
        while(p1<=mid && p2 <=R ){
            extra[i++] = arr[p1] < arr[p2] ? arr[p1++]: arr[p2++];  //两个数相等，排那个都行。
        }
        // 只有一个满足条件执行 下面两个while执行只能满足一个
        while(p1 <= mid){
            extra[i++] = arr[p1++];
        }
        while(p2 <= R){
            extra[i++] = arr[p2++];
        }
        for( i=0;i<extra.length;i++){
            arr[L+i] = extra[i];  //从L开始因为下标是从L开始的。
        }
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
//        int i = 0;
//        int j = 1;
//        int temp = 1 < 1? i:j;
//        System.out.println(temp );

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
     /*   boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");*/

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }
}
