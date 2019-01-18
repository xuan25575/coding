package ccu.common.algorithms.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 写段代码，定义一个字符串常量，字符串中只有大小写字母和整数，输出字符串中的出现最多的数字的和？
 * 例如 ” 9fil3dj11P0jAsf11j ” 中出现最多的是11两次，输出22.
 */
public class Test01 {

    public static void main(String[] args) {

        long sum = new Test01().sumOfIntInStr("9fil3dj11P0jAsf11j");
        System.out.println(sum);
    }

    public long sumOfIntInStr(String input){

        Map<Integer, Integer> map = new HashMap<>();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            Integer curKey = Integer.valueOf(matcher.group());
            if(map.containsKey(curKey)){
                map.put(curKey, map.get(curKey) + 1);
            }else {
                map.put(curKey, 1);
            }
        }

        long curMaxCnt = 0;
        Integer maxKey = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > curMaxCnt){
                curMaxCnt = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return curMaxCnt * maxKey;
    }

}

