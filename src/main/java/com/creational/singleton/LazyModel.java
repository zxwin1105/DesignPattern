package com.creational.singleton;

/**
 * 创建型设计模式-单例-懒汉模式
 *
 * @author seisei
 * @date 2023/6/23
 */
public class LazyModel {
    /**
     * 懒汉模式，并不直接实例化单例实例，而是第一次获取实例时进行实力哈操作
     * volatile修饰防止重排序，出现线程安全问题
     */
    private volatile static LazyModel instance;

    /**
     * 私有化构造方法
     */
    private LazyModel() {

    }

    /**
     * 获取单例对象
     *
     * <p>DCL 双重检查，方法中使用了两次`instance==null`，解决线程安全问题，也提高了效率，
     * 第一次创建完instance后，后续的线程获取实例时 不用进入同步代码块就可以判断对象是否创建</p>
     *
     * <p>`instance = new LazyModel();` 这句代码在字节码层面实际上是3个操作，包括
     * - 分配对象内存空间
     * - 创建对象
     * - 将对象地址赋值给instance
     * 在第一次创建对象过程中如果两个线程分时都进入了同步代码块，第一个进入的线程没有完整的执行`instance = new LazyModel()`
     * 第二个线程执行完成，就会创新两个对象不一致的情况
     * </p>
     * @return LazyModel
     */
    public static LazyModel getInstance() {
        if (instance == null) {
            // 如果单例对象为null，则需要创建对象，需要主要多线程环境下线程安全问题
            synchronized (LazyModel.class) {
                if (instance == null) {
                    instance = new LazyModel();
                }
            }
        }
        // 如果单例对象不为null，直接返回
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(getInstance());
            }).start();
        }
    }
}
