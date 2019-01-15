package ccu.common.algorithms.practice.class_7;

import java.util.HashMap;

/**
 * 动态规划，+  LongestSumSubArrayLength 算法原型
 * 定义数组的异或和的概念：
 * 数组中所有的数异或起来，得到的结果叫做数组的异或和，
 * 比如数组{3,2,1}的异或和是，3^2^1 = 0
 * 给定一个数组arr，你可以任意把arr分成很多不相容的子数组，你的目的是：
 * 分出来的子数组中，异或和为0的子数组最多。
 * 请返回：分出来的子数组中，异或和为0的子数组最多是多少？
 *  解:
 * 情况1：从 0 到 i 存在最优划分，i 所在的子数组不是异或和为 0 的部分，即不在最优划分里面，
 * 那么 0 到 i 部分能划分多少个异或和为0的子数组 和 0 到 i- 1 能划分多少个异或和为 0 的子数组的结果是一样的，
 *  dp[i] = dp[i - 1]
 *  情况2：从 0 到 i 存在最优划分，i 所在的子数组是异或和为 0 的部分，即是最优划分的中异或和为0的部分，
 *  设 k 是 i 左边离它最近的异或和为0的位置，则问题变成，假设从 0 到 i 异或和为 sum，
 *  那么只需要找到从 0 到 i - 1 异或和为 sum 的位置的下一个位置就是 k 位置。
 *   dp[i] = dp[k - 1] + 1
 *
 * */
public class Most_EOR {


    public static int mostEOR(int[] arr){
        if(arr == null ||arr.length < 1){
            return 0;
        }
        int res = 0; // 结果
        int xor = 0; //异或
        int[] dp = new int[arr.length]; // 动态规划的数组
        HashMap<Integer,Integer> map = new HashMap<>(); // 第一个数存放 异或和，第二个存放下标
        map.put(0,-1); // 特殊情况
        for(int i = 0;i < arr.length;i++){
            xor ^= arr[i];
            if(map.containsKey(xor)){ //解中分析的 情况二
                int pre = map.get(xor); // 去出上一个和为sum的下标 它的下一个位置即为当前保存的 。。。
                dp[i] = pre == -1 ? 1 : dp[pre]+1;
            }
            if(i > 0){ // 保证dp 数组中i位置  异或和为0的子数组最多
                dp[i] = Math.max(dp[i],dp[i-1]);
            }
            map.put(xor,i);// 存放每个位置的异或和
            res = Math.max(dp[i],res); // 取出结果
        }
        return res;
    }


    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] eors = new int[arr.length];
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            eors[i] = eor;
        }
        int[] mosts = new int[arr.length];
        mosts[0] = arr[0] == 0 ? 1 : 0;
        for (int i = 1; i < arr.length; i++) {
            mosts[i] = eors[i] == 0 ? 1 : 0;
            for (int j = 0; j < i; j++) {
                if ((eors[i] ^ eors[j]) == 0) {
                    mosts[i] = Math.max(mosts[i], mosts[j] + 1);
                }
            }
            mosts[i] = Math.max(mosts[i], mosts[i - 1]);
        }
        return mosts[mosts.length - 1];
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
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

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 300;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int res = mostEOR(arr);
            int comp = comparator(arr);
            if (res != comp) {
                succeed = false;
                printArray(arr);
                System.out.println(res);
                System.out.println(comp);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }



}
