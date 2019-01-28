package ccu.swordoffer;

/**
 * 题目一：输入一个递增排序的数组和一个数字 s，在数组中查找两个数，得它们的和正好是 s。如果有多对数字的和等于 s，输出任意一对即可。
 * 例如输入数组｛1 、2 、4、7 、11 、15 ｝和数字 15。
 *  由于 4+11 = 15 ，因此输出 4 和 11 。
 */
public class Test41 {

    public static boolean findNumbersWithSum(int[] arr,int s){
        if (arr == null || arr.length < 2) return false;
        int p1 = 0;
        int p2 = arr.length -1;
        long sum = 0;
        int[] res = new int[2];
        boolean found = false;

        while(p1 < p2){
            sum = arr[p1] + arr[p2];
            if(sum == s){
                res[0] = arr[p1];
                res[1] =arr[p2];
                found = true;
                break;
            }else if(sum > s){  // 数组有序， 大于的话 后面的数大了，p2向前移动。
                p2 --;
            }else{
                p1++;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[] data1 = {1, 2, 4, 7, 11, 15};
        System.out.println(findNumbersWithSum(data1, 15));
        int[] data2 = {1, 2, 4, 7, 11, 16};
        System.out.println(findNumbersWithSum(data2, 13));
        int[] data3 = {1, 2, 4, 7, 11, 16};
        System.out.println(findNumbersWithSum(data3, 24));
    }
}
