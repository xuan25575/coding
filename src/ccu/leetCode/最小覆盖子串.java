package ccu.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huang_2
 * @Date 2020/5/2 10:37 上午
 * @Description
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 算法
 * 1.初始，left 指针和 right 指针都指向 S 的第一个元素.
 * 2.将 right指针右移，扩张窗口，直到得到一个可行窗口，亦即包含 T 的全部字母的窗口。
 * 3.得到可行的窗口后，将 left 指针逐个右移，若得到的窗口依然可行，则更新最小窗口大小。
 * 4.若窗口不再可行，则跳转至 2 。
 */
public class 最小覆盖子串 {

    public String minWindow(String s, String t) {

        if(s.length() ==0 || t.length()==0){
          return "";
        }
        // 统计 t 字符串 ，字符和字符个数。
        Map<Character,Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int cnt = dictT.getOrDefault(t.charAt(i),0);
            dictT.put(t.charAt(i),cnt+1);
        }

        int minLen = Integer.MAX_VALUE;
        int r=0, l= 0;
        int count=0;//count代表符合要求的字符个数

        int start= 0,end = 0;

        Map<Character, Integer> window = new HashMap<>();

        while(r < s.length()){
            char c  = s.charAt(r);
            if(dictT.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(dictT.get(c).intValue() == window.get(c).intValue()){
                    count++;
                }
            }
            // 右移窗口
            r++;

            //得到可行的窗口后
            while(count == dictT.size()){
                if(r-l < minLen){
                    start= l;
                    end = r;
                    minLen = r-l;
                }
                //d 是将移出窗口的字符 ,开始缩小窗口
                char d = s.charAt(l);
                //将 left 指针逐个右移，若得到的窗口依然可行，则更新最小窗口大小。
                if(dictT.containsKey(d)){
                    //说明窗口一定有 ,
                    window.put(d,window.get(d)-1);
                    //这一步也关键，判断
                    if(window.get(d)<dictT.get(d)){
                        count--;
                    }

                }
                // 左移窗口
                l++;
            }

        }
        return minLen == Integer.MAX_VALUE ? "" :s.substring(start,end);

    }


    public static void main(String[] args) {
       String s = "ADOBECODEBANC", t= "ABC";

        最小覆盖子串 q = new 最小覆盖子串();

        System.out.println(q.minWindow(s,t));

    }

    /* 滑动窗口算法框架 */
//    void slidingWindow(string s, string t) {
//        unordered_map<char, int> need, window;
//        for (char c : t) need[c]++;
//
//        int left = 0, right = 0;
//        int valid = 0;
//        while (right < s.size()) {
//            // c 是将移入窗口的字符
//            char c = s[right];
//            // 右移窗口
//            right++;
//            // 进行窗口内数据的一系列更新
//        ...
//
//            /*** debug 输出的位置 ***/
//            printf("window: [%d, %d)\n", left, right);
//            /********************/
//
//            // 判断左侧窗口是否要收缩
//            while (window needs shrink) {
//                // d 是将移出窗口的字符
//                char d = s[left];
//                // 左移窗口
//                left++;
//                // 进行窗口内数据的一系列更新
//            ...
//            }
//        }
//    }


}
