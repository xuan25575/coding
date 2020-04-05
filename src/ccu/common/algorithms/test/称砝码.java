package ccu.common.algorithms.test;

import java.util.*;

/**
 * @Author huang_2
 * @Date 2020/3/28 6:00 下午
 * @Description
 * 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
 * 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 * 注：
 * 称重重量包括0
 *
 * 输入描述:
 * 输入包含多组测试数据。
 *
 * 对于每组测试数据：
 * 第一行：n --- 砝码数(范围[1,10])
 * 第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
 * 第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
 * 输出描述:
 * 利用给定的砝码可以称出的不同的重量数
 */
public class 称砝码 {


    /*思路：
     输入砝码种类n;
     输入砝码质量w[i];
     输入砝码个数c[i]；
     输出  可以拼凑的质量个数
     w1  w2  w3  w4  ......  wn
     c1  c2  c3  c4  ......  cn
     对于前i个砝码：
    （不同质量为Q[i])则 Q[i]=Q[i-1]+k*w[i]; -->0<=k<=c[i];
        Q[i]在Q[i-1]的基础上，对Q[i-1]个不同的重量，分别添加k个砝码i;
        在添加的过程中去除重复情况
        c[i]表示N个不同砝码相应的数量  c[1~~n];
     则（结果）:Q[i]=(Q[i-1]+k*w[i])--(减去)添加过程中重复的个数
    */
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        while(cin.hasNext()){
            int n=cin.nextInt();//砝码种类
            int[]  weights = new int[n];
            int[]  numbers = new int[n];
            for(int i=0;i<n;i++)
                weights[i]=cin.nextInt();
            for(int i=0;i<n;i++)
                numbers[i]=cin.nextInt();
            int result=function(n,weights,numbers);
            System.out.println(result);
        }
        cin.close();
    }
    public static int function(int n,int[] weights,int[] numbers){
        Set<Integer> set=new HashSet<>();
        for(int i=0;i <= numbers[0];i++)
            set.add( i * weights[0]); //第一个可以称出多少个重量
        for(int i=1;i<n;i++){//从第二个砝码开始
            List<Integer> list =new ArrayList<>(set);
            for(int j=1;j <= numbers[i];j++){//遍历砝码的个数
                for(int k=0;k<list.size();k++)
                    set.add(list.get(k)+j*weights[i]);
            }
        }
        return set.size();
    }
}
