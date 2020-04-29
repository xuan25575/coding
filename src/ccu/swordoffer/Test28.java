package ccu.swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 *  题目：输入一个字符串，打印出该字符串中字符的所有排列。
 *  例如 输入字符串 abc。
 *  则打印出由字符 a、b、c 所能排列出来的所有字符串 abc、acb、bac 、bca、cab 和 cba 。
 *  每一次递归都将字符串分成两部分： 第1个字符，和他后面的所有字符
 *  先将第一个字符与其后面的字符依次交换，然后 求其后面的所有字符的全排列
 *  去重：
 *     就是从第一个字符开始，每个字符与其后面非重复的字符交换
 *     即：当chars[begin]与chars[i]交换时，[begin,i)中没有与chars[i]相同的字符
 *
 *     回溯算法的思想
 *  模板
 *  result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 */
public class Test28 {

    // 回溯算法
    public static void permutation(String str){
        if(str.isEmpty()) return;
        char[] chars = str.toCharArray();
        permutation(chars,0);

    }
    public static void permutation(char[] chars,int begin){
        if(chars.length-1 == begin){
            System.out.print(new String(chars)+" ");
        }else{
            for (int i = begin; i < chars.length; i++) {
                swap(chars,begin,i); // 交换
                permutation(chars,begin+1);
                swap(chars,begin,i); // 回溯  复原现场
            }
        }
    }

    public static void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] =temp;
    }

    public static boolean isSwap(char[] chars,int i,int j){
        for (  ;i<j ; i++) {
            if(chars[i] == chars[j]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = new String();
        str = "abc";
        permutation(str);
      //  abc acb bac bca cba cab
      //  abc acb cab cba abc acb

    }



    class Solution {

        public List<List<Integer>> permute(int[] nums) {
            // 首先是特判
            int len = nums.length;
            // 使用一个动态数组保存所有可能的全排列
            List<List<Integer>> res = new ArrayList<>();

            if (len == 0) {
                return res;
            }

            boolean[] used = new boolean[len];
            List<Integer> path = new ArrayList<>();

            dfs(nums, len, 0, path, used, res);
            return res;
        }

        private void dfs(int[] nums, int len, int depth,
                         List<Integer> path, boolean[] used,
                         List<List<Integer>> res) {
            if (depth == len) {
                //path  值传递的原因
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    path.add(nums[i]);
                    used[i] = true;

                    dfs(nums, len, depth + 1, path, used, res);
                    // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                    used[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }

//        public static void main(String[] args) {
//            int[] nums = {1, 2, 3};
//            Solution solution = new Solution();
//            List<List<Integer>> lists = solution.permute(nums);
//            System.out.println(lists);
//        }
    }




}
