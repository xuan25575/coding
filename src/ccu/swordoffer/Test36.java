package ccu.swordoffer;

import java.util.Arrays;

/**
 *  题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * 例如在数组｛7, 5, 6, 4}中，
 * 一共存在 5 个逆序对，分别是（7, 6）、（7，5），(7, 4）、（6, 4）和（5, 4）。
 *
 * 【解】：归并排序的思想
 *  在把数组分成1个1个的数字之后，开始合并的过程中：
 *  - 两个{1个数的数组}开始合：
 *          只要第1个数比第2个数大，cnt++;
 *  - 两个{2个数的数组}开始合：
 *      p1：指向第一个数组的末尾
 *      p2：指向第二个数组的末尾
 *      p3：指向合并的{4个数的}大数组的末尾
 *          p1>p2： cnt+=2，aux[p3--] = aux[p1--],
 *          p1<=p2：cnt不变, aux[p3--] = aux[p2--],
 *  - 两个{4个数的数组}开始合：
 */
public class Test36 {



   /**
    *1.在每次的操作中，数值的比较都是采用当前传入函数中第一项，也就是data；比较的结果都存放到copy中；也就意味着此时copy中是经过此次调用的结果。
     2.从最底层返回时，进入了(start == end)的情形，data 和 copy 完全没有修改，此时copy和data还是一样的。
     3.进入倒数第二层时，程序进入42行以后部分，copy是部分排序后的新数组，data是旧数组。----------注意这里都是传值的调用，数组都是直接修改的。----------
       倒数第二层使用的copy其实是倒数第三层中的data,这就确保了倒数第三层进入42行以后时，数据比较使用的data是最新排序的数组。
     4. 倒数第三层将排序的结果存入copy中。程序在倒数第四层进入42行后，使用的data数组为刚刚倒数第三层中的最新排序的copy.
     5. 也就是说，在每次程序进入42行时，此时的data是最新的排序结果，copy是次新的结果。
        在最后一次进入42行以后时，copy为完整排序后的结果，data是次新的结果。
        然而这里第一个类内函数调用第二个函数时，data和copy的顺序没有改变，所以最后结果应该copy是完整排序的结果.data是差一步完成排序的结果。
        以输入[7,5,6,4], 最后的结果copy[4,5,6,7], data[5,7,4,6].*/
    public static int inversePairsCore(int[] arr, int[] aux, int lo, int hi) {
        if (lo == hi) {
            return 0;
        }
        int mid = lo +(hi-lo)/2;
        int left = inversePairsCore(aux, arr, lo, mid);// 保证代码 arr数组中 在递归中排好序。 传递只是引用。
        int right = inversePairsCore(aux, arr, mid + 1, hi);
        // 两个指针
        int p1 = mid; //前半部分的末尾
        int p2 = hi; // 后半部分的末尾
        int p3 = hi;  // 辅助数组的复制
        int cnt = 0; // 逆序对数的统计
        while (p1 >= lo && p2 >= mid+ 1) {
            if (arr[p1] > arr[p2]) { // 存在逆序对
                cnt += (p2 - mid); // p2 之前的都是小于 p[p1]的数(归并过程中（p2 - mid）排序了)  统计逆序对数
                aux[p3--] = arr[p1--];
            } else {
                aux[p3--] = arr[p2--]; // 加入p2 的值  顺便再辅助数组排序
            }
        }
        while (p1 >= lo) {
            aux[p3--] = arr[p1--];
        }
        while (p2 >= mid + 1) {
            aux[p3--] = arr[p2--];
        }
        return cnt + left + right;
    }


