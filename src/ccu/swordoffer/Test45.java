package ccu.swordoffer;

/**
 *
 * 题目：0, 1, … , n-1 这 n 个数字排成一个圈圈，从数字 0 开始每次从圆圏里删除第 m 个数字。
 * 求出这个圈圈里剩下的最后一个数字。
 *  约瑟夫环杀人  一个公式 f(N,M)=(f(N−1,M)+M)%n
 *  每杀掉一个人，下一个人成为头，相当于把数组向前移动M位。若已知N-1个人时，胜利者的下标位置位f(N−1,M)，则N个人的时候，
 *  就是往后移动M为，(因为有可能数组越界，超过的部分会被接到头上，所以还要模N)，既f(N,M)=(f(N−1,M)+M)%n
 *
 */
public class Test45 {

    public static class Node{
        private int value;
        Node next;
        public Node(int data){
            this.value = data;
        }
    }

    /**
     *   左神解法
     * @param head  头结点
     * @param m  第 m 个数字。
     * @return
     */
    public static Node lastRemaining3(Node head,int m){
        if(head == null || head.next == head || m < 1){
            return head;
        }
        Node last = head;
        // 连成环
        while(last.next != head){
            last = last.next;
        }
        int count = 0;
        while(last != head){
            if(++count == m ){
                last.next = head.next; // 删除节点
            }else {
                last = last.next;
            }
            head = last.next; // 用来保存下一次判断前的 last下一个节点（通过画图）
        }
        return head;
    }





    /**
     *  公式：
     * f(N,M)=(f(N−1,M)+M)%n
     */
    public static int lastRemaining(int n,int m){
        if(n < 1 ||  m < 1){
            return -1;
        }
        int last = 0;  // 从0 开始的。 如果是 因为求出的结果是数组中的下标，最终的编号还要加1
        for (int i = 2; i <=n ; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    public static int lastRemaining2(int n,int m){
        if(n < 1 ||  m < 1){
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return (lastRemaining(n-1, m ) + m ) % n;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3)); // 最后余下3
        System.out.println(lastRemaining(5, 2)); // 最后余下2
        System.out.println(lastRemaining(6, 7)); // 最后余下4
        System.out.println(lastRemaining2(5, 3)); // 最后余下3
        System.out.println(lastRemaining2(5, 2)); // 最后余下2
        System.out.println(lastRemaining2(6, 7)); // 最后余下4
    }
}
