package ccu.swordoffer;

import java.util.List;

/**
 * 题目：我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求从小到大的顺序的第 1500个丑数。
 * 例如 6、8 都是丑数，但 14 不是，它包含因子 7。习惯上我们把 1 当做第一个丑数。
 *
 * 时间换空间
 */
public class Test34 {


    /**
     *   获取第n个丑数
     * @param n 多少个
     * @return
     */
    public static int getUglyNumber(int n){
        if(n < 1 ){
            return -1;
        }
        int[] uglyArr = new int[n];
        uglyArr[0] = 1;
        int index  = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        while(index < n){
            int min = min(uglyArr[p2]*2,uglyArr[p3]*3,uglyArr[p5]*5);
            uglyArr[index] = min;  // 阈值
            while(uglyArr[p2]*2 <= uglyArr[index] ){
                p2++;
            }
            while(uglyArr[p3]*3 <= uglyArr[index] ){
                p3++;
            }
            while(uglyArr[p5]*5 <= uglyArr[index] ){
                p5++;
            }
            index++;
        }
        return uglyArr[--index];

    }


    public static int min(int a,int b,int c){
        int min = a < b ? a : b;
        return c < min ? c : min;
    }


    /**
     * 思路;:  让数组 丑数排序  每一个丑数都是前一个丑数乘以2 或3 或5
     * @param n
     * @return
     */
    public static int getUglyNumber2(int n){
        if(n < 7)  return n;
        int[] res = new int[n];
        res[0]= 1; // 第一个丑数
        int p2 =0,p3 =0,p5=0;
        for (int i = 1; i < n ; i++) {
            res[i] = min(res[p2]*2,res[p3]*3,res[p5]*5);
            if(res[i] == res[p2]*2) p2++;
            if(res[i] == res[p3]*3) p3++;
            if(res[i] == res[p5]*5) p5++;
        }
        return res[n-1];
    }



    public static void main(String[] args) {
//        System.out.println(getUglyNumber(1)); // 1
//        System.out.println(getUglyNumber(2)); // 2
//        System.out.println(getUglyNumber(3)); // 3
//        System.out.println(getUglyNumber(4)); // 4
//        System.out.println(getUglyNumber(5)); // 5
//        System.out.println(getUglyNumber(6)); // 6
//        System.out.println(getUglyNumber(7)); // 8
//        System.out.println(getUglyNumber(8)); // 9
//        System.out.println(getUglyNumber(9)); // 10
//        System.out.println(getUglyNumber(10)); // 12
//        System.out.println(getUglyNumber(11)); // 15
//        System.out.println(getUglyNumber(1500)); // 859963392

        System.out.println("======================");
//        System.out.println(getUglyNumber2(1)); // 1
//        System.out.println(getUglyNumber2(2)); // 2
//        System.out.println(getUglyNumber2(3)); // 3
//        System.out.println(getUglyNumber2(4)); // 4
//        System.out.println(getUglyNumber2(5)); // 5
//        System.out.println(getUglyNumber2(6)); // 6
//        System.out.println(getUglyNumber2(7)); // 8
//        System.out.println(getUglyNumber2(8)); // 9
        System.out.println(getUglyNumber2(9)); // 10
        System.out.println(getUglyNumber2(10)); // 12
        System.out.println(getUglyNumber2(11)); // 15
        System.out.println(getUglyNumber2(1500)); // 859963392
    }
}
