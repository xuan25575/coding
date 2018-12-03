package ccu.common.algorithms.practice.class_2;

import java.util.HashSet;
import java.util.Set;

/**
 * 删除无序单链表中无序出现重复的单链表节点
 */
public class RemoveRepeatValue {
    public static class Node{
        private int value;
        private Node next;
        public Node(int data){
            this.value =data;
        }
    }

    /**
     *  方法一：
     *  利用hash表去重。
     * @param head
     */
    public static void removeRepeatValue1(Node head){
        if(head == null){
            return ;
        }
        Set<Integer> set = new HashSet<>();
        Node previous = head;
        Node current = head.next;
        set.add(head.value);
        while(current != null){
            if(set.contains(current.value)){
               previous.next = current.next;
            }else{
                set.add(current.value);
                previous = current;
            }
            current = current.next;
        }
    }

    /**
     *  方法二：
     *  思路是： 每个节点检查一次 遍历链表长度去重。
     *  时间复杂度：O(n^2)
     * @param head
     */
    public static void removeRepeatValue2(Node head){
        if(head == null){
            return;
        }
        Node current = head;
        Node previous = null;
        Node next =  null;  //  下一个节点
        while(current != null){
            previous = current;
            next = current.next;
            while(next != null){
                if(current.value  == next.value){  // current.value 是判断值 相当于第一个for循环
                    previous.next = next.next;   // 删除当前next 节点
                }else{
                    previous = next;  // 保存上一次next节点
                }
                next = next.next;
            }
            current = current.next;
        }
    }
    public static void  printLinkedList(Node node){
        System.out.print("linked list: ");
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
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(3);

//        removeRepeatValue1(head);
        removeRepeatValue2(head);
        printLinkedList(head);

    }
}
