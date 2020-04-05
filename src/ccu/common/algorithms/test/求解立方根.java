package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/26 11:36 下午
 * @Description •计算一个数字的立方根，不使用库函数
 * public static double getCubeRoot(double input)
 * 输入:double 待求解参数
 * 返回值:double  输入参数的立方根，保留一位小数
 */
public class 求解立方根 {


    // 使用二分查找算法
    public static double getCubeRoot(double input) {
        double min = 0;
        double max = input;
        double mid = 0;

        // 注意，这里的精度要提高一点，否则某些测试用例无法通过
        while ((max - min) > 0.001) {
            mid = (max + min) / 2;
            if (mid * mid * mid > input)
                max = mid;
            else if (mid * mid * mid < input)
                min = mid;
            else
                return mid;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double input = sc.nextDouble();
            double result = getCubeRoot(input);
            System.out.printf("%.1f\n", result);
        }
        sc.close();
    }
}
