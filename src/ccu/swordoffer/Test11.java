package ccu.swordoffer;

/**
 * 剑指offer面试题11：数值的整数次方
 * 题目：实现函数double power(double base,int exponent),求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 * 解题思路：实现数值的n次方就是将一个数自身连乘n次
 * 底数要考虑到正数、负数和零的情况
 * 指数要考虑到正整数，负整数和零的情况。因此可能的情况有九种，其中尤其要注意底数为0，指数为负数的情况下是无意义的，因此要做特殊处理
 * 指数为负数的乘方运算，可先按照指数为正求得，然后求倒数得到真正结果
 * 解法二：全面高效完美的算法，使用公式a^n=a^(n/2)*a^(n/2)    n是偶數
 *     a^(n/2)*a^(n/2)&a    n是奇数
 */
public class Test11 {

    public static double powerWithRecursion(double base,int exponent){
        if(exponent == 0)
             return 1;
        if(exponent == 1)
             return base;
        if(exponent == -1) // 处理-1
             return 1/base;
        double result = powerWithRecursion(base, exponent >> 1);  // 右移一位相等于除2
        result *= result;// 结果处理
        if((exponent & 1) == 1){  // 位运算：  0 & 1 == 0; 1 & 1 == 1  处理奇数
            result *= base;
        }
        return result;
    }


    public static void main(String[] args) {
//        System.out.println(powerWithRecursion(3,6));
          System.out.println(powerWithRecursion(2, -4));
//        System.out.println(powerWithRecursion(2, 4));
//        System.out.println(powerWithRecursion(2, 0));

//        System.out.println(-1>>1);
        System.out.println(0x1);
    }

}
