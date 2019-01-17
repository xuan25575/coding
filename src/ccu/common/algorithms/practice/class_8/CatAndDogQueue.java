package ccu.common.algorithms.practice.class_8;

import jdk.nashorn.internal.ir.RuntimeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列
 *
 *   实现一种狗猫队列的结构，要求如下：
 *   用户可以调用add方法将cat类或dog类的实例放入队列中；
 *   用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
 *   用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
 *   用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
 *   用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
 *   用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
 *   用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例
 *
 *
 *   思路：猫和狗两个队列，设计一个类PetEnterQueue ，pet 用来表示加入的pet。count用于记录放入队列的每个元素的时间戳，
 *   取出时按时间戳来判断从dog队列或cat队列取出元素 小的先出。
 */
public class CatAndDogQueue {

    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }

    }
    public  static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }
    public static  class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }
    public static class PetEnterQueue{
        private Pet pet;
        private int count; // 时间戳  用来表示优先级 小的优先级高 ，先出来。

        public PetEnterQueue(Pet pet,int count){
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet(){
            return this.pet;
        }
        public int getCount(){
            return this.count;
        }
        public String getEnterPetType(){
            return this.pet.getPetType();
        }

    }
    public static class CatDogQueue{
        private Queue<PetEnterQueue> catQ;
        private Queue<PetEnterQueue> dogQ;
        private int count;
        public CatDogQueue(){
            catQ = new LinkedList<>();
            dogQ = new LinkedList<>();
            count = 0;
        }
        public void add(Pet pet){
            if("cat".equals(pet.getPetType())){
                catQ.add(new PetEnterQueue(pet,this.count++));
            }else if("dog".equals(pet.getPetType())){
                dogQ.add(new PetEnterQueue(pet,this.count++));
            }else{
                throw new RuntimeException("not is  cat or dog");
            }
        }

        public Pet pollAll(){
            if(!this.isCatEmpty() && !this.isDogEmpty()){
                if(this.catQ.peek().getCount() < this.dogQ.peek().getCount()){  //注意，这里使用peek方法弹出队列顶部元素而不删除。
                    return this.catQ.poll().getPet();
                }else{
                    return this.dogQ.poll().getPet();
                }
            }else if(!this.isDogEmpty()){  //如果通过上面条件 必然有一个为 empty
                return this.dogQ.poll().getPet();
            }else if(!this.isCatEmpty()){
                return this.catQ.poll().getPet();
            }else{
                throw new RuntimeException("queue is empty ..");
            }
        }
        public Pet pollDog(){
            if(this.isDogEmpty()){
                throw new RuntimeException("Dog queue is empty");
            }
            return dogQ.poll().getPet();
        }
        public Pet pollCat(){
            if(this.isCatEmpty()){
                throw new RuntimeException("Cat queue is empty..");
            }
            return catQ.poll().getPet();
        }
        public boolean isEmpty(){
            return catQ.isEmpty() && dogQ.isEmpty();
        }
        public boolean isCatEmpty(){
            return catQ.isEmpty();
        }
        public boolean isDogEmpty(){
            return dogQ.isEmpty();
        }
    }
    public static void main(String[] args) {
        CatDogQueue test = new CatDogQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

//        test.add(dog1);
//        test.add(cat1);
//        test.add(dog2);
//        test.add(cat2);
//        test.add(dog3);
//        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
//        while (!test.isEmpty()) {
//            System.out.println(test.pollAll().getPetType());
//        }
    }
}
