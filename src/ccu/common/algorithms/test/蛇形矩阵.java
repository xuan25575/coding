package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author huang_2
 * @Description TODO
 * 题目说明
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * 样例输入
 * 5
 * 样例输出
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 */
public class 蛇形矩阵 {


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            int col = 1;

            for(int i = 1; i <= N; i++){
                System.out.print(col);
                int tmp = col;
                for(int j = i+1; j <= N; j++){
                    tmp += j;
                    System.out.print(" " + tmp);
                }
                System.out.println();
                col += i;
            }
        }
        in.close();
    }
}
