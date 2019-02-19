package ccu.common.algorithms.practice.class_7;

/**
  *    给定一个数组arr，全是正数；一个整数aim，求累加和等
  *   于aim的，最长子数组，要求额外空间复杂度O(1)，时间
  *   复杂度O(N)
 *
 *   解: 双指针实现，left、right 两个指针之间的窗口的累加和 O(N) 移动窗口找出最小值
 */
public class LongestSumSubArrayLengthInPositiveArray {

    public static int getMaxLength(int[] arr, int k){
        if(arr == null || arr.length == 0 || k <= 0){
            return 0;
        }
        int L = 0;
        int R = 0;
        int sum = arr[0];
        int len = 0;
        while(L < arr.length){
            if(sum == k ){
                len = Math.max(len,R - L+ 1); // 保存子数组的长度
                sum -= arr[L++];
            }else if(sum <  k){
                R++;
                if(R == arr.length){
                    break;
                }
                sum+= arr[R];
            }else{
                sum-= arr[L++];
            }
        }
        return len;
    }

    public static int[] generatePositiveArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 10) + 1;
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
        int len = 20;
        int k = 15;
        int[] arr = generatePositiveArray(len);
        printArray(arr);
        System.out.println(getMaxLength(arr, k));

    }
}
