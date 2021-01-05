package com.mashibing.singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类装在时就完成实例化
 * （话说你不用，你加载他干啥呢）
 * 这个常用
 */
public class Mgr01 {
    /**
     * final  不允许修改
     */
    private static final Mgr01 INSTANCE = new Mgr01();

    /**
     * 私有构造方法
     */
    private Mgr01(){}
    /**
     * 创建对象
     */
    public static Mgr01 getInstance(){
        return INSTANCE;
    }

    /**
     * 其他业务方法
     */
    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr07.getInstance().hashCode());
            }).start();
        }
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);
    }
}
