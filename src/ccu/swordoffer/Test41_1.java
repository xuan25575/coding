package ccu.swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目二：输入一个正数 s，打印出所有和为 s 的连续正数序列（至少两个数）。
 * 例如输入 15，
 *   由于 1+2+3+4+5 = 4+5+6 ＝ 7+8 = 15，
 *   所以结果打出 3 个连续序列 1～5、4～6 和 7～8。
 */
public class Test41_1 {


    /**
     *  维护一个一个窗口 思路可以
     * @param s
     * @return
     */
    public static List<List<Integer>> findContinuousSequence2(int s){
        if(s < 3) return null;
        int p1= 1,p2 = 2;
        List<List<Integer>> result  = new ArrayList<>();
        while(p1 < p2){
            int cur = (p1+p2 )*(p2-p1+1)/2; // 等差数列求和
            if(cur ==s ){
                List<Integer> list = new ArrayList<>();
                for (int i = p1; i <=p2 ; i++) {
                    list.add(i);
                }
                result.add(list);
                p1++;
            }else if(cur > s ){
                p1++;
            }else{
                p2++;
            }
        }
        return result;
    }






    public static void findContinuousSequence(int s){
        if(s < 3){
            return;
        }
        int p1 = 1;
        int p2 = 2;
        int curSum = p1+p2;
        int mid  = (s+1)/2;  // 由于序列至少要有两个数字，所以p1不可能>(1+s)/2。
        while(p1 < mid){
            if(curSum == s){
                printNumbers(p1,p2);
            }
            while(p1 < mid && curSum > s){
                curSum-=p1;
                p1++;
                if(curSum == s){
                    printNumbers(p1,p2);
                }
            }
            p2++;
            curSum+=p2;
        }
    }

    public static void printNumbers(int p1,int p2){
        for (int k = p1; k <=p2 ; k++) {
            System.out.print(k+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        findContinuousSequence(15);
        findContinuousSequence(3);
    }
}
