package ccu.swordoffer;

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

    public static int inversePairsCore(int[] arr, int[] aux, int lo, int hi) {
        if (lo == hi) {
            return 0;
        }
        int mid = lo +(hi-lo)/2;
        int left = inversePairsCore(aux, arr, lo, mid);
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

}






