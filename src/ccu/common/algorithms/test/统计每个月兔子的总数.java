package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Date 2020/3/28 5:25 下午
 * @Description
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，
 * 小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * 输入描述:
 * 输入int型表示month
 *
 * 输出描述:
 * 输出兔子总数int型
 */
public class 统计每个月兔子的总数 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!= null){
            int monthCount = Integer.parseInt(line);
            System.out.println(getTotalCount(monthCount));
        }
    }

    //关键是找到递推式 f(n)=f(n-1)+f(n-2) (n>=4)
    //一部分是上个月的兔子f(n-1)，另一部是满足3个月大的兔子
    // 通用斐波那契数列的解
    //会生一只兔子f(n-2)
    // 1 2  3  4 5 6
    // 1 1  2  3 5 8
    // 前面两个相加
    public static int getTotalCount(int monthCount) {
        int a = 1;
        int b = 1;
        int c = 0;
        for(int i=2;i<monthCount;++i) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
}
