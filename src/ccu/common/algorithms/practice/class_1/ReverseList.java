package ccu.common.algorithms.practice.class_1;

public class ReverseList {

    private static Node previousHead;

    public static class Node{
        private int value;
        private Node next;
        public Node(int data){
            this.value = data;
        }
    }

    /**
     *  递归实现
     * @param head 头结点
     * @return
     */
    public static Node reverseListByRecursion(Node head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            previousHead = head; // 新链表的头指针。
            return head;
        }
        Node node = reverseListByRecursion(head.next);// 递归
        node.next = head;  // 设置指向前一个节点   反转操作
        head.next = null;  // 下一个节点指向空
        return head;  // 新链表的尾部节点
    }

    public static void printList(Node node){
        System.out.print("Linked List :");
        while(node != null){
            System.out.print(node.value +" ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

       Node head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(6);
            head.next.next.next.next = new Node(7);
        printList(head);
        Node head2 = reverseListByRecursion(head); // 尾部节点
        printList(previousHead);

    }

}
