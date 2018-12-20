package ccu.swordoffer;

/**
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 *  例如输入一个长度为 9 的数组｛ 1, 2, 3, 2, 2, 2, 5, 4, 2｝。
 *  由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2 。
 */
public class Test29 {

    /**
     * 解1
     * @param arr
     * @return
     */
    public static int solution1(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int count = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if(count == 0){
                result = arr[i];
                count =1;
            }else if(result == arr[i]){
                count++;
            }else {
                count--;
            }
        }
        if(!checkMoreThanHalf(arr,result)){
            return -1;
        }
        return result;
    }

    public static boolean checkMoreThanHalf(int[] arr,int num){
        if(arr == null || arr.length == 0){
            return false;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(num == arr[i]){
                count++;
            }
        }
        if(count * 2 < arr.length){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        // 存在出现次数超过数组长度一半的数字
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(solution1(numbers));
        // 出现次数超过数组长度一半的数字都出现在数组的前半部分
        int numbers2[] = {2, 2, 2, 9, 2, 1, 3, 4, 5};
        System.out.println(solution1(numbers2));
        // 出现次数超过数组长度一半的数字都出现在数组的后半部分
    }
}
