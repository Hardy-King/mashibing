package com.mashibing.singleton;

/**
 * lazy loading
 * 懒汉模式
 * 实现了按需初始化，但是线程不安全了
 * 可以通过 synchronized解决，但也带来效率下降
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;

    public static Mgr05 getInstance(){
        if (INSTANCE == null){
            synchronized (Mgr05.class){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
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
                    System.out.println(Mgr05.getInstance().hashCode());
                }
            }).start();
        }
    }

}
