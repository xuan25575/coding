package ccu.swordoffer;

/**
 *  题目：输入一个字符串，打印出该字符串中字符的所有排列。
 *  例如 输入字符串 abc。
 *  则打印出由字符 a、b、c 所能排列出来的所有字符串 abc、acb、bac 、bca、cab 和 cba 。
 *  每一次递归都将字符串分成两部分： 第1个字符，和他后面的所有字符
 *  先将第一个字符与其后面的字符依次交换，然后 求其后面的所有字符的全排列
 *  去重：
 *     就是从第一个字符开始，每个字符与其后面非重复的字符交换
 *     即：当chars[begin]与chars[i]交换时，[begin,i)中没有与chars[i]相同的字符
 *
 *     回溯算法的思想
 */
public class Test28 {

    public static void permutation(String str){
        if(str.isEmpty()){
            return;
        }
        char[] chars = str.toCharArray();
        permutation(chars,0);

    }
    public static void permutation(char[] chars,int begin){
        if(chars.length == 0){
            return;
        }
        if(chars.length-1 == begin){
            System.out.print(new String(chars)+" ");
        }else{
            for (int i = begin; i < chars.length; i++) {
                //if(isSwap(chars,begin,i)){
                swap(chars,begin,i);
                permutation(chars,begin+1);
                swap(chars,begin,i); // 回溯
            //    }
            }
        }
    }

    public static void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] =temp;
    }

    public static boolean isSwap(char[] chars,int i,int j){
        for (  ;i<j ; i++) {
            if(chars[i] == chars[j]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = new String();
        str = "abc";
        permutation(str);
      //  abc acb bac bca cba cab
      //  abc acb cab cba abc acb

    }
}
