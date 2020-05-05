package ccu.leetCode;

/**
 * @Author huang_2
 * @Date 2020/5/3 8:52 上午
 * @Description TODO
 */
public class 最大子序和 {


    /**
     * 状态压缩
     * 将dp 数组压缩至一个变量。
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {

        int pre = nums[0];
        int ans= nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre= Math.max(pre+nums[i],nums[i]);
            ans = Math.max(pre, ans);
        }
        return ans;
    }



    /**
     * dp[i] 表示i位置最大的连续子数组和
     * dp方程
     * dp[i] = max(dp[i-1]+nums[i], nums[i])
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int len = nums.length;
        if(len ==0) return 0;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int ans= nums[0];

        for (int i = 1; i < len; i++) {
            dp[i]= Math.max(dp[i-1]+nums[i],nums[i]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
