package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Date 2020/3/27 4:17 下午
 * @Description
 * 考试题目和要点：
 *
 * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）
 * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。（30分）
 * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。（
 *
 * 输入描述:
 * 输入一个double数
 *
 * 输出描述:
 * 输出人民币格式
 * 输入
 * 151121.15
 * 输出
 * 人民币拾伍万壹仟壹佰贰拾壹元壹角伍分
 */
public class 人民币转换 {

    /**
     * 151121.15
     * 人民币拾伍万壹仟壹佰贰拾壹元   壹角伍分
     */
    public static String[] RMB = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    public static String[] unit = {
            "元", "拾", "佰", "仟", "万",
            "拾", "佰", "仟", "亿",
            "拾", "佰", "仟", "万","兆",
            "拾", "佰", "仟", "万","亿"

    };
    public static String[] smallUnit = {"角", "分"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null && (input = input.trim()) != null) {
            String rets = "";

            if (input.contains(".")) {
                String zhengShu = input.substring(0, input.indexOf("."));
                String xiaoShu = input.substring(input.indexOf(".") + 1);
                rets = "人民币" + zhengShu(zhengShu) + xiaoShu(xiaoShu);
            } else {
                rets = "人民币" + zhengShu(input) + "整";
            }
            System.out.println(rets);
        }
    }


    /**
     * 处理整数
     *
     * @param zhengShu
     * @return
     */
    private static String zhengShu(String zhengShu) {
        if (zhengShu.length() == 1 && zhengShu.charAt(0) == '0') {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = zhengShu.length() - 1; i >= 0; i--) {//正整数反转插入 sb 中
            sb.append(zhengShu.charAt(i));
        }

        int[] arr = new int[zhengShu.length()];//

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(String.valueOf(sb.toString().charAt(i)));
        }

        sb.delete(0, sb.length());//sb清空

        /**
         *  钱正整数，因为是倒序；
         *      一： 正整数单位 + 数字大写
         *      二： 最后反转得到， 大写数字 + 正整数单位
         *      三： 第一位若为 壹 && 第二位为 拾 时，删除掉第一位
         * **/
        for (int i = 0; i < arr.length; i++) {
            sb.append(unit[i] + RMB[arr[i]]);
        }

        sb = sb.reverse();

        if (sb.charAt(0) == '壹' && sb.charAt(1) == '拾') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    /**
     * 处理小数
     *
     * @param xiaoShu
     * @return
     */
    private static String xiaoShu(String xiaoShu) {
        String temp = "";
        int[] arr = new int[xiaoShu.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(String.valueOf(xiaoShu.charAt(i)));
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            temp += RMB[arr[i]] + smallUnit[i];
        }
        return temp;
    }
}
