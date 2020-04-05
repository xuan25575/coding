package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author huang_2
 * @Date 2020/3/29 1:19 下午
 * @Description
 * 输入描述:
 * 输入说明
 * 1 输入两个整数
 * 2 输入一个整数数组
 * 输出描述:
 * 输出一个整数数组
 *
 * 示例1
 * 输入
 * 5 2
 * 1 3 5 7 2
 * 输出
 * 1 2
 */
public class 输入n个整数输出其中最小的k个 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line ;
        while((line = br.readLine())!= null){
            String[] split = line.split(" ");
            int n = Integer.parseInt(split[0]);
            int k = Integer.parseInt(split[1]);
            int[] arr = new int[n];
            String[] strArr = br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }
            Arrays.sort(arr);
            for (int j = 0; j < k-1; j++) {
                System.out.print(arr[j]+" ");
            }
            System.out.println(arr[k-1]);
        }

    }
}
