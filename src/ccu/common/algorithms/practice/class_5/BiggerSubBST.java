package ccu.common.algorithms.practice.class_5;

/**
 * 找到二叉树中的最大搜索二叉子树
 *
 * 套路解法  树形DP  设计结构 收集信息
 *
 * 题目：给定一个二叉树的头节点head，已知其中所有节点的值都不一样，
 * 找到含有节点最多的搜索二叉子树，并返回这个子树的头节点。
 *   信息一: 左树最大搜索二叉树大小；
 *    信息二: 右树最大搜索二叉树大小；
 *    信息三: 左树上最大搜索二叉树的头部是什么；
 *    信息四: 右树上最大搜索二叉树的头部是什么；
 *    信息五: 左树上的最大值；
 *    信息六: 右树上的最小值；
 *  信息一和信息二整合：size ，信息三和信息四整合 : head(结点类型)，以及信息五和信息六
 */
public class BiggerSubBST {

    public static class Node{
        public Integer value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }

    // 设计一个结构整合
    public static class ReturnType{
        public int max;
        public int min;
        public Node head;
        public int size;
        public ReturnType(int size,Node head,int max,int min){
            this.size = size;
            this.head = head;
            this.max= max;
            this.min =min;
        }
    }



    public static Node getBiggerSubBST(Node head){
      return  process(head).head;
    }
    public static ReturnType process(Node head){
        if(head == null){
            return new ReturnType(0,null,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        Node left = head.left;
        Node right = head.right;
        // 看成黑盒
        ReturnType  subLeftInfo = process(left);
        ReturnType subRightInfo = process(right);

        // 拆黑盒
        int includeItSelf = 0;
        if(subLeftInfo.head == head.left
            && subRightInfo.head == head.right
            && subLeftInfo.max < head.value
            && subRightInfo.min > head.value
          ){
            includeItSelf = subLeftInfo.size + subRightInfo.size + 1;
        }
        int  p1 = subLeftInfo.size;
        int  p2 = subRightInfo.size;
        int maxSize = Math.max(Math.max(p1,p2),includeItSelf);
        Node maxHead = p1 > p2 ?  subLeftInfo.head :  subRightInfo.head;
        if(maxSize == includeItSelf){
            maxHead = head;
        }
        return new ReturnType(
                maxSize,
                maxHead,
                Math.min(Math.min(subLeftInfo.min,subRightInfo.min),head.value),
                Math.max(Math.max(subLeftInfo.max,subRightInfo.max),head.value)
        );
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
        System.out.println(getBiggerSubBST(head1).value);
    }
}
