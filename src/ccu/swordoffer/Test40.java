package ccu.swordoffer;

/**
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次，请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是 O(n)，空间复杂度是 O(1)。
 *  * 例如输入数组｛2, 4, 3, 6, 3, 2, 5 }，
 *     因为只有 4 、6 这两个数字只出现一次，其他数字都出现了两次，
 *     所以输出 4 和 6
 *
 *    因为异或：相同为0，不同为1
 *    1.假如数组中只有1个数字只出现过一次，其他的都出现了两次，怎么找到它？
 *    所以我们可以从头到尾依次异或数组中的每一个数字，最终的异或结果刚好是只出现一次的那个数字。那些成对出现的两个数字刚好在异或中抵消了
 *
 */
public class Test40 {

    public static void main(String[] args) {

        int[] data1 = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] result1 = findNumAppearOnce(data1);
        System.out.println(result1[0] + " " + result1[1]);
//        int xor = 0;
//        for (int i : data1) {
//            xor = xor^ i;
//        }
//        System.out.println(xor);

        int[] data3 = {4, 6, 1, 1, 1, 1};
        int[] result3 = findNumAppearOnce(data3);
        System.out.println(result3[0] + " " + result3[1]);

    }
    /**
     *   那数组中又两个只出现一次的数字呢？
     *      我们可以把大数组分成两个子数组啊，每个子数组中都只有1个只出现一次的数字。*
     * @param arr 数组
     * @return
     */
    public static int[] findNumAppearOnce(int[] arr){
        if(arr== null ||  arr.length < 2){
            return null;
        }
        int resultExclusiveOr =0;
        for (int i = 0; i < arr.length; i++) {
            resultExclusiveOr ^= arr[i];
        }
        int indexOf1 = findFirstBitIs1(resultExclusiveOr);
        int[] res = new int[2];   // 用来接受结果
        for (int i = 0; i < arr.length; i++) {
            // 通过indexOf1这个位置将两个不同的只出现一次的数字分到两个数组中。
            // 而且成对的数字在一个数字中， 因为两个数字相同他们的各个位都相同。
            if(isBit1(arr[i],indexOf1)==1){
                res[0] ^=arr[i];
            }else{
                res[1] ^=arr[i];
            }
        }
        return res;
    }


    /**
     *  判断一个数字的2进制的indexOf1位是不是1
     * @param num  s数字
     * @param indexOf1  出现1 的 位置
     * @return
     */
    public static int isBit1(int num,int indexOf1){
        num = num >>indexOf1;
        return num & 1;
    }

    /**
     * 找到不同两个数字异或后的数字的2进制表示中出现第一个1 的位置
     * @param num  数字
     * @return
     */
    public static int findFirstBitIs1(int num){
        int index = 0;
        while((num & 1)==0 && index <32){
            num= num>>1;
            index++;
        }
        return index;
    }

}
