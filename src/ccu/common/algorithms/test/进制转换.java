package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/25 8:30 下午
 * @Description 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 * 16进制  int  a  =  0x100F;
 */
public class 进制转换 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str= sc.next().substring(2);
            System.out.println(Integer.parseInt(str,16));
        }
    }
}
