package ccu.common.algorithms.practice.class_7;

/**
 *  给定一个数组arr，值可正，可负，可0；一个整数aim，求累加
 *  和小于等于aim的，最长子数组，要求时间复杂度O(N)
 *  解：
 *  1. 利用窗口
 *  借助两个辅助数组
 *  每一个位置往右的的最小和， -- 数组
 *  每一个位置往右的的最小和右边界的index。 -- 数组
 *  这两个数组生成通过 逆序生成。
 *
 */
public class LongestSubarrayLessSumAwesomeSolution {
    public static int maxLengthAwesome(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] sums = new int[arr.length]; //从i位置开始 subArray_min_sum 的数组
        int[] ends = new int[arr.length]; // subArray_min_sum_index 保存每一个最小和 最右边界
        sums[arr.length - 1] = arr[arr.length - 1]; // 从该位置子数组最小和
        ends[arr.length-1] = arr.length - 1; // 子数组最小和的最右index

        for (int i = arr.length - 2; i >= 0; i--) {
            if (sums[i + 1] < 0) {
                sums[i] = arr[i] + sums[i + 1];
                ends[i] = ends[i+1];
                //ends.put(i, ends.get(i + 1));
            } else {
                sums[i] = arr[i];
                ends[i] = i;
                //ends.put(i, i);
            }
        }
        int R = 0;// 右边界
        int sum = 0;
        int len = 0; // 子数组长度
        for (int i = 0; i < arr.length; i++) {
            while (R < arr.length && sum + sums[R] <= k) {
                sum += sums[R];
                R = ends[R]+1; //  其实长度为开始位置 - R-1 位置
                //end = ends.get(end) + 1;
            }
            sum -= R > i ? arr[i] : 0; //开始就扩不动, 否则就是窗口减小。
            len = Math.max(len, R - i);
            R = Math.max(R, i + 1);//开始就扩不动
        }
        return len;
    }
}
