package ccu.swordoffer;

/**
 *
 * 题目一：输入一棵二叉树的根结点，求该树的深度。
 * 从根结点到叶子点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Test39 {
        public static class Node {
            public int value;
            Node left;
            Node right;
            public Node(int data) {
                this.value = data;
            }
        }
    public static  int treeDepth(Node head){
        if(head == null ){
            return 0;
        }
        int left = treeDepth(head.left);
        int right = treeDepth(head.right);
        return left > right ? (left +1) : (right+1);
    }
}
