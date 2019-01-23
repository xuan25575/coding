package ccu.common.algorithms.practice.class_4;

import java.util.HashMap;

/**
 *  设计可以变更的缓存结构（LRU）
 *    【题目】
 *    设计一种缓存结构，该结构在构造时确定大小，假设大小为K，并有两个功能：
 *    set(key,value)：将记录(key,value)插入该结构。
 *    get(key)：返回key对应的value值。
 *    【要求】
 *    1．set和get方法的时间复杂度为O(1)。
 *    2．某个key的set或get操作一旦发生，认为这个key的记录成了最经常使用的。
 *    3．当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 *    【举例】
 *    假设缓存结构的实例是cache，大小为3，并依次发生如下行为：
 *    1．cache.set("A",1)。最经常使用的记录为("A",1)。
 *    2．cache.set("B",2)。最经常使用的记录为("B",2)，("A",1)变为最不经常的。
 *    3．cache.set("C",3)。最经常使用的记录为("C",2)，("A",1)还是最不经常的。
 *    4．cache.get("A")。最经常使用的记录为("A",1)，("B",2)变为最不经常的。
 *    5．cache.set("D",4)。大小超过了3，所以移除此时最不经常使用的记录("B",2)，
 *    加入记录 ("D",4)，并且为最经常使用的记录，然后("C",2)变为最不经常使用的
 *    记录
 *
 *   解： 哈希表（Map）和双向链表（LinkedList）*
 *  map中存的是（key, value） = （数据，结点（数据和值））  当map中存放的是String，Integer.....时，
 *  存放的是值，的是自己定义的类型Node......时，实际存放的是引用，即内存地址
 *  双向链表：尾进头出
 *  当有结点加入的话，加入双向链表尾部， 加入map中，
 *  当进行get操作时，从map中找到那个结点，然后从链表中分离出这个结点，然后加到尾部
 *  进行set操作时，在map中进行修改，然后从链表中再分离出这个结点，然后加到尾部
 *  当数据超过指定大小之后，在双向链表的头部删除，然后找到map中的值，也删掉
 *
 */
public class LRU {

    public static class Node<K,V>{
        public K key;
        public V value;
        public Node<K,V> last;
        public Node<K,V> next;
        public Node(K key,V value){
            this.key  = key;
            this.value = value;
        }
    }


    public static class NodeDoubleLinkedList<K,V>{
        private Node<K,V> head;
        private Node<K,V> tail;

        public NodeDoubleLinkedList(){
            this.head = null;
            this.tail = null;
        }

        public void addNode(Node<K,V> newNode){
            if(newNode == null){
                return ;
            }
            if(head == null){  // 链表为空
                head = newNode;
                tail = newNode;
            }else{ // 链表不为空
                this.tail.next = newNode;
                newNode.last = this.tail;
                this.tail =  newNode;
            }
        }

        //移动一个节点 到尾部
        public void moveNodeToTail(Node<K,V> node){
            if(this.tail == node){ // 尾部不用移动
                return;
            }
            // 移动的节点在 头部或者中间
            if(head == node){
                head = head.next;
                head.last = null;
            }else{
                node.last.next = node.next;
                node.next.last = node.last;
            }
            // 移动到尾部
            this.tail.next = node;
            node.next = null;
            node.last = this.tail;
            this.tail = node;
        }

        public Node<K,V> removeHead(){
            if(head == null){
                return null;
            }
            Node res = this.head;
            if(this.head == this.tail){
               this.head = null;
               this.tail = null;
            }else{
                this.head = res.next;
                this.head.last = null;
                res.next = null;
            }
            return res;
        }

    }


    public static class MyCache<K,V>{
        private HashMap<K,Node<K,V>> map;
        private NodeDoubleLinkedList<K,V> nodeList;
        private int capacity;
        public MyCache(int capacity){
            if(capacity <1 ){
                throw new RuntimeException("capacity is  less than 1");
            }
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.nodeList = new NodeDoubleLinkedList<>();
        }

        public V get(K key){
            if(map.containsKey(key)){
                Node<K,V> node = map.get(key);
                nodeList.moveNodeToTail(node);
                return node.value;
            }
            return null;
        }

        public void set(K key,V value){
            if(map.containsKey(key)){
                Node<K,V> node = map.get(key);
                node.value = value;
                this.nodeList.moveNodeToTail(node);
            }else{
                Node<K,V> newNode = new Node<>(key,value);
                map.put(key,newNode);
                this.nodeList.addNode(newNode);
                if(map.size() == this.capacity+1){ // 到达容量限制后 需要删除一个最近使用的  即删除nodeList 的头节点
                    removeMostUnusedCatch();
                }
            }
        }

        public void removeMostUnusedCatch(){
            Node<K,V> removeNode = nodeList.removeHead();
            map.remove(removeNode.key);//
        }

    }

    public static void main(String[] args) {
        MyCache<String, Integer> testCache = new MyCache<String, Integer>(3);
        testCache.set("A", 1);
        testCache.set("B", 2);
        testCache.set("C", 3);
        System.out.println(testCache.get("B"));
        System.out.println(testCache.get("A"));
        testCache.set("D", 4);
        System.out.println(testCache.get("D"));
        System.out.println(testCache.get("C"));

    }


}
