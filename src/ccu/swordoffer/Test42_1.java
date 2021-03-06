package ccu.swordoffer;

/**
 *  题目二：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 *  比如输入字符串“abcdefg”和数字 2，
 *  该函数将返回左旋转 2 位得到的结果“cdefgab”。
 */
public class Test42_1 {

    public static String leftRotateString(String str,int n){
        if(str == null || str =="" || n <0 || n> str.length()){
            return null;
        }
        char[] c = str.toCharArray();
        Test42.reverse(c,0,n-1);
        Test42.reverse(c,n,c.length-1);
        Test42.reverse(c,0,c.length-1);
        return new String(c);
    }

    /**
     *  大佬思路  巧妙啊。
     * @param str
     * @param n
     * @return
     */
    public static String leftRotateString2(String str,int n){
        int len = str.length();
        if(len == 0) return "";
        n = n % len; // 求出需要 截取字母长度。。 n 可能大于 len
        str += str;
        return str.substring(n,len+n);
    }

    public static void main(String[] args) {
        System.out.println(leftRotateString("abcdefg",2));
        System.out.println(leftRotateString2("abcdefg",2));

        System.out.println( 2 % 5);
        System.out.println(2%1);

    }
}
