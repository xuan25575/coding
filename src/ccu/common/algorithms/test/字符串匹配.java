package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Date 2020/3/28 2:22 下午
 * @Description 判断短字符串中的所有字符是否在长字符串中全部出现
 * 输入描述:
 * 输入两个字符串。第一个为短字符，第二个为长字符。
 *
 * 输出描述:
 * 返回值：
 *
 * 示例1
 * 输入
 * bc
 * abc
 * 输出
 * true
 */
public class 字符串匹配 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            String str2 = br.readLine();
            int i;
            for (i = 0; i < str.length(); i++) {
                if (str2.indexOf(str.charAt(i)) == -1) {
                    System.out.println("false");
                    break;
                }
            }
            if (i == str.length()) {
                System.out.println(true);
            }
        }
        br.close();
    }
}
