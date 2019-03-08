package ccu.common.algorithms.practice.class_4;

import java.util.HashMap;
import java.util.List;

/**
 * 认识并查集
 * 在计算机科学中，并查集是一种树型的数据结构，用于处理一些不交集（Disjoint Sets）的合并及查询问题。
 * 有一个联合-查找算法（union-find algorithm）定义了两个用于此数据结构的操作：
 * Find：确定元素属于哪一个子集。它可以被用来确定两个元素是否属于同一子集。
 * Union：将两个子集合并成同一个集合。
 * 由于支持这两种操作，一个不相交集也常被称为联合-查找数据结构（union-find data structure）
 * 或合并-查找集合（merge-find set）。
 * 其他的重要方法，MakeSet，用于创建单元素集合。有了这些方法，许多经典的划分问题可以被解决。
 */
public class UnionFind {
    public static class Node{

    }

    public static class DisjointSets{
        private HashMap<Node,Node>  fatherMap; // 第一个用来存储节点 。泛型第二个用来存储用来存放父节点
        private HashMap<Node,Integer> rankMap; // 用来存放节点的层级
        public DisjointSets(){
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
        }

        /**
         *  用于创建单元素集合。
         * @param nodes 节点集合
         */
        public  void makeSets(List<Node> nodes){
            fatherMap.clear();
            rankMap.clear();
            for(Node node : nodes){
                fatherMap.put(node,node);
                rankMap.put(node,1);
            }
        }

        /**
         * 确定元素属于哪一个子集
         * @param n  节点
         * @return  返回该集合头节点
         */
        public Node findFather(Node n){
            Node father = fatherMap.get(n);
            while(father != n){ // 找到头节点  头节点指针指向自己
                findFather(father); // 递归实现
            }
            fatherMap.put(n,father); // 优化  优化，把这个链的每个节点修改成指向父节点
            return father;
        }

        /**
         * 将两个子集合并成同一个集合。
         * @param a 节点 某个集合的结点
         * @param b 节点 某个集合的结点
         */
        public void union(Node a,Node b){
            if(a == null || b == null){
                return;
            }
            Node aFather = fatherMap.get(a);
            Node bFather = fatherMap.get(b);
            if(aFather != bFather){ // 当两父节点不相等不是一个集合
               Integer aRank = rankMap.get(a);  // 取得层级  把层级小的挂大的下面
               Integer bRank = rankMap.get(b);
               if(aRank <= bRank){
                   fatherMap.put(aFather,bFather); // aFather 集合挂在 bFather 下面
                   rankMap.put(bFather,aRank+bRank); //修改 bFather 集合的层级深度
               }else{
                   fatherMap.put(bFather,aFather);
                   rankMap.put(aFather,aRank+bRank);
               }

            }
        }
    }
}
