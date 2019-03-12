package ccu.swordoffer;

import java.util.Stack;

/**
 *
 * 题目： 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小素的 min 函数。
 * 在该栈中，调用 min、push 及 pop 的时间复杂度都是 0(1)
 *
 * 【解】：
 *   再用一个辅助栈，来存放当前最小值
 *   class_8 GetMinStack
 */
public class Test21 {

    public static class MinStack{

        Stack<Integer> dataStack = new Stack<>();
        Stack<Integer>  minStack = new Stack<>();


        public void push(int data){
            if(minStack.isEmpty() ||  data <minStack.peek()){
                minStack.push(data);
            }else{
                minStack.push(minStack.peek());
            }
            dataStack.push(data);
        }
        public Integer pop(){
            if (dataStack.isEmpty()){
                throw new RuntimeException("Stack is empty!");
            }
            minStack.pop();
            return  dataStack.pop();
        }

        public Integer getMin(){
            if(minStack.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(3);
        System.out.println(stack.getMin() == 3);
        stack.push(4);
        System.out.println(stack.getMin() == 3);
        stack.push(2);
        System.out.println(stack.getMin() == 2);
        stack.push(3);
        System.out.println(stack.getMin() == 2);
        stack.pop();
        System.out.println(stack.getMin() == 2);
        stack.pop();
        System.out.println(stack.getMin() == 3);
        stack.push(0);
        System.out.println(stack.getMin() == 0);
    }
}
