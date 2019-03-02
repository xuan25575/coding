package ccu.swordoffer;

/**
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
 */
public class Test17 {

    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value= data;
        }
        public Node(){
        }
    }

    /**
     *  空间复杂度为 O(m+n)  构造了一条新链  不是最优解
     * @param head1
     * @param head2
     * @return
     */
    public static Node mergeSortList2(Node head1,Node head2){
        if(head1 == null){
            return head2;
        }else if(head2 == null){
            return head1;
        }
        Node tail = new Node(); // 避免空指针
        Node  head = tail; // 新链表的开始节点  过度节点
        // 类似归并排序的思路
        while(head1!= null && head2!= null){
            if(head1.value <= head2.value){
                tail.next = head1; // 避免在此处发生 空指针
                head1 = head1.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;  // 让tail 节点一直指向节点尾部。
        }
        if(head1!= null){
            tail.next =  head1;
        }
        if(head2 != null){
            tail.next =head2;
        }
        return head.next;
    }
    /**
     * 递归实现
     * @param head1
     * @param head2
     * @return
     */
    public static Node mergeSortList1(Node head1,Node head2){
        if(head1 == null){
            return head2;
        }else if(head2 == null){
            return head1;
        }
        Node mergeHead = null;
        if(head1.value <= head2.value){
            mergeHead = head1;
            mergeHead.next = mergeSortList1(head1.next,head2); // 接到头结点的下一个
        }else{
            mergeHead= head2;
            mergeHead.next = mergeSortList1(head1,head2.next);
        }
        return mergeHead;
    }

    //理解
    public Node Merge(Node list1,Node list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        if(list1.value <= list2.value){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    public static void printList(Node node){
        while(node!= null){
            System.out.print(node.value +" ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(6);
        head1.next.next.next = new Node(9);

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(5);
        head2.next.next.next = new Node(6);
        head2.next.next.next.next = new Node(7);

//        head1 = mergeSortList1(head1, head2);
        head1 = mergeSortList2(head1, head2);
        printList(head1);
        System.out.println();
    }
}
