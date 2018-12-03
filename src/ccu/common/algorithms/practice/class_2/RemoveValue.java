package ccu.common.algorithms.practice.class_2;

import java.util.Stack;

/**
 * 在单链表中删除指定值的节点
 * 【题目】：
 *　　给定一个链表的头节点 head 和一个整数 num，请实现函数将值为 num 的节点全部删除。
 * 　 例如，链表为 1->2->3->4->NULL，num=3，链表调整后为：1->2->4->NULL。
 */
public class RemoveValue {
    public static class Node{
        private int value;
        private Node next;
        public Node(int data){
            this.value =data;
        }
    }

    /**
     *  借助栈实现
     * @param head
     * @param num  要删除的节点
     * @return
     */
    public static Node removeValue1(Node head,int num){
        Stack<Node> stack = new Stack<>();
        while(head != null){
            if(head.value != num){
                stack.push(head);
            }
            head = head.next;
        }
        //重新连接链表
        while(!stack.isEmpty()){
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    /**
     * 方法二
     * @param head 头结点
     * @param num
     */
    public static Node removeValue2(Node head,int num){
       // 找到第一个不为 num 的节点  并把它当做头结点
        while(head != null){
            if(head.value != num){
                break;
            }
            head = head.next;
        }
        Node previous = head;
        Node current = head;
        while(current != null){
            if(current.value == num){ // 找到了修改指针指向
                previous.next = current.next;
            }else{
                previous = current;
            }
            current = current.next;
        }
        return head;
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        Node node1 = removeValue1(head, 3);
        printLinkedList(node1);
        Node node2 = removeValue2(head, 6);
        printLinkedList(node2);
    }
}
