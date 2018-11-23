package ccu.common.algorithms.sort;

/**
 * 桶排序（Bucket sort）或所谓的箱排序，是一个排序算法，工作的原理是将数组分到有限数量的桶里。
 * 每个桶再个别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序）。
 *
 *   1.设置一个定量的数组当作空桶子。
 *   2.寻访序列，并且把项目一个一个放到对应的桶子去。
 *   3.对每个不是空的桶子进行排序。
 *   4.从不是空的桶子里把项目再放回原来的序列中。
 *   注意：排序数组中出现负数会越界。
 */
public class BucketSort {

    public static void bucketSort(int[] arr){
        if(arr == null | arr.length <2){
            return;
        }
        //获取桶的数量   假如200 个数 拿201个桶
        int max = Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            max = Math.max(max,arr[i]);  //取得数组中最大值
        }
//        System.out.println(max);
        int[] buckets = new int[max+1]; //桶要做够放下你排序的数组的数量

         //2. 数放置到相应的桶中。
        for(int i=0;i<arr.length;i++){
            //桶排序出现负数怎么解决？？  出现下标越界。
            buckets[arr[i]]++;   // buckets[XX]++  统计每个数出现的数量
        }
        //3.每个不是空的桶子进行排序。
        int i = 0;
       for(int j=0;j<buckets.length;j++){
           while(buckets[j]-- > 0){  //buckets[j]--  ： 桶里面放置这个数的个数。 依次拿出
               arr[i++] = j;  //从不是空的桶子里把项目再放回原来的序列中。 完成排序  （下标即为要排序的数)。
           }
       }

    }

    public static void swap(int [] arr,int i,int j){
        int temp  = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }

    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr  = new int[(int)(Math.random()*(maxSize+1))];
        for(int i= 0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*(maxValue+1)) - (int)(Math.random()*maxValue);
        }
        return arr;
    }

    public static  void printArray(int[] arr ){
        if(arr == null){
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int [] a  = new int[10];
//        System.out.println(++a[2]);

//        int[] arr = generateRandomArray(100, 100);
        int[] arr  = {12,1,4,2,55,21,3,23,41};
        printArray(arr);
        bucketSort(arr);
        printArray(arr);
    }
}
