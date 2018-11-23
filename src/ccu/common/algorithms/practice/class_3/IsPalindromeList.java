package ccu.common.algorithms.practice.class_3;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 * 【题目】
 *  给定一个链表的头节点head，请判断该链表是否为回文结构。
 *  例如：
 *  1->2->1，返回true。
 *  1->2->2->1，返回true。
 *  15->6->15，返回true。
 *  1->2->3，返回false。
 *  进阶：
 *  如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)。
 *
 */
public class IsPalindromeList {


   public static class Node{
       public int value;
       public Node next;
       public Node(int data){
           this.value = data;
       }
   }



    /**
     * 思路： 一个栈放入所有节点的值，然后pop出来和head.value 比较 不相等则不是回文结构
     * need n extra space
     * @param head 头结点
     * @return
     */
   public static boolean isPalindrome1(Node head){
       if(head == null|| head.next == null ){
           return true;
       }
       Stack<Integer> stack  = new Stack<>();
       Node currentNode = head;//用来处理链表中数据
       while(currentNode !=  null){
           stack.push(currentNode.value);
           currentNode = currentNode.next;
       }
       while(head != null){
           if(head.value != stack.pop()){
               return false;
           }
           head = head.next;
       }
       return true;
   }


    /**
     *  快慢指针法
     *  给定两个节点指针，一个走一步，一个走两步，当走两步的节点走完，走一步的节点到了中点的下一个。
     *  将他们push栈中， 链表从头开始和栈从pop出来的数比较， 不相等不是回文
     * @param head  头结点
     * @return
     */
   public static boolean isPalindrome2(Node head){
       if(head == null || head.next == null){
           return true;
       }
       Stack<Integer> stack = new Stack<>();
       Node currentNode = head;
       Node right = head.next;  //对于奇数个链表 1->2->3->2->1 slow指向2
       while(currentNode.next != null && currentNode.next.next != null){ // 判断走两步是否为空，就得判断走一步的是否为空
           currentNode = currentNode.next.next;
           right = right.next;
       }
       while(right != null){
           stack.push(right.value);
           right = right.next;
       }
       while(!stack.isEmpty()){
           if(head.value != stack.pop()){
               return false;
           }
           head = head.next;
       }
       return true;
   }

    /**
     * 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)。
     * 涉及到链表反转
     * @param head 头结点
     * @return
     */
   public static boolean isPalindrome3(Node head){
       if(head == null || head.next == null){
           return true;
       }
       Node n1 = head;
       Node n2 = head;
       while(n2.next != null && n2.next.next!=null){
           n1 = n1.next;     // n1  mid
           n2 = n2.next.next;   // n2  end
       }
       //链表反转  三个变量控制
       Node n3 = null; // 用来保存下一个节点 辅助变量
       n2 =  n1.next; // 取得下一个节点
       n1.next = null; // 将第一个节点置为null  n1 为head
       while(n2 !=  null){
           n3 = n2.next;//保存下一个节点
           n2.next = n1; // next of right node convert
           n1 = n2; //n1 move
           n2 = n3; //n2 move
       }

       // 关键代码
       n3 = n1;  // 保存last node  n1是没有反转前最后一个节点，反转后的第一个节点
       n2 = head;
       boolean result = true;
       while(n1 != null && n2!= null){
           if(n1.value != n2.value){
               result = false;
               break;
           }
           n1 = n1.next; // to mid
           n2 = n2.next;  // to mid
       }

       //恢复链表 recover list
       n1 = n3.next; // n1 保存下一个节点
       n3.next = null; // 第一个节点指向 null
       while(n1 != null){  //  下一个节点不为null
           n2 = n1.next;   // 不能用 n3 != null  会NullPointException  n3.next = null 那么n1.next 成了 null.next.
           n1.next = n3; // 指向上一个节点
           n3 = n1; // n3 往后移动一个节点
           n1 = n2; // n1 往后移动一个节点
       }
       return result;
   }



   public static void printLinkedList(Node node){
       System.out.print("Linked List: ");
       while(node != null){
           System.out.print(node.value+" ");
           node  = node.next;
       }
       System.out.println();
   }

    public static void main(String[] args) {
        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");
    }















}
