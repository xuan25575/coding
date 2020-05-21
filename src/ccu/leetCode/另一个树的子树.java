package ccu.leetCode;

/**
 * @Author huang_2
 * @Date 2020/5/7 12:24 上午
 * @Description
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 *
 *  和剑指offer test18 是否是子结构还是不一样的。
 */
public class 另一个树的子树 {




    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null )return false ;
        // 先检查头节点， 在检查左子树， 在检查右子树
        return check(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }


    /**
     *
     * @param s 较大的树
     * @param t 较短的树
     * @return
     */
    public boolean check(TreeNode s, TreeNode t){
        if(s==null && t==null) return true;
        if(s== null|| t== null) return false;
        if(s.val != t.val) return false;
        return check(s.left,t.left) && check(s.right,t.right);

    }





}
