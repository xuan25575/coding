package ccu.leetCode;

import java.util.Stack;

/**
 * @Author huang_2
 * @Date 2020/5/5 11:37 上午
 * @Description TODO
 */
public class 验证二叉搜索树2 {

    private double pre = - Double.MAX_VALUE;

    /**
     * 递归实现
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val <= pre){
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

    /**
     * 非递归实现
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        double preVal = -Double.MAX_VALUE;
        while(!stack.isEmpty() || root != null){
            if(root!= null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                if(root.val <= preVal){
                    return false;
                }
                preVal = root.val;
                root = root.right;
            }
        }
        return true;
    }
}
