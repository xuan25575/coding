package ccu.common.algorithms.practice.class_6;

import java.util.LinkedList;

/**
 * 给定一个字符串str，str表示一个公式，公式里可能有整数、加减乘除符号和
 *    左右括号，返回公式的计算结果。
 *    【举例】
 *    str="48*((70-65)-43)+8*1"，返回-1816。
 *    str="3+1*4"，返回7。 str="3+(1*4)"，返回7。
 *    【说明】
 *    1．可以认为给定的字符串一定是正确的公式，即不需要对str做公式有效性检
 *    查。
 *    2．如果是负数，就需要用括号括起来，比如"4*(-3)"。但如果负数作为公式的
 *    开头或括号部分的开头，则可以没有括号，比如"-3*4"和"(-3*4)"都是合法的。
 *    3．不用考虑计算过程中会发生溢出的情况
 *
 *  注意：s[i]是一个字符变量，当s="123"的时候，s[0]='1',s[1]='2',s[2]='3';
 *   这里的s[i]-'0'的实质就是将单个字符转化为单个数字。
 *   当字符类型的变量赋值给整型变量的时候，系统会自动将其转换成ASCII码。'0'的ASCII码为48，'1'为49，依次类推。
 *   思路：  遇到‘(’ 递归   遇到 * / 计算   队列里面只剩下整数 加减
 */
public class ExpressionCompute {



    public static int getValue(String str){
        return value(str.toCharArray(),0)[0];
    }



    public static int[] value(char[] str,int i){
        LinkedList<String> que = new LinkedList<>();
        int pre = 0;
        int[] bra = null; // 存两 个值， 一个计算结果 ，一个'(' 的下标
        while(i<str.length && str[i] != ')'){
            if(str[i] >='0' && str[i] <= '9'){
                pre = pre*10 + str[i++]-'0';
            }else if(str[i] != '('){
                addNum(que,pre);
                que.addLast(String.valueOf(str[i++]));
                pre = 0;
            }else{
                bra = value(str,i+1);
                pre = bra[0];
                i= bra[1]+1;
            }
        }
        addNum(que,pre);
        return  new int[]{getNum(que),i};
    }




    public static void addNum(LinkedList<String> que,int num){
        if(!que.isEmpty()){
            int cur = 0;
            String top = que.pollLast();
            if(top.equals("+") || top.equals("-")){
                que.addLast(top);
            }else{
                cur = Integer.valueOf(que.pollLast());
                num =top.equals("*") ? cur * num :cur / num;
            }
        }
        que.addLast(String.valueOf(num));
    }

    public static int getNum(LinkedList<String> que){
        int res = 0;
        boolean add = true;
        String cur = null;
        int num =0;
        while(!que.isEmpty()){
            cur =  que.pollFirst();
            if(cur.equals("+")){
                add =true;
            }else if(cur.equals("-")){
                add =false;
            }else{
                num = Integer.valueOf(cur);
                res+= add? num:-num;
            }
        }
        return res;
    }







    public static void main(String[] args) {
//        int a = '3';
//        System.out.println(a);
        String exp = "48*((70-65)-43)+8*1";
        System.out.println(getValue(exp));

        exp = "4*(6+78)+53-9/2+45*8";
        System.out.println(getValue(exp));

        exp = "10-5*3";
        System.out.println(getValue(exp));

        exp = "-3*4";
        System.out.println(getValue(exp));

        exp = "3+1*4";
        System.out.println(getValue(exp));
    }
}
