package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/27 5:11 下午
 * @Description
 * 请编写一个函数（允许增加子函数），计算n x m的棋盘格子
 * （n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，
 * 总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 * 输入描述:
 * 输入两个正整数
 *
 * 输出描述:
 * 返回结果
 *
 * 示例1
 * 输入
 * 2
 * 2
 * 输出
 * 6
 */
public class JAVA题目2 {


    //基础的动态规划问题
    public static void main(String ... args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            // n个格子就有n + 1个点
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] dp = new int[n + 1][m + 1];
            // 初始子问题：只有一个点时有一条路，其他时候都为它上面的路和加左边的路和
            for(int i = 0; i <= n; i++){
                for(int j = 0; j <= m; j++){
                    if(i ==0 || j ==0){
                       dp[i][j] = 1;
                    }else{
                        dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}
