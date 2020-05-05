package ccu.swordoffer;

import com.sun.org.apache.bcel.internal.util.ClassQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    /**
     * 层序遍历  -- 队列实现
     * @param pRoot
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode pRoot) {

        List<List<Integer>> levels = new ArrayList<>();
        if(pRoot == null) return levels;
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点入队。
        queue.offer(pRoot);

        while(!queue.isEmpty()){
            List<Integer> list  = new ArrayList<>();
            //每一层都是节点 queue.size 个
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                System.out.println("层序遍历："+cur.val);
                if(cur.left!= null) {
                    queue.offer(cur.left);
                }
                if(cur.right !=null){
                    queue.offer(cur.right);
                }
            }
            levels.add(list);
        }
        return levels;
    }



    // 递归
   public ArrayList<ArrayList<Integer>> print1(TreeNode pRoot) {
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
