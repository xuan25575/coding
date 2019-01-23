package ccu.common.algorithms.practice.class_5;

/**
 * 判断一棵树是否是平衡二叉树
 * 解：套路解法  树形DP  设计结构 收集信息
 */
public class IsBalancedTree {

    public static class Node{
        public Integer value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }

    // 设计一个结构整合   树的高度  是否是平衡二叉树
    public static class ReturnType{
        public boolean isB;
        public int h;
        public ReturnType(boolean isB,int h){
            this.isB = isB;
            this.h = h;
        }
    }


    public static ReturnType process(Node head){
        if(head == null){
            return new ReturnType(true,0);
        }
        ReturnType leftReturnType = process(head.left);
        if(!leftReturnType.isB){
            return new ReturnType(false,0);
        }
        ReturnType rightReturnType = process(head.right);
        if(!rightReturnType.isB){
            return new ReturnType(false,0);
        }
        if(Math.abs(leftReturnType.h - rightReturnType.h) > 1){
            return new ReturnType(false,0);
        }
        return new ReturnType(true,Math.max(leftReturnType.h,rightReturnType.h)+1);
    }

    public static boolean isBalance(Node head){
        return process(head).isB;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));

    }
}
