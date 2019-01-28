package ccu.swordoffer;

/**
 * 题目：统计一个数字：在排序数组中出现的次数。
 * 例如输入排序数组｛ 1, 2, 3, 3, 3, 3, 4, 5｝和数字 3 ，
 *      由于 3 在这个数组中出现了 4 次，因此输出 4 。
 */
public class Test38 {


    public static int getNumberOfK(int[] arr,int k){
        if(arr== null || arr.length == 0){
            return -1;
        }
        int first = getFirstK(arr,k,0,arr.length-1);
        int last = getLastK(arr,k,0,arr.length-1);
        int num = 0;
        if(first > -1  &&last > -1){
           num =  last -first+1;
        }
        return num;
    }


    /**
     *  查找最后一个K 二分查找
     * @param arr
     * @param k
     * @param lo
     * @param hi
     * @return  返回索引
     */
    public static int getFirstK(int[] arr,int k ,int lo,int hi){
        if(lo > hi ) return -1 ;
        int mid = (hi+lo) >> 1;
        if(arr[mid] == k){
            if((mid > 0 && k != arr[mid-1]) || mid == 0 ){
                return mid;
            }else{
                hi = mid -1;
            }
        }else if (arr[mid] > k){
            hi = mid -1;
        }else{
            lo = mid+1;
        }
        return getFirstK(arr,k,lo,hi);
    }

    /**
     *  查找最后一个K  二分查找
     * @param arr 数组
     * @param k  查找关键字
     * @param lo  最低
     * @param hi  最高
     * @return 最后一个 K
     */
    public static int getLastK(int[] arr,int k ,int lo,int hi){
        if(lo > hi) return -1 ;
        int mid = (hi+lo)/2;
        if(arr[mid] == k){
            if((mid < arr.length-1 && k != arr[mid+1]) || mid == arr.length-1 ){
                return mid;
            }else{
                lo = mid + 1;
            }
        }else if (arr[mid] > k){
            hi = mid -1;
        }else{
            lo = mid + 1;
        }
        return getLastK(arr,k,lo,hi);
    }

    public static void main(String[] args) {
        // 查找的数字出现在数组的中间
        int[] data1 = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data1, 3)); // 4
        int[] data6 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data6, 0)); // 0
    }

}
