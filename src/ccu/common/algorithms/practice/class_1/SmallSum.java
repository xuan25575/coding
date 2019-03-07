package ccu.common.algorithms.practice.class_1;

/**
 * 一个数列，其中一个数p，其左边所有比p小的数的和，是数p的小和。
 * 求这个数列所有数的小和之和。
 *  思路：
 *  用归并排序的思路，在merge 过程中求出每个数列的小和。
 *
 *  1、首先划分划分划分，一直划分到不能划分，即每个组都只有一个数值。
 *  2、然后合并，合并的过程就是每个二划分排序的过程。
 *  3、在合并的时候，开辟一个辅助数组，其大小等于这两个合并数列的大小。
 *  4、设置两个指针分别指向每个数列的首部，然后比较得到其中较小的值，并将这个值放入辅助数组中。
 *     然后取出小值的那个数列的指针可以继续向前走，与另一个数列的指针所指向的值继续比较。
 *  5、这样比较完成后，如果两个数列中有个数列的数值有剩余，即其指针没有走到末尾，
 *     则将这个数列直接赋到辅助数组末尾即可。
 *  6、然后将辅助数组中的值拷贝回原数组中刚才合并的那两个数列的位置上。
 *
 *  可对比：  sword offer Test36
 */
public class SmallSum {

    public static int smallSum(int [] arr){
        if(arr == null || arr.length <2){
            return 0;
        }
       return mergeSortToSmallSum(arr,0,arr.length-1);
    }

    /**
     *
     * @param arr
     * @param L  左边界
     * @param R  右边界
     * @return
     */
    public  static int  mergeSortToSmallSum(int [] arr,int L,int R){
        if(L == R ){
            return 0;
        }
        int mid = L +(R-L)/2;
        return mergeSortToSmallSum(arr,L,mid) + mergeSortToSmallSum(arr,mid+1,R) + merge(arr,L,mid,R); //将每一部分和相加。
    }
    public static int merge(int[] arr,int L,int mid,int R){
        int p1 = L;
        int p2 =mid+1;
        int i  = 0; //
        int[] help  = new int[R -L +1];
        int result = 0; // 小和结果
        while(p1 <= mid && p2 <= R){
            result += arr[p1] < arr[p2]? (R-p2+1)*arr[p1]:0;  // 关键：求小和思路 R-p2+1（得到比arr[p1]这个数大的个数）*arr[p1]
            help[i++] = arr[p1] < arr[p2] ? arr[p1++]:arr[p2++];
        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= R){
            help[i++] = arr[p2++];
        }
        for ( i = 0; i < help.length; i++) {
            arr[L+i] = help[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,1,5};
        int result = smallSum(arr);
        System.out.println(result);
    }

}
