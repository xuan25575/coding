package ccu.common.algorithms.practice.class_6;

/**
 * KMP算法
 * KMP算法要解决的问题就是在字符串（也叫主串）中的模式（pattern）定位问题。
 * 说简单点就是我们平时常说的关键字搜索。模式串就是关键字（接下来称它为P），
 * 如果它在一个主串（接下来称为T）中出现，就返回它的具体位置，否则返回-1（常用手段）。
 *
 *
 */
public class KMP {


    /**
     *
     * @param s  原字符串
     * @param p  需要匹配的字符串
     */
    public static int getIndexOf(String s ,String p){
        if(s == null || p == null || p.length() < 1 || s.length()< p.length()){
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] sp = p.toCharArray();
        int sIndex =0;
        int pIndex = 0;
        int[] next = getNextArray(sp);
        while(sIndex < ss.length  && pIndex < sp.length){
            if(ss[sIndex] == sp[pIndex]){
                sIndex++;
                pIndex++;
            }else if(next[pIndex] == -1){ // 到了next数组的头部 ;  暴力扩
                sIndex++;  // 下标从 原始字符串下一个 开始
            }else{
                pIndex = next[pIndex];
            }
        }
        return pIndex == sp.length ? sIndex - pIndex : -1;

    }

    /**
     *  关键是： 最长前缀子串 和 最长后缀子串的概念。
     * @param sp 匹配的字符串的char数组
     * @return next 数组
     */
    public static int[] getNextArray(char[] sp){
        if(sp.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[sp.length];
        next[0] = -1;  // 没有字符 规定-1
        next[1] = 0;  // 任何子串的后缀不能包括后缀  设置为0；
        int pos = 2;  // 从第二个位置开始 计算
        int cn = 0;
        while(pos < next.length){
            if(sp[pos-1] == sp[cn]){
                next[pos++] = ++cn;  // 如果相等，那么最大相同前后缀长度加1
            }else if(cn > 0){
                cn = next[cn];  // next 数组存储最大前后缀子串长度 该位置求出上一个位置的最长匹配子串 next数组还是理解不够深
            }else{
                next[pos++] = 0;  // next数组跳到-1 都没有 该位置没有 设置为0
            }
        }
        return next;
    }


    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));
        System.out.println(bf(str,match));

    }



    /**
     * 暴力破解法
     * @param ts 主串
     * @param ps 模式串
     * @return 如果找到，返回在主串中第一个字符出现的下标，否则为-1
     */

    public static int bf(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        int i = 0; // 主串的位置
        int j = 0; // 模式串的位置
        while (i < t.length && j < p.length) {
            if (t[i] == p[j]) { // 当两个字符相同，就比较下一个
                i++;
                j++;
            } else { i = i - j + 1; // 一旦不匹配，i后退
                j = 0; // j归0
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }


}
