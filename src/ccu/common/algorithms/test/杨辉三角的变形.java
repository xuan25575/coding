package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Description
 *
 *            1
 *          1  1  1
 *       1  2  3  2  1
 *    1  3  6  7  6  3  1
 * 1  4  10 16 19  16 10  4  1
 * 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，
 * 是恰好是它上面的数，左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
 *
 * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。
 * 输入n(n <= 1000000000)
 * 输入描述:
 * 输入一个int整数
 *
 * 输出描述:
 * 输出返回的int值
 */
public class 杨辉三角的变形 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(getResult(line));
        }
    }

    // 找规律
    public static int getResult(String str) {
        int i = Integer.valueOf(str);
        if (i <= 2) {
            return -1;
        } else if (i % 2 == 1) {
            return 2;
        } else {
            if (i % 4 == 0) {
                return 3;
            } else {
                return 4;
            }
        }
    }
}
