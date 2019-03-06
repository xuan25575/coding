package ccu.common.algorithms.sort;

/**
 * 堆排序（英语：Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆是一个近似完全二叉树的结构，并同时满足
 * 堆积的性质：即子节点的键值或索引总是小于（或者大于）它的父节点。
 *  父节点i的左子节点在位置 (2i+1)
 *  父节点i的右子节点在位置 (2i+2)
 *  子节点i的父节点在位置 floor((i-1)/2)
 *  leftNo = parentNo*2+1
 *  rightNo = parentNo*2+2
 *  parentNo = (nodeNo-1)/2
 * 思路: 构建大根堆，交换首尾，堆Size减一 调整大根堆  循环遍历。
 */
public class HeapSort {
    public static  void  headSort(int[] arr){
        if(arr == null || arr.length <2){
            return;
        }
        //插入堆 并构建初始化大根堆。
        for(int i = 0;i<arr.length;i++){
            insertHeap(arr,i);
        }
        int heapSize = arr.length; // 注意：heapSize 是arr.length
        swap(arr,0,--heapSize);
        while(heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    /**
     *  插入堆。
     * @param arr
     * @param index
     */
    public static void insertHeap(int[] arr,int index){
        while(arr[index] > arr[(index -1)/2]){  //index -1)/2 求给定下标为index 的父节点
            swap(arr,index,(index-1)/2);
            index = (index -1)/2;
        }
    }

    /**
     *  将堆调整成大根堆，
     * @param arr
     * @param index  数组下标索引
     * @param heapSize  堆长度
     */
    public static void heapify(int[] arr,int index,int heapSize){
        int left  = index *2 +1; // 取得index节点左子节点。
        while(left < heapSize){
            int largest = left+1 < heapSize && arr[left+1] > arr[left] ? left+1 : left; //比较左右两个节点取得较大的节点的索引
            largest =  arr[largest] > arr[index] ? largest:index; //  和index节点比较取得较大值的索引
            if(largest == index){ // 如果和根节点相等 跳出循环
                break;
            }
            swap(arr,largest,index); // 交换位置开始 子树往下比较，
            index = largest;
            left = index*2-1;
        }
    }

    public static void swap(int[] arr,int i,int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[]  generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int)(Math.random()*(maxSize+1))];
        for(int i =0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*(maxValue+1)) - (int)(Math.random()*maxValue);
        }
        return arr;
    }
    public static void printArray(int[] arr){
        if(arr == null){
            return;
        }
        for (int i  = 0; i  <arr.length ; i ++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        System.out.println(Math.floor(4.8));
        int[] arr = generateRandomArray(100, 100);
        printArray(arr);
        headSort(arr);
        printArray(arr);

    }
}
