package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Date 2020/3/27 4:49 下午
 * @Description
 *
 * 输入描述:
 * 输入候选人的人数，第二行输入候选人的名字，第三行输入投票人的人数，第四行输入投票。
 *
 * 输出描述:
 * 每行输出候选人的名字和得票数量。
 *
 * 示例1
 * 输入
 * 4
 * A B C D
 * 8
 * A B C D E F G H
 * 输出
 * A : 1
 * B : 1
 * C : 1
 * D : 1
 * Invalid : 4
 */
public class 记票统计 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str="";
        while((str=bf.readLine())!=null) {
            int n=Integer.parseInt(str);
            String name[] =bf.readLine().split(" ");
            int num=Integer.parseInt(bf.readLine());
            String s[] =bf.readLine().split(" ");
            int count[]=new int[n];
            for(int i=0;i<n;i++) {
                for(int j=0;j<num;j++) {
                    if(s[j].equals(name[i])) {
                        count[i]++;
                    }
                }
            }
            int Invalid=num;
            for(int k=0;k<n;k++) {
                Invalid -= count[k];
                System.out.println(name[k]+" : "+count[k]);
            }
            System.out.println("Invalid : "+Invalid);
        }
    }
}
