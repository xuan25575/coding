package ccu.swordoffer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，
 * 所有偶数位予数组的后半部分。
 *  O(N^2)的解法：
 *    插入排序的变形：将交换的判断条件改为（arr[j-1]为偶数 && arr[j]为奇数）
 *  O(N)的解法：
 *    设置两个指针：p1 = arr[0], p2 = arr[length-1]
 *      while(p1<=p2){
 *          p1往右走，遇到偶数就停
 *          p2往左走，遇到奇数就停
 *          swap(arr, p1, p2);
 *      }
 *      为了增加程序的鲁棒性：
 *          可将p1、p2的判断条件 写成一个独立的函数，
 *          这样前置的就不仅可以是奇数、也可以将非负数放在前面、将所有能被3整除的数放在前面...
 *
 */
public class Test14 {


    /**
     *  O(N^2)的解法：
     * @param arr 整数数组
     */
    public static void  reorderOddEven1(int[] arr){
        if(arr == null || arr.length <1){
            return;
        }
        int size = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if(size == arr.length-1){  // 控制循环次数
                break;
            }
            if((arr[i]&1)==0){
                int temp = arr[i];
                for (int j = i; j < arr.length-1; j++) {
                    arr[j] = arr[j+1];
                }
                arr[arr.length-1] = temp;
                i = i-1; // 修正下标
            }
            size++;
        }
    }

    /**
     * O(N)的解法
     * @param arr 整数数组
     */
    public static void  reorderOddEven2(int[] arr){
        if(arr== null || arr.length <1){
            return ;
        }
        int i = 0;
        int j = arr.length-1;
        while(i < j){
            while(i < j && (arr[i]&1)!=0){
                i++;
            }
            while(i < j && (arr[j]&1)==0){
                j--;
            }
            swap(arr,i,j);
        }
    }



    public static void printArray(int[] arr){
        if(arr == null){
            return;
        }
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    public static void swap(int [] arr,int a,int b){
        int temp =  arr[a];
        arr[a] = arr[b];
        arr[b] =temp;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 5};
        printArray(arr);
        reorderOddEven1(arr);
        printArray(arr);
        int[] arr2 = {1, 2, 2, 3, 4, 5};
        reorderOddEven2(arr2);
        printArray(arr2);
    }

}
