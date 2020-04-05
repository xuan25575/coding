package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/27 4:09 下午
 * @Description 将一个字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 * 输入描述:
 * 输入一个字符串
 * 输出描述:
 * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 */
public class 表示数字 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "" ;
        while ((line = br.readLine() )!= null){
            char[] arr = line.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i] - '0' >= 0) && (arr[i] - '0' <= 9)) { // 判断为数字
                    sb.append("*" + arr[i] + "*");  //两边都加上*
                } else
                    sb.append(arr[i]);
            }
            String s =  sb.toString().replace("**", "");  //两个数字中间有** 替换掉
            System.out.println(s);
        }

    }
}
