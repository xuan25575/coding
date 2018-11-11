package ccu.common.algorithms.sort;

/**
 * 快速排序使用分治法（Divide and conquer）策略来把一个序列（list）分为两个子序列（sub-lists）。
 * 步 骤为：
 *    从数列中挑出一个元素，称为“基准”（pivot），
 *    重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任何一边）。
 *    在这个分割结束之后，该基准就处于数列的中间位置。这个称为分割（partition）操作。
 *    递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *    递归到最底部时，数列的大小是零或一，也就是已经排序好了。这个算法一定会结束，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
 */
public class QuickSort {



    public static void quickSort(int[] arr){
       if(arr == null || arr.length < 2){
           return;
       }
       quickSort(arr,0,arr.length-1);
    }

    /**
     *  快排
     * @param arr
     * @param L
     * @param R
     */
    public static void quickSort(int[] arr, int L,int R){
        if(L < R){
            swap(arr,L+(int)Math.random()*(R-L+1),R); //将基准值采用随机数赋值。
            int[] p = partition(arr, L, R);
            quickSort(arr,L,p[0]-1);
            quickSort(arr,p[1]+1,R);
        }
    }

    /**
     *  荷兰国旗问题切分的
     * @param arr
     * @param L
     * @param R
     * @return int[] 为相等值集合的左右边界的索引
     */
    public static int[] partition(int arr[],int L,int R){
        int less = L -1; //小于pivot左边开始的索引  pivot 基准值
        int more = R;  // 大于pivot右边开始的索引
        while(L<more){   // 由左向右循环
           if(arr[L] < arr[R]){  // 基准值为 arr[R]
               swap(arr,++less,L++); // 当左边arr[L]小于基准值，交换一次位置到左边集合（小于基准值的值），并向前走一步
           }else if(arr[L] > arr[R]){
               swap(arr,--more,L); // 当左边arr[L]大于基准值，交换一次位置右边集合（大于基准值的值），指针不动
           }else{
               L++; // 当和基准值相等时，向前走
           }
        }
        swap(arr,more,R); //由于 pivot 包含在右边集合中。做一次交换
        return new int[]{less+1,more};
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] arr = {3,1,7,34,24,45};
//        quickSort(arr);
//        printArray(arr);

        int[] arr1 = generateRandomArray(100, 100);
        printArray(arr1);
        quickSort(arr1);
        printArray(arr1);
    }

}
