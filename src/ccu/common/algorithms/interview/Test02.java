package ccu.common.algorithms.interview;

/**
 * 输出100以内所有的素数
 * 质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数
 *
 */
public class Test02 {

    public static void main(String[] args) {
        printPrimeNumber3();
        System.out.println();
        printPrimeNumber1();
        System.out.println();
        printPrimeNumber2();
        System.out.println(2%2);
    }

    /**
     *    所谓的筛选法：是指从小到大筛去已知的一个素数的所有倍数，
     *    根据2我们可以筛去“4,6,8,...,100”等数，然后根据3可以筛去“9,15,...,99”等数，
     *    注意此时的6,12早就被作为2的倍数给筛去了，由于4已经被筛去了，所以下一个筛选数是5
     *
     *   编程原理：定义一个大小为101的数组,把被筛去的数赋值为1,留下未被筛去的并且数组下标大于等于2的数输出，
     *     输出的就是质数*
     */
    public static  void  printPrimeNumber1(){
        int[] a = new int[101];
         for (int j = 2;j < 101;j++) {
            if (a[j] == 0) {
                for (int i = j + 1; i < 101; i++) {
                    if (i % j == 0) {
                        a[i] = 1;
                    }
                }
            }
        }
        for (int k = 0; k < 101; k++) {
            if (k >= 2 && a[k] == 0) {
                System.out.print(k+"  ");
            }
        }
    }

    /**
     *  普通方法 用一个Boolean值控制输出
     *  boolean 变量是用来控制是不是质数的。
     *  注意 ：int j=2 开始。 j=2  取1 所有数都是输出不了。
     *  Math.sqrt(i) 取得平方根方法  内层for循环作为 除数  优化循环次数*   除了2所有的偶数都不是质数，那么能不能只遍历奇数。
     *  取余方向  i % j
     */
    public static  void  printPrimeNumber2(){
        for (int i = 2;i<100;i++){
            boolean flag =  true;
            for(int j = 2;j<= (int)Math.sqrt(i);j++){
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.print(i+"  ");
            }
        }
    }

    /**
     *  普通方法 用一个count值控制输出
     *  注意：j = 1 开始
     *  count 是用来统计取余等于0的数量，由于只有取余等于0的数量为1 说明是质数。
     */
    public static  void  printPrimeNumber3(){
        int count  = 0; // 定义for里面相当于每次创建了一个变量。
        for (int i = 2;i<100;i++){
            for(int j = 1;j<= (int)Math.sqrt(i);j++){
                if(i % j == 0){
                    count++;
                }
            }
            if(count == 1){
                System.out.print(i+"  ");
            }
            count = 0;
        }
    }


}
