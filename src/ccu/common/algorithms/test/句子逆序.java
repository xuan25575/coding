package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/25 9:23 下午
 * @Description 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 */
public class 句子逆序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            s = reverse(s);
            System.out.println(s);
        }
    }

    public  static String reverse(String sentence) {
        String[] s = sentence.split("[\\s]+");
        StringBuffer buffer = new StringBuffer();
        for (int i = s.length - 1; i >=0 ; i--) {
            if (i == 0) buffer.append(s[i]);
            else buffer.append(s[i] + " ");
        }
        return buffer.toString();
    }

}
