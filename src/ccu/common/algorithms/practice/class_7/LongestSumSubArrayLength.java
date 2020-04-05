package ccu.common.algorithms.practice.class_7;

import java.util.HashMap;

/**
 *  给定一个数组arr，和一个整数num，求在arr中，累加和等于num的最长
 *  子数组的长度
 *   例子：
 *   arr = {7,3,2,1,1,7,7,7} num = 7
 *   其中有很多的子数组累加和等于7，但是最长的子数组是{3,2,1,1}，所
 *  以返回其长度4
 */
public class LongestSumSubArrayLength {


    /**
     * 算法原型  可以解多种类似的题
     * 给定一个无序数组arr， 其中元素只能是1或0，求arr 数组中所有子数组中0 和1 个数相等的最长的子数组长度
     * 思路： 将0 变成-1 求和为0 最长的子数组的长度
     * @param arr
     * @param k
     * @return
     */
    public static int maxLength(int[] arr,int k){
        if(arr == null || arr.length == 0){
            return -1;
        }
        HashMap<Integer,Integer> map =  new HashMap<>();
        map.put(0,-1); // 很重要
        int sum = 0;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(map.containsKey(sum-k)){
                len = Math.max(i-map.get(sum -k),len);
            }
            if(!map.containsKey(sum)){// 记录第一出现的和
                map.put(sum,i);
            }
        }
        return len;
    }

    public static int[] generateArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 11) - 5;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = generateArray(20);
        printArray(arr);
        System.out.println(maxLength(arr, 10));
        int[] arr1 = {7,3,2,1,1,7,7,7};
        System.out.println(maxLength(arr1, 7));
    }


}
