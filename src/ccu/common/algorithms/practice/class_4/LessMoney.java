package ccu.common.algorithms.practice.class_4;

import java.util.PriorityQueue;

/**
 * 【题目】
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的
 * 金条，不管切成长度多大的两半，都要花费20个铜板。一群人想整分整块金
 * 条，怎么分最省铜板？
 * 例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为10+20+30=60.
 * 金条要分成10,20,30三个部分。
 * 如果，
 * 先把长度60的金条分成10和50，花费60
 * 再把长度50的金条分成20和30，花费50
 * 一共花费110铜板。
 * 但是如果，
 * 先把长度60的金条分成30和30，花费60
 * 再把长度30金条分成10和20，花费30
 * 一共花费90铜板。
 * 输入一个数组，返回分割的最小代价。
 * 思路】

 考察堆结构和贪心思想。哈夫曼编码找出最小代价。把数组成小根堆形式，每次弹出两个最小的数，
 把这两个数的和再加入到堆里，调整成小根堆形式，再弹出两个最小的数，把这两个数的和再加入到堆里，不断弹出加入。
 */
public class LessMoney {

    public static int lessMoney(int[] arr){
        PriorityQueue<Integer> pQ = new PriorityQueue<>();  // 默认是小根堆
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int current = 0;
        while(pQ.size() > 1){ //注意是要大于1 注意：代价不是最后一个值，而是所有非叶结点之和，即上面求得两两个结点之和
            current = pQ.poll()+ pQ.poll();
            sum += current;
            pQ.add(sum);
        }
        return sum;
    }
    public static void main(String[] args) {
        // solution
//        int[] arr = { 6, 7, 8, 9 };
//        int[] arr = {10,20,30};
        int[] arr = {1,3,6,6,9,16};
        System.out.println(lessMoney(arr));


        // for test
        int[] arrForHeap = { 3, 5, 2, 7, 0, 1, 6, 4 };

        // min heap
        PriorityQueue<Integer> minQ1 = new PriorityQueue<>();
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ1.add(arrForHeap[i]);
        }
        while (!minQ1.isEmpty()) {
            System.out.print(minQ1.poll() + " ");
        }
        System.out.println();
    }


}
