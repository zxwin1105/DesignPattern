package com.creational.singleton;

/**
 * 创建型设计模式-单例-静态内部类实现
 *
 * @author seisei
 * @date 2023/6/23
 */
public class StaticInnerModel {

    /**
     * 私有化构造器
     */
    private StaticInnerModel() {

    }

    /**
     * 创建静态内部类
     * <p>静态内部类实现的优势</p>
     * <p>- 线程安全：内部类的静态属性，是在类加载过程中初始化的，JVM会保证线程安全</p>
     * <p>- 懒加载，调用内部类属性时才会被加载，调用外部类不会被加载</p>
     *
     */
    static class Inner {
        private final static StaticInnerModel INSTANCE = new StaticInnerModel();
    }

    public static StaticInnerModel getInstance() {
        return Inner.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getInstance());
        }
    }

}
