package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/28 3:43 下午
 * @Description 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 * 输入描述:
 * 输入说明
 * 1 输入链表结点个数
 * 2 输入链表的值
 * 3 输入k的值
 *
 * 输出描述:
 * 输出一个整数
 *
 * 示例1
 * 输入
 * 8
 * 1 2 3 4 5 6 7 8
 * 4
 * 输出
 * 5
 */
public class 输出单向链表中倒数第k个结点 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line ;
        while((line = br.readLine())!= null){

            int n = Integer.parseInt(line);
            String[] strNodes = br.readLine().split(" ");

            int delIdx = Integer.parseInt(br.readLine());
            if(delIdx == 0){
                System.out.println(0);
            }
            int cnt  =0;
            for (int i = n-1; i >= 0; i--) {
                if(++cnt == delIdx){
                    System.out.println(strNodes[i]);
                }
            }
        }

    }
}
