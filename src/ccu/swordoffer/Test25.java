package ccu.swordoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  题目：输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。
 * 【从树的根结点开始往下一直到叶结点所经过的结点形成一条路径】
 */
public class Test25 {
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
    public static  void findPath(Node head,int expectedSum){
        if(head == null ){
            return ;
        }
        List<Integer> path = new ArrayList<>();
        int currentSum = 0;
        findPath(head,currentSum,path,expectedSum);
    }

    public static void findPath(Node head, int currentSum, List<Integer> path, int expectedSum){
        currentSum += head.value;
        path.add(head.value);
        if(currentSum  == expectedSum && head.left == null && head.right == null){
            System.out.println(path);
        }
        if(head.left != null){
            findPath(head.left,currentSum,path,expectedSum);
        }
        if(head.right != null){
            findPath(head.right,currentSum,path,expectedSum);
        }
      //  currentSum -= head.value;  Java系统调用栈结构。 递归上层变成正确的current。
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        //            10
        //         /      \
        //        5        12
        //       /\
        //      4  7
        Node head = new Node();
        head.value = 10;
        head.left = new Node();
        head.left.value = 5;
        head.left.left = new Node();
        head.left.left.value = 4;
        head.left.right = new Node();
        head.left.right.value = 7;
        head.right = new Node();
        head.right.value = 12;
        findPath(head, 22);


    }
}
