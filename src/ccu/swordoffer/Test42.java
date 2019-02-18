package ccu.swordoffer;



/**
 *  题目一：输入一个英文句子，翻转句子中单词的顺序，但单词内字母的顺序不变。为简单起见，标点符号和普通字母一样处理。
 *   例如输入字符串”I am a student. ”，
 *   则输出”student. a am I”。
 *  【解】：翻转两次字符串即可
 *     第一步，翻转句子中的所有字符
 *      比如翻转“I am a student. ”中所有的字符得到“.tneduts am a I”，
 *     第二步，再翻转每个单词中字符的顺序就得到了“student. a am I”。
 */
public class Test42 {

    public static String reverseSequence2(String str){
        if(str.trim().equals("")){
            return str;
        }
        String[] strings = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = strings.length-1; i >= 0 ; i--) {
            sb.append(strings[i]).append(" ");
        }
        return sb.substring(0,sb.length()-1);
    }


    public static void main(String[] args) {
        String  str= "I am a student.";
        System.out.println( reverseSequence2(str));
        System.out.println(reverseSequence(str));
    }


    public static String reverseSequence(String str){
        if(str == null || str ==""){
            return null;
        }
        char[] c = str.toCharArray();
        int len = c.length;
        reverse(c,0,len-1);
        int lo =0;
        int hi = 0;
        while(lo < len){
            hi++;
            if(hi==len || c[hi] == ' '){
                reverse(c,lo,hi-1);
                hi++;
                lo = hi;
            }
        }
        return new String(c);

    }




    public static void reverse(char[] c,int begin,int end){
        if(c.length ==0 || begin < 0|| end > c.length || begin >end ){
            return;
        }
        while(begin <end){
            char temp = c[begin];
            c[begin] = c[end];
            c[end] = temp;
            begin++;
            end--;
        }
    }

}
