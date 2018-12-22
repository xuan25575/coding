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


    public static int getFirstK(int[] arr,int k ,int lo,int hi){
        if(lo > hi ){
            return -1 ;
        }
        int mid = (hi+lo)/2;
        if(arr[mid] == k){
            if((k > 0 && k != arr[mid-1]) || mid == 0 ){
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

    public static int getLastK(int[] arr,int k ,int lo,int hi){
        if(lo > hi){
            return -1 ;
        }
        int mid = (hi+lo)/2;
        if(arr[mid] == k){
            if((k < arr.length-1 && k != arr[mid+1]) || mid == arr.length-1 ){
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
