package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/25 8:24 下午
 * @Description
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class 字符串分隔 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            if(s.length() %8 !=0 )
                s = s + "00000000";

            while(s.length()>=8){
                System.out.println(s.substring(0, 8));
                s = s.substring(8);
            }
        }
    }
}
