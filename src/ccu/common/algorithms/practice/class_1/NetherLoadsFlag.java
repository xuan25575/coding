package ccu.common.algorithms.practice.class_1;


/**
 *  荷兰国旗问题
 *  现有n个红白蓝三种不同颜色的小球，乱序排列在一起，请通过两两交换任意两个球，
 *  使得从左至右的球依次为红球、白球、蓝球。这个问题之所以叫荷兰国旗，
 *  是因为将红白蓝三色的小球弄成条状物，并有序排列后正好组成荷兰国旗。
 *  给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，
 *  等于num的数放在数组的中间，大于num的数放在数组的右边
 *  思路 ： 给定两个边界  和给定的一个值，大于p放右边，小于p放左边。
 */
public class NetherLoadsFlag {
    /**
     *
     * @param arr  数组
     * @param L    左边界
     * @param R    右边界
     * @param p    给定要分割的数
     * @return  int[]
     */
    public  static int[] partition(int[] arr,int L,int R, int p){
        int less = L -1; // 左边界开始的地方
        int more = R + 1; // 右边开始的地方
        while(L< more){  // 循环结束的条件
            if(arr[L] < p){
                swap(arr,++less,L++);
            }else if(arr[L]>p){
                swap(arr,--more,L);
            }else{
                L++;
            }
        }
        //less 最终为小于p的左边界 more最终为 大于p的右边界。
        return new int[]{less+1,more-1}; // 返回中间的相等部分的左右边界
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] generateArray(){
        int[] arr = new int[10];
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (int)(Math.random()*10);
        }
        return arr;
    }

    public static void printArray(int[] arr){
        if(arr == null){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = generateArray();
        int[] p  = partition(arr,0,arr.length-1,3);
        printArray(arr);
        System.out.println(p[0]);
        System.out.println(p[1]);
    }
}
