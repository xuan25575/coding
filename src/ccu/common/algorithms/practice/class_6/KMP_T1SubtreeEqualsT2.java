package ccu.common.algorithms.practice.class_6;

/**
 * 给定两个二叉树T1和T2，返回T1的某个子树结构是否与T2的结构相等。
 */
public class KMP_T1SubtreeEqualsT2 {

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
     *  【题目】判断t1 树和t2 树是够有完全相同的拓扑结构。
     * @param head1
     * @param head2
     * @return
     */
    public static boolean isSubtree(Node head1,Node head2){
        String str1 =  serialByPre(head1);
        String str2 =  serialByPre(head2);
        return  getIndexOf(str1,str2) != -1;
    }


    public static String serialByPre(Node head){
        if(head == null){
            return "#!";
        }
        String str = head.value+"!";
        str += serialByPre(head.left);
        str += serialByPre(head.right);
        return  str;
    }

    public static int getIndexOf(String str1,String str2){
        if(str1 == null || str2 == null || str2.length()<1 || str1.length() < str2.length()){
            return -1;
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int index1 = 0;
        int index2 = 0;
        int[] next = getNextArray(s2);
        while(index1<s1.length && index2 < s2.length){
            if(s1[index1] == s2[index2]){
                index1++;
                index2++;
            }else if(next[index2] == -1){
                index1++;
            }else{
                index2 = next[index2];
            }
        }
        return index2 == s2.length ? index1-index2 :-1;
    }


    public static int[] getNextArray(char[] s2){
        if(s2.length ==1){
            return new int[]{-1};
        }
        int[] next = new int[s2.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn =0;
        while(pos < next.length){
            if(s2[pos-1] == s2[cn]){
                next[pos++] = ++ cn;
            }else if (cn > 0){
                cn = next[cn];
            }else{
                next[pos++] = 0;
            }
        }
        return next;
    }


    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);
        t1.right.left = new Node(6);
        t1.right.right = new Node(7);
        t1.left.left.right = new Node(8);
        t1.left.right.left = new Node(9);

        Node t2 = new Node(2);
        t2.left = new Node(4);
        t2.left.right = new Node(8);
        t2.right = new Node(5);
        t2.right.left = new Node(9);

        System.out.println(isSubtree(t1, t2));

    }
}
