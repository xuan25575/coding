package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Date 2020/3/29 1:57 下午
 * @Description
 * 任意一个偶数（大于2）都可以由2个素数组成，
 * 组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对
 */
public class 查找组成一个偶数最接近的两个素数 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=bf.readLine())!=null){
            int count = Integer.valueOf(str);
            int left = count / 2;
            int right = count /2;
            while (left > 0 && right < count){
                if (isNum(left) && isNum(right)) {
                    System.out.println(left );
                    System.out.println(right);
                    break;
                }
                left--;
                right++;
            }
        }
    }

    public static boolean isNum(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
