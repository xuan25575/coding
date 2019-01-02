package ccu.common.algorithms.practice.class_2;

/**
 * 删除链表中间节点和a/b 处的节点
 */
public class RemoveLinkedNode {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value= data;
        }
    }


    /**
     * 删除链表的中间节点
     * 链表长度增加2 删除的节点位置+1
     * @param head
     * @return
     */
    public static Node removeMidNode(Node head){
        if(head == null || head.next == null){
            return  head;
        }
        if(head.next.next == null ){
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while(cur.next != null && cur.next.next != null){
            pre = pre.next;
            cur= cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }


    /**
     * 删除 a/ b出的节点
     * @param head  头结点
     * @param a  数字
     * @param b 数字
     * @return
     */
    public static Node removeByRatio(Node head,int a,int b){
        if(a < 1 && a > b ){
            return head;
        }
        int n =0;
        Node cur = head;
        while(cur != null){
            n++;
            cur= cur.next;
        }
        n = (int)Math.ceil((double)(a * n)/(double)b);
        if(n == 1){
            head = head.next;
        }
        if(n > 1){
            cur = head;
            while(--n != 1){  // 等于1 才好删除下一个节点
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }


}
