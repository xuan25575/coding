package ccu.leetCode;

/**
 * @Author huang_2
 * @Date 2020/4/29 9:29 上午
 * @Description  leetcode 1095
 *   特别注意：3 个辅助方法的分支出奇地一样，因此选中位数均选左中位数，才不会发生死循环
 */
public class 山脉数组中查找目标值 {


    /**
     * 解
     * @param target
     * @param mountainArr
     * @return
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();

       // 步骤 1：先找到山顶元素所在的索引
        int mountaintopIndex = findMountaintop(mountainArr, 0, length - 1);
        // 步骤 2：在前有序且升序数组中找 target 所在的索引
        int i = findFromSortedArr2(mountainArr, 0, mountaintopIndex, target);
        if(i != -1){
            return i;
        }
        // 步骤 3：如果步骤 2 找不到，就在后有序且降序数组中找 target 所在的索引
        return findFromInverseArr(mountainArr, mountaintopIndex, length - 1, target);

    }





        /**
         *  在后有序且降序数组中找 target 所在的索引
         * @param mountainArr
         * @param l
         * @param r
         * @param target
         * @return
         */
    private int findFromInverseArr(MountainArray mountainArr, int l, int r, int target) {

        while(l < r){
            int mid = l + (r-l)/2;
            // 一定不是解
            if(mountainArr.get(mid) > target){
                l = mid+1;
            }else{
                r =mid ; // [mid,r];
            }
        }
        if(mountainArr.get(l)==target){
            return l;
        }
        return -1;

    }




    /**
     *   在前有序且升序数组中找 target 所在的索引
     * @param mountainArr
     * @param l
     * @param r
     * @param target
     * @return
     *
     *
     */
    private int findFromSortedArr(MountainArray mountainArr, int l, int r, int target) {
        while(l < r){ // 这种叫排除法
            int mid = l +(r-l)/2 ;

            // 一定不是解
            if(mountainArr.get(mid) <  target){
                l = mid+1;
            }else {
                r = mid; // [mid r];
            }
        }
         // 因为不确定区间收缩成 1个数以后，这个数是不是要找的数，因此单独做一次判断
        if(mountainArr.get(l) == target){
            return l;
        }
        return -1;
    }

    private int findFromSortedArr2(MountainArray mountainArr, int l, int r, int target) {
        while(l <= r){
            int mid = l +(r-l)/2 ;
            if(mountainArr.get(mid) < target){
                l = mid+1;
            }else if(mountainArr.get(mid) > target){
                r = mid-1;
            }else if(mountainArr.get(mid) == target){
                return mid;
            }
        }
        return -1;

    }




    /**
     * 山顶元素 index
     * @param mountainArr
     * @param l
     * @param r
     * @return
     */
    private int findMountaintop(MountainArray mountainArr, int l, int r) {

        while(l < r){
            int mid =  l + (r-l)/2 ;
            // 一定不是解
            if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                l = mid+1;
            }else{
                r = mid;// [mid,r] 可出现 mid =r；
            }
        }
         // 根据题意，山顶元素一定存在，因此退出 while 循环的时候，不用再单独作判断
        return r;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 8;
        MountainArray mountainArray = new MountainArray(arr);

        山脉数组中查找目标值 solution = new 山脉数组中查找目标值();
        int res = solution.findInMountainArray(target, mountainArray);
        System.out.println(res);

    }



}


class MountainArray {

    private int[] arr ;
    public MountainArray(int[] arr) {
        this.arr  =arr ;
    }

    int get(int index){
        return arr[index];

     }
     int length(){
        return arr.length;
     }
}