package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Date 2020/3/28 4:01 下午
 * @Description
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
 * 给定函数count(int n),用于计算n以内(含n)完全数的个数。计算范围, 0 < n <= 500000
 * 返回n以内完全数的个数。 异常情况返回-1
 *
 * 输入描述:
 * 输入一个数字
 * 输出描述:
 * 输出完全数的个数
 */
public class 完全数计算 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfd = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = bfd.readLine()) != null) {
            int n = Integer.parseInt(str);
            int count = 0;
            for (int i = 2; i <= n; i++) {
                if (isPerfect(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static boolean isPerfect(int num) {
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return sum == num;
    }
}
