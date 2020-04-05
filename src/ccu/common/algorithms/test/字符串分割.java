package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/27 2:00 下午
 * @Description
 * 连续输入字符串(输出次数为N, 字符串长度小于100)，请按长度为8拆分每个字符串后输出到新的字符串数组，
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 首先输入一个整数，为要输入的字符串个数。
 * 例如：
 * 输入：  2
 *       abc
 *       12345789
 * 输出： abc00000
 *       12345678
 *       90000000
 *
 * 输入描述:
 * 首先输入数字n，表示要输入多少个字符串。连续输入字符串(输出次数为N,字符串长度小于100)。
 * 输出描述:
 * 按长度为8拆分每个字符串后输出到新的字符串数组，长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class 字符串分割 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n  = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                if(s.length() %8 !=0 )
                    s = s + "00000000";
                while(s.length()>=8){
                    System.out.println(s.substring(0, 8));
                    s = s.substring(8);
                }
            }
        }
    }
}
