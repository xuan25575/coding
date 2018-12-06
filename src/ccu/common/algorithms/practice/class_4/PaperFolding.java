package ccu.common.algorithms.practice.class_4;

/**
 *  折纸问题
 *    【题目】
 *    请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开。此时
 *    折痕是凹下去的，即折痕突起的方向指向纸条的背面。如果从纸条的下边向上方连续对折2
 *    次，压出折痕后展开，此时有三条折痕，从上到下依次是下折痕、下折痕和上折痕。给定一
 *    个输入参数N，代表纸条都从下边向上方连续对折N次，请从上到下打印所有折痕的方向。
 *    例如：N=1时，打印：
 *    down
 *    N=2时，打印：
 *    down
 *    down
 *    up
 *
 *    要点： 折痕其实是二叉树结构。该二叉树的特点是：根节点是下，每一个树的左节点是下，
 *    右节点是上。该二叉树的中序遍历即为答案，但不需要构造一颗二叉树，用递归方法可打印出来。
 *    中序遍历
 *
 */
public class PaperFolding {

    public static void paperFolds(int N){
        foldProcess(1,N,true);
    }

    /**
     *
     * @param i  折到第几次
     * @param N  需要折多少次
     * @param down  桶过Boolean 控制 左右子树
     */
    public static void foldProcess(int i,int N ,boolean down){
        if(i > N){
            return;
        }
        foldProcess(i+1,N,true);  // true  --> down  对应树左节点
        System.out.print(down ? "down ": "up " );
        foldProcess(i+1,N,false); // false  --> up  对应树右节点
    }

    public static void main(String[] args) {
        paperFolds(2);

    }
}
