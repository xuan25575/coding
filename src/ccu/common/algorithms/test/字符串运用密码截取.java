package ccu.common.algorithms.test;


import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/26 10:43 下午
 * @Description
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，
 * 比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。
 * 比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。
 * 因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），
 * Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 **
 * 输入描述:
 * 输入一个字符串
 *
 * 输出描述:
 * 返回有效密码串的最大长度
 */
public class 字符串运用密码截取 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
//            System.out.println(manacher(s));
            System.out.println(process(s));
        }

    }


    /**
     * 以每个字符（奇数长度的回文串）或者字符间空隙（偶数长度的回文串）分别向左向右扩充，记录遇到的最大长度
     * @param str
     * @return
     */

    public static int process(String str){
        int len=str.length();
        if(len<1){
            return 0;
        }
        int max=1;//只要字符创长度大于1，则最短的回文串长度为1
        //考虑奇数个数的回文串
        for(int i=1;i<len-1;i++){
            int k=i-1,j=i+1;
            int count=0;
            while(k>=0 && j<=len-1){
                if(str.charAt(k--)==str.charAt(j++)){
                    count++;
                }else{
                    break;
                }
            }
            max= (max>=(count*2+1)) ? max:(count*2+1);
        }
        //现在考虑偶数回文串的情况，主要考虑字符之间的位置
        for(int i=1;i<len-1;i++){
            int k=i-1,j=i;
            int count=0;
            while(k>=0 && j<=len-1){
                if(str.charAt(k--)==str.charAt(j++)){
                    count++;
                }else{
                    break;
                }
            }
            max= (max>=count*2) ? max : (count*2);
        }
        return max;
    }


    //马拉车算法。 不懂
    public static int manacher(String s) {
        int count =0;//记录最大回文
        StringBuffer sb = new StringBuffer();
        char[] c =s.toCharArray();
        sb.append("#");
        //对字符串进行封装
        for (int i = 0; i < c.length; i++) {
            sb.append(c[i]);
            sb.append("#");
        }
        int[] rad = new int[sb.length()];//记录新字符串以每个字符为中心的最大回文半径
        char[] cl = sb.toString().toCharArray();
        int max=0;//记录已经搜寻到的回文半径能到达右端的最达大值
        int id=0;//记录回文半径能到达最右端的回文字符串的中心
        for (int i = 1; i < cl.length; i++) {
            if (max>i) {
                rad[i]=Math.min(rad[2*id-i], max-i);
            }else {
                rad[i]=1;
            }
            while (i-rad[i]>=0 && i+rad[i]<cl.length && cl[(i-rad[i])]==cl[(i+rad[i])]) {
                rad[i]++;
            }
            if (i+rad[i]>max) {
                max=i+rad[i];
                id=i;
            }
            count=Math.max(count, rad[i]-1);
        }

        return count;
    }



}
