package ccu.common.algorithms.practice.class_3;

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
     */
    public static class TowStacksToQueue{

        private Stack<Integer> pushStack;  //
        private Stack<Integer> popStack;

        public TowStacksToQueue(){
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        public  void replace(){
            if(pushStack.empty() && popStack.empty()){
                throw new RuntimeException("queue is empty ..");
            }else if(popStack.empty()){   // 确保
                while(!pushStack.empty()){
                    popStack.push(pushStack.pop());
                }
            }
        }
        public void push(int data){
            pushStack.push(data);
        }
        public int poll(){
            replace();
            return popStack.pop();
        }

        public int peek(){
            replace();
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

}
