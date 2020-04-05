package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/25 9:20 下午
 * @Description 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 */
public class 字符串反转 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();

            for(int i=s.length()-1;i>=0;i--){
                System.out.print(s.charAt(i));
            }
 //            StringBuffer sb  = new StringBuffer(s);
 //            sb.reverse();
 //            System.out.println(sb.toString());
        }
    }
}
