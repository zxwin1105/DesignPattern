package com.creational.singleton;

/**
 * 创建型设计模式-单例-饿汉模式
 *
 * @author seisei
 * @date 2023/6/23
 */
public class HungryModel {

    /**
     * 饿汉模式，直接初始化单例实例
     */
    private final static HungryModel INSTANCE = new HungryModel();

    /**
     * 私有化无参构造，防止实例化对象
     */
    private HungryModel() {

    }

    /**
     * 提供公共方法，获取单例对象
     *
     * @return HungryModel对象
     */
    public static HungryModel getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        HungryModel instance1 = getInstance();
        HungryModel instance2 = getInstance();
        System.out.println(instance1 == instance2);
    }
}
