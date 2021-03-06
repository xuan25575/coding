package ccu.leetCode;

/**
 * @Author huang_2
 * @Date 2020/4/30 2:39 下午
 * @Description TODO
 */
public class Solution {



    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next=l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if(l1 == null){
            pre.next =l2;
        }

        if(l2 ==null){
            pre.next = l1;
        }
        return dummyHead.next;
    }


    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next  = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
