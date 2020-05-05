package ccu.leetCode;

/**
 * @Author huang_2
 * @Date 2020/5/4 9:03 上午
 * @Description TODO
 */
public class 跳跃游戏II {


    /**
     * 贪心 从前往 后
     * 从每个位置取值 能跳最远
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int len = nums.length;
        int position = 0;
        int step =0;
        int end = 0;
        // 最后一步不用走， 这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置
        // 在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」
        for (int i = 0; i < len-1; i++) {
            // 取得当前位置能走最远的步数
            position = Math.max(i+nums[i],position);
            //如果走到边界 更新下一个边界
            if(i==end){
                end =position;
                step++;
            }
        }

        return  step;
    }



    /**
     * 贪心
     * 从尾部到头
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int len = nums.length;
        int position = nums.length-1;
        int step =0;
        while(position > 0){
            for (int i = 0; i < len; i++) {
                if(i + nums[i] >= position){
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return  step;
    }
}
