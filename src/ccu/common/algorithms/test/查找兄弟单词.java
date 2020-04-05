package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author huang_2
 * @Date 2020/3/22 8:21 下午
 * @Description TODO
 */
public class 查找兄弟单词 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            String[] s = str.trim().split(" ");
            if(s.length<4){continue;}
            int num = Integer.parseInt(s[0]);
            if(num>1000){continue;}
            String key = s[num+1];
            int index = Integer.parseInt(s[num+2]);
            ArrayList<String> list = new ArrayList<String>();
            for(int i = 1; i < s.length; i++){
                if(isBroStr(s[i],key)){
                    list.add(s[i]);
                }
            }
            System.out.println(list.size());
            Collections.sort(list);
            if(list.size() >= index){
                System.out.println(list.get(index-1));
            }
        }
    }

    private static boolean isBroStr(String source,String key){
        if((source.equals(key)) ||(source.length() != key.length())){
            return false;
        }
        for(int i = 'a'; i <= 'z'; i++){
            char c = (char)i;
            if(getCharNum(source,c) != getCharNum(key,c)){
                return false;
            }
        }
        return true;
    }

    private static int getCharNum(String str,char ch){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ch){
                count++;
            }
        }
        return count;
    }
}
