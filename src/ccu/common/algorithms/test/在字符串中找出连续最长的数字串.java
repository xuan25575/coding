package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/27 5:04 下午
 * @Description
 * 样例输出
 * 输出123058789，函数返回值9
 * 输出54761，函数返回值5
 *
 *
 * 输入描述:
 * 输入一个字符串。
 *
 * 输出描述:
 * 输出字符串中最长的数字字符串和它的长度。如果有相同长度的串，则要一块儿输出，但是长度还是一串的长度
 *
 * 示例1
 * 输入
 * abcd12345ed125ss123058789
 * 输出
 * 123058789,9
 */
public class 在字符串中找出连续最长的数字串 {

    public static void main(String[] args) {

        //将不是数字的字符全部变成‘a’，再将字符串用a来分割称数组，长度最大的数组的长度即为所求的长度，
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()) {
            String str1="";
            String str=scan.nextLine();
            for(char ch:str.toCharArray()){
                //将不是数字的字符全部变成a
                if(ch>='0' && ch<='9'){
                    str1+=ch;
                }else{
                    str1+="a";
                }
            }
            //按a分割
            String[] strs = str1.split("a");
            int max=0;//记录最长的连续数字串的长度
            for(int i=0;i < strs.length;i++){
                max=strs[i].length()>max?strs[i].length():max;
            }
            for(int i=0;i<strs.length;i++){
                if(strs[i].length()==max)
                    System.out.print(strs[i]);
            }
            System.out.println(","+max);
        }
    }
}
