package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/27 3:38 下午
 * @Description 自守数是指一个数的平方的尾数等于该数自身的自然数。
 * 例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数
 * 输入描述:
 * int型整数
 *
 * 输出描述:
 * n以内自守数的数量。
 */
public class 自守数 {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            int cnt = 0;
            for(int i=0;i<=N;i++){
                 String iStr = String.valueOf(i*i);
                 String s= iStr.substring(iStr.length()-String.valueOf(i).length());
                if(s.equals(String.valueOf(i))){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
        in.close();

    }

    // 特性求解
    public static int sum(int n){
        int m = 0;
        for(int i = 0;i<=n;i++){
            int d = i;
            int k = 0;
            while(d != 0){
                k++;
                d /= 10;
            }
            if((i*i-i)%Math.pow(10,k) == 0){
                m++;
            }
        }
        return m;
    }
}
