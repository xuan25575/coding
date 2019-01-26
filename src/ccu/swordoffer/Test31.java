package ccu.swordoffer;

/**
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为 O(n)。
 * 左神做法：
 *    cur 依次累加各个元素，一旦cur为负数时，则将cur清为零。
 *    并尝试更新一次result（最大值）
 *    最终返回result即为子数组的最大累加和
 */
public class Test31 {

    /**
     * 书上解法
     * @param arr
     * @return
     */
    public static int findGreatestSumOfSubArray(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int curSum = 0;
        int greatestSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(curSum <= 0){
                curSum =arr[i];
            }else{
                curSum +=arr[i];
            }
            if(curSum>greatestSum){
                greatestSum = curSum;
            }
        }
        return greatestSum;
    }


    //TODO  左神解法
    public static int findGreatestSumOfSubArray2(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            max = Math.max(cur,max);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] data2 = {-2, -8, -1, -5, -9};
        int[] data3 = {2, 8, 1, 5, 9};
        System.out.println(findGreatestSumOfSubArray(data));
        System.out.println(findGreatestSumOfSubArray2(data));
        System.out.println(findGreatestSumOfSubArray(data2));
        System.out.println(findGreatestSumOfSubArray2(data2));
        System.out.println(findGreatestSumOfSubArray(data3));
        System.out.println(findGreatestSumOfSubArray2(data3));
    }


}
