package ccu.leetCode;

/**
 * @Author huang_2
 * @Date 2020/4/29 9:05 上午
 * @Description TODO
 */
public class 山脉数组的峰顶索引 {


    public static int peakIndexInMountainArray(int[] A) {
        int len = A.length;
        if(len ==0) return -1;
        int left=0,right = len-1;
        while(left < right){ // 退出二分结果必然是 left == right
//            int mid = (left +right) /2;
            int mid = left + (right-left) /2; // 第一条当只有两个树只能取左边的数
//            int mid = left + (right-left+1) /2; // 第二条当只有两个树只能取右边边的数

            // 一定不是解
            if(A[mid] < A[mid+1]){
                left = mid+1;
            }else{
                right = mid; //  刚好 对应第一条【mid,right】 可能诞生 left == right
//                left = mid; // 刚好 对应第二条【left,mid】 细想
            }
        }
        return left;

    }

    public int peakIndexInMountainArray2(int[] A) {
        //二分查找;
        int left=0,right=A.length-1,mid;

        while(left<=right){
            mid=left+((right-left)>>1);
            if(A[mid]<A[mid-1]){
                right=mid-1;
            }else if (A[mid]<A[mid+1]){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,1};

        int i = peakIndexInMountainArray(arr);
        System.out.println(i);
    }
}
