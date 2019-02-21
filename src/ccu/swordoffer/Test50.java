package ccu.swordoffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *  * 题目：输入两个树结点，求他们的最低公共祖先
 *
 * 【注意】：
 *  1. 此树不一定是二叉树，（如果是二叉搜索树==> 二分查找 O（logN））
 *  2. 树中的结点没有指向父结点的指针（直接将此题转化为：求两个链表的第一个公共结点问题）
 *
 *  【解】：
 *      即使是一颗多叉树，一样可以转化为 求两个链表的公共结点问题
 *      1. 将到达两个树结点的必经之路记录下来，
 *      2. 然后开始寻找两条链表的最后公共结点
 */
public class Test50 {

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

    /**
     * 左神解法
     * 基于二叉树的后序遍历
     * @param head
     * @param o1
     * @param o2
     * @return
     */
    public static Node lowestAncestor(Node head,Node o1,Node o2){
        if(head == null || head == o1 || head ==o2 ){
            return head;
        }
        Node left = lowestAncestor(head.left,o1,o2);
        Node right = lowestAncestor(head.right,o1,o2);
        if(left != null && right != null){
            return head;
        }
        // 往上标记
        return left != null ? left: right;
    }


    public static  class TreeNode {
        public int value;
        public List<TreeNode> children = new LinkedList<>();
        public TreeNode() {
        }
        public TreeNode(int value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return value + "";
        }
    }

    /**
     * 寻找树中两个结点的最低公共祖先
     * @param head  树的根结点
     * @param t1    结点1
     * @param t2    结点2
     * @return 公共结点，没有返回null
     */
    public static TreeNode getLastCommonParent(TreeNode head,TreeNode t1,TreeNode t2){
        if(head == null || t1 ==null || t2 ==null){
            return head;
        }
        List<TreeNode> path1 =  new ArrayList<>();
        getNodePath(head,t1,path1);
        List<TreeNode> path2 =  new ArrayList<>();
        getNodePath(head,t2,path2);
        return getLastCommonNode(path1,path2);
    }

    /**
     * 寻找两条路径的最后一个公共结点
     * @param path1
     * @param path2
     * @return 没有返回null
     */
    public static TreeNode getLastCommonNode(List<TreeNode> path1,List<TreeNode> path2){
        Iterator<TreeNode> iterator1 = path1.iterator();
        Iterator<TreeNode> iterator2 = path2.iterator();
        TreeNode last = null;
        while(iterator1.hasNext() && iterator2.hasNext()){
            TreeNode temp  = iterator1.next();
            if(temp == iterator2.next()){
                last = temp;
            }
        }
        return last;
    }

    /**
     * 记录到达结点p的必经之路
     * @param head 头结点
     * @param p 目标节点
     * @param path  路径
     */
    public static boolean getNodePath(TreeNode head,TreeNode p,List<TreeNode> path){
       if(head == p){
            return true;
       }
       path.add(head);
       List<TreeNode> children = head.children;
       boolean found = false;
       int i = 0;
       while(!found && i < children.size() ){
            found = getNodePath(children.get(i),p,path);
            i++;
       }
       if(!found){
           path.remove(path.size()-1);
       }
       return found;

       // 感觉这种解法有问题的
//      for(TreeNode node : children){
//           if(node == p){
//               path.add(node);
//               return;
//           }else{
//               getNodePath(node,p,path);
//           }
//       }
//        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        test01();
        test02();  // 结果是2   疑问
//        test03();

//        Node head = new Node(1);
//        head.left =new Node(2);
//        head.left.left =new Node(3);
//        Node n4 = head.left.left.left =new Node(4);
//        Node n5  = head.left.left.left.left =new Node(5);
//        System.out.println(lowestAncestor(head,n4,n5).value);
    }


    // 形状普通的树
    //             1
    //           /   \
    //         2      3
    //        /         \
    //      4            5
    //     / \        /  |  \
    //    6   7      8   9  10
    public static void test01() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        n1.children.add(n2);
        n1.children.add(n3);
        n2.children.add(n4);
        n4.children.add(n6);
        n4.children.add(n7);
        n3.children.add(n5);
        n5.children.add(n8);
        n5.children.add(n9);
        n5.children.add(n10);
        System.out.println(getLastCommonParent(n1, n6, n7));
    }

    // 树退化成一个链表
    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test02() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);
        System.out.println(getLastCommonParent(n1, n4, n5));
    }
    // 树退化成一个链表，一个结点不在树中
    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test03() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);
        System.out.println(getLastCommonParent(n1, n5, n6));
    }

}
