package ccu.common.algorithms.practice.class_5;

/**
  * 介绍一种时间复杂度O(N)，额外空间复杂度O(1)的二叉树的遍
  *   历方式，N为二叉树的节点个数
  *   Morris遍历
  *   利用Morris遍历实现二叉树的先序，中序，后续遍历，时间复
  *   杂度O(N)，额外空间复杂度O(1)。
 *   后续遍历  -- >
  *
  *   1. 如果当前节点的左孩子为空，则cur = cur.right
  *   2. 当前节点有左子树，找到左子树的最右节点 mostRight
  *     a) 如果mostRight的右孩子为空，将它的右孩子设置为当前节点（cur）。当前节点更新为当前节点的左孩子。（cur向左）
  *     b) 如果mostRight的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。 cur向右 （cur = cur.right）
  *
 */
public class MorrisTraversal {

    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void morrisIn(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null){
           mostRight = cur.left;
           if(mostRight != null){
               while(mostRight.right != null && mostRight.right != cur){
                   mostRight = mostRight.right;
               }
               if(mostRight.right == null){
                   mostRight.right = cur;
                   cur = cur.left;
                   continue;
               }else{
                   mostRight.right = null;
               }
           }
           System.out.print(cur.value +" ");
           cur = cur.right;
        }
        System.out.println();
    }

    public static void morrisPre(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    System.out.print(cur.value +" ");   // 第一次来到这个节点 打印
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }else{
                System.out.print(cur.value +" "); // 无左子树的节点直接打印
            }
            cur = cur.right;
        }
        System.out.println();
    }
    public static void morrisPos(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
        System.out.println();
    }



    public static void printEdge(Node head){
        Node tail = reverseEdge(head);
        Node cur = tail;  //保存tail节点用来 recover
        while(cur != null){
            System.out.print(cur.value +" ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }
    public static Node reverseEdge(Node from){
        Node pre = null;
        Node next = null;
        while(from != null){
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    public static void process(Node head){
        if(head != null){
            System.out.print(head.value +" ");
            process(head.left);
            process(head.right);
        }
    }



    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        morrisIn(head);
        morrisPre(head);
        morrisPos(head);
        process(head);
    }

}
