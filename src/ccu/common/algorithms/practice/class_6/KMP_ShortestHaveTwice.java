package ccu.common.algorithms.practice.class_6;

/**
 *   给定一个字符串str1，只能往str1的后面添加字符变成str2。
 *    要求1：str2必须包含两个str1，两个str1可以有重合，但是不
 *    能以同一个位置开头。
 *    要求2：str2尽量短
 *    最终返回str2
 *    举例：
 *    str1 = 123，str2 = 123123 时，包含两个str1，且不以相同
 *    位置开头，且str2最短。
 *    str1 = 123123，str2 = 123123123 时，包含两个str1，且不
 *    以相同位置开头，且str2最短。
 *    str1 = 111，str2 = 1111 时，包含两个str1，且不以相同位
 *    置开头，且str2最短。
 */
public class KMP_ShortestHaveTwice {

    public static String  getShortestStr(String str){
       if(str == null || str.length()==0){
           return "";
       }
        char[] chas =  str.toCharArray();
       if(chas.length == 1){
           return  (str + str);
       }
       if(chas.length == 2){
            return chas[0] == chas[1] ?str +String.valueOf(chas[0]):(str+str);
       }
      int nextIndex = getNextArrayEnd(chas);
      return str + str.substring(nextIndex);
    }

    public static int getNextArrayEnd(char[] chas){
        int[] nextArr =  new int[chas.length+1]; // 求最后一个字符的最长前缀
        nextArr[0] = -1;
        nextArr[1] =0;
        int pos = 2;
        int cn = 0;
        while(pos < nextArr.length){
            if(chas[pos-1] == chas[cn]){
                nextArr[pos++] =++cn;
            }else if(cn > 0){
                cn = nextArr[cn];
            }else{
                nextArr[pos++] =0;
            }
        }
        return nextArr[nextArr.length-1];
    }
    public static void main(String[] args) {
//        String test1 = "a";
//        System.out.println(getShortestStr(test1));
//
//        String test2 = "aa";
//        System.out.println(getShortestStr(test2));
//
//        String test3 = "ab";
//        System.out.println(getShortestStr(test3));

        String test4 = "abcdabcd";
        System.out.println(getShortestStr(test4));

//        String test5 = "abracadabra";
//        System.out.println(getShortestStr(test5));

    }
}
