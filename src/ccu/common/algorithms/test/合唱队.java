package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/26 7:38 下午
 * @Description
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 *
 * 说明：
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，
 * 则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 *
 * 请注意处理多组输入输出！
 * 输入描述:
 * 整数N
 * 输出描述:
 * 最少需要几位同学出列
 *
 * 首先计算每个数在最大递增子串中的位置
 *
 * 186  186  150  200  160  130  197  200   quene
 *
 * 1      1      1      2       2      1      3     4       递增计数
 *
 *
 * 然后计算每个数在反向最大递减子串中的位置--->计算反向后每个数在最大递增子串中的位置
 *
 * 200  197  130  160  200  150  186  186      反向quene
 *
 * 1      1      1       2     3      2      3       3      递减计数
 *
 *
 * 然后将每个数的递增计数和递减计数相加
 *
 * 186  186  150  200  160  130  197  200   quene
 *
 * 1      1      1      2       2     1      3      4       递增计数
 *
 * 3      3      2      3       2     1      1      1       递减计数
 *
 * 4      4      3      5       4     2      4      5       每个数在所在队列的人数+1（自己在递增和递减中被重复计算）
 *
 *
 * 如160这个数
 *
 * 在递增队列中有2个人数
 *
 * 150  160
 *
 * 在递减队列中有2个人数
 *
 * 160  130
 *
 * 那么160所在队列中就有3个人
 *
 * 150  160  130
 *
 * 每个数的所在队列人数表达就是这个意思
 *
 *
 * 总人数 - 该数所在队列人数 = 需要出队的人数
 */
public class 合唱队 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = br.readLine()) != null) {
            int total = Integer.parseInt(str);
            int[] data = new int[total];
            int[] reverseData = new int[total];
            // 处理身高数据
            str = br.readLine();
            String[] arr = str.split(" ");

            for (int i = 0; i < total; ++i) {
                data[i] = Integer.parseInt(arr[i]);
                reverseData[total - 1 - i] = data[i];
            }

            int[] asc = calculate(data);
            int[] desc = calculate(reverseData);
            int ret = 0;
            for (int i = 1; i <= total; i++) {
                ret = Math.max(asc[i] + desc[total - i + 1] - 1, ret); //有一个数被重复计算 需要减一。
            }

            System.out.println(total - ret);
        }
    }

    private static int[] calculate(int[] data) {
        // max[i]存储最长子序列长度为i的时候,最小的序列结尾.
        int total = data.length;
        int[] max = new int[total];
        int[] dp = new int[total + 1]; // 下标从1开始 存储是每个数是递增排序中的位置。（第几个）
        int index = 0;
        max[index] = -1;
        for (int i = 0; i < total; i++) {
            if (data[i] > max[index]) { // 大于的话 说明是递增的 序列长度加1。
                max[++index] = data[i];
                dp[i + 1] = dp[i] + 1;
            } else {
                for (int j = 0; j <= index; j++) {
                    // 因为i的循环顺序是从小到大的,所以保证了当max[j]的数都是在i之前按序列顺序先后出现的.
                    if (data[i] <= max[j]) {
                        max[j] = data[i];
                        break;
                    }
                }
                dp[i + 1] = dp[i];
            }
        }

        return dp;
    }
}
