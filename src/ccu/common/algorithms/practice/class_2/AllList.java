package ccu.common.algorithms.practice.class_2;

import java.util.Stack;

/**
 * 两个单链表生成相加单链表
 * 假设链表中每一个节点的值都在0~9之间，那么链表整体就可以代表一个整数。
 *  例如：9 -> 3 -> 7，可以代表整数937。
 *  给定两个这种链表的头节点head1和head2，请生成代表两个整数相加值的结果链表。
 *  例如：链表1为9 -> 3 -> 7，链表2为6 -> 3，最后生成新的结果链表为1 -> 0 -> 0 -> 0。
 */
public class AllList {

    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value= data;
        }
    }

    /**
     *  利用栈实现
     * @param head1
     * @param head2
     * @return
     */
    public static Node addList1(Node head1,Node head2){
        Stack<Integer> s1 =  new Stack<>();
        Stack<Integer> s2 =  new Stack<>();
        while(head1 != null){
            s1.push(head1.value);
            head1= head1.next;
        }
        while(head2 != null){
            s2.push(head2.value);
            head2= head2.next;
        }
        int ca = 0 ; //进位
        int n1 =0; // 取出第一个链表中的数
        int n2 =0; // 取出第二个链表中的数
        int n = 0;
        Node pre = null;
        Node node = null;
        while(!s1.isEmpty() ||!s2.isEmpty()){ // 栈弹出是链表逆序  从后往前
            n1 = s1.isEmpty()? 0 :s1.pop();
            n2 = s2.isEmpty()? 0 :s2.pop();
            n = n1 +n2 +ca;
            pre = node;  // 保存上一个节点
            node = new Node(n%10);
            node.next = pre;
            ca = n/10;
        }
        if(ca == 1){  // 最后判断是不是进位了
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node; // 头结点
    }

    /**
     * 利用链表反转
     * @param head1
     * @param head2
     * @return
     */
    public static Node addList2(Node head1,Node head2){
        head1 = reverseList(head1);
        head2  = reverseList(head2);
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node node1 =head1;
        Node node2 =head2;
        Node pre = null;
        Node node = null;
        while(node1!= null || node2 != null){
            n1 = node1 != null ? node1.value:0;
            n2 = node2 != null ? node2.value:0;
            n = n1 +n2 +ca;
            pre = node;
            node = new Node(n%10);
            node.next = pre;
            ca = n/10;
            node1 = node1 != null ? node1.next:null; // 必须要做   while循环用的 或 可能有一个为 null
            node2 = node2 != null ? node2.next:null;
        }
        if(ca == 1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        reverseList(head1);
        reverseList(head2);
        return node;
    }



    public static Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next; // 最后head 指向null  pre 指向头结点
        }
        return pre;
    }

    public static void printLinkedList(Node node){
        System.out.print("Linked List: ");
        while(node != null){
            System.out.print(node.value+" ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

//        Node head = new Node(9);
//        head.next = new Node(3);
//        head.next.next = new Node(7);
//
//        Node head1 = new Node(6);
//        head1.next = new Node(3);

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(3);
        Node head1 = new Node(3);
        head1.next = new Node(1);
        head1.next.next = new Node(4);
        head1.next.next.next = new Node(7);
        head1.next.next.next.next = new Node(5);

        Node node = addList1(head,head1);
        printLinkedList(node);
        printLinkedList(addList2(head,head1));
    }
}
