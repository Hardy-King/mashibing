package com.mashibing.singleton;

/**
 * lazy loading
 * 懒汉模式
 * 实现了按需初始化，但是线程不安全了
 * 可以通过 synchronized解决，但也带来效率下降
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;

    public static synchronized Mgr04 getInstance(){
        if (INSTANCE == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
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
                    System.out.println(Mgr04.getInstance().hashCode());
                }
            }).start();
        }
    }

}
