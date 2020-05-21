package ccu.leetCode;

/**
 * @Author huang_2
 * @Date 2020/5/6 9:06 上午
 * @Description TODO
 */
public class 最低票价 {

    /**
     *
     * 如果 : 第i天没旅行，第i天的最小钱数 = 第i-1天的最小钱数
     * 否则 : 第i天的最小钱数 = min ( 第i-1天的最小钱数+1天票钱costs[0] , 第i-7天的最小钱数+7天票钱costs[1] ,第i-30天的最小钱数+30天票钱costs[2])
     * 其中如果 i-1,i-7,i-30<0 那天的最小钱数就为0
     *
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        if(days==null || days.length< 1 ||costs==null || costs.length<1){
            return 0;
        }

        int[] dp = new int[days[days.length-1]+1];
        // 初始化 每天都要去旅行的日子
        for (int num : days) {
            dp[num] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < dp.length; i++) {
            // 这一天不出去，就可以不买
            if(dp[i]==0){
                dp[i] = dp[i-1];
                continue;
            }
            int sum1 = dp[i-1] + costs[0];
            int sum2 = i> 7? dp[i-7]+costs[1]:costs[1];
            int sum3 = i> 30 ?dp[i-30]+costs[2]:costs[2];
            dp[i] =  Math.min(Math.min(sum1,sum2),sum3);
        }
        return dp[dp.length-1];
    }


    public static void main(String[] args) {
        int[] arr  = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] cost = {2,7,15};

        最低票价 a = new 最低票价();

        a.mincostTickets(arr,cost);
    }
}
