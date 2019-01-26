package ccu.swordoffer;

import java.util.HashMap;

/**
 *  题目：请实现函数 ComplexListNode clone(ComplexListNode head)，复制一个复杂链表。
 * 在复杂链表中，每个结点除了有一个 next 域指向下一个结点外，还有一个 sibling 指向链表中的任意结点或者 null。
 *  【解】：
 *  法一：
 *      用HashMap保存(1,1.value)、(2,2.value)、...之间的对应关系
 *  法二：
 *      先将链表化成 1->1'->2->2'->...
 *
 *      可参考 class_2 包下的CopyListWithRandom 类
 */
public class Test26 {
    public static class ComplexListNode {
        private int value;
        ComplexListNode next;
        ComplexListNode sibling;
        public ComplexListNode() {
        }
        public ComplexListNode(int value) {
            this.value = value;
        }
    }

    /**
     * 解 1
     * @param head
     * @return
     */
    public static ComplexListNode clone1(ComplexListNode head){
       if(head == null){
           return null;
       }
        HashMap<ComplexListNode,ComplexListNode> map = new HashMap<>();
        ComplexListNode cur = head;
        //复制节点
        while(cur != null){
            map.put(cur,new ComplexListNode(cur.value));
            cur =cur.next;
        }
        // 连接list
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).sibling = map.get(cur.sibling);
            cur = cur.next;
        }
        return map.get(head);
    }


    /**
     *  解 2
     * @param head
     * @return
     */
    public static ComplexListNode clone2(ComplexListNode head){
        if(head == null){
            return null;
        }
        ComplexListNode cur = head;
        //复制链表   1->1`->2->2`->3->3`->null
        while(cur != null){
            ComplexListNode cloneCur =  new ComplexListNode(cur.value);
            cloneCur.next = cur.next;
            cloneCur.sibling = null;
            cur.next = cloneCur;
            cur =  cloneCur.next;  // 往后移动
        }
         // 设置 sibling 节点
        cur = head;
        while(cur != null){
            if(cur.sibling != null){
                ComplexListNode cloneNode = cur.next;
                cloneNode.sibling = cur.sibling.next;
            }
            cur = cur.next.next;
        }
        // 拆分
        cur = head;
        ComplexListNode  result = head.next;
        while(cur != null){
            ComplexListNode next = cur.next.next;
            ComplexListNode cloneCur= cur.next;
            cur.next= next;
            cloneCur.next = next != null ? next.next:null; // 空判断是有必要的
            cur = next;   // 移动
        }
        return result;
    }

    private static void printList(ComplexListNode head) {
        ComplexListNode cur = head;
        System.out.println("order: ");
        while (cur != null) {
            System.out.print(cur.value + "-> ");
            cur = cur.next;
        }
        System.out.println("null");
        cur = head;
        System.out.println("sibling:  ");
        while (cur != null) {
            System.out.println(cur.value + ".sibling -> " + (cur.sibling == null ? "null" : cur.sibling.value));
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //  |       |      /|\             /|\
        //  --------+--------               |
        //          -------------------------
        ComplexListNode head = new ComplexListNode();
        head.value = 1;
        head.next = new ComplexListNode();
        head.next.value = 2;
        head.next.next = new ComplexListNode();
        head.next.next.value = 3;
        head.next.next.next = new ComplexListNode();
        head.next.next.next.value = 4;
        head.next.next.next.next = new ComplexListNode();
        head.next.next.next.next.value = 5;
        head.sibling = head.next.next;
        head.next.sibling = head.next.next.next.next;
        head.next.next.next.sibling = head.next;
        printList(head);
        ComplexListNode newHead = clone2(head);
        printList(newHead);
    }
}
