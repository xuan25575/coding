package ccu.common.algorithms.practice.class_6;

/**
 * Manacher算法扩展题目
 *    给定一个字符串str1，只能往str1的后面添加字符变成str2，要求str2
 *    整体都是回文串且最短。
 *    举例：
 *    str1 = ABC12321, 返回ABC12321CBA
 */
public class Manacher_ShortestEnd {

    public static char[]  manacherString(String str){
        if(str == null || str.length() ==0){
            return null;
        }
        char[] chars = str.toCharArray();
        char[] res = new char[chars.length*2+1];
        int  index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i&1) == 0 ? '#': chars[index++];
        }
        return res;
    }


    public static  String getShortestEnd(String str){
        if(str == null || str.length() ==0){
            return null;
        }
        char[] chars = manacherString(str);
        int[] pArr = new int[chars.length];
        int index =-1;
        int pR = -1;
        int containsEnd = 0;
        for (int i = 0; i < chars.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2*index-i],index-i):1;
            while(i+pArr[i] < chars.length && i-pArr[i]> -1){
                if(chars[i+pArr[i]] == chars[i-pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(i+pArr[i] > pR){
                pR = i+pArr[i];
                index = i;
            }
            if(pR == chars.length){
                containsEnd = pArr[i];
                break;
            }
        }
        char[] res = new char[str.length() - containsEnd +1];
        for (int i = 0; i < res.length; i++) {
           res[res.length -1-i] = chars[2*i+1]; // chars[2*i+1] 由于查chars 中有特殊字符# 除去
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String str2 = "abcd123321";
        System.out.println(str2+getShortestEnd(str2));

    }
}
