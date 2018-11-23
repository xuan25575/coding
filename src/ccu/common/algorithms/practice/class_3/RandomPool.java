package ccu.common.algorithms.practice.class_3;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *  设计RandomPool结构
 *   【题目】
 *    设计一种结构，在该结构中有如下三个功能：
 *    insert(key)：将某个key加入到该结构，做到不重复加入。
 *    delete(key)：将原本在结构中的某个key移除。
 *    getRandom()：等概率随机返回结构中的任何一个key。
 *    【要求】
 *    Insert、delete和getRandom方法的时间复杂度都是O(1)。
 */
public class RandomPool {

    public static class Pool<K>{
        private Map<K,Integer> keyIndexMap;
        private Map<Integer,K> indexKeyMap;
        private Integer size;

        public Pool(){
            keyIndexMap = new HashMap<>();
            indexKeyMap = new HashMap<>();
            size = 0;  // 记录下标
        }

        public void insert(K key){
            if(!keyIndexMap.containsKey(key)){ // 去掉重复的key
                keyIndexMap.put(key,this.size);
                indexKeyMap.put(this.size++,key); //插入后size会加1。 最后size会多1
            }
        }

        /**
         * 很巧妙
         * @param key
         */
        public void delete(K key){
            if(keyIndexMap.containsKey(key)){
                Integer deleteIndex = keyIndexMap.get(key);
                Integer lastIndex = --this.size;  //   可以使维持数量的size减小
                K lastKey = indexKeyMap.get(lastIndex);// 取得最后一个key
                keyIndexMap.put(lastKey,deleteIndex);  // 最后一个key的 键值deleteIndex
                indexKeyMap.put(deleteIndex,lastKey);  // deleteIndex键值被lastKey覆盖以前的key
                keyIndexMap.remove(key);
                indexKeyMap.remove(lastIndex);
            }
        }

        //出现null  并且如果不算null值就不会有等概率了
//        public void delete(K key) {
//            if(keyIndexMap.containsKey(key)){
//                Integer deleteIndex = keyIndexMap.get(key);
//                keyIndexMap.remove(key);
//                indexKeyMap.remove(deleteIndex);
//            }
//        }

        public K getRandom(){
            if(size == 0){
                return null;
            }
            int random =(int)(Math.random()*this.size);// 不用考虑加一的问题。
            return indexKeyMap.get(random);
        }

    }

    public static void main(String[] args) {
        Pool<String> randomPool = new Pool();
        randomPool.insert("123");
        randomPool.insert("1346");
        randomPool.insert("hello");

        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());

        System.out.println("==========================");
        randomPool.delete("123");
        randomPool.delete("1346");
        randomPool.delete("hello");

        System.out.println(randomPool.getRandom());


        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());


    }


}
