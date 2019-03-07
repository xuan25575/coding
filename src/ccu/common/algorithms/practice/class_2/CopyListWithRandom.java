package ccu.common.algorithms.practice.class_2;

/*【题目】
        一种特殊的链表节点类描述如下：
    public class Node {
        public int value;
        public Node next;
        public Node rand;
        public Node(int data) {
            this.value = data;
        }
    }
        Node类中的value是节点值，next指针和正常单链表中next指针的意义一
        样，都指向下一个节点，rand指针是Node类中新增的指针，这个指针可
        能指向链表中的任意一个节点，也可能指向null。
        给定一个由Node节点类型组成的无环单链表的头节点head，请实现一个
        函数完成这个链表中所有结构的复制，并返回复制的新链表的头节点。
        进阶：不使用额外的数据结构，只用有限几个变量，且在时间复杂度为
        O(N)内完成原问题要实现的函数。*/

import java.util.HashMap;

/**
 * 复制含有随机指针节点的链表
 *
 * 可参考  swordoffer Test26
 */
public class CopyListWithRandom {
    public static  class  Node {
        public int value;
        public Node next;
        public Node rand;
        public Node(int data) {
            this.value = data;
        }
    }


    public static Node copyListWithRand1(Node head){
        HashMap<Node,Node> map = new HashMap<>();
        Node currentNode =  head;
        //设置 value
        while(currentNode != null){
            map.put(currentNode,new Node(currentNode.value));
            currentNode = currentNode.next;
        }
        currentNode = head;
         //设置新节点的 next 和 rand
        while(currentNode != null){
            map.get(currentNode).next = map.get(currentNode.next);
            map.get(currentNode).rand = map.get(currentNode.rand);
            currentNode = currentNode.next;
        }
        return map.get(head);
    }

    // 第二个方法：

    /**
     *  进阶
     * @param head
     * @return
     */
    public static Node  copyListWithRand2(Node head){
        if(head  == null){
            return null;
        }
        Node currentNode = head;
        Node next = null;
        // 1. copy node and link to every node  保存类似这种结构  1->1`->2->2`->3->3`->null
        while(currentNode != null){
            next = currentNode.next;  // sava next node
            currentNode.next = new Node(currentNode.value); //set new  next node
            currentNode.next.next = next;  //set old next node to  new  next node after
            currentNode = next; // move
        }

        //2.设置复制节点的rand指针
        currentNode = head;
        Node copyCurrentNode = null;
        while(currentNode != null){
           next = currentNode.next.next; //保存原有链表的下一个节点
           copyCurrentNode = currentNode.next; //取得被复制的节点
            //currentNode.rand.next 当前rand节点的下一个
           copyCurrentNode.rand = currentNode.rand != null ?currentNode.rand.next : null; // 设置复制节点的rand指针
           currentNode = next;  //往后移动
        }
        // 3.拆分
        Node result = head.next;
        currentNode = head;
        while(currentNode != null){
            next = currentNode.next.next; //保存下一个节点
            copyCurrentNode = currentNode.next; // 取得当前节点的复制节点
            copyCurrentNode.next = next != null ? next.next:null; //设置新链表下一个节点
            currentNode.next = next; //设置旧链表下一个节点
            currentNode = next;
        }
        return result;
    }



    public static void  printRandLinkedList(Node head){
        Node currentNode  = head;
        System.out.print("order : ");
        while(currentNode != null){
            System.out.print(currentNode.value+" ");
            currentNode =currentNode.next;
        }
        System.out.println();
        currentNode = head;
        System.out.print("random : ");
        while(currentNode != null ){
            System.out.print(currentNode.rand == null ? "- ":currentNode.rand.value+" ");
            currentNode =currentNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        Node res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        Node res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");


    }
}
