package ccu.common.algorithms.practice.class_2;

/**
 * 　给定一个单向链表的头节点 head，以及两个整数 from 和 to，
 *   在单向链表上把第 from 个节点到第 to 个节点这一部分进行反转。
 *   【要求】
 *   1、如果链表长度为 N，时间复杂度的要求为 O(N)，额外的空间复杂度要求为O(1)。
 * 　2、如果不满足1<=from<=to<=N，则不用调整。
 */
public class ReversePartList {

    public static class Node{
       public int value;
       public  Node next;
       public Node(int data){
           this.value = data;
       }
    }

    /**
     * 反转部分链表
     * 思路： 先判断是否满足1<=from<=to<=N
     * 先找到from-1个节点fPre,和to+1个节点tPos, 反转部分反转后
     * 然后连接fPre和tPos,如果fPre为null,则说明反转部分包含头结点，则返回新的头结点，也就是没反转之前反转部分
     * 的最后一个节点，如果fPre不为null,子返回旧的头结点
     * @param head  head node
     * @param from 开始的位置
     * @param to  结束的位置
     * @return 头结点
     */
    public static Node reversePartList(Node head,int from, int to){
        if(head == null){
            return null;
        }
        int len = 0;
        Node fPre = null; // from 位置的前一个节点
        Node tPos = null; // to 位置的 下一个节点
        Node n1 = head; 
        // find fPre node and tPost node and set it
        while(n1 != null){
            len++;
            fPre = len == from -1 ? n1:fPre;
            tPos = len == to + 1 ? n1:tPos;
            n1 = n1.next;
        }
        // validate  data is ok ?
        if(from >= to || from < 1 || to>len ){
            return head;
        }
        //update old list head node point to tPos node
        n1 = fPre == null ? head : fPre.next; // 修改 n1 的值  from节点
        n1.next = tPos;// 提前将反转链表下一个节点连好。
        // reverse list
        Node n2 = n1.next;// n1 已经反转好了。 取n1的下一个节点。
        Node next= null; // sava next node
        while(n2 != tPos){   // node2 != tPos 注意反转的边界。 而不是 node2 != null。
            next = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = next;
        }
  //     determine whether fPre node is null
        if(fPre != null){
            fPre.next = n1; // 原有链表的前一个节点连接反转链表后的头结点
            return head;  //  返回原有链表的头结点
        }
        return n1; // n1 是反转链表的头结点。 这是由于 from指向的节点和head 节点重合
    }

    public static void printLinkedList(Node node){
        if(node == null){
            return;
        }
        System.out.print("Linked List: ");
        while(node != null){
            System.out.print(node.value+" ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head =  new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next  = new Node(4);
        head.next.next.next.next = new Node(7);
        printLinkedList(head);
        Node node =  reversePartList(head,2,5);
        printLinkedList(node);
    }


}
