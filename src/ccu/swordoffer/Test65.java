package ccu.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 */
public class Test65 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>(); // 双端队列 维护一个窗口最大值。

        if(num.length==0 || size <1 || size > num.length)
            return result;
        for(int i=0;i<num.length;i++){
            while(!queue.isEmpty() && num[queue.peekLast()] < num[i] ){
                queue.pollLast();
            }
            queue.addLast(i);
            if(queue.peekFirst() == i-size){ // i 数组在移动index  i-size == index;   例如：4-3=1  4所在的窗口（最左窗口2，3，4）没有包含下标1
                queue.pollFirst();
            }
            if( i>= size-1){ // 窗口数组长度： 数组长度len - size-1 个数。
                result.add(num[queue.peekFirst()]);
            }
        }
        return result;
    }
}
