package ccu.leetCode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author huang_2
 * @Date 2020/5/2 9:44 上午
 * @Description TODO
 */
public class 无重复字符的最长子串 {


    /**
     * 使用hashMap
     * @param s
     * @return
     */

    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            // 包含就更新左边界
            if(map.containsKey(s.charAt(i))){
                // 为什么+1   原因当前这个s.charAt(i)字符下标已经在map中，所以下一个从不包含
                // 重复字符的位置在当前map中这个s.charAt(i)字符的下标的下一个位置
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }


    /**
     * 滑动窗口
     * 左右指针
     * HashSet
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();

        int kr = -1,ans = 0;
        for (int i = 0; i < n; i++) {
            if(i!=0){
                // 左指针向右边移动 删除一位
                set.remove(s.charAt(i-1));
            }
            //比如 pwwkew 认为当更新到 pw -->kr=0,pww -->kr=1
            // 当我右边需要扩展是 0 - kr 位置是一个无重复字串。
            // 下一次应该是从 kr+1 开始。
            while(kr+1 < n && !set.contains(s.charAt(kr+1))){
                // 右指针 不断扩展
                set.add(s.charAt(kr+1));
                kr++;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans ,kr - i +1);

        }
        return ans;
    }

    /**
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        if(s.length() == 0) return 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();

        int kr = 0,ans = 0;
        for (int i = 0; i < n; i++) {
            if(i!=0){
                // 左指针向右边移动 删除一位
                set.remove(s.charAt(i-1));
            }

            while(kr < n && !set.contains(s.charAt(kr))){
                // 右指针 不断扩展
                set.add(s.charAt(kr));
                kr++;
            }
            //为啥是第 i 到 rk-1 个字符， 当判断包含kr这个字符的时候，kr已经夺走了一步，细想。
            // 第 i 到 rk-1 个字符是一个极长的无重复字符子串
            // 但是 rk-1-i+1  == kr-i
            ans = Math.max(ans ,kr - i );

        }
        return ans;
    }




    public static void main(String[] args) {

        String str = "abcabcbb";
        无重复字符的最长子串 s = new 无重复字符的最长子串();
        System.out.println(s.lengthOfLongestSubstring2(str));
    }
}
