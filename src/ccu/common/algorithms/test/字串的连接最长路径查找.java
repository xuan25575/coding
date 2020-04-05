package ccu.common.algorithms.test;

import jdk.nashorn.internal.ir.SetSplitState;

import java.util.*;

/**
 * @Author huang_2
 * @Date 2020/3/25 9:28 下午
 * @Description 给定n个字符串，请对n个字符串按照字典序排列。
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 *
 * next()从遇到第一个有效字符（非空格、换行符）开始扫描，遇到第一个分隔符或结束符（空格’ ‘或者换行符 ‘\n’）时结束。
 * nextLine()则是扫描剩下的所有字符串知道遇到回车为止。
 *
 */
public class 字串的连接最长路径查找 {

    public static void main(String[]args){
        Scanner sc =new Scanner(System.in);
        int num = sc.nextInt();
        String[] strings = new String[num];
        for (int i = 0; i < num; i++) {
            strings[i] = sc.next();
//            strings[i] = sc.nextLine(); 换成这个case 不过。
        }
        Arrays.sort(strings);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}
