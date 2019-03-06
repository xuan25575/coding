package ccu.swordoffer;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）  中，按结点数值大小顺序第三小结点的值为4。
 * 思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
 *      所以，按照中序遍历顺序找到第k个结点就是结果。
 *      二叉树中序遍历将数字加入数组。在数组中找K小的数
 */
public class Test63 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 必须要对每一个递归调用返回值进行判断if(node != null){return node;}，
     *    判断返回值是否为null，如果为null就说明在没找到，要继续执行index++ ; if(index == k){...}的寻找过程，
     *   如果返回不为空，则说明在递归调用判断子节点的时候已经找到符合要求的节点了，则将找到的节点
     *   逐层向上传递返回。直到返回到第一次调用KthNode的地方。
     *   如果不对递归调用的返回值做判断，即不执行if(node != null){return node;}，那所找到符合 要求的节点只能返回到上一层，
     *   不能返回到顶层（可以自己调试，然后观察方法栈的调用变化）
     */
    private int index = 0;
    TreeNode kthNode(TreeNode pRoot, int k) {
        if(pRoot == null)  return null;
        TreeNode node = kthNode(pRoot.left,k);
        if(node != null){
            return node;
        }
        index++;
        if(index == k){
            return pRoot;
        }
        node = kthNode(pRoot.right,k);
        if(node != null){
            return node;
        }
        return null;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        Test63 t = new Test63();
        System.out.println(t.kthNode(root,3).val);

    }
}
