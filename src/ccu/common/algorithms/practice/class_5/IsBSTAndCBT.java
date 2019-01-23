package ccu.common.algorithms.practice.class_5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵二叉树是否是搜索二叉树
 *
 *  解： 通过二叉树中序遍历 判断 是否递增的
 *
 * 判断一棵二叉树是否是完全二叉树
 *  概念：
 * 【完全二叉树】: 若对于深度为K的，有n个结点的二叉树，
 *  当且仅当其每一个结点都与深度为K的满二叉树中编号从1至n的结点一一对应时称之为完全二叉树
 *
 *  若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，
 *   第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
 *
 *   解：如果树不为空：层序遍历二叉树
 *   1> 如果一个结点左右孩子都不为空，则pop该节点，将其左右孩子入队列；
 *   2> 如果遇到一个结点，左孩子为空，右孩子不为空，则该树一定不是完全二叉树；
 *   3> 如果遇到一个结点，左孩子不为空，右孩子为空；或者左右孩子都为空；
 *   则该节点之后的队列中的结点都为叶子节点；该树才是完全二叉树，否则就不是完全二叉树；

 */
public class IsBSTAndCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int data) {
            this.value = data;
        }
    }
    //使用Morris 中序遍历
     public static boolean isBST(Node head){
         if(head == null){
             return  false;
         }
         Node cur1= head;
         Node cur2= null;
         Node pre = null;
         boolean result = true;
         while(cur1!= null){
             cur2 = cur1.left;
             if(cur2 != null){
                 while(cur2.right != null && cur2.right != cur1){
                     cur2 = cur2.right;
                 }
                 if(cur2.right == null){
                     cur2.right = cur1;
                     cur1 =cur1.left;
                     continue;
                 }else{
                     cur2.right = null;
                 }
             }
             if(pre!= null && pre.value > cur1.value){
                 result =  false;
             }
             pre = cur1;
             cur1 = cur1.right;
         }
         return result;
     }

     // 层级遍历
     public static boolean isBCT(Node head){
         if(head == null){
             return false;
         }
         Queue<Node> que = new LinkedList<>();
         Node l = null;
         Node r = null;
         boolean leaf= false;
         que.offer(head);
         while (head != null){
             head = que.poll();
             l =head.left;
             r =head.right;
             if((leaf && (l != null|| r!= null) ) || (l == null && r!= null) ){
                 return false;
             }
             if(l!= null){
                 que.offer(l);
             }
             if(r!= null){
                 que.offer(r);
             }else{ // 开启一种模式 剩下的都是叶子节点
                 leaf = true;
             }
         }
         return true;
     }
}
