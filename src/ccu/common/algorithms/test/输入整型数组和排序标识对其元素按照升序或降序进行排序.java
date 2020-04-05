package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author huang_2
 * @Date 2020/3/27 3:02 下午
 * @Description
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序（一组测试用例可能会有多组数据）
 * 接口说明
 * 原型：
 * void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag);
 * 输入参数：
 * Integer[] pIntegerArray：整型数组
 * int  iSortFlag：排序标识：0表示按升序，1表示按降序
 * 输出参数：
 * 无
 * 返回值：
 * void
 * 输入描述:
 * 1、输入需要输入的整型数个数
 * 输出描述:
 * 输出排好序的数字
 */
public class 输入整型数组和排序标识对其元素按照升序或降序进行排序 {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while((line=br.readLine())!=null){
            int n = Integer.parseInt(line);
            String[] data=br.readLine().split(" ");
            int m = Integer.parseInt(br.readLine());
            int[] arr=new int[n];
            for(int i=0;i<data.length;i++){
                arr[i]=Integer.parseInt(data[i]);
            }
            StringBuffer sb=new StringBuffer();
            if(m==0){
                Arrays.sort(arr);
            }else{
                Arrays.sort(arr);
                for(int i=0;i<arr.length/2;i++){
                    int a=arr[i];
                    arr[i]=arr[arr.length-1-i];
                    arr[arr.length-1-i]=a;
                }
            }
            for(int i=0;i<arr.length;i++){
                sb.append(arr[i]+" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
