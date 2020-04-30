package ccu.leetCode;

/**
 * @Author huang_2
 * @Date 2020/4/30 3:13 下午
 * @Description
 *
 * 判断链表是否有环。
 *
 *  学习快慢指针的写法
 */
public class 环形链表 {


    /**
     *  写法一
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&& fast.next != null){ // 快指针不能 null 不会出现 NPE 异常
            slow  = slow.next;
            fast = fast.next.next;
            if(fast == slow){  //判断相等跳出循环。
                return true;
            }
        }
        return false;
    }

    /**
     * 写法二
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != fast){ //首先你的 让这个条件不成立。所以必须得fast 先走一步
            if(fast.next == null || fast ==null){ //还得避免 NPE
                return false;
            }
            slow  = slow.next;
            fast =  fast.next.next;

        }
        return true;
    }
}
