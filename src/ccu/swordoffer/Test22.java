package ccu.swordoffer;

import java.util.Stack;

/**
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1、2、3 、4、5 是某栈压栈序列，
 *    序列4、5、3、2、1 是该压栈序列对应的一个弹出序列，
 *    但4、3、5、1、2 就不可能是该压棋序列的弹出序列。
 *
 */
public class Test22 {

    /**
     *
     * @param push
     * @param pop
     * @return
     */
    public static  boolean isPopOrder(int[] push,int [] pop){
        if(push == null || pop == null || push.length < 1
                || pop.length <1 || push.length  != pop.length ){
            return false;
        }
        Stack<Integer> stack =  new Stack<>();
        int popIndex  = 0;
        int pushIndex = 0;
        while(popIndex < pop.length){
            while(pushIndex < push.length && (stack.isEmpty() || pop[popIndex] != stack.peek())){
                stack.push(push[pushIndex]);
                pushIndex++;
            }
            if(pop[popIndex] == stack.peek()){
                stack.pop();
                popIndex++;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        System.out.println(isPopOrder(push,pop));
    }
}
