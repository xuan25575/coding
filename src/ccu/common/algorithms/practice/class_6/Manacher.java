package ccu.common.algorithms.practice.class_6;

/**
 * Manacher算法
 */
public class Manacher {


    /**
     * 避免偶数字符没有对称中心
     *
     * @param str
     * @return
     */
    public static char[] manacherString(String str) {
        char[] s = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : s[index++];
        }
        return res;
    }

    /**
     * 马拉车算法
     * 求最大回文子串
     *
     * @param str
     * @return
     */
    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = manacherString(str);
        int pR = -1; // 最大回文右边界
        int index = -1; // 最近一次更新pR时，的回文中心
        int max = Integer.MIN_VALUE;
        int[] pArr = new int[chars.length]; // 每一个值回文右边界的长度
        for (int i = 0; i < chars.length; i++) {
             // 核心一行
            //  pR <= i 当前位置大于等于回文右边界，设置当前为1，并开始重新匹配
            //  pR > i  1）看会回文右边是在index ，代表pArr[2 * index - i] 回文右边界里面，
            //          2）pR - i可能是在压线或者外部。往下开始匹配
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (pArr[i] + i < chars.length && i - pArr[i] > -1) {
                if (chars[pArr[i] + i] == chars[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            // 如果当前的回文右边界大于pR 修改 pR的值。
            if (pArr[i] + i > pR) {
                pR = pArr[i] + i;
                index = i;
            }
            max = Math.max(max, pArr[i]); // 获取最大的回文右边界
        }
        return max - 1; // //返回Len[i]中的最大值-1即为原串的最长回文子串的长度（由于填充了字符）
    }


    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
    }
}