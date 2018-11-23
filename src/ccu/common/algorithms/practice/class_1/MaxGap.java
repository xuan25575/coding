package ccu.common.algorithms.practice.class_1;

import java.util.Arrays;

/**
 * 无序数组算出相邻两个数之间的最大差值
 * 思路 桶排序的思路 （每相邻的两个桶的差，为当前桶的最小值减去上一个桶最大值。）
 *    1. 扫面一遍数组，找到数组中的最大max，最小min值。
 *    2. 将[min, max]区间分为n-1个区间段（每个区间段对应一个桶bucket）
 *    3. 再次从头到尾扫描数组，将每个元素添加到相应的桶bucket里面。 注意：有的桶为空（不含任何数据）
 *    4. 然后按顺序访问每个（ 非空 ）的相邻的桶进行比较。若两个非空的相邻的桶分别为(a,b) , (c,d)，那么这两个 非空 相邻的桶的距离为 c-b。
 *       最后选择最大的非空相邻同的距离返回即可。
 *  思路二： 先排序 然后两两比较。
 */
public class MaxGap {

    /**
     *  找出最大间隔
     * @param nums
     * @return
     */
    public static int  maxGap(int[] nums){
        if(nums == null || nums.length < 2){
            return 0;
        }
        //找到最大数和最小数
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length ; i++) {
            max = max(max,nums[i]);
            min = min(min,nums[i]);
        }
        if(max == min){
            return 0;
        }
        int[] mins = new int[nums.length+1];  //每个通只记录进入该桶的最小数
        int[] maxs = new int[nums.length+1];  //每个桶只记录进入该桶的最大数
        boolean[] hasNum = new boolean[nums.length+1];  //用来标记 是否是空桶
        int bid  = 0;
        //将每个桶中放好最大数和最小数。有的桶是空桶。
        for (int i = 0; i < nums.length; i++) {
          bid = bucket(nums[i],nums.length-1,min,max); //算出该数在那个桶。
          mins[bid] = hasNum[bid] ? min(mins[bid],nums[i]):nums[i]; //保证mins[bid]桶放入是最小值
          maxs[bid] = hasNum[bid] ? max(maxs[bid],nums[i]):nums[i];  //保证 maxs[bid] 桶中放入最大值。
          hasNum[bid] = true;
        }
        //.然后按顺序访问每个（ 非空 ）的相邻的桶进行比较
        int result = 0;  //个结果
        int lastMax = nums[0]; // 上一个桶的最大值
        for (int i = 0; i <nums.length ; i++) {
            if(hasNum[i]){ // 只有非空桶的相邻进行比较
                result = max(result,mins[i]-lastMax); //当前桶最小值减去上一个桶的最大值
                lastMax = maxs[i]; // 改变值成为下一个相邻桶比较。
            }
        }
      return result;
    }


    public static int max(int a,int b){
        return a >= b ? a :b;
    }
    public static int min(int a ,int b){
        return a <= b ? a :b;
    }

    /**
     * 算出该数出现在那个桶
     * @param num  给定一个数
     * @param length 数组长度
     * @param min 最小值
     * @param max 最大值
     * @return  int  该数出现那个桶
     */
    public static int bucket(long num,long length,long min,long max){
         return  (int)((num -min)*length  / (max - min));  // (max - min）/length 求出桶的间隔， (num -min) / 桶的间隔 求出出现在那个桶
    }
    // for test  先让数组有序 然后两两进行比较。
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }

    // for test
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

    public static void printArray(int [] arr){
        if(arr == null){
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i] +" " );
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
//        int testTime = 500000;
//        int maxSize = 100;
//        int maxValue = 100;
//        boolean succeed = true;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            if (maxGap(arr1) != comparator(arr2)) {
//                succeed = false;
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");


        int[] nums = generateRandomArray(100, 100);
        printArray(nums);
        int result  = maxGap(nums);
        int result2  = comparator(nums);
        System.out.println(result +"==========="+result2);
    }

}
