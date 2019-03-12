package ccu.common.algorithms.practice.class_8;

import java.util.Stack;

/**
 *  实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返
 *  回栈中最小元素的操作。
 *   【要求】
 *   1．pop、push、getMin操作的时间复杂度都是O(1)。
 *   2．设计的栈类型可以使用现成的栈结构。
 *   思路： 设计两个栈，一个存放最下值，一个存放数据。
 */
public class GetMinStack {

    public static class MyStack1{
        private Stack<Integer> minStack;  // 存放栈中最小值的栈
        private Stack<Integer> dataStack;

        public MyStack1(){
            minStack = new Stack();
            dataStack =new Stack();
        }
        public void push(int newData){
            if(this.minStack.empty()){
                minStack.push(newData);  // 空栈直接放入
            }else if( newData<= getMin()){
                minStack.push(newData); // 只要进来的值比当前值小或者等于，放入栈中。
            }
            dataStack.push(newData); // 所有数据加入数据栈中
        }
        public int pop(){
            if(dataStack.size() == 0){
                throw new RuntimeException("stack is empty .. ");
            }
            int value = dataStack.pop();
            if(value == getMin()){    // 如果弹出的值和栈中最小值相等 弹出最小栈的值。保证minStack中存放当前栈中最小值。
                this.minStack.pop();
            }
            return value;
        }

        public int getMin(){
            if(this.minStack.empty()){
                throw new RuntimeException("stack is empty .. ");
            }
            return minStack.peek();  // peek操作不删除栈顶数据，并返回栈顶数据。
        }
    }


    /**  Test 21  */
    public static class MyStack2{
        private Stack<Integer> stackMin;
        private Stack<Integer> stackData;

        public MyStack2(){
            this.stackMin = new Stack();
            this.stackData = new Stack();
        }
        public void push(int newData){
            if(stackMin.empty()){
                this.stackMin.push(newData);
            }else if(newData < getMin()){
                this.stackMin.push(newData);
            }else{   //和上一种方式不同在于处理数据，只要是newData大于等于getMin()， 加入的数当stackMin栈中栈顶元素放入栈中。
                int min = stackMin.peek();
                this.stackMin.push(min);
            }
            this.stackData.push(newData);
        }
        public int pop(){
            if(this.stackData.empty()){
                throw new RuntimeException(" stack is empty ..");
            }
            this.stackMin.pop(); // 这里可以省略判断。
            return this.stackData.pop();
        }

        public int getMin(){
            if(stackMin.empty()){
                throw new RuntimeException("stack is empty .. .");
            }
            return stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());


        System.out.println("========================");
        MyStack2 stack2 = new MyStack2();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }

}
