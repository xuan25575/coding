package ccu.common.algorithms.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author huang_2
 * @Date 2020/3/28 3:05 下午
 * @Description 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
 */
public class 从单向链表中删除指定值的节点 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int num = sc.nextInt();
            int firstNode = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();

            list.add(firstNode);
            for(int i=0;i<num-1;i++){
                int Node1 = sc.nextInt();           //要插入的节点
                int Node2 = sc.nextInt();           //插入在哪个节点之后
                int index = list.indexOf(Node2);
                list.add(index+1,Node1);

            }
            Object deleteNode = sc.nextInt();
            list.remove(deleteNode);
            for(int i=0;i<list.size()-1;i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println(list.get(list.size()-1)+" ");
        }
        sc.close();
    }
}
