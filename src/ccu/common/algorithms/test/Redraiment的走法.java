package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Date 2020/3/27 2:23 下午
 * @Description
 * 题目描述
 *    Redraiment是走梅花桩的高手。
 *    Redraiment总是起点不限，从前到后，往高的桩子走，但走的步数最多，
 *    不知道为什么？你能替Redraiment研究他最多走的步数吗？
 * 样例输入
 * 6
 * 2 5 1 5 4 5
 * 样例输出
 * 3
 * 提示
 * Example:
 * 6个点的高度各为 2 5 1 5 4 5
 * 如从第1格开始走,最多为3步, 2 4 5
 * 从第2格开始走,最多只有1步,5
 * 而从第3格开始走最多有3步,1 4 5
 * 从第5格开始走最多有2步,4 5
 * 所以这个结果是3。
 * 输入描述:
 * 输入多行，先输入数组的个数，再输入相应个数的整数
 *
 * 输出描述:
 * 输出结果
 */
public class Redraiment的走法 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            String[] data = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < data.length; i++) {
                arr[i] = Integer.parseInt(data[i]);
            }

            //dp 找到最长子序列
            // 动态转移方程。
           // dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
            int[] dp = new int[n];
            for (int i = 0; i < arr.length; i++) {
                dp[i] = 1; // 每个数至少一个，所以初始化长度为1
                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int max = 0;
            for (int a : dp) {
                if (a > max) {
                    max = a;
                }
            }
            System.out.println(max);
        }
    }
}
