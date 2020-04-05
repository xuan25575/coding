package ccu.common.algorithms.test;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author huang_2
 * @Date 2020/3/25 8:58 下午
 * @Description
 * 数据表记录包含表索引和数值（int范围的整数），
 * 请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 */
public class 合并表记录 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 有序
            Map<Integer, Integer> map = new TreeMap<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                int value = sc.nextInt();
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + value);
                } else
                    map.put(s, value);
            }
            for (Integer key : map.keySet()) {
                System.out.println(key + " " + map.get(key));
            }
        }
    }
}
