package ccu.swordoffer;

/**
 * 题目：输入一个字符串，打印出该字符串中字符的所有组合。
 * 例如 输入字符串 abc。（输入字符不重复）
 *      输出：a、b、c、ab、ac、bc、abc、
 */
public class Test28_1 {

    public static void combination(String str){
        if(str ==  null ||str.length() ==0)  return;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            combination(str,0,i,sb);
        }
    }

    /**
     *
     * @param str 字符串
     * @param index  str长度 开始位置
     * @param number 挑选多少个字符
     * @param sb  保存结果
     */
    public static void combination(String str,int index,int number,StringBuffer sb){
        if(number == -1){
            System.out.println(sb.toString());
            return;
        }
        if(str.length() == index)  return;
        sb.append(str.charAt(index));
        combination(str,index+1,number-1,sb); // 如果包含第一个字符串，在str长度n-1中选number-1个字符
        sb.deleteCharAt(sb.length()-1);  // 该位置不包含该字符。
        combination(str,index+1,number,sb);// 不包含该字符，在str长度n-1（体现index+1）中选number个字符
    }

    public static void main(String[] args) {
        combination("abc");
    }
}
