package ccu.common.algorithms.practice.class_4;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 算法思路：
 * 访问某个节点时，将其从原来的位置删除，并重新插入到链表头部。这样就能保证链表尾部存储的就是最近最久未使用的节点，
 * 当节点数量大于缓存最大空间时就淘汰链表尾部的节点。
 * 为了使删除操作时间复杂度为 O(1)，就不能采用遍历的方式找到某个节点。
 * HashMap存储着 Key 到节点的映 射，通过 Key 就能以 O(1) 的时间得到节点，
 * 然后再以 O(1)的时间将其从双向队列中删除。
 * @param <K> 健
 * @param <V> 值
 */
public class LRU2<K, V> implements Iterable<K>  {

    private Node head;
    private Node tail;
    private HashMap<K, Node> map;
    private int maxSize;

    private class Node {

        Node pre;
        Node next;
        K k;
        V v;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }


    public LRU2(int maxSize) {

        this.maxSize = maxSize;
        this.map = new HashMap<>(maxSize * 4 / 3);

        head = new Node(null, null); // 哨兵
        tail = new Node(null, null); // 哨兵

        head.next = tail;
        tail.pre = head;
    }


    public V get(K key) {

        if (!map.containsKey(key)) {
            return null;
        }

        Node node = map.get(key);
        unlink(node);
        appendHead(node);

        return node.v;
    }


    public void put(K key, V value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            unlink(node);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        appendHead(node);

        if (map.size() > maxSize) {
            Node toRemove = removeTail();
            map.remove(toRemove.k);
        }
    }


    private void unlink(Node node) {

        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.pre = null;
        node.next = null;
    }


    private void appendHead(Node node) {
        Node next = head.next;
        node.next = next;
        next.pre = node;
        node.pre = head;
        head.next = node;
    }


    private Node removeTail() {

        Node node = tail.pre;

        Node pre = node.pre;
        tail.pre = pre;
        pre.next = tail;

        node.pre = null;
        node.next = null;

        return node;
    }


    @Override
    public Iterator<K> iterator() {

        return new Iterator<K>() {
            private Node cur = head.next;

            @Override
            public boolean hasNext() {
                return cur != tail;
            }

            @Override
            public K next() {
                Node node = cur;
                cur = cur.next;
                return node.k;
            }
        };
    }


    public static void main(String[] args) {
        LRU2<Integer,Integer> lru = new LRU2<>(3);
        lru.put(2,2);
        lru.put(1,1);
        lru.get(2);
        lru.get(1);
        lru.get(2);
        lru.put(3,3);
        lru.put(4,4);
        System.out.println(lru.get(3));
    }
}
