package ccu.swordoffer;

import ccu.structure.ListNode;

import java.util.Stack;

/**
 * 从尾到头打印链表
 *
 * 两种方式，
 * 栈实现
 * 递归实现
 *
 */
public class Test5 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printListReverseByStack(head);
        printListReverseByRecursion(head);
    }

    /**
     * 栈实现  顺序逆序  -->栈先进后出
     * @param head
     */
    public static void printListReverseByStack(ListNode  head){
        Stack<Integer> stack = new Stack<>();
        if(head  == null) return;
        while(head != null){
            stack.push(head.value);
            head = head.next;
        }
        while(!stack.empty()){
            System.out.println(stack.pop()+ " ");
        }
    }

    /**
     * 递归实现
     * @param head
     */
    public static void printListReverseByRecursion(ListNode head) {
        if (head == null)  return;
        printListReverseByRecursion(head.next);
        System.out.println(head.value);
    }

}