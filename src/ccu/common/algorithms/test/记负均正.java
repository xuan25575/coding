package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Date 2020/3/27 3:49 下午
 * @Description
 * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
 *
 * 输入描述:
 * 首先输入一个正整数n，
 * 然后输入n个整数。
 *
 * 输出描述:
 * 输出负数的个数，和所有正整数的平均值。
 */
public class 记负均正 {
    public static void main(String[] args)throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while((line=bReader.readLine())!=null) {
            int N = Integer.parseInt(line);
            String[] strNums = bReader.readLine().split(" ");
            int cnt =0;  // 负数的个数
            int cnt2=0;  // 正数的 个数
            int sum = 0;
            for(int i=0;i<strNums.length;i++){
                int x = Integer.valueOf(strNums[i]);
                if(x<0) {
                    cnt++;
                }else if (x>0){
                    cnt2++;
                    sum += x;
                }
            }
            System.out.printf("%d %.1f\n",cnt,sum*1.0/cnt2);
        }
    }
}
