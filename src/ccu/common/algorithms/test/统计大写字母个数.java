package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Date 2020/3/28 2:03 下午
 * @Description
 * 找出给定字符串中大写字符(即 ' A ' - ' Z ')的个数
 *
 * 输入描述:
 * 输入一个String数据
 *
 * 输出描述:
 * 输出string中大写字母的个数
 *
 * 示例1
 * 输入
 * add123#$%#%#O
 * 输出
 * 1
 */
public class 统计大写字母个数 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null) {
            int cnt = 0;
            for(int i=0;i<line.length();++i)
                if(line.charAt(i)>='A' && line.charAt(i)<='Z'){
                    cnt++;
                }
            System.out.println(cnt);
        }
    }
}
