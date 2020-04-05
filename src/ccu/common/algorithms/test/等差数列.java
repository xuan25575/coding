package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/27 3:18 下午
 * @Description
 * 功能:等差数列 2，5，8，11，14。。。。
 * 输入:正整数N >0
 * 输出:求等差数列前N项和
 * 返回:转换成功返回 0 ,非法输入与异常返回-1
 * 输入描述:
 * 输入一个正整数。
 * 输出描述:
 * 输出一个相加后的整数。
 * 示例1
 * 输入
 * 2
 * 输出
 * 7
 */
public class 等差数列 {

    //等差数列求和公式：Sn=a1*n+n*(n-1)*d/2
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            if(n<1){
                System.out.println(-1);
            }else{
                System.out.println((2*n+3*n*(n-1)/2));
            }

        }
        in.close();
    }
}
