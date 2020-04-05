package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/26 11:15 下午
 * @Description 正整数A和正整数B 的最小公倍数是指
 * 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 * 输入描述:
 * 输入两个正整数A和B。
 * 输出描述:
 * 输出A和B的最小公倍数。
 *
 * 最小公倍数 = 两数之积除以最大公约数
 */
public class 求最小公倍数 {

    private static int gcd(int x,int y){
        if(y==0) return x;
        int r = x % y;
        return  gcd(y, r);
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while(reader.hasNext()){
            int m = reader.nextInt();
            int n = reader.nextInt();
            System.out.println(m*n/gcd(m, n));
        }
    }
}
