package ccu.common.algorithms.practice.class_7;

/**
 *  给定一个数组，求子数组的最大异或和。
 *  一个数组的异或和为，数组中所有的数异或起来的结果。
 *   用到一个公式：d = a ⊕ b ⊕ c 可以推出 a = d ⊕ b ⊕ c.
 */
public class MaxEOR {


    /**
     *  先求一个数组每一个 异或和， dp解
     * @param arr
     * @return
     */
    public static int maxXorSubArray(int[] arr){
        if(arr== null || arr.length ==0){
            return 0;
        }
        int[] dp = new int[arr.length];
        int max = Integer.MIN_VALUE; // 记录全局最大
        int eor = 0;

        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i]; // 0- i  的异或和
            for (int  start = 1; start <i;i++){
                int curXor = eor ^ dp[start-1]; // 求start - i 的异或和 用到上面的一个公式
                max = Math.max(eor,curXor);
            }
            dp[i] = eor;
        }
        return max;
    }
}
