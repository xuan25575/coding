package ccu.common.algorithms.practice.class_1;

import java.util.Stack;

/**
 * 【题目】：给定一个整型矩阵map， 其中的值只有0 和 1 两种，
 *  求其中全是1 的所有矩形区域中， 最大的矩形区域为1的数量。
 *    例如：
 *    1 0 1 1
 *    1 1 1 1
 *    1 1 1 0
 *    其中，最大的矩形区域有6个1，所以返回6 。
 *   矩阵的大小为 O(N * M) ， 时间复杂度为O（ N* M）
 *
 *   关键 思路：单调栈的使用
 */
public class MaximalRectangle {

    public static int maxRecSize(int[][] map ){
        if(map == null || map.length == 0 ||map[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                // 将矩阵组装成 height 数组  0,1矩阵特点在于 遇到0就置为0 否则加1
                height[j] = map[i][j] == 0 ? 0 :height[j] + 1;
            }
             // 取得每一层的矩阵最大值  比较找出最大值。
            maxArea = Math.max( maxRecFromBottom(height),maxArea);
        }
        return maxArea;
    }



    public static int maxRecFromBottom(int[] height){
        if(height== null || height.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        // 这个单调栈底部到顶部 ----> 小到大
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]){
                int j = stack.pop(); // 数组下标 找到j 左右能扩多远
                int k = stack.isEmpty() ? -1: stack.peek();  // 横向扩展左边 的边界
                int currentArea = (i -k -1)* height[j]; // i -k -1
                maxArea = Math.max(currentArea,maxArea);
            }
            stack.push(i);
        }
        //如果 最后栈还有值
        while(!stack.isEmpty()){
            int j = stack.pop(); // 数组下标
            int k = stack.isEmpty() ? -1: stack.peek();
            int currentArea = (height.length -k -1)* height[j];
            maxArea = Math.max(currentArea,maxArea);
        }

        return maxArea;
    }


    public static void main(String[] args) {
        int[] []  map = {
            {1,0,1,1},
            {1,1,1,1},
            {1,1,1,0}
        };
        System.out.println(maxRecSize(map));
    }

}
