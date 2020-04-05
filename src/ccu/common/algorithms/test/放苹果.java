package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/29 2:01 下午
 * @Description
 * 把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，
 * 问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
 *
 *
 * 输入
 * 每个用例包含二个整数M和N。0<=m<=10，1<=n<=10。
 * 样例输入
 * 7 3
 * 样例输出
 * 8
 * 放苹果分为两种情况，一种是有盘子为空，一种是每个盘子上都有苹果。
 * 令(m,n)表示将m个苹果放入n个盘子中的摆放方法总数。
 * 1.假设有一个盘子为空，则(m,n)问题转化为将m个苹果放在n-1个盘子上，即求得(m,n-1)即可
 * 2.假设所有盘子都装有苹果，则每个盘子上至少有一个苹果，即最多剩下m-n个苹果，问题转化为将m-n个苹果放到n个盘子上
 * 即求(m-n，n)
 */
public class 放苹果 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int m=sc.nextInt();
            int n=sc.nextInt();
            System.out.println(F(m,n));
        }
    }

    /**
     *
     * @param x 个苹果
     * @param y 个盘子
     * @return
     */
    public static int F(int x,int y){
        if(x<0) // 当没有苹果，不能放了。
            return 0;
        if(x==1||y==1)// 当只有一个盘子 所有苹果放一个盘子， 当只有一个苹果，只能放一个盘子。
            return 1;
        return F(x,y-1)+F(x-y,y);
    }
}
