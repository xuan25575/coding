package ccu.swordoffer;

/**
 * 题目：把 n 个骰子扔在地上，所有骰子朝上一面的点数之和为 s。输入 n，打印出 s 的所有可能的值出现的概率。
 *     基于递归求骰子点数，时间效率不够高。
 *    先把骰子分成两堆，第一堆只有一个，第二堆有n-1个，
 *    单独的那一个可能出现1到6的点数，我们需要计算从1-6的每一种点数和剩下的n-1个骰子来计算点数和。
 *    还是把n-1个那部分分成两堆，上一轮的单独骰子点数和这一轮的单独骰子点数相加，然后再和剩下的n-2个骰子来计算点数和。
 *    不难发现这是一种递归的思路。
 *    定义一个长度为6n-n+1的数组，和为s的点数出现的次数保存到数组的第s-n个元素里。
 */
public class Test43 {

    private static int  g_maxValue = 6;


    public static void printProbability(int n ){
        if(n <= 0){
            return;
        }
        int maxSum = g_maxValue * n;
        int[] probabilities = new int[maxSum -n +1]; // 数组长度

        for (int i = 1; i <= g_maxValue; i++) { // 第一次骰子计数
            probability(n,n,i,probabilities);
        }
        printProbability(n,maxSum,probabilities);
    }

    /**
     *
     * @param n  n个骰子
     * @param cur 剩余的骰子
     * @param sum   当前和
     * @param probabilities 有情况的出现的次数数组
     */
    public static void probability(int n,int cur,int sum, int[] probabilities){
        if(cur == 1){
            probabilities[sum -n]++; // 统计次数
        }else{
            for (int i = 1; i <= g_maxValue; i++) {
                probability(n,cur-1,sum+i,probabilities);
            }
        }


    }


    /**
     * 打印概率数组
     * @param n
     * @param maxSum
     * @param probabilities
     */
    private static void printProbability(int n, int maxSum, int[] probabilities) {
        double total = Math.pow(g_maxValue, n); //计算概率的分母
        for (int i = n; i <= maxSum; i++) {
            double ratio = probabilities[i-n]/total;
            System.out.print("P("+i + ")=");
            System.out.printf("%.4f", ratio);
            if (i != maxSum){
                System.out.print(", ");
            }
        }
    }

    public static void main(String[] args) {
        printProbability(3);

        System.out.println();
      //  printProbability2(80);
    }
}