    private static int inversePairs(int[] arr) {
        if (arr == null || arr.length <= 0) {
            throw new IllegalArgumentException("args should not be null or empty");
        }
        int[] aux = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            aux[i ]  = arr[i];
        }
//        int[] copyOf = Arrays.copyOf(arr, arr.length);
        return inversePairsCore(arr, aux, 0, arr.length - 1);
    }


    public static void main(String[] args) {
        int[] data7 = {1, 2, 1, 2, 1};
        System.out.println(inversePairs(data7)); // 3

//        for (int i = 0; i < data7.length; i++) {
//            System.out.print(data7[i]+" ");
//        }


//        int[] data6 = {2, 1};
//        System.out.println(inversePairs(data6)); // 1
//
//        int[] data = {1, 2, 3, 4, 7, 6, 5};
//        System.out.println(inversePairs(data)); // 3
//
        int[] data2 = {6, 5, 4, 3, 2, 1};
        System.out.println(inversePairs(data2)); //  15

    }

     // 方式二
    class Solution {
        //记录答案
        private int res = 0;
        public int reversePairs(int[] nums) {
            int len = nums.length;

            //为了不改变原数组 新copy个数组进行计算
            int[] copy = new int[len];
            for(int i=0;i<len;i++){
                copy[i]=nums[i];
            }

            //归并排序
            mergeSort(copy,0,len-1);
            return res;
        }

        /**
         *nums 待排序数组
         *left 当前待排序区间的左下标
         *right 当前待排序区间的右下标
         */
        private void mergeSort(int[] nums,int left,int right){
            if(left>=right)return;

            //求中点 划分左右两个区间 递归排序
            int mid = (left+right)/2;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);

            //利用一个tmp辅助数组 开始对左右两个排序后的区间合并
            int l = left,r=mid+1,cur=0;
            int[] tmp = new int[right-left+1];
            while(l<=mid&&r<=right){
                //左边区间数小于等于右边 左边先放入tmp 并更新左边指针
                if(nums[l]<=nums[r]){
                    tmp[cur]=nums[l++];
                    //相对于正常归并排序多出的一个步骤 计算有多少个逆序对
                    res+=r-(mid+1);
                }else{
                    tmp[cur]=nums[r++];
                }
                cur++;
            }
            //如果右边节点先到右区间边界导致上边while退出
            while(l<=mid){
                tmp[cur++]=nums[l++];
                //相对于正常归并排序多出的一个步骤 计算有多少个逆序对
                res+=r-(mid+1);
            }
            while(r<=right){
                tmp[cur++]=nums[r++];
            }

            //将待排序数组 当前排好序的left~right区间重新赋值
            for(int i=0;i<tmp.length;i++){
                nums[left+i]=tmp[i];
            }

        }
    }



    // 方式三
    public class Solution3 {

        public int reversePairs(int[] nums) {
            int len = nums.length;

            if (len < 2) {
                return 0;
            }

            int[] copy = new int[len];
            for (int i = 0; i < len; i++) {
                copy[i] = nums[i];
            }

            int[] temp = new int[len];
            return reversePairs(copy, 0, len - 1, temp);
        }

        /**
         * nums[left..right] 计算逆序对个数并且排序
         *
         * @param nums
         * @param left
         * @param right
         * @param temp
         * @return
         */
        private int reversePairs(int[] nums, int left, int right, int[] temp) {
            if (left == right) {
                return 0;
            }

            int mid = left + (right - left) / 2;
            int leftPairs = reversePairs(nums, left, mid, temp);
            int rightPairs = reversePairs(nums, mid + 1, right, temp);

            // 如果整个数组已经有序，则无需合并，注意这里使用小于等于
            if (nums[mid] <= nums[mid + 1]) {
                return leftPairs + rightPairs;
            }

            int crossPairs = mergeAndCount(nums, left, mid, right, temp);
            return leftPairs + rightPairs + crossPairs;
        }

        /**
         * nums[left..mid] 有序，nums[mid + 1..right] 有序
         *
         * @param nums
         * @param left
         * @param mid
         * @param right
         * @param temp
         * @return
         */
        private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
            for (int i = left; i <= right; i++) {
                temp[i] = nums[i];
            }

            int i = left;
            int j = mid + 1;

            int count = 0;
            for (int k = left; k <= right; k++) {
                // 有下标访问，得先判断是否越界
                if (i == mid + 1) {
                    nums[k] = temp[j];
                    j++;
                } else if (j == right + 1) {
                    nums[k] = temp[i];
                    i++;
                } else if (temp[i] <= temp[j]) {
                    // 注意：这里是 <= ，写成 < 就不对，请思考原因 ->稳定的排序，相同数字的位置不变
                    nums[k] = temp[i];
                    i++;
                } else {
                    nums[k] = temp[j];
                    j++;

                    // 在 j 指向的元素归并回去的时候，计算逆序对的个数，只多了这一行代码
                    count += (mid - i + 1);
                }
            }
            return count;
        }
    }

}






