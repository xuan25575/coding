package ccu.swordoffer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 */
public class Test7 {
    Stack<Integer> s1 = new Stack<>();// push
    Stack<Integer> s2 = new Stack<>();// pop
    public void push(int node) {
        s1.push(node);
    }
    public int pop() {
        if(s1.isEmpty() && s2.isEmpty()){
            throw new RuntimeException("queue is empty ..");
        }else if(s2.isEmpty()){ // 必须空
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
