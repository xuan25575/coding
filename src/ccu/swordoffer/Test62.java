package ccu.swordoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 假设序列化的结果字符串为str，初始时str等于空字符串。
 * 先序遍历二叉树，如果遇到空节点，就在str的末尾加上“#!”，“#”表示这个节点为空，
 * 节点值不存在，当然你也可以用其他的特殊字符，“!”表示一个值的结束。(不加出现歧义)
 * 如果遇到不为空的节点，假设节点值为3，就在str的末尾加上“3!”。
 */
public class Test62 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    String serialize(TreeNode root) {
        if(root == null) return "#!";
        String str = root.val +"!";
        str += serialize(root.left);
        str += serialize(root.right);
        return str;
    }
    TreeNode deserialize(String str) {
        String[] values = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.add(values[i]);
        }
        return reconPreOrder(queue);
    }
    public TreeNode reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("#")) return null;
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right =reconPreOrder(queue);
        return head;
    }
}
