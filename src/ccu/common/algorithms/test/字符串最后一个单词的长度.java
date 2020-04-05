package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/25 8:10 下午
 * @Description TODO
 */
public class 字符串最后一个单词的长度 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" "); //正则表达式实用性更强( str.split("\\s+"))
        int length = s[s.length - 1].length();
        System.out.println(length);
    }
}
