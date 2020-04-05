package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/25 8:11 下午
 * @Description 写出一个程序，接受一个由字母和数字组成的字符串，
 * 和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 */
public class 计算字符个数 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char c = in.next().charAt(0);
        System.out.println(getNum(s,c));

    }
    public static int getNum(String s, char c){
        int length = s.length();
        int num = 0 ;
        for (int i = 0; i < length; i++) {
            if (s.toLowerCase().charAt(i) == c  || s.toUpperCase().charAt(i) == c  ) {
                num++;
            }
        }

        return num;
    }
}
