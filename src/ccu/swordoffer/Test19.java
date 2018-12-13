package ccu.swordoffer;

/**
 * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 【思路】
 *  先序遍历这棵树的每个结点，
 *  如果遍历到的结点有左右结点(只要不都为null)，就交换它的两个子结点。
 *  当交换完所有非叶子结点的左右子结点之后，就得到了树的镜像。
 *
 */
public class Test19 {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int dada){
            this.value = dada;
        }
        public Node(){
        }
    }
    public static void mirrorRecursively(Node head){
        if(head == null || (head.right == null && head.right == null)){
            return;
        }
        Node temp = head.left;
        head.left = head.right;
        head.right = temp;
        mirrorRecursively(head.left);
        mirrorRecursively(head.right);
    }

    public static void main(String[] args) {
        Node head2 = new Node();
        head2.value = 8;
        head2.left = new Node();
        head2.left.value = 9;
        head2.right = new Node();
        head2.right.value = 2;
        mirrorRecursively(head2);

    }

}
