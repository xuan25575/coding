package ccu.leetCode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author huang_2
 * @Date 2020/5/1 10:55 上午
 * @Description TODO
 */
public class 排序链表 {


    /**
     * 虽然不是最优解。
     * 快慢指针 和 合并链表
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow= slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        // 需要把链表断开。
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        return merge(left,right);
    }


    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy  = new ListNode(-1);
        ListNode tail = dummy;
        while(l1!=null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2:l1;
        return dummy.next;
    }



    /**
     * 不符合要求
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {

        ListNode dummy = new ListNode(-1);
        ArrayList<Integer> list = new ArrayList<>();
        while(head!= null){
            list.add(head.val);
            head = head.next;
        }

        Collections.sort(list);
        ListNode cur = dummy;
        for (Integer val : list) {
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}
