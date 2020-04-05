package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Date 2020/3/27 1:55 下午
 * @Description
 * 题目描述
 * 从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值
 * 输入描述:
 * 输入任意个整数
 *
 * 输出描述:
 * 输出负数个数以及所有非负数的平均值
 */
public class 记负均正II {
    public static void main(String[] args)throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while((line=bReader.readLine())!=null) {
            String[] strNums = line.split(" ");
            int cnt =0;  // 负数的个数
            int cnt2=0;  // 正数的 个数
            int sum = 0;
            for(int i=0;i<strNums.length;i++){
                int x = Integer.valueOf(strNums[i]);
                if(x<0) cnt++;
                else {
                    cnt2++;
                    sum += x;
                }
            }
            System.out.println(cnt);
            System.out.format("%.1f", (float)sum/cnt2);
            System.out.println();
        }


    }
}
