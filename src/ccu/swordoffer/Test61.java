package ccu.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Test61 {
    public  static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    // 非递归实现
    //队列LinkedList完成层序遍历，用count记录每层结点数目
    ArrayList<ArrayList<Integer>> print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null) return list;
        Queue<TreeNode> layer = new LinkedList<>();// 关键是 队列LinkedList  完成层序遍历
        ArrayList<Integer> layerList  = new ArrayList<>();
        layer.add(pRoot);
        int count =1,n =0;
        while(!layer.isEmpty()){
            TreeNode cur = layer.remove();
            layerList.add(cur.val);
            n++;
            if(cur.left!= null) {
                layer.add(cur.left);
            }
            if(cur.right !=null){
                layer.add(cur.right);
            }
            if(n == count ){
                count = layer.size();// 记录下一层节点数量
                n = 0;
                list.add(layerList);
                layerList = new ArrayList<>();
            }
        }
        return list;
    }



    // 递归
    ArrayList<ArrayList<Integer>> print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot,1,list);
        return list;
    }

    // 如何保证层次遍历的。 通过depth 在先序遍历过程中知道每一个节点存储在哪个集合中。
    private void depth(TreeNode root,int depth,ArrayList<ArrayList<Integer>> list){
        if(root == null) return;
        if(depth > list.size()) // 判断条件很重要。涉及到list集合创建的个数。
            list.add( new ArrayList<Integer>());
        list.get(depth-1).add(root.val);
        depth(root.left,depth+1,list);
        depth(root.right,depth+1,list);
    }
}
