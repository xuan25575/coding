package ccu.swordoffer;

/**
 * 位运算  2进制1 的个数
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 * 例如把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 */
public class Test10 {

    /**
     * 【惊喜做法】
     *  一个数减去1：（如果一个数不是0，那么它的二进制中至少有1位是1）
     *   - 假设这个数的最后一位是1，那么减去1之后，只是最后一位由1变成了0，其他位不变。
     *   - 最后一位不是1，假设这个数第m位是1，减去1之后，
     *      第m位由1变成了0，m后面的0全部变成了1，m前面的数字不变
     *      这时 n & (n-1)，就可以把m后面的那些1右变回了0，
     *      然后再继续 判断、减1 最后为0结束
     *      思路：将所有1 变成0 。 计算多少次就有多少1 呗。
     * @param n 整数
     * @return
     */
    public static int numberOf1(int n){
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }

    /**
     * 常规解法
     * 为了避免死循环，我们可以不右移输入的数字i：
     *　（1）首先把i和1做与运算，判断i的最低位是不是为1。
     *　（2）接着把1左移一位得到2，再和i做与运算，就能判断i的次低位是不是1。
     *　（3）这样反复左移，每次都能判断i的其中一位是不是1。
     *  需要移动32位
     * @return
     */
    public static int numberOf12(int n){
        int  flag = 1;  // 这个int flag 还是有误 0x80000000 ，0xFFFFFFFF 结果有误
        int count= 0;
        while(flag >= 1){
            if((n & flag) > 0){  // 注意：这里是大于0.
                count ++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 10;

        System.out.println(numberOf1(num));
        System.out.println(numberOf12(num));
       System.out.println(numberOf1(0x80000000));
//        System.out.println(numberOf12(0x80000000));  有误
        System.out.println(numberOf1(0xFFFFFFFF));
//        System.out.println(numberOf12(0xFFFFFFFF));  有误

       // System.out.println(numberOf12(0x7FFFFFFF));

//        System.out.println(0x80000000);
//        System.out.println(0xFFFFFFFF);
//        System.out.println(3&2);


        System.out.println(0B01111111_11111111_11111111_11111111 == Integer.MAX_VALUE);
        System.out.println(0B10000000_00000000_00000000_00000000 == Integer.MIN_VALUE);
    }
}
