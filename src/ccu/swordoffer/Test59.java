package ccu.swordoffer;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 思路：如果先序遍历的顺序分为两种先左后右和先右后左两种顺序遍历，如果两者相等说明二叉树是对称的二叉树
 */
public class Test59 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }


    //递归版
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null) return true;
        return  isSymmetrical(pRoot,pRoot);
    }
    boolean isSymmetrical(TreeNode root1,TreeNode root2) {
        if(root1==null && root2 ==null) return true;
        if(root1!= null  && root2 != null){
            return (root1.val == root2.val)
                    && isSymmetrical(root1.left,root2.right) && isSymmetrical(root1.right,root2.left);
        }
        return false;
    }
    // 写法
    boolean isSymmetrical2(TreeNode root1,TreeNode root2) {
        if(root1==null && root2 ==null) return true;
        if(root1==null || root2 ==null) return false;
        if(root1.val != root2.val){
            return false;
        }
        return isSymmetrical(root1.left,root2.right) && isSymmetrical(root1.right,root2.left);
    }
}

