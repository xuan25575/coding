package ccu.common.algorithms.practice.class_2;


/**
 * 在单链表和双链表中删除倒数第K个节点
 */
public class RemoveLastKthNode {

    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value= data;
        }
    }

    /**
     * 长度n 找到倒数第k个节点
     * @param head 头结点
     * @param lastKth 倒数第几个
     * @return
     */
    public static Node removeLastKthNode(Node head,int lastKth){
        if(head == null|| lastKth <1 ){
            return head;
        }
        Node current = head;
        // 遍历一次找到  lastKth = k-n位置
        while(current != null){
            lastKth--;
            current = current.next;
        }
        // 如果等于0  为头结点 大于0说明链表没有这么长不用判断了
        if(lastKth == 0){
            head = head.next;
        }
        // 小于0  找到倒数第k个位置的前一个位置 将指针修改。
        if(lastKth<0){
            current = head;
            while(++lastKth<0){
                current = current.next;
            }
            current.next = current.next.next; //修改next指针指向
        }
        return head;
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
     *
     * @param head  头结点
     * @param lastKth 倒数k位置
     * @return
     */
    public static DoubleNode removeLastKthDoubleNode(DoubleNode head,int lastKth){

        if(head == null|| lastKth <1 ){
            return head;
        }
        DoubleNode current = head;
        // 遍历一次找到  lastKth = k-n位置
        while(current != null){
            lastKth--;
            current = current.next;
        }
        // 如果等于0  为头结点 大于0说明链表没有这么长不用判断了
        if(lastKth == 0){
            head = head.next;
            head.last = null; // 修改下一个节点的last指针
        }
        DoubleNode newNode = null; //用一个变量来接 防止空指针
        // 小于0  找到倒数第k个位置的前一个位置 将指针修改。
        if(lastKth<0){
            current = head;
            while(++lastKth !=0){
                current = current.next;
            }
            newNode = current.next.next; //修改next指针指向
            current.next = newNode;
            if(newNode != null){// 防止 NullPointException
                newNode.last = current; // 修改last指针指向
            }
        }
        return head;
    }

    public static void printDoubleLinkedList(DoubleNode node){
        DoubleNode end =null;
        System.out.print("linked list: " );
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
        Node node = removeLastKthNode(head1,2);
        printLinkedList(node);

        System.out.println("===================");


        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(removeLastKthDoubleNode(head2,2));
    }

}
