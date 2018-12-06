package ccu.swordoffer;

/**
 *【题目】
 * 把一个数组最开始的若干个元素搬到数组的末尾， 我们称之数组的旋转。
 * 输入一个递增排序的数组的一个旋转， 输出旋转数组的最小元素。
 * 例如数组{ 3, 4, 5, 1, 2} 为{ l, 2, 3, 4, 5}的一个旋转，该数组的最小值为 1。
 * 特点： 分成两个子数组 ，都是递增序列。 头开始递增，尾开始递减。
 */
public class Test8 {

    public static int minNumberInRotatedArray(int[] arr){
        if(arr == null || arr.length < 1){
            throw new RuntimeException(" array is error ..");
        }
        int index1 = 0;
        int index2 = arr.length-1;
        int indexMid = 0;
        while(arr[index1] >= arr[index2]){ //特殊性 开始位置大于等于结束位置
            if(index2-index1 == 1){  // 当index1和index2挨着的时候  index2 下标为最小。
                indexMid = index2;
                break;
//                return arr[index2];
            }
            indexMid = (index2 + index1)/2;
            //1,0,1,1,1
            //1,1,1,0,1
            //特殊情况此时就要遍历整个arr[index1...index2]了，
            if(arr[index1] == arr[indexMid] && arr[indexMid] == arr[index2]){
                return getMinInArray(arr,index1,index2);
            }else if(arr[indexMid] >= arr[index1]){
                index1 = indexMid ;
            }else if(arr[indexMid] <= arr[index2]){
                index2 = indexMid;
            }
        }
        return arr[indexMid];

    }
    public static int getMinInArray(int[ ] arr,int index1,int index2){
        int min = arr[index1];
        for (int i = index1 + 1; i < index2; i++) {
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }


    public static void main(String[] args) {
        // 典型输入，单调升序的数组的一个旋转
        int[] array1 = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotatedArray(array1));
        // 有重复数字，并且重复的数字刚好的最小的数字
        int[] array2 = {3, 4, 5, 1, 1, 2};
        System.out.println(minNumberInRotatedArray(array2));
        // 有重复数字，但重复的数字不是第一个数字和最后一个数字
        int[] array3 = {3, 4, 5, 1, 2, 2};
        System.out.println(minNumberInRotatedArray(array3));
        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
        int[] array4 = {1, 0, 1, 1, 1};
        System.out.println(minNumberInRotatedArray(array4));
        // 单调升序数组，旋转0个元素，也就是单调升序数组本身
        int[] array5 = {1, 2, 3, 4, 5};
        System.out.println(minNumberInRotatedArray(array5));
        // 数组中只有一个数字
        int[] array6 = {2};
        System.out.println(minNumberInRotatedArray(array6));
        // 数组中数字都相同
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.println(minNumberInRotatedArray(array7));
        // 输入NULL
//        System.out.println(MinNumberInRotatedArray(null));
    }
}
