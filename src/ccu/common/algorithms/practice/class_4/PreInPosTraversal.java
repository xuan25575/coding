package ccu.common.algorithms.practice.class_4;

import java.util.Stack;

/**
 * 二叉树先序、中序，后序遍历的非递归实现 和递归实现
 */
public class PreInPosTraversal {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int dada){
            this.value = dada;
        }
    }

    /**
     * 递归实现二叉树遍历
     * @param head
     */
    public static void preTraversalRecursion(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.value+"  ");
        preTraversalRecursion(head.left);
        preTraversalRecursion(head.right);
    }
    public static void inTraversalRecursion(Node head){
        if(head == null){
            return;
        }
        inTraversalRecursion(head.left);
        System.out.print(head.value+"  ");
        inTraversalRecursion(head.right);
    }
    public static void posTraversalRecursion(Node head){
        if(head == null){
            return;
        }
        posTraversalRecursion(head.left);
        posTraversalRecursion(head.right);
        System.out.print(head.value+"  ");
    }

    /**
     *  二叉树遍历的非递归实现
     *  思路： 用一个栈来操作。和系统栈类似。
     * @param head  头结点
     */
    public static void preOrderUnRecursion(Node head){
        System.out.print("pre-order  unRecursion: ");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value+" ");
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public static void inOrderUnRecursion(Node head){
        System.out.print("in-order unRecursion: ");
        if(head!= null){
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || head != null ){ //!stack.isEmpty() new出来时 栈为空
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.print(head.value +" ");
                    head  = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void  posOrderUnRecursion(Node head){
        System.out.print("pos-order unRecursion: ");
        if (head != null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();  // 逆序保存在其中，用来输出
            s1.push(head);
            while(!s1.isEmpty()){
               head = s1.pop();
               s2.push(head);
               // 压栈顺序
               if(head.left != null){
                   s1.push(head.left);
               }
               if(head.right != null){
                   s1.push(head.right);
               }
            }
            // 顺序输出
            while(!s2.isEmpty()){
                System.out.print(s2.pop().value+" ");
            }
        }
    }



    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
        // recursive
        System.out.println("print pre order:");
        preTraversalRecursion(head);
        System.out.println();
        System.out.println("print in order:");
        inTraversalRecursion(head);
        System.out.println();
        System.out.println("print pos order:");
        posTraversalRecursion(head);
        System.out.println();

        System.out.println("===================");
        //unrecursive
        preOrderUnRecursion(head);
        inOrderUnRecursion(head);
        posOrderUnRecursion(head);
    }
}
