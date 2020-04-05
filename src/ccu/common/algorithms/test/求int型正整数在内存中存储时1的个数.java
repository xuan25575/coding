package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/25 9:40 下午
 * @Description 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *  这个数转换成2进制后，输出1的个数
 */
public class 求int型正整数在内存中存储时1的个数 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        while(n > 0){
            if((n&1)>0){
                count++;
            }
            n = n>>1; // 等价于除以2
        }
        System.out.println(count);
    }
}
