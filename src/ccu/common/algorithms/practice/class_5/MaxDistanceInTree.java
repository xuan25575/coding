package ccu.common.algorithms.practice.class_5;

/**
 *   二叉树中，一个节点可以往上走和往下走，那么从节点A总能走到节点
 *   B。
 *    节点A走到节点B的距离为：A走到B最短路径上的节点个数。
 *    求一棵二叉树上的最远距离
 *
 *    解：套路解法  树形DP  设计结构 收集信息
 */
public class MaxDistanceInTree {

    public static class Node{
        public Integer value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }

    // 设计一个结构整合   树的高度  每棵树的最大距离
    public static class ReturnType{
        public int maxDistance;
        public int h;

        public ReturnType(int maxDistance,int h){
            this.maxDistance = maxDistance;
            this.h = h;
        }
    }
    public static ReturnType process(Node head){
        if(head == null){
            return new ReturnType(0,0);
        }
        ReturnType leftReturnType = process(head.left);
        ReturnType rightReturnType =  process(head.right);
        int includeHeadDistance = leftReturnType.h + rightReturnType.h +1;
        int p1 = leftReturnType.maxDistance;
        int p2 = rightReturnType.maxDistance;
        int resultDistance = Math.max(Math.max(p1,p2),includeHeadDistance);
        int hItself = Math.max(leftReturnType.h,rightReturnType.h)+1;
        return new ReturnType(resultDistance,hItself);
    }

    public static int getMaxDistanceInTree(Node head){
       return process(head).maxDistance;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.right = new Node(3);
        head1.left.left = new Node(4);
        head1.left.right = new Node(5);
        head1.right.left = new Node(6);
        head1.right.right = new Node(7);
        head1.left.left.left = new Node(8);
        head1.right.left.right = new Node(9);
        System.out.println(getMaxDistanceInTree(head1));

        Node head2 = new Node(1);
        head2.left = new Node(2);
        head2.right = new Node(3);
        head2.right.left = new Node(4);
        head2.right.right = new Node(5);
        head2.right.left.left = new Node(6);
        head2.right.right.right = new Node(7);
        head2.right.left.left.left = new Node(8);
        head2.right.right.right.right = new Node(9);
        System.out.println(getMaxDistanceInTree(head2));

    }
}
