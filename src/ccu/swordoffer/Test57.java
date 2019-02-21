package ccu.swordoffer;
/**
 * 题目：在一个排序的链表中，如何删除重复的结点？
 * 例如，1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5 -> null 中重复结点被删除之后，链表变成了：
 *      1 -> 2 -> 5 -> null
 *
 */
public class Test57 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
            return pHead;
        }
        if (pHead.val == pHead.next.val) { // 当前结点是重复结点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            return deleteDuplication(pNode); // 从第一个与当前结点不同的结点开始递归
        } else { // 当前结点不是重复结点
            pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
            return pHead;
        }
    }

    //非递归实现
    public ListNode deleteDuplication2(ListNode pHead) {
        if(pHead==null) return pHead;
        ListNode first = new ListNode(0);
        first.next = pHead;
        ListNode cur = pHead;
        ListNode pre =first;
        while(cur!= null&& cur.next!= null){
            if(cur.val == cur.next.val){
              int val = cur.val;
              while(cur != null && cur.val == val){ // 找到不重复的节点
                  cur =cur.next;
              }
              pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return first.next;
    }





}
