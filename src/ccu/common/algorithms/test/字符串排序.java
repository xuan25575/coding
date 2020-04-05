package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Date 2020/3/26 8:13 下午
 * @Description 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * 如，输入： Type 输出： epTy
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * 如，输入： BabA 输出： aABb
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 * 如，输入： By?e 输出： Be?y
 * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
 */
public class 字符串排序 {
    public static void main(String []args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=bf.readLine())!=null){
            StringBuffer builder = new StringBuffer();
            for(int i= 0;i < 26;i++){
                char c = (char)(i+'A');
                for(int j=0;j<str.length();j++){
                    char sc=str.charAt(j);
                    // a-32 = A  97-32=65，对应asc码中大写字母A，然后再强制转换成char类型。
                    if(c==sc || c == sc-32){
                        builder.append(sc);
                    }
                }
            }
            for(int i=0;i<str.length();i++){
                char c=str.charAt(i);
                if(!(c>='a'&&c<='z')&&!(c>='A'&&c<='Z')){
                    builder.insert(i,c);
                }
            }
            System.out.println(builder.toString());
        }
        bf.close();
    }
}
