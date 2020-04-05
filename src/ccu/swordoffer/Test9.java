package ccu.swordoffer;

/**
 * 一只青蛙一次只能跳一阶或两阶台阶，总共要跳n阶，求总共有多少总跳法  ---- 》 扩展：一只青蛙一次只能跳一阶或两阶台阶 或n阶
 *  跳的 考虑除去特殊情况    1阶---1  2阶---2
 * 其实是 斐波那契数列 变形
 * 输入一个n 求斐波那契数列的第n项 的值
 * 数列的特点 ： f(n) = f(n-1)+ f(n-2)
 *
 *
 *  类似题目：
 *  我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 *  请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *  竖着放的时候，右边还剩下2x7的区域，将其记为f(7)
 *  横着放的时候，2x1的小矩形放在最左上角，左下角必须横着放一个2x1的小矩形，右边还剩下2x6的区域，记为f(6)
 *  所以本质上仍然是一个斐波那切数列
 */
public class Test9 {


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
        int i = fibonacciRecursion(2);
//        long i1 = fibonacciUnRecur(4);
        System.out.println(i);
    }

}
