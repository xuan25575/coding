package ccu.common.algorithms.practice.class_4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  【题目】
     输入：
     参数1，正数数组costs
     参数2，正数数组profits
     参数3，正数k
     参数4，正数m
     costs[i]表示i号项目的花费
     profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
     k表示你不能并行、只能串行的最多做k个项目
     m表示你初始的资金
     说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个
     项目。
     输出：
     你最后获得的最大钱数。
 *
 *  思路：给定一个初始投资资金，给定N个项目，想要获得其中最大的收益，并且一次只能做一个项目。
 *  这是一个贪心策咯的问题，按照花费的多少放到一个小根堆里面，然后要是小根堆里面的头节点的花费少于给定资金，
 *  就将头节点一个个取出来，放到按照收益的大根堆里面，这样就然后将大根堆 的堆顶弹出。。。
 */
public class IOP {

    public static class Node{
        int cost ; // 花费资本
        int profit;  // 利润
        public Node(int cost,int profit){
            this.cost = cost;
            this.profit = profit;
        }
    }
    public static class MinCostHeapComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return  o1.cost - o2.cost;
        }
    }

    public static class MaxProfitHeapComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return  o2.profit - o1.profit;
        }
    }

    /**
     * 贪心策咯
     * @param k  k表示你不能并行、只能串行的最多做k个项目
     * @param m  m表示你初始的资金
     * @param casts  数组 costs[i]表示i号项目的花费
     * @param profits 数组  profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
     * @return  你最后获得的最大钱数。
     */

    public static int getMaximizedCapital(int k,int m,int[] casts,int[] profits){

        Node[] nodes = new Node[profits.length];  // 初始化 node数组。
        for (int i = 0; i < profits.length; i++) {
            nodes[i] = new Node(casts[i],profits[i]);
        }
        PriorityQueue<Node>  minCostsHeap = new PriorityQueue<>(new MinCostHeapComparator());   // 小根堆
        PriorityQueue<Node>  maxProfitsHeap = new PriorityQueue<>(new MaxProfitHeapComparator()); // 大根堆

        for (int i = 0; i < nodes.length; i++) { // 将所有的项目放入
            minCostsHeap.add(nodes[i]);
        }
        for (int i = 0; i < k ; i++) { // 可以做的 项目数
            while (!minCostsHeap.isEmpty() && minCostsHeap.peek().cost < m ){
                maxProfitsHeap.add(minCostsHeap.poll());
            }
            if(maxProfitsHeap.isEmpty()){  // 结束条件 防止NullPointException
                return m;
            }
            m += maxProfitsHeap.poll().profit;
        }
        return m;
    }




}
