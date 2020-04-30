package ccu.leetCode;

import java.util.HashSet;

/**
 * @Author huang_2
 * @Date 2020/4/30 10:35 上午
 * @Description TODO
 */
public class 快乐数 {


    /**
     * 求 85 = 8^2 + 5^2
     * @param n
     * @return
     */
    private int getNext(int n){
        int sum= 0;
        while(n > 0){
           int i = n%10;
           n = n/10;
           sum += i*i;
        }
        return sum;
    }

    /**
     * 利用 hashset 去重。有环一定有 退出循环
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    /**
     * 快慢指针，
     * 乌龟从原地走，兔子先走一步，(一定不是在同一个起点走。)
     * 乌龟每次走一步， 兔子每次走两步， 有环的话（数学结论）一定会在相遇。
     *
     *  快指针一定先到1 。
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {

        int slow = n ;
        int fast = getNext(n);
        while(fast !=1 && slow != fast){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;

    }



    public static void main(String[] args) {
        快乐数 s = new 快乐数();
        boolean b = s.isHappy2(19);
        System.out.println( b);
    }
}
