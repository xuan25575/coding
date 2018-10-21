package ccu.swordoffer;
/**
 * 题目  请实现一个函数，把字符串中没一个空格替换成%20
 *
 * 最直观的想法，从头扫描 遇到空格就替换成'20%'，长度是n的字符串，遇到一个空格，就需要向后移动n个字符，
 * 所以时间复杂度为O（N^2)
 *
 * 思路：
 * 双指针，从后往前遍历替换：
 *      p1：指向字符串末尾，
 *      p2：指向替换之后的字符串的末尾（关键需提前遍历一遍str，数一下一共有多少个空格）
 *      每替换一个空格长度加2
 *  然后p1和p2一起向前跑，当p1遇到空格，则将' '变成'%20'，然后继续向前跑。
 *
 *
 */
public class Test04 {

    public static void main(String[] args) {
        String s = "we are happy";
        char[] chars = s.toCharArray();
        char[] str = new char[50];
        for (int i = 0; i < chars.length; i++) {
            str[i]=chars[i];
        }
        System.out.println( replaceBlank(str,chars.length));
        System.out.println( replaceBlank(null,chars.length));


    }
    /**
     *
     * @param str 替换空格使用的字符数组
     * @param length  origin str 的总长度
     * @return
     */
    public static String replaceBlank(char[] str, int length){

        if(str ==null || length <1){
            return null ;
        }
       int blankNum = 0;
//       计算所有空格
       for(int i=0;i<length;i++){
           if(str[i] == ' '){
               blankNum++;
           }
       }

       int p1 = length -1;
       int p2 = length + blankNum*2;
//判断char 数组长度是否足够。
       if(p2 >str.length){
           throw new RuntimeException("str 长度不够");
       }
//同时移动 遇到空格就填充 最终p1 p2 相遇空格替换结束。把字符串复制一遍。
       while(p1 >= 0){
           if(str[p1] == ' '){
               str[p2--]='%';
               str[p2--]='2';
               str[p2--]='0';
           }else{
               str[p2--]=str[p1];
           }
           p1--;
       }
       return new String(str);
    }
}
