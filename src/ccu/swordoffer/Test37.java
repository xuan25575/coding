package ccu.swordoffer;

/**
 * 题目：输入两个链表，找出它们的第一个公共结点
 *
 * 可参考 class_2 FindFirstIntersectNode 类
 */
public class Test37 {

    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value= data;
        }
    }

    /**
     *  长度相同有公共结点，第一次就遍历到；没有公共结点，走到尾部NULL相遇，返回NULL
     *  长度不同有公共结点，第一遍差值就出来了，第二遍一起到公共结点；没有公共，一起到结尾NULL。
     *  只是适用链表无环
     * @param head1
     * @param head2
     * @return
     */
    public static Node findFirstCommonNode(Node head1,Node head2){
        Node p1 = head1;
        Node p2 = head2;
        while(p1 != p2){
            p1 =(p1 == null)? head2 : p1.next;
            p2 =(p2 == null)? head1 : p2.next;
        }
        return p1;
    }

    // 解二  先记录两个链表的长度，然后长的链表先走 （两个链表长度）差值 ，然后一起走  相等则找到相同的节点。








    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        //head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6

        System.out.println(findFirstCommonNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        // printLinkedList(head2);
        System.out.println(findFirstCommonNode(head1, head2).value);
    }








}
