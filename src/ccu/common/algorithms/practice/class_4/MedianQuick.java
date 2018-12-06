package ccu.common.algorithms.practice.class_4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  随时找到数据流的中位数
 *    【题目】
 *    有一个源源不断地吐出整数的数据流，假设你有足够的空间来
 *    保存吐出的数。请设计一个名叫MedianHolder的结构，
 *    MedianHolder可以随时取得之前吐出所有数的中位数。
 *    【要求】
 *    1．如果MedianHolder已经保存了吐出的N个数，那么任意时刻
 *    将一个新数加入到MedianHolder的过程，其时间复杂度是
 *    O(logN)。
 *    2．取得已经吐出的N个数整体的中位数的过程，时间复杂度为
 *    O(1)。
 */
public class MedianQuick {

    public static class MedianHolder{

        private  PriorityQueue<Integer> maxHeap = new PriorityQueue(new MaxHeapComparator()); // 大根堆  5,4,3,2,1 类似这种结构
        private  PriorityQueue<Integer> minHeap = new PriorityQueue(new MinHeapComparator()); // 小根堆  6,7,8,9,10

        /**
         *   调整两个堆
         */
        private void modifyTowHeapSize(){
            if(maxHeap.size() == minHeap.size()+2){
                minHeap.add(maxHeap.poll());
            }
            if(minHeap.size() == maxHeap.size()+2){
                maxHeap.add(minHeap.poll());
            }
        }

        public void addNumber(int num){
            if(maxHeap.isEmpty()) {
                maxHeap.add(num);
                return;
            }
            if(maxHeap.peek() > num){
                maxHeap.add(num);
            }else{
                if(minHeap.isEmpty()){
                    minHeap.add(num);
                    return;
                }
                if(minHeap.peek() > num){
                    maxHeap.add(num);
                }else{
                    minHeap.add(num);
                }
            }
            modifyTowHeapSize();
        }

        public Integer getMedian(){
            int maxHeapSize = maxHeap.size();
            int minHeapSize = minHeap.size();
            Integer  maxHeapNum = maxHeap.peek();
            Integer  minHeapNum = minHeap.peek();

            if(maxHeapSize + minHeapSize == 0){
                return null;
            }
            if((( maxHeapSize + minHeapSize) & 1) == 0){ // 位运算 数量和判断是不是偶数
                return (maxHeapNum+ minHeapNum) /2;
            }
            return maxHeapSize > minHeapSize ? maxHeapNum : minHeapNum; // 奇数 个数的数量直接判断。
        }

    }


    // 降序
    public static class MaxHeapComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o2 > o1){ // 返回1 表示那个数在前面。
                return 1;
            }else{
                return -1;
            }
        }
    }
    // 升序
    public static class MinHeapComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            if(o2 < o1){
                return 1;
            }else{
                return -1;
            }
        }
    }

    // for test
    public static int[] getRandomArray(int maxLen, int maxValue) {
        int[] res = new int[(int) (Math.random() * maxLen) + 1];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue);
        }
        return res;
    }

    // for test, this method is ineffective but absolutely right
    public static int getMedianOfArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int mid = (newArr.length - 1) / 2;
        if ((newArr.length & 1) == 0) {
            return (newArr[mid] + newArr[mid + 1]) / 2;
        } else {
            return newArr[mid];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean err = false;
        int testTimes = 200000;
        for (int i = 0; i != testTimes; i++) {
            int len = 30;
            int maxValue = 1000;
            int[] arr = getRandomArray(len, maxValue);
            MedianHolder medianHold = new MedianHolder();
            for (int j = 0; j != arr.length; j++) {
                medianHold.addNumber(arr[j]);
            }
            if (medianHold.getMedian() != getMedianOfArray(arr)) {
                err = true;
                printArray(arr);
                break;
            }
        }
        System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");

    }
}
