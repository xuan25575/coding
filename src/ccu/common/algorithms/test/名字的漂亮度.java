package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author huang_2
 * @Date 2020/3/28 2:29 下午
 * @Description
 * 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 * 输入描述:
 * 整数N，后续N个名字
 * 输出描述:
 * 每个名称可能的最大漂亮程度
 * 输入
 * 2
 * zhangsan
 * lisi
 * 输出
 * 192
 * 101
 */
public class 名字的漂亮度 {

   // 找到每个字符个数排序  最多*26 依次递减
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            for (int i = 0; i < n; i++) {
                int[] repeat = new int[26];
                String s = br.readLine().toLowerCase();
                for (int j = 0; j < s.length(); j++) {
                    repeat[s.charAt(j) - 'a']++;
                }
                // 字母排序 升序
                Arrays.sort(repeat);
                int k = 26;
                int value = 0;
                // 倒排
                for (int j = repeat.length - 1; j >= 0; j--) {
                    if (repeat[j] == 0) {
                        break;
                    }
                    value += repeat[j] * k;
                    k--;
                }
                System.out.println(value);
            }

        }
    }
}
