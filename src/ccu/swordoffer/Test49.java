package ccu.swordoffer;

/**
 * 题目：实现一个函数 stringToInt，实现把字符串转换成整数这个功能，不能使用 atoi 或者其他类似的库函数。
 *
 * 原理很简单，就是从前往后遍历，前一个数×10，加上当前数。
 * 但要注意特殊输入：
 *    - 空指针null
 *    - 空字符串""
 *    - 正负号
 *    - 溢出
 *    - 非数字字符
 */
public class Test49 {


    public static int stringToInt(String str){
        if (str==null || str.length()<=0){
            throw new IllegalArgumentException("args  is  null or empty");
        }
        char[]  c = str.toCharArray();
        if(c[0]=='+'){
            return parseString(c,1,true);
        }else if(c[0] >= '0' && c[0] <= '9'){
            return parseString(c,0,true);
        }else if(c[0] == '-'){
            return parseString(c,1,false);
        }else {
            return -1;
        }

    }

    public static int parseString(char[] c ,int begin,boolean isPositive){
        if(c == null || c.length == 0){
            throw new RuntimeException("args is null");
        }
        int res = isPositive ? 1: -1;
        long temp =0;
        while(begin < c.length){
            if (!isDigit(c[begin])){
                throw new IllegalArgumentException("Invalid args");
            }
            temp = temp*10 + c[begin]-'0';  // 没懂
            if (temp > 0x80000000L || (isPositive && temp==0x80000000L)){
                throw new RuntimeException("溢出了！");
            }
            begin++;
        }
        return  (int)temp*res;
    }
    private static boolean isDigit(char x){
        return x>='0' && x<='9';
    }


    public static void main(String[] args) {
        System.out.println(0x8000_0000L);
        System.out.println(stringToInt("123"));
        System.out.println(stringToInt("+123"));
        System.out.println(stringToInt("-123"));
    }
}
