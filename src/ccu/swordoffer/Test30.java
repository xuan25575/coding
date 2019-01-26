package ccu.swordoffer;

/**
 * 题目： 输入n个整数，找出其中最小的k个数。
 * 例如输入 4 、5 、1、6、2、7、3 、8 这 8 个数字，
 *    则最小的 4 个数字是 1 、2、3 、4
 */
public class Test30 {

    public static int[] getLeastKthInArr(int[] arr,int  k){
        if(arr == null || arr.length < 1 || k > arr.length || k <= 0){
            return null;
        }
       int index =  partition2(arr,0,arr.length-1);
        while(index != k-1){
            if(index > k-1){
                index = partition(arr,0,index-1);
            }else{
                index =partition(arr,index+1,arr.length-1);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    public static int partition(int[] arr,int start,int end){
     //   int pivotIndex = (int)(Math.random()*arr.length);
//        int pivotIndex = start;
        int pivot = arr[start];  // 开始位置选取很重要
      //  swap(arr,pivotIndex,end);
        int low = start;
        int high = end;
        while(low < high){
            // 因为把pivot放在了开始位置，所以hi指针先走
            while (low <high && arr[high] >= pivot) high--;
            while (low<high && arr[low] <= pivot) low++;
            swap(arr,low,high);
        }
      //  swap(arr,low,end);
        swap(arr,low,start); // 交换 pivot 值
        return low;
    }


    public static int partition2(int[] arr, int lo, int hi) {
        if (arr==null || arr.length<=0 || lo<0 || hi>=arr.length){
            throw new RuntimeException("输入有误");
        }
        int small = lo;
        //以arr[hi]为基准 划分
        for (int i = lo; i < hi; i++) {
            if (arr[i] <= arr[hi]){
                swap(arr, i, small++);
            }
        }
        swap(arr, hi, small);
        return small;
    }
    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        int[] res = getLeastKthInArr(arr, k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
