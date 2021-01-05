package com.mashibing.singleton;

/**
 * lazy loading
 * 懒汉模式
 * 实现了按需初始化，但是线程不安全了
 * 可以通过 synchronized解决，但也带来效率下降
 */
public class Mgr06 {
    /**
     * 为何加volatile
     *
     */
    private static volatile Mgr06 INSTANCE;

    public static Mgr06 getInstance(){
        //双重if检查
        if (INSTANCE == null){
            synchronized (Mgr06.class){
                if (INSTANCE == null){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }

            }
        }
        return INSTANCE;
    }

    public static void m(){
        System.out.println("m");
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Mgr06.getInstance().hashCode());
                }
            }).start();
        }
    }

}
