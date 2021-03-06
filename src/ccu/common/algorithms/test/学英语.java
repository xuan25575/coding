package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @Author huang_2
 * @Date 2020/3/28 6:23 下午
 * @Description
 * Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
 *
 * 如22：twenty two，123：one hundred and twenty three。
 * 说明：
 * 数字为正整数，长度不超过九位，不考虑小数，转化结果为英文小写；
 * 输出格式为twenty two；
 * 非法数据请返回“error”；
 * 关键字提示：and，billion，million，thousand，hundred。
 * 输入描述:
 * 输入一个long型整数
 *
 * 输出描述:
 * 输出相应的英文写法
 */
public class 学英语 {
    static HashMap<Integer, String> dict = new HashMap<>();
    static {
        dict.put(0, "zero");
        dict.put(1, "one");
        dict.put(2, "two");
        dict.put(3, "three");
        dict.put(4, "four");
        dict.put(5, "five");
        dict.put(6, "six");
        dict.put(7, "seven");
        dict.put(8, "eight");
        dict.put(9, "nine");
        dict.put(10, "ten");
        dict.put(11, "eleven");
        dict.put(12, "twelve");
        dict.put(13, "thirteen");
        dict.put(14, "fourteen");
        dict.put(15, "fifteen");
        dict.put(16, "sixteen");
        dict.put(17, "seventeen");
        dict.put(18, "eighteen");
        dict.put(19, "nineteen");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null){
            Integer l = Integer.valueOf(line);
            System.out.println(parse(l));
        }
    }

    public static String parse(int num){
        int len = String.valueOf(num).length();
        if(len == 1){
            return dict.get(num);
        }
        if(len == 2){
            if(num < 20){
                return dict.get(num);
            }else if(num < 30){
                int k = num % 10;
                return k != 0 ? "twenty "+ dict.get(k): "twenty";
            }else if(num<40){
                return num % 10 == 0 ? "thirty " :"thirty " + dict.get(num % 10);
            }else if(num<50){
                return num % 10 != 0 ? "forty " + dict.get(num % 10): "forty";
            }else if(num<60){
                return num % 10 != 0 ? "fifty " + dict.get(num % 10): "fifty";
            }else if(num<70){
                return num % 10 != 0 ? "sixty " + dict.get(num % 10): "sixty";
            }else if(num<80){
                return num % 10 != 0 ? "seventy " + dict.get(num % 10): "seventy";
            }else if(num<90){
                return num % 10 != 0 ? "eighty " + dict.get(num % 10): "eighty";
            }else if(num<100){
                return num % 10 != 0 ? "ninety " + dict.get(num % 10): "ninety";
            }
        }else if(len ==3){
            String str = parse(num/100) + " hundred ";
            num -= num/100*100;//减去百位。
            if(num != 0){
                str = str + "and "+ parse(num%100);
            }
            return str;
        }else if(len == 4 || len == 5 || len == 6){
            String str = parse(num/1000) + " thousand ";
            num -= (num/1000 * 1000);
            if(num != 0){
                str += parse(num);
            }
            return  str;
        }else if(len == 7 || len == 8 || len == 9){
            String str = parse(num/1000000) + " million ";
            num -= (num/1000000 * 1000000);
            if(num != 0){
                str += parse(num);
            }
            return  str;
        }
        return "error";
    }
}
