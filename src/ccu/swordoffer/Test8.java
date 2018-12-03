package ccu.swordoffer;

/**
 * 一只青蛙一次只能跳一阶或两阶台阶，总共要跳n阶，求总共有多少总跳法
 *  跳的 考虑除去特殊情况    1阶---1  2阶---2
 * 其实是 斐波那契数列 变形
 * 输入一个n 求斐波那契数列的第n项 的值
 * 数列的特点 ： f(n) = f(n-1)+ f(n-2)
 */
public class Test8 {


    /**
     *  斐波那契数列递归求解
     * @param n
     * @return
     */
    public static int fibonacciRecursion(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1 ;
        }
        return fibonacciRecursion(n-1) + fibonacciRecursion(n-2);
    }

    /**
     *  青蛙跳的解
     * @param n
     * @return
     */
    public static long fibonacciUnRecur(int n){
        long[] result = {0,1,2};
        if(n <= 2){
            return result[n];
        }
//        通用斐波那契数列的解
//        long f1 = 0; // 第一个数
//        long f2 = 1; // 第二个数
//        long fn = 0;  // 斐波那契数列第n个数的值
//        for (int i = 2; i <= n; i++) { // 等于  属于边界问题   0,1,1,2,3,5   或者 1,1,2,3,5 不能算0
//            fn = f1 + f2;
//            f1 = f2; // 更新f1的值
//            f2 = fn; // 更新f2的值。
//        }

        long f1 = 1; // 青蛙跳第一个数
        long f2 = 2; // 青蛙跳第二个数
        long fn = 0;  // 求当前斐波那契数列第n个数的值
        for (int i = 3; i <= n; i++) { //   1,2,3,5
            fn = f1 + f2;
            f1 = f2; // 更新f1的值
            f2 = fn; // 更新f2的值。
        }
        return fn;
    }


    public static void main(String[] args) {
//        int i = fibonacciRecursion(5);
        long i1 = fibonacciUnRecur(4);
        System.out.println(i1);
    }

}
