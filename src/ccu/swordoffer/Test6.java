package ccu.swordoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}
 * 和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Test6 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || in.length ==0 ) return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
       return  reConstructBinaryTreeCore(pre,0,pre.length-1,in,0,in.length-1,map);
    }
    public TreeNode reConstructBinaryTreeCore(int[] pre,int i,int j ,int[] in, int m,int n,Map<Integer,Integer> map){
        if(i >j) return null;
        TreeNode root = new TreeNode(pre[i]);
        int index = map.get(pre[i]);
        root.left = reConstructBinaryTreeCore(pre,i+1,index -m+i,in,m,index-1,map);
        root.right = reConstructBinaryTreeCore(pre,index -m+i+1,j,in,index+1,n,map);
        return root;
    }
}
