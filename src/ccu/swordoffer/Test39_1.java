package ccu.swordoffer;
import ccu.swordoffer.Test39.*;

/**
 * 题目二：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意结点的左右子树的深度相差不超过 1 ，那么它就是一棵平衡二叉树。
 */
public class Test39_1 {

    /**
     *  基于上一次的方法
     * @param head
     * @return
     */

    public static boolean isBinaryTree(Node head){
        if(head == null){
            return true;
        }
        int left = Test39.treeDepth(head.left);
        int right = Test39.treeDepth(head.right);
        int diff = left - right;
        if(diff > 1 || diff < -1){
            return false;
        }
        return isBinaryTree(head.left) && isBinaryTree(head.right);
    }

    public static boolean isBinaryTree2(Node head){
        int[] depth = new int[]{0} ;
        return  isBinaryTree2(head,depth);
    }


    /**
     *   遍历一次解决。
     * @param head
     * @param depth
     * @return
     */

    public static boolean isBinaryTree2(Node head,int[] depth){
        if(head == null){
            depth[0] = 0;
            return true;
        }
        int[] left = new int[]{0};
        int[] right = new int[]{0};
        if(isBinaryTree2(head.left,left) && isBinaryTree2(head.right,right)){
            int diff = left[0] -right[0];
            if(diff <= 1 && diff >=-1 ){
                depth[0] = 1 + Math.max(left[0],right[0]);
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
          test1();
          test2();
          test3();
          test4();

    }

    // 完全二叉树
    //             1
    //         /      \
    //        2        3
    //       /\       / \
    //      4  5     6   7
    private static void test1() {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);
        Node n5 = new Node(1);
        Node n6 = new Node(1);
        Node n7 = new Node(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println(isBinaryTree(n1));
        System.out.println(isBinaryTree2(n1));
        System.out.println("----------------");
    }
    // 不是完全二叉树，但是平衡二叉树
    //             1
    //         /      \
    //        2        3
    //       /\         \
    //      4  5         6
    //        /
    //       7
    private static void test2() {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);
        Node n5 = new Node(1);
        Node n6 = new Node(1);
        Node n7 = new Node(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n7;
        n3.right = n6;
        System.out.println(isBinaryTree(n1));
        System.out.println(isBinaryTree2(n1));
        System.out.println("----------------");
    }
    // 不是平衡二叉树
    //             1
    //         /      \
    //        2        3
    //       /\
    //      4  5
    //        /
    //       7
    private static void test3() {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);
        Node n5 = new Node(1);
        Node n6 = new Node(1);
        Node n7 = new Node(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n7;
        System.out.println(isBinaryTree(n1));
        System.out.println(isBinaryTree2(n1));
        System.out.println("----------------");
    }
    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test4() {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);
        Node n5 = new Node(1);
        Node n6 = new Node(1);
        Node n7 = new Node(1);
        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n4.left = n5;
        System.out.println(isBinaryTree(n1));
        System.out.println(isBinaryTree2(n1));
        System.out.println("----------------");
    }
    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    private static void test5() {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);
        Node n5 = new Node(1);
        Node n6 = new Node(1);
        Node n7 = new Node(1);
        n1.right = n2;
        n2.right = n3;
        n3.right = n4;
        n4.right = n5;
        System.out.println(isBinaryTree(n1));
        System.out.println(isBinaryTree2(n1));;
        System.out.println("----------------");
    }
}
