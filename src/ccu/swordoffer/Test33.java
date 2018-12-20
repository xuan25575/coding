package ccu.swordoffer;

import java.util.Comparator;

/**
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3， 32, 321}，
 * 则扫描输出这 3 个数字能排成的最小数字 321323。
 *
 *【解】：自定义排序规则，
 *      两个数字 m和n
 *      mn>nm： m>n
 *      mn==nm：m=n
 *      mn<nm： m<n
 *      但是这里隐含这一个大数问题，（mn拼接之后有可能超出int范围）
 *      所以，我们可以把数值的比较大小 直接转化为字符串的compare
 *
 */
public class Test33 {

    public static void main(String[] args) {
        String[] data = {"3", "5", "1", "4", "2"};
        printMinNumber(data);
        String[] data3 = {"3", "323", "32123"};
        printMinNumber(data3);
    }



    public static void printMinNumber(String[] arr){
        if(arr== null || arr.length ==0){
            return;
        }
        StringComparator comparator = new StringComparator();
        quickSort(arr,0,arr.length-1,comparator);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }



    public static void quickSort(String[] arr,int lo,int hi,StringComparator comparator){
        if(lo > hi){
            return;
        }
        int small = lo;  // 边界
        for (int i = lo; i < hi; i++) {
            if(comparator.compare(arr[i],arr[hi]) < 0){
                swap(arr,i,small++);
            }
        }
        swap(arr,small,hi);
        quickSort(arr,lo,small-1,comparator);
        quickSort(arr,small+1,hi,comparator);
    }

    public static void swap(String[] arr ,int i,int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }





    public static class StringComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {

            if(o1 == null || o2 == null){
                throw new RuntimeException("args is error ");
            }
            return (o1+o2).compareTo(o2+o1);
        }
    }
}
