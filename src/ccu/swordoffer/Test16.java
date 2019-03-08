package ccu.swordoffer;

/**
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 */
public class Test16 {

    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value= data;
        }
    }
    public static Node reverseList(Node head){
        if(head == null){
            return null;
        }
        Node pre = null;
        Node next = null;
        Node cur = head;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre =cur;
            cur = next;
        }
        return pre;
    }

    public static void printList(Node node){
        while(node!= null){
            System.out.print(node.value +" ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        Node  node = reverseList(head);
        System.out.println(node.value);
        printList(node);

    }
}
