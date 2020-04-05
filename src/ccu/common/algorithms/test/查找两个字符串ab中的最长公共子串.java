package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/29 2:13 下午
 * @Description
 * 查找两个字符串a, b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 输入描述:
 * 输入两个字符串
 * 输出描述:
 * 返回重复出现的字符
 * 示例1
 * 输入
 * abcdefghijklmnop
 * abcsafjklmnopqrstuvw
 * 输出
 * jklmnop
 */
public class 查找两个字符串ab中的最长公共子串 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            String max = s1.length() >= s2.length()?s1:s2;
            String min = s1.length() >= s2.length()?s2:s1;
            int l = 0;
            String s ="";
            for(int i=0;i<min.length();i++){
                for(int j=i+1;j<=min.length();j++){
                    if(max.contains(min.substring(i,j)) && j-i>l){
                        l=j-i;
                        s=min.substring(i,j);
                    }
                }
            }
            System.out.println(s);
        }

    }

}
