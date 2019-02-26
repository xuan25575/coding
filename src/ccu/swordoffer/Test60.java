package ccu.swordoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Test60 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        int layer=1;
        Stack<TreeNode> s1 = new Stack<>();  //s1存奇数层节点
        s1.push(pRoot);
        Stack<TreeNode> s2 = new Stack<>(); //s2存偶数层节点
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while(!s1.empty() || !s2.empty()){
            if(layer%2!=0){
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if(node != null){
                        temp.add(node.val);
                        System.out.println(node.val);
                        s2.push(node.left); //注意
                        s2.push(node.right);
                    }
                }
                if(!temp.isEmpty()){
                    result.add(temp);
                    layer++;
                    System.out.println();
                }

            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if(node!= null){
                        temp.add(node.val);
                        System.out.println(node.val);
                        s1.push(node.right); //注意
                        s1.push(node.left);
                    }
                }
                if(!temp.isEmpty()){
                    result.add(temp);
                    layer++;
                    System.out.println();
                }
            }
        }
        return result;
    }
}
