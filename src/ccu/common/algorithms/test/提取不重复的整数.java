package ccu.common.algorithms.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author huang_2
 * @Date 2020/3/25 9:03 下午
 * @Description 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 */
public class 提取不重复的整数 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringBuffer sb = new StringBuffer(str);
        Set s = new HashSet();
        sb.reverse();//字符串反转
        for(int i = 0;i<sb.length();i++){
            if(s.add(sb.substring(i,i+1))){//set不允许重复添加相同的元素
                System.out.print(sb.substring(i,i+1));
            }
        }
    }

}
