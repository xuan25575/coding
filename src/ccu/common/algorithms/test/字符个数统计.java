package ccu.common.algorithms.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author huang_2
 * @Date 2020/3/15 9:09 下午
 * @Description 编写一个函数，计算字符串中含有的不同字符的个数。
 * 字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。
 */
public class 字符个数统计 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        Set set = new HashSet();
        for (int i = 0; i < str.toCharArray().length; i++) {
            set.add(str.charAt(i));
        }
        System.out.println(set.size());

    }

    private static void getResult() {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        int count=0;
        int []tab=new int[128];
        for (int i = 0; i < str.length(); i++) {
            if(tab[str.charAt(i)]==0)
                tab[str.charAt(i)]++;
        }
        for (int i = 0; i < tab.length; i++) {
            if(tab[i]!=0)
                count++;
        }
        System.out.println(count);
    }


}
