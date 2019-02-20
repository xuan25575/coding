package ccu.swordoffer;

/**
 * 题目：写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷四则运算符号。
 * 位运算
 * step1:按位与是查看两个数哪些二进制位都为1，这些都是进位位，结果需左移一位，表示进位后的结果， 计算需要进位结果
 * step2: 异或是查看两个数哪些二进制位只有一个为1，这些是非进位位，可以直接加、减，结果表示非进位位进行加操作后的结果,  主要不计算进位的结果
 * step3: num2==0 判断还有没有进位 ，如果有，需要重复step1、step2； 没有返回结果。num1
 */
public class Test47 {

    public static int add(int num1,int num2){
        int sum = 0;
        int carry =0;
        while(num2 != 0){
            sum = num1 ^ num2;
            carry = (num1 & num2)<<1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 2) + ", " + (1 + 2));
        System.out.println(add(13, 34)+ ", " + (13 + 34));
        System.out.println(add(19, 95)+ ", " + (19 + 95));
    }
}
