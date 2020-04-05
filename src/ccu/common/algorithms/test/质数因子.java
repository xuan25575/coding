package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/25 8:36 下午
 * @Description 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（
 * 如180的质因子为2 2 3 3 5 ）
 *最后一个数后面也要有空格
 *  1既不是质数也不是合数 。
 */
public class 质数因子 {

    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        long num = str.nextLong();
        String result = getResult(num);
        System.out.println(result);
    }
    public static String getResult(long num){
        int pum = 2;
        String result = "";
        while(num != 1){ // 最终 num 为1
            while(num%pum == 0){ // 取余
                num = num/pum;
                result = result + pum + " ";
            }
            pum++;
        }
        return result;
    }
}
