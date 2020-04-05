package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/28 5:51 下午
 * @Description 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下,
 * 求它在第5次落地时，共经历多少米?第5次反弹多高？
 * 最后的误差判断是小数点3位
 * 输入描述:
 * 输入起始高度，int型
 *
 * 输出描述:
 * 分别输出第5次落地时，共经过多少米第5次反弹多高
 */
public class 求小球落地5次后所经历的路程和第5次反弹的高度 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            double n=sc.nextDouble();
            System.out.println(n*2.875);
            System.out.println(n/32);//不必纠结输出
        }
        sc.close();
    }
}
