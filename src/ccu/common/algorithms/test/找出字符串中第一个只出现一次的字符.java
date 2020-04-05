package ccu.common.algorithms.test;

import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/29 1:53 下午
 * @Description
 * 输入描述:
 * 输入一个非空字符串
 * 输出描述:
 * 输出第一个只出现一次的字符，如果不存在输出-1
 */
public class 找出字符串中第一个只出现一次的字符 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            char[] cs = str.toCharArray();
            for(int i = 0; i < cs.length; i++){
                if(str.indexOf(cs[i]) == str.lastIndexOf(cs[i])){
                    System.out.println(cs[i]);
                    break;
                }else{
                    System.out.println("-1");
                }
            }
        }
        sc.close();
    }


//    public static void main(String[] args) throws IOException {
//        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//        String str = "";
//        while((str=br.readLine())!=null) {
//            String s = "";
//            char[] c = str.toCharArray();
//            int num[] = new int[128];
//            for(int i = 0;i<str.length();i++){
//                num[str.charAt(i)]++;
//            }
//            for(int i = 0;i<str.length();i++){
//                if(num[c[i]]==1){
//                    System.out.println(c[i]);
//                    break;
//                }
//                if(i==str.length()-1)
//                    System.out.println(-1);
//            }
//
//        }
//    }
}
