package ccu.common.algorithms.practice.class_3;

/**
 *  打印两个有序链表的公共部分
 *  【题目】
 *   给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 */
public class PrintCommonPart {

    public static class Node{
        private int value;
        private Node next;
        public Node(int data){
            this.value = data;
        }
    }
    public static void printCommonPart(Node head1,Node head2){
        while(head1!= null && head2 != null){  // 循环往后走
            if(head1.value > head2.value){
                head2 = head2.next;
            }else if(head1.value < head2.value){
                head1 = head1.next;
            }else{
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

    public static void printList(Node head){
        System.out.print("Linked List: ");
        while(head != null){
            System.out.print(head.value+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(4);
        head1.next.next.next = new Node(6);


        Node head2 = new Node(1);
        head2.next =new Node(4);
        head2.next.next = new Node(5);
        head2.next.next.next = new Node(6);
        head2.next.next.next.next = new Node(8);

        printList(head1);
        printList(head2);
        printCommonPart(head1,head2);

    }
}
