package ccu.swordoffer;

/**
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。*
 * 思路： 中序遍历
 */
public class Test27 {
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
     * 解一：
     * @param head
     * @return
     */
    public static Node convert1(Node head){
        if(head == null){
            return null;
        }
        Node lastNode = null;
        lastNode = convertNode(head,lastNode); // 执行完后 lastNode节点变为双向链表的尾节点
        head = lastNode;
        while(head!= null && head.left != null){ // left 往前游 找到头结点。
            head = head.left;
        }
        return head;
    }

    /**
     *  整个一中序遍历
     * @param head 当前节点
     * @param lastNode 上一个节点
     */
    public static Node convertNode(Node head,Node lastNode){
        if(head == null){
            return null;
        }
        if(head.left != null){
            lastNode = convertNode(head.left,lastNode);
        }
        head.left = lastNode; // 设置当前节点前驱
        if(lastNode != null){
            lastNode.right = head; // 设置当前节点后继
        }
        lastNode = head; // 保存下一次的前驱节点
        if(head.right != null){
            lastNode = convertNode(head.right,lastNode);
        }
        return lastNode;
    }






    public static void inTraversalRecursion(Node head){
        if(head == null){
            return;
        }
        inTraversalRecursion(head.left);
        System.out.print(head.value+"  ");
        inTraversalRecursion(head.right);
    }

    public static void printDoubleLinkedList(Node node){
        Node end =null;
        System.out.print("double linked list: " );
        while(node != null){
            System.out.print(node.value+" ");
            end = node; // 用来保存最后一个节点 不能为空。放在 node = node.next;之前
            node = node.right;
        }
        System.out.print(" | ");
        while(end != null){
            System.out.print(end.value+" ");
            end = end.left;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test01();
    }

    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    private static void test01() {
        Node node10 = new Node();
        node10.value = 10;
        Node node6 = new Node();
        node6.value = 6;
        Node node14 = new Node();
        node14.value = 14;
        Node node4 = new Node();
        node4.value = 4;
        Node node8 = new Node();
        node8.value = 8;
        Node node12 = new Node();
        node12.value = 12;
        Node node16 = new Node();
        node16.value = 16;
        node10.left = node6;
        node10.right = node14;
        node6.left = node4;
        node6.right = node8;
        node14.left = node12;
        node14.right = node16;
        System.out.println("inOrderTraversal: ");
        inTraversalRecursion(node10);
        System.out.println();
        Node head = convert1(node10);
        printDoubleLinkedList(head);
        System.out.println();
    }

}
