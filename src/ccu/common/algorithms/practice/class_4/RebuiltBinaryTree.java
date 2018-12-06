package ccu.common.algorithms.practice.class_4;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 二叉树的后序遍历和中序遍历重建二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不包含重复的数字。
 * 例如输入前序遍历序列{1， 2， 4， 7， 3， 5， 6， 8}和中序遍历序列{4， 7， 2， 1，5， 3， 8， 6}，
 * 则重建出二叉树并输出它的头结点。
 */
public class RebuiltBinaryTree {
    public static class BinaryTreeNode{
        private int value;
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        public BinaryTreeNode(int data){
            this.value = data;
        }
    }

    /**
     *
     * @param pre  先序遍历的数组
     * @param in  中序遍历的数组
     * @return  重建后的头节点
     */
    public static BinaryTreeNode  preInToTree(int[] pre, int[] in){
        if(pre == null || in == null){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return preIn(pre,0,pre.length-1,in,0,in.length-1,map);
    }

    /**
     *
     * @param p  先序遍历的数组
     * @param pi 开始的位置
     * @param pj 结束的位置
     * @param n  中序遍历的数组
     * @param ni 开始的位置
     * @param nj 结束的位置
     * @param map 辅助结构
     * @return
     */
    public static BinaryTreeNode  preIn(int[] p,int pi,int pj,int[] n,int ni,
                                        int nj,HashMap<Integer,Integer> map){
        if(pi >pj){
            return null;
        }
        BinaryTreeNode head = new BinaryTreeNode(p[pi]);  // 设置头节点
        int index = map.get(p[pi]); // 取得中序遍历中根节点的下标
        // 递归构建树  index-ni这个为树的左子树节点数量的个数
        head.left = preIn(p,pi+1,pi+index-ni,n,ni,index-1,map);
        head.right = preIn(p,pi+index-ni+1,pj,n,index+1,nj,map);
        return head;
    }

    /**
     *
     * @param in 中序遍历的数组
     * @param pos 后序遍历的数组
     * @return 重建后的头节点
     */
    public static BinaryTreeNode  inPosToTree(int[] in , int[] pos){
        if(pos == null || in == null){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return inPos(in,0,in.length-1,pos,0,pos.length-1,map);
    }

    /**
     *
     * @param n  中序遍历的数组
     * @param ni 开始的位置
     * @param nj 结束的位置
     * @param s  后序遍历的数组
     * @param si 开始的位置
     * @param sj 结束的位置
     * @param map 辅助结构
     * @return 头节点
     */
    public static BinaryTreeNode  inPos(int[] n,int ni,
                                        int nj,int[] s ,int si,int sj,HashMap<Integer,Integer> map){
        if(si >sj){
            return null;
        }
        BinaryTreeNode head = new BinaryTreeNode(s[sj]);  // 设置头节点
        int index = map.get(s[sj]); // 取得中序遍历中根节点的下标
        // 递归构建树
        head.left = inPos(n,ni,index-1,s,si,si+index-ni-1,map);
        head.right = inPos(n,index+1,nj,s,si+index-ni,sj-1,map);
        return head;
    }



    public static void printInOrderTree(BinaryTreeNode node){
        if(node != null){
            printInOrderTree(node.left);
            System.out.print(node.value+" ");
            printInOrderTree(node.right);
        }
    }


    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        int[] posOrder = {7,4, 2, 5, 8, 6, 3, 1};
        BinaryTreeNode node = inPosToTree(inOrder, posOrder);
        printInOrderTree(node);
    }
}
