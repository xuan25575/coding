package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/26 7:30 下午
 * @Description
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，
 * 字符串中其它字符保持原来的顺序。
 * 注意每个输入文件有多组输入，即多个字符串用回车隔开
 * 输入描述:
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * 输出描述:
 * 删除字符串中出现次数最少的字符后的字符串。
 */
public class 删除字符串中出现次数最少的字符 {
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNextLine()){
            String str=scan.nextLine();
            if(str.length()>20){
                continue;
            }
            int[] max= new int[26];
            char[] ch= str.toCharArray();
            int min = Integer.MAX_VALUE;
            // 统计每个字符的个数，找不字符最少的那个。
            for(int i=0;i<ch.length;i++){
                max[ch[i]-'a'] ++;
                min = min > max[ch[i]-'a'] ? max[ch[i]-'a']:min;
            }
            // 替换字符串
            for(int i=0;i<max.length;i++){
                if(max[i]==min){
                    str=str.replaceAll(String.valueOf((char)(i+97)), "");
                }
            }
            System.out.println(str);
        }
    }
}
