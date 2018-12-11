package ccu.swordoffer;

/**
 * 题目：输入两棵二叉树 A 和 B，判断 B 是不是 A 的子结构。
 */
public class Test18 {
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

    public  static boolean contain(Node head1,Node head2){
        boolean result = false;
        if(head1!= null && head2!= null){
            if(head1.value == head2.value){
                result = check(head1,head2);
            }
           if(!result){
               contain(head1.left,head2);  //配左子树
           }
           if (!result){
               contain(head1.right,head2);//配右子树
           }
        }
        return result;
         // 上面代码全不用 直接写成这样。
        // return check(head1,head2) || contain(head1.left,head2)|| contain(head1.right,head2);
    }


    /**
     *  检查是否包含该子树
     * @param head1
     * @param head2 查找的子树
     * @return
     */
    public static boolean check(Node head1,Node head2){
        if(head2 == null){
            return true;
        }
        if(head1 == null || head2.value != head2.value){
            return false;
        }
        return check(head1.left,head2.left) && check(head1.right,head2.right);
    }


    public static void main(String[] args) {
        Node head1 = new Node();
        head1.value = 8;
        head1.right = new Node();
        head1.right.value = 7;
        head1.left = new Node();
        head1.left.value = 8;
        head1.left.left = new Node();
        head1.left.left.value = 9;
        head1.left.right = new Node();
        head1.left.right.value = 2;
        head1.left.right.left = new Node();
        head1.left.right.left.left = new Node();
        head1.left.right.left.left.value = 4;
        head1.left.right.left.right = new Node();
        head1.left.right.left.right.value = 7;
        Node head2 = new Node();
        head2.value = 8;
        head2.left = new Node();
        head2.left.value = 9;
        head2.right = new Node();
        head2.right.value = 2;
        System.out.println(contain(head1, head2));
        System.out.println(contain(head2, head1));
    }

}
