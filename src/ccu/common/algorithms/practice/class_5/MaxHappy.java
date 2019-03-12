package ccu.common.algorithms.practice.class_5;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个公司的上下节关系是一棵多叉树，这个公司要举办晚会，你作为组织者已经摸清了大家的心理：一个员工的直
     接上级如果到场，这个员工肯定不会来。每个员工都有一个活跃度的值，决定谁来你会给这个员工发邀请函，怎么
     让舞会的气氛最活跃？返回最大的活跃值。
     举例：
     给定一个矩阵来表述这种关系
     matrix =
     {
         1,6
         1,5
         1,4
     }
     这个矩阵的含义是：
     matrix[0] = {1 , 6}，表示0这个员工的直接上级为1,0这个员工自己的活跃度为6
     matrix[1] = {1 , 5}，表示1这个员工的直接上级为1（他自己是这个公司的最大boss）,1这个员工自己的活跃度
     为5
     matrix[2] = {1 , 4}，表示2这个员工的直接上级为1,2这个员工自己的活跃度为4
     为了让晚会活跃度最大，应该让1不来，0和2来。最后返回活跃度为10
 *
 *  解：套路解法  树形DP 多叉树
 */
public class MaxHappy {

    public static class Node{
        public Integer value;
       public List<Node> nexts;
        public Node(int data){
            this.value = data;
            this.nexts = new ArrayList<>();
        }
    }

    // 设计一个结构 装载信息
    public static class ReturnType{
        public int come_active; // 来的总的活跃度
        public int not_come_active;  // 不来的总的活跃度
        public ReturnType(int come_active,int not_come_active){
            this.come_active = come_active;
            this.not_come_active = not_come_active;
        }
    }
     public static ReturnType process(Node head){
//        if(head == null){
//            return new ReturnType(0,0);
//        }
        int comeActive = head.value;
        int notComeActive = 0;
         for (int i = 0; i < head.nexts.size(); i++) {
             Node next = head.nexts.get(i);
             ReturnType nextReturnType = process(next);
             comeActive += nextReturnType.not_come_active;
             notComeActive += Math.max(nextReturnType.come_active,nextReturnType.not_come_active);
         }
         return new ReturnType(comeActive,notComeActive);
     }

     public static int getMaxHappy(Node head){
        ReturnType data =  process(head);
        return Math.max(data.come_active,data.not_come_active);
     }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 8 }, { 1, 9 }, { 1, 10 } };
        Node head = new Node(1);
        head.nexts.add(new Node(8));
        head.nexts.add(new Node(9));
        head.nexts.add(new Node(10));
        System.out.println(getMaxHappy(head));
    }

}
