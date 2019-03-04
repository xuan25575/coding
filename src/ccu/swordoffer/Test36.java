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






