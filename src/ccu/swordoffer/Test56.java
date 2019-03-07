package ccu.swordoffer;
/**
 * 题目：一个链表中包含环，如何找出环的入口结点？
 *
 * 题目五：两个单链表相交的一系列问题的第一个小环节
 *  class_2 FindFirstIntersectNode 类
 * 【解】：双指针：
     F：一次走两步、S：一次走一步
     - 如果有环，则F与S一定会在环中相遇。
     相遇时，再来一个指针A：一次走一步，（S：也一次走一步）
     则A与S 一定会在入环的第一个节点相遇【一定】，可返回入环的第一个节点。
     - 如果无环，
     return null;
 *
 *
 */
public class Test56 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode entryNodeOfLoop(ListNode pHead) {
        if(pHead == null|| pHead.next == null || pHead.next.next == null )  return null;
        ListNode slow  = pHead.next;  // --> slow
        ListNode fast =  pHead.next.next; // --> fast
        while(slow != fast){
            if(fast.next == null || fast.next.next == null) return null; // 链表没有环。
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = pHead;
        while(slow != fast){
            slow=  slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
