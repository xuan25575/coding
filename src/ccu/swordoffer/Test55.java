package ccu.swordoffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *  例如，当从字符流中只读出前两个字符“go”时，第一个只出现一次的字符是‘g’。
 *      当从该字符流中读出前六个字符“google”时，第一个只出现 1 次的字符是”l”。
 */
public class Test55 {

    Map<Character,Integer>  m = new HashMap<>();
    List<Character>  list = new ArrayList<>();// 保证顺序

    //Insert one char from stringstream
    public void insert(char ch) {
        if(m.containsKey(ch)){
            m.put(ch,m.get(ch)+1);
        }else{
            m.put(ch,1);
        }
        list.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce() {
        char c='#';
        for(char key: list ){
            if(m.get(key) == 1){
                c = key;
                break;
            }
        }
        return c;
    }
}
