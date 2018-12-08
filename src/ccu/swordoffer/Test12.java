package ccu.swordoffer;

/**
 *
 * 题目：
 *  输入数字n，按顺序打印出从1到最大的n位十进制数。
 *  比如输入3，则打印出1、2、3一直到最大的3位数即999。
 */
public class Test12 {

    // 大数问题不好解决  数太大会溢出
    public static void printNumber1(int n){
        int number = 1;
        int index = 0;
        while(index++ < n){
            number *= 10;
        }
        for (int i = 0; i < number; i++) {
            System.out.print(i+" ");
        }
    }

 //解法二：


    public static void printMaxOfNDigits(int n){
        if(n < 0){
            throw new RuntimeException(" error number ");
        }
        char[] number = new char[n];
        for (int i = 0; i < 10; i++) {
            number[0] = (char)(i+'0');
            printMaxOfNDigitsRecursively(number,n,0);
        }
    }

    /**
     *
     * @param number  数字的字符数组
     * @param length  长度
     * @param index   开始的位置
     */
    public static void printMaxOfNDigitsRecursively(char[] number,int length,int index){
        if(index == length -1){
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index+1] = (char)(i+'0');
            printMaxOfNDigitsRecursively(number,length,index+1);
        }
    }

    /**
     *  打印一个数
     * @param number  数
     */
    public static void printNumber(char[] number){
        boolean isBeginning0 = true;
        for (int i = 0; i < number.length; i++) {
            if(isBeginning0 && number[i] != '0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(number[i]);
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
      //  printNumber(3);
        System.out.println( (char)1);

        printMaxOfNDigits(2);


    }
}
