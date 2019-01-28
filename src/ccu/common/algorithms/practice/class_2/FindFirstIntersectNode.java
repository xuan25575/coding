package ccu.common.algorithms.practice.class_2;

/**
 * 两个单链表相交的一系列问题
 *
 *    在本题中，单链表可能有环，也可能无环。给定两个单链表的头节点
 *    head1和head2，这两个链表可能相交，也可能不相交。请实现一个函数，
 *    如果两个链表相交，请返回相交的第一个节点；如果不相交，返回null
 *    即可。
 *    要求：如果链表1的长度为N，链表2的长度为M，时间复杂度请达到
 *    O(N+M)，额外空间复杂度请达到O(1)。
 */
public class FindFirstIntersectNode {

    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value= data;
        }
    }

    /**
     *   loop1 == null && loop2 != null  不存在这种情况。
     * @param head1 链表1 头结点
     * @param head2 链表2 头结点
     * @return
     */
    public static Node getIntersectNode(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1 == null && loop2 == null){
           return  noLoop(head1,head2);
        }
        if(loop1 != null && loop2!=null){
           return  bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }

    /**
     *  判断链表是否有环
     * @param head  头结点
     * @return  有环返回环节点  无环返回null
     */
    public static Node getLoopNode(Node head){
        if(head == null|| head.next == null || head.next == null){
            return null;
        }
        Node n1 = head.next; // - slow
        Node n2 = head.next.next; // -  fast
        while(n1 != n2){
            if(n2.next == null|| n2.next.next == null){
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;  // 修改n2指向头结点 一起走
        while(n1!= n2){ // 数学结论  会在第一个入环节点相遇。
            n1= n1.next;
            n2= n2.next;
        }
        return n1;
    }

    /**
     *  判断无环相交  据单链表性质，只能是在尾节点一起结束，
     * @param head1  链表1 头结点
     * @param head2 链表2 头结点
     * @return 返回相遇的节点
     */
    public static Node noLoop(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node current1 = head1;
        Node current2 = head2;
        int n =  0; // 用来计数
        while(current1.next != null){ // 保证尾节点不为null
            n++;
            current1 =current1.next;
        }
        while(current2.next != null){
            n--;
            current2 =current2.next;
        }
        if(current1 != current2){ // 不是同一个尾节点
            return null;
        }
        // 判断哪个先走
        current1 = n > 0 ? head1:head2;
        current2 = current1 == head1 ? head2: head1;
        n  = Math.abs(n);  // 不能为负数
        //走到0停止，然后一起走。
        while(n != 0){
            n--;
            current1 = current1.next;
        }
        //不相等没相遇
        while(current1 != current2){
            current1 = current1.next;
            current2 = current2.next;
        }// 当两个节点相等，即是相交节点。
        return current1;
    }


    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2){
        Node current1 =  null;
        Node current2 =  null;
        if(loop1 == loop2){ // 都有环 并且相等
            current1 = head1;
            current2 = head2;
            int n =  0; // 用来计数
            while(current1.next != loop1){  // 结束条件不一样  和上面无环的判断。
                n++;
                current1 =current1.next;
            }
            while(current2.next != loop2){
                n--;
                current2 =current2.next;
            }
            if(current1 != current2){
                return null;
            }
            // 判断哪个先走
            current1 = n > 0 ? head1:head2;
            current2 = current1 == head1 ? head2: head1;
            n  = Math.abs(n);  // 不能为负数
            //走到
            while(n != 0){
                n--;
                current1 = current1.next;
            }
            //不相等没相遇
            while(current1 != current2){
                current1 = current1.next;
                current2 = current2.next;
            }
            return current1;
        }else {  // 环节点节点不在一起   两种情况：一种是两个环  一种是一个环上两个环节点。
            current1 = loop1.next;
            while(current1 != loop1){
                if(current1  == loop2){ //只要在环上相遇loop2 确定是后面那种情况。直接返回。
                    return loop1;
                }
                current1 =current1.next;
            }
            return null; // 没有返回null
        }
    }

    public static void printLinkedList(Node node){
        System.out.print("Linked List :");
        while(node != null){
            System.out.print(node.value+" ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        printLinkedList(head2);
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
       // printLinkedList(head1);

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        //printLinkedList(head2);
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
       // printLinkedList(head2);
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
