package ccu.swordoffer;

/**
 *   题目：输入一个整数 n 求从 1 到 n 这 n 个整数的十进制表示中 1 出现的次数。
 *   例如输入 12 ，从 1 到 12 这些整数中包含 1 的数字有 1、10、11 和 12，1 一共出现了 5 次。
 */
public class Test32 {

    /**
     * 解1
     * @param num
     * @return
     */
    public static int solution1(int num){
        if(num < 1){
            return 0;
        }
        int res =0;
        for (int i = 1; i <= num; i++) {
            res+=getNumOf1(i);
        }
        return res;
    }

    public static int getNumOf1(int num){
        int result = 0;
        while (num != 0){
            if(num%10==1){
                result++;
            }
            num = num/10;
        }
        return result;
    }



    public static int solution2(int num){
        if(num < 1){
            return 0;
        }
        int len =  getNumLen(num);
        if(len == 1){
            return 1;
        }
        int temp = powerBaseOf10(len-1);
        int first = num / temp; // 求出第一位
        int firstNumOf1 = first == 1 ? (num % temp )+1:temp;
        int secondNumOf1 = first *(len-1)*(temp/10);
        return  firstNumOf1+secondNumOf1+solution2(num % temp);
    }


    public static int getNumLen(int num){
        int len = 0;
        while(num!=0){
            len++;
            num = num/10;
        }
        return len;
    }
    public static int powerBaseOf10(int n){
        return (int)Math.pow(10,n);
    }

    public static void main(String[] args) {
        System.out.println(solution2(5));
        System.out.println(solution2(99));
        System.out.println(solution2(21345));
        System.out.println(solution1(5));
        System.out.println(solution1(99));
        System.out.println(solution1(21345));
        System.out.println(0X80000000);
    }
}
