package ccu.common.algorithms.practice.class_8;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *  如何仅用队列结构实现栈结构？
 *  如何仅用栈结构实现队列结构？
 */
public class QueueAndStackConvert {

    /**
     * 如何仅用栈结构实现队列结构？
     * 队列 先进先出 结构
     * 思路： 使用两个栈，一个栈用push数据，一个栈用来pop
     * push操作： 把数据push到一个栈中
     * poll操作， 把push到栈的中的数据pop到另一个栈中。 使用该栈pop操作即可。
     *
     *
     */
    public static class TowStacksToQueue{

        private Stack<Integer> pushStack;  //
        private Stack<Integer> popStack;

        public TowStacksToQueue(){
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

//        public  void replace(){
//            if(pushStack.empty() && popStack.empty()){
//                throw new RuntimeException("queue is empty ..");
//            }else if(popStack.empty()){   // 确保
//                while(!pushStack.empty()){
//                    popStack.push(pushStack.pop());
//                }
//            }
//        }
        public void push(int data){
            pushStack.push(data);
        }
        public int poll(){
//            replace();
            if(pushStack.empty() && popStack.empty()){
                throw new RuntimeException("queue is empty ..");
            }else if(popStack.empty()){   // 确保 pop栈不为null 不让压入。不然出错。
                while(!pushStack.empty()){  // 确保一次性全部压入
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.pop();
        }

        public int peek(){
//            replace();
            if(pushStack.empty() && popStack.empty()){
                throw new RuntimeException("queue is empty");
            }else if(popStack.empty()){
                while(!pushStack.empty()){
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.peek();
        }

    }

    /**
     * 如何仅用队列结构实现栈结构
     * 思路： 利用两个队列和它的特性，完成pop 和push操作
     */
    public static class TowQueuesToStack{
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TowQueuesToStack(){
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(int data){
            queue.add(data);
        }

        public int pop(){
            if(queue.isEmpty()){
                throw new RuntimeException("stack is empty..");
            }
            while(queue.size() != 1){ //使队列中只剩一个
                help.add(queue.poll());
            }
            int result =  queue.poll();
            swap(); //交换引用
            return result;
        }


        public int peek(){
            if(queue.isEmpty()){
                throw new RuntimeException("stack is empty..");
            }
            while(queue.size() != 1){
                help.add(queue.poll());
            }
            int result =  queue.peek();
            help.add(result);
            swap();
            return result;
        }

       //交换引用。
        public void swap(){
            Queue<Integer> temp = queue;
            queue = help;
            help = queue;
        }

    }

    // 一个队列实现栈
    class MyStack {

        private LinkedList<Integer> q1 = new LinkedList<>();
        /** Initialize your data structure here. */
        public MyStack() {
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q1.add(x);
            int sz = q1.size();
            while(sz>1){ // 最后一个刚好不用动。
                q1.add(q1.remove());
                sz--;
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q1.remove();
        }

        /** Get the top element. */
        public int top() {
            return q1.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.size()==0;
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */

}
