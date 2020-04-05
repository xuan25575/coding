package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/28 3:19 下午
 * @Description
 * 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。
 * 但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"6，
 * 应该输出为"我ABC"而不是"我ABC+汉的半个"。
 *
 * 输入描述:
 * 输入待截取的字符串及长度
 *
 * 输出描述:
 * 截取后的字符串
 */
public class 按字节截取字符串 {

    //一个非汉字字符占1字节
    //一个汉字字符占2字节
    public static void getResult(int N,String str){
        char[] temp=str.toCharArray();
        int count=0;
        for(int j=0;j < str.length();j++){
            if(temp[j] > 128){
                count += 2;
            }else{
                count++;
            }
            if(count == N){
                System.out.println(str.substring(0,j+1));
                break;
            }
            if(count==N+1){
                System.out.println(str.substring(0,j));
                break;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.next();
            int N=sc.nextInt();
            getResult(N,str);
        }
        sc.close();
    }
}
