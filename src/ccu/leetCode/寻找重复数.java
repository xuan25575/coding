package ccu.leetCode;

import java.util.HashSet;

/**
 * @Author huang_2
 * @Date 2020/4/30 2:41 下午
 * @Description TODO
 */
public class 寻找重复数 {


    /**
     *
     *      快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
     *      注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
     *      因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
     *      即按照寻找链表环入口的思路来做
     *
     *
     *  环找入环节点。
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {

        int slow =0 ,fast = 0;

        while(true){
           fast = nums[nums[fast]];
           slow = nums[slow];
           if(slow == fast) {
               break;
           }
        }
        fast = 0;
        while(nums[slow] != nums[fast]){
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[slow];

    }

    public int findDuplicate2(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)){
                return num;
            }
        }
        return -1;

    }
}
