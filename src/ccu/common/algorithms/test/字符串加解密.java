package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Date 2020/3/21 9:29 下午
 * @Description
 * 1、对输入的字符串进行加解密，并输出。
 *
 * 2加密方法为：
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 * 其他字符不做变化。
 * 3、解密方法为加密的逆过程。
 * 接口描述：
 *
 *     实现接口，每个接口实现1个基本操作：
 *
 * void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出
 *
 * 说明：
 *
 * 1、字符串以\0结尾。
 *
 * 2、字符串最长100个字符。
 * int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出
 * 说明：
 * 1、字符串以\0结尾。
 *     2、字符串最长100个字符。
 */
public class 字符串加解密 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str=br.readLine())!=null){
            String str1 = encrypt(str);
            System.out.println(str1);
            str = br.readLine();
            String str2 = unEnCrypt(str);
            System.out.println(str2);
        }

    }

    public static String encrypt(String line){
        if(line==null || line.length()<1){
            return line;
        }
        StringBuffer sb = new StringBuffer();
        char c;
        for(int i=0;i<line.length();i++){
            c=line.charAt(i);
            if(c>='A' && c<='Z'){
                if(c!='Z'){// 大小写相差32
                    c=(char)(c+33);
                    sb.append(c);
                }else{
                    c='a';
                    sb.append(c);
                }
            }else if(c>='a' && c<='z'){
                if(c !='z'){
                    c=(char)(c-31);
                    sb.append(c);
                }else{
                    c='A';
                    sb.append(c);
                }
            }else if(c>='0' && c<='9'){
                if(c!='9'){
                    c=(char)(c+1);
                    sb.append(c);
                }else{
                    c='0';
                    sb.append(c);
                }
            }else{
                sb.append(c);
            }

        }
        return sb.toString();
    }

    public static String unEnCrypt(String line){
        if(line==null || line.length()<1){
            return line;
        }
        StringBuffer sb = new StringBuffer();
        char c;
        for(int i=0;i<line.length();i++){
            c=line.charAt(i);
            if(c>='A' && c<='Z'){
                if(c!='A'){
                    c=(char)(c+31);
                    sb.append(c);
                }else{
                    c='z';
                    sb.append(c);
                }
            }else if(c>='a' && c<='z'){
                if(c!='a'){
                    c=(char)(c-33);
                    sb.append(c);
                }else{
                    c='Z';
                    sb.append(c);
                }
            }else if(c>='0' && c<='9'){
                if(c!='0'){
                    c=(char)(c-1);
                    sb.append(c);
                }else{
                    c='9';
                    sb.append(c);
                }
            }else{
                sb.append(c);
            }

        }
        return sb.toString();
    }
}
