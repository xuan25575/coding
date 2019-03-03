package ccu.swordoffer;

/**
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回 true。否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 * 二叉索索树特征 ： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 */
public class Test24 {


    public static boolean verifySequenceIsBST(int[] sequence){
        if(sequence == null || sequence.length== 0)  return false;
        return verifySequenceIsBST(sequence,0,sequence.length-1);
    }
    /**
     *
     * @param sequence  序列
     * @param start  开始的位置
     * @param end  结束的位置
     * @return
     */
    public static boolean verifySequenceIsBST(int[] sequence,int start,int end){
        if (start >= end) return true; // 递归结束条件
        int root = sequence[end];
        int i = 0;
        for (;i < end; i++) {
            if(sequence[i] > root)  break; // 找到第一个大于 根节点的值。
        }
        for (int j = i; j < end ; j++) {    // i-1即为左子树的根的值的下标  在 for完后i++， 故 j=i右子树第一个节点
            if(sequence[j] < root) return false; // 右子树节点的值 比根 的值 小 错误
        }
        return verifySequenceIsBST(sequence,start,i-1) && verifySequenceIsBST(sequence,i,end-1);
    }

    public static void main(String[] args) {

        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16
        int[] squence = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + verifySequenceIsBST(squence));

        int[] squence6 = {7, 4, 6, 5};
        System.out.println("false: " + verifySequenceIsBST(squence6));
    }

}
