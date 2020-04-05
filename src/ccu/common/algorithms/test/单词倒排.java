package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Date 2020/3/26 10:34 下午
 * @Description 对字符串中的所有单词进行倒排。
 * 说明：
 *
 * 1、每个单词是以26个大写或小写英文字母构成；
 * 2、非构成单词的字符均视为单词间隔符；
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 * 4、每个单词最长20个字母；
 */
public class 单词倒排 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line=br.readLine())!=null){
            StringBuffer sb=new StringBuffer();
            for (int i=0;i<line.length();i++){
                char c=line.charAt(i);
                if ((c>='A'&&c<='Z')||(c>='a'&&c<='z')){
                    sb.append(c);
                }else {
                    sb.append(' ');
                }
            }
            String[] str=sb.toString().trim().split(" ");
            StringBuffer sb2=new StringBuffer();
            for (int j=str.length-1;j>=0;j--){
                if (j==0){
                    sb2.append(str[j]);
                }else{
                    sb2.append(str[j]+ " ");
                }
            }
            System.out.println(sb2.toString());
        }
    }
}
