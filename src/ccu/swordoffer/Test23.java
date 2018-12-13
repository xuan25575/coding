package ccu.swordoffer;

import java.util.LinkedList;

/**
 * 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左向右的顺序打印。
 * 思路： 用一个队列
 */
public class Test23 {

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
    public static void printFromToBottom(Node head){
        if(head == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        Node cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            System.out.print(cur.value+" ");
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        Node head = new Node(8);
        head.left = new Node(6);
        head.left.left = new Node(5);
        head.left.right = new Node(7);
        head.right = new Node(10);
        head.right.left = new Node(9);
        head.right.right = new Node(11);
        printFromToBottom(head);
    }
}
