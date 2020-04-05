package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/25 9:17 下午
 * @Description 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 */
public class 数字颠倒 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        String str = String.valueOf(n);

        StringBuffer sb = new StringBuffer();

        for(int i=str.length()-1;i>=0;i--){
            sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }

}
