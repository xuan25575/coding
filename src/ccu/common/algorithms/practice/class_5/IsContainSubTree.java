package ccu.common.algorithms.practice.class_5;

/**
 *
 * 题目：输入两棵二叉树 A 和 B，判断 B 是不是 A 的子结构。
 *
 *     看起来是一种解 有bug  如果通过先序遍历能够不能确定一个树把。就是说加入两棵树结构不一样，也能返回true。
 *     【解1】：
 *      利用二叉树的神级遍历(空间复杂度：O(1)， 时间复杂度：O(h))
 *      转化成字符串匹配问题：KMP算法（时间：O(N)）
 *      总的时间复杂度：O(N)
 *
 *      【解2】：
 *      递归解法： 参考swordoffer包下 Test18 代码
 *
 *      相似题目：【题目】判断t1 树和t2 树是够有完全相同的拓扑结构。
 *      代码如下；
 *      左神的解法：
 *      先序列化一一棵二叉树，使用KMP解法。
 *
 *
 *
 */
public class IsContainSubTree {

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

    public static boolean contain(Node head1,Node head2){
        String str1 =  morrisPreTraversal(head1);
        String str2 =  morrisPreTraversal(head2);
        return  getIndexOf(str1,str2) != -1;
    }


    public static String morrisPreTraversal(Node head){
        if(head == null){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        Node cur = head;
        Node mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right != null && mostRight.right != cur){  // 除去两种特殊情况 找到最右节点
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    sb.append(cur.value);
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }else{
                sb.append(cur.value);
            }
            cur = cur.right;
        }
        return sb.toString();
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
//        System.out.println(contain(head1, head2));
//        System.out.println(contain(head2, head1));
        System.out.println(contain(head1, head2));
        System.out.println(contain(head2, head1));
    }
}
