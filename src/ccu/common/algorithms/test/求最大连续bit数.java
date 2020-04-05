package ccu.common.algorithms.test;

import com.sun.media.jfxmediaimpl.HostUtils;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/28 11:41 上午
 * @Description
 * 功能: 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 * 输入: 一个byte型的数字
 * 输出: 无
 * 返回: 对应的二进制数字中1的最大连续数
 * 输入描述:
 * 输入一个byte数字
 * 输出描述：
 * 输出转成二进制之后连续1的个数
 * 输入
 * 3
 * 输出
 * 2

 */
public class 求最大连续bit数 {


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int input = sc.nextInt();
            String bi = Integer.toBinaryString(input);
            String subs = "1";
            int cnt = 1;
            for(int i=1; i<=bi.length(); i++) {
                if(bi.contains(subs)) {
                    cnt = subs.length();
                    subs += "1";
                }
            }
            System.out.println(cnt);
        }
    }

    // 方法
    // 第一步: 使用bitset将数字转化为8为二进制
    // 第二步: 将bitset转为字符串, 使用'0'对字符串分割, 找到最大的子串的size即可
    private static int getRes(int input){
        String bi = Integer.toBinaryString(input);
        String[] split = bi.split("0");
        int cnt = 0;
        for (String s : split) {
            cnt = Math.max(cnt, s.length());
        }
        return cnt;
    }
}
