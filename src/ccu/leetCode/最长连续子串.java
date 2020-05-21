package ccu.leetCode;

public class 最长连续子串 {
    /**
     * 暴力解法
     * @param s
     * @return
     */
    public static  int findTheLongestSubstring(String s) {


        int len = s.length();
        int aCnt=0,eCnt=0,iCnt=0,oCnt=0,uCnt=0;

        int res = 0;

        for (int i = 0; i < len-1; i++) {
            for (int j = 1; j < len; j++) {
                for (int k = i; k < j; k++) {
                    if('a'==s.charAt(k)){
                        aCnt++;
                    }
                    if('e'==s.charAt(k)){
                        eCnt++;
                    }
                    if('i'==s.charAt(k)){
                        iCnt++;
                    }
                    if('o'==s.charAt(k)){
                        oCnt++;
                    }
                    if('u'==s.charAt(k)){
                        uCnt++;
                    }
                }
                if(aCnt %2!=0){
                    aCnt=0;
                    eCnt=0;
                    iCnt=0;
                    oCnt=0;
                    uCnt=0;
                    continue;
                }
                if(eCnt %2!=0){
                    aCnt=0;
                    eCnt=0;
                    iCnt=0;
                    oCnt=0;
                    uCnt=0;
                    continue;
                }

                if(iCnt %2!=0){
                    aCnt=0;
                    eCnt=0;
                    iCnt=0;
                    oCnt=0;
                    uCnt=0;
                    continue;
                }
                if(oCnt %2!=0){
                    aCnt=0;
                    eCnt=0;
                    iCnt=0;
                    oCnt=0;
                    uCnt=0;
                    continue;
                }
                if(uCnt %2!=0){
                    aCnt=0;
                    eCnt=0;
                    iCnt=0;
                    oCnt=0;
                    uCnt=0;
                    continue;
                }
                res = Math.max(res,j-i);
            }

        }
        return res;

    }
}
