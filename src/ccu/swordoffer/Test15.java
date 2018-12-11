package ccu.swordoffer;

/**
 *  题目：输入一个链表，输出该链表中倒数第k 个结点．
 *  【思路】
 *   两个指针:
 *      p1指向头节点
 *      p2指向第k-1个结点
 *      然后双指针一起往后跑，知道p2到达末尾
 *      则p1指向的就是倒数第k个结点
 *  【相关题目】
 * - 求链表的中间节点
 * - 判断单向链表是否形成了环形结构？
 *      快慢指针，快指针一次走两步，慢指针一次走一步。
 *      若快指针走到头了，慢指针指向的就是中间节点，
 *      若快指针追上了慢指针，则是环形链表。
 */
public class Test15 {

    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value= data;
        }
    }

    public static Node findLastKthNode(Node head,int kth){
        if(head == null || kth  == 0 ){ // 0 是无效的
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < kth-1; i++) { // 链表是从1开始计数的
            if(p2.next != null){
                p2 = p2.next;  // p2 ->在 kth-1位置  下标是从0 开始的，
            }else {  // 处理kth 大于链表长度
                throw new RuntimeException(" invalid node ");
            }
        }
        while(p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println(findLastKthNode(head, 1).value);   //倒数第1个
      //  System.out.println(findLastKthNode(head, 3).value);   //中间的一个
        System.out.println(findLastKthNode(head, 6).value);   //倒数最后一个就是顺数第一个
       // System.out.println(findLastKthNode(head, 0));
    }
}
