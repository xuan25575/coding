package ccu.common.algorithms.practice.class_3;

/**
 * 反转单向和双向链表
 */
public class ReverseList {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }

    /**
     * 思路： 实现需要3个变量控制  一个当前节点  一个previous node， 一个next node
     * 1.保存next node, 修改 head.next 的指向，previous node and  head node 同时移动一步。
     * reverse List  单向链表
     * @param head  head node
     * @return  head  node
     */
    public static Node reverseList(Node head){
        Node previous = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }

    public static class DoubleNode{
        public int value;
        public DoubleNode last; // 前一个节点
        public DoubleNode next;
        public DoubleNode(int data){
            this.value =  data;
        }
    }

    /**
     *  双向链表的反转 多出一个前驱节点的指向的修改
     * @param head head node
     * @return head node
     */
    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode previous = null;
        DoubleNode next = null;
        while(head != null){
            next = head.next;
            head.next = previous;
            head.last = next;
            previous = head;
            head = next;
        }
        return previous;
    }

    public static void printDoubleLinkedList(DoubleNode node){
        DoubleNode end =null;
        System.out.print("double linked list: " );
        while(node != null){
            System.out.print(node.value+" ");
            end = node; // 用来保存最后一个节点 不能为空。放在 node = node.next;之前
            node = node.next;
        }
        System.out.print(" | ");
        while(end != null){
            System.out.print(end.value+" ");
            end = end.last;
        }
        System.out.println();
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
        Node head1 =  new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next  = new Node(4);

        printLinkedList(head1);
        Node node = reverseList(head1);
        printLinkedList(node);
        printLinkedList(head1); // reverse list after this node is last node

        System.out.println("===================");


        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(reverseDoubleList(head2));

    }
}
