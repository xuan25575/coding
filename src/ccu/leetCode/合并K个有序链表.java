package ccu.leetCode;

import java.util.PriorityQueue;

/**
 * @Author huang_2
 * @Date 2020/4/26 9:40 上午
 * @Description TODO
 */
public class 合并K个有序链表 {



   // 分治大法
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }


    // 两两合并

    public ListNode mergeKLists2(ListNode[] lists) {

        if(lists == null || lists.length ==0) return null;

        ListNode res = lists[0];
        for (int i = 1; i <lists.length ; i++) {
            res = merge(res, lists[i]);
        }

        return res ;
    }


    private ListNode merge(ListNode list1, ListNode list2){

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(list1 != null && list2!=null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2  = list2.next;
            }
            cur = cur.next;
        }

        if(list1 != null){
            cur.next = list1;
        }
        if(list2 != null){
            cur.next = list2;
        }

        return dummy.next;
    }





    // 优先级队列
    public ListNode mergeKLists(ListNode[] lists) {
        // 小根堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2)-> o1.val - o2.val);

        // 加入头
        for (ListNode head : lists) {
            if(head!= null) {
                queue.add(head);
            }
        }

        // 虚拟节点
        ListNode dummy  = new ListNode(-1);
        ListNode cur = dummy;

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if(node.next != null){ // 判断下一个入队。
                queue.add(node.next);
            }
        }
        return dummy.next;

    }











}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
