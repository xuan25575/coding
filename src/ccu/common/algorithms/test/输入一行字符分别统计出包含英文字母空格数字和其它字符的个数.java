package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Date 2020/3/28 5:57 下午
 * @Description TODO
 */
public class 输入一行字符分别统计出包含英文字母空格数字和其它字符的个数 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null) {

        }
            int EnglishCharCount=0;
            int BlankCharCount=0;
            int NumberCharCount=0;
            int OtherCharCount=0;

            char[] chs = line.toCharArray();
            for(int i=0;i<chs.length;++i){

                if((chs[i]>='a'&&chs[i]<='z')||(chs[i]>='A'&&chs[i]<='Z')){
                    ++EnglishCharCount;
                    continue;
                }
                else if(chs[i]==' '){
                    ++BlankCharCount;
                    continue;
                }
                else if(chs[i]>='0'&&chs[i]<='9'){
                    ++NumberCharCount;
                    continue;
                }
                else
                    ++OtherCharCount;
            }

            System.out.println(EnglishCharCount);
            System.out.println(BlankCharCount);
            System.out.println(NumberCharCount);
            System.out.println(OtherCharCount);
        }
}
