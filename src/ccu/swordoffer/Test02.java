package ccu.swordoffer;

/**
 * 单例模式
 */
public class Test02 {}

    /**
     * 饿汉式
     */
class  Singleton1{
    private static final  Singleton1  instance  =  new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance(){
        return  instance;
    }
}

    /**
     * 懒汉式
     */
class Singleton2{
    private static  Singleton2  instance = null ;
    private Singleton2(){}
    //非线程安全
    /*public static Singleton2 getInstance(){
        if(instance == null){
            return new Singeton2();
        }
        return instance;
    }*/

    //线程安全的 但是效率低
    public static synchronized Singleton2 getInstance(){
        if(instance == null ){
            return new Singleton2();
        }
        return instance;
    }
}

/**
 * 双重检索模式
 */
class Singleton3{
    private volatile static Singleton3 instance = null;//volitile 保证内存可见性，防止指令重排序
    private Singleton3(){}
    public static Singleton3 getInstance(){
        if(instance == null ){
            synchronized(Singleton3.class){
                if(instance == null){
                    return  new Singleton3();
                }
            }
        }
        return instance;
    }
}

/**
 * 静态内部类
 * 只有在调用 getInstance() 时，对象才会被创建，同时没有性能缺点，也不依赖 Java 版本。
 */
class Singleton4{
    private static class StaticInnner{
        private static final Singleton4  instance = new Singleton4();
    }
    private Singleton4(){}
    public static Singleton4 getInstance(){
        return StaticInnner.instance;
    }
}
/**
 * 枚举
 */
enum Singleton5{
    INSTANCE;
    public  static Singleton5 getInstance(){
        return INSTANCE;
    }
}