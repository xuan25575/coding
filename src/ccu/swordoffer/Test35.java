package ccu.swordoffer;

import java.util.HashMap;
import java.util.Map;

/**
 *  题目：在字符串中找出第一个只出现一次的字符。
 * 例如输入"abaccdeff"，则输出'b'。
 *
 * 【解】：
 *     用HashMap统计每个字符出现的次数
 *     然后再扫描一次字符数组，当此字符出现次数为1时，直接return
 *     时间复杂度：2 * O(N)
 */
public class Test35 {


    public static Character firstNotRepeatingChar(String s ){
        if(s == null || s == "" || s.length() == 0){
            return null;
        }
        char[] c = s.toCharArray();
        int count = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < c.length; i++) {
            if(map.get(c[i]) == null){
                map.put(c[i],1);
            }else{
                count = map.get(c[i]);
                count++;
                map.put(c[i],count);
            }
        }
        char res = '\0';  // 空
        for (int i = 0; i < c.length; i++) {
            if(map.get(c[i]) == 1){
                res = c[i];
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
     //   System.out.println('\0');
        System.out.println(firstNotRepeatingChar("google")); // l
        System.out.println(firstNotRepeatingChar("aabccdbd")); // '\0'
        System.out.println(firstNotRepeatingChar("abcdefg")); // a
        System.out.println(firstNotRepeatingChar("gfedcba")); // g
        System.out.println(firstNotRepeatingChar("zgfedcba")); // g
    }
}
