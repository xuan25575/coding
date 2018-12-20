package ccu.swordoffer;

/**
 * 题目：输入一个字符串，打印出该字符串中字符的所有组合。
 * 例如 输入字符串 abc。（输入字符不重复）
 *      输出：a、b、c、ab、ac、bc、abc、
 */
public class Test28_1 {

    public static void combination(String str){
        if(str ==  null ||str.length() ==0){
            return;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            combination(str,0,i,sb);
        }
    }
    public static void combination(String str,int index,int number,StringBuffer sb){

        if(number == -1){
            System.out.println(sb.toString());
            return;
        }
        if(str.length() == index){
            return;
        }
        sb.append(str.charAt(index));
        combination(str,index+1,number-1,sb);
        sb.deleteCharAt(sb.length()-1);
        combination(str,index+1,number,sb);
    }

    public static void main(String[] args) {
        combination("abc");
    }
}
