package ccu.common.algorithms.practice.class_8;

/**
 * 用数组结构实现大小固定的队列和栈
 */
public class ArrayToStackAndQueue {


    /**
     * 实现栈
     */
    public static class ArrayToStack{
      private Integer[] arr;  //数组
      private int size;   // 元素个数。

      public ArrayToStack(Integer initCapacity){
          arr = new Integer[initCapacity];
          size  = 0;
      }

      public void push(int obj){
          if(size > arr.length -1){
              throw new ArrayIndexOutOfBoundsException("stack is full..");
          }
          arr[size++] = obj;
      }

      public Integer pop(){
          if(size <=  0){
              throw new ArrayIndexOutOfBoundsException("stack is empty ..");
          }
          return  arr[--size]; //size 记录的是个数，需要现减一拿最后一个元素的下标。并实现元素的删除。
      }

      public Integer peek(){
          if(size == 0){
              return null;
          }
          return arr[size-1];
      }
  }

    /**
     * 实现队列
     */
  public static class ArrayToQueue{
        private Integer[] arr;
        private Integer size;
        private Integer first; //队列开始的元素，用来控制出去队列的操作
        private Integer last;  //队列结束的元素。 用来控制进入队列的操作

      public ArrayToQueue(Integer initCapacity){
          arr = new Integer[initCapacity];
          size = 0;
          first = 0;
          last = 0;
      }
      public Integer peek(){
          if(size == 0){
              return  null;
          }
          return arr[first];
      }
      public void push(int obj){
          if(size == arr.length){
              throw new RuntimeException("queue is full ..");
          }
          size++;
          arr[last] = obj;
          last = last == arr.length -1 ? 0 : last+1; // last 等于最后一个时，需要置为0；
      }
       public Integer poll(){
          if(size == 0){
              throw new RuntimeException("queue is empty .. ");
          }
          size--;
          int temp  = first;
          first = first == arr.length-1?0:first+1;
          return arr[temp];
       }

  }

    //for test
    public static void main(String[] args) {
        ArrayToStackAndQueue.ArrayToStack  stack =  new ArrayToStackAndQueue.ArrayToStack(10);
        ArrayToStackAndQueue.ArrayToQueue  queue =  new ArrayToStackAndQueue.ArrayToQueue(10);
        for (int i = 0; i < 10; i++) {
//            stack.push(i);
            queue.push(i);
        }
        System.out.println(queue.peek());
        for (int j = 0; j <10 ; j++) {
//            System.out.print(stack.pop()+" ");
            System.out.print(queue.poll()+" ");
        }

    }
}
