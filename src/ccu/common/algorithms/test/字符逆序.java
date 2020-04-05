package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Date 2020/3/27 1:52 下午
 * @Description
 * 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。
 * 如：输入“I am a student”，输出“tneduts a ma I”。
 *
 * 输入参数：
 * inputString：输入的字符串
 * 返回值：
 * 输出转换好的逆序字符串
 */
public class 字符逆序 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        StringBuffer sb=new StringBuffer(str);
        System.out.println(sb.reverse());
    }
}
