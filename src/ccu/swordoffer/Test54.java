package ccu.swordoffer;
/**
 * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串“+100”，“5e2”，“-123”，“3.1416”及”-1E-16”都表示数值，
 *   但“12e”,”1a3.14”,”1.2.3”,”+-5”及“12e+5.4”都不是。 　
 *   正则 表达式解决
 *
 *   知识点：
 *        在其他语言中，\\ 表示：我想要在正则表达式中插入一个普通的（字面上的）反斜杠，请不要给它任何特殊的意义。
 *        在 Java 中，\\ 表示：我要插入一个正则表达式的反斜线，所以其后的字符具有特殊的意义。
 *        所以，在其他的语言中（如Perl），一个反斜杠 \ 就足以具有转义的作用，
 *        而在 Java 中正则表达式中则需要有两个反斜杠才能被解析为其他语言中的转义作用。
 *        也可以简单的理解在 Java 的正则表达式中，两个 \\ 代表其他语言中的一个 \，
 *        这也就是为什么表示一位数字的正则表达式是 \\d，而表示一个普通的反斜杠是 \\\\。
 */
public class Test54 {

    /**
     *  [+-]?     表示+ - 可以出现一次或者没有
     *  \\d*      表示数字：[0-9] 出现0 次或者多次
     * (\\.[0-9]+)?   如果出现小数点，那么小数点后面必须有数字；否则一起不出现 （）代表分组
     * ([Ee][+-]?\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，紧接着必须跟着整数；或者整个部分都不出现
     * @param str
     * @return
     */
    public static boolean isNumeric(char[] str) {
        String s = String.valueOf(str);
        return  s.matches("[+-]? \\d*(\\.[0-9]+)?([Ee][+-]?\\d+)?");
    }
}