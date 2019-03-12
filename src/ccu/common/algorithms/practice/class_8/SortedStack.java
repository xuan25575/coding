package ccu.common.algorithms.practice.class_8;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，
 * 只许申请一个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构。
 */
public class SortedStack {


    public static void sortedStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack(); // 栈顶到栈底从小到大
        while(!stack.isEmpty()){
            int cur = stack.pop();
            while(!help.isEmpty() && cur > help.peek()){  // 找到最大那个数。 压入栈底。
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(5);
        stack.push(1);
        System.out.println(stack);
        sortedStackByStack(stack);
        System.out.println(stack);
    }


}
