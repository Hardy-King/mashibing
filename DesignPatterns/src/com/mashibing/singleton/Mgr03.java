package com.mashibing.singleton;

/**
 * lazy loading
 * 懒汉模式
 * 实现了按需初始化，但是线程不安全了
 */
public class Mgr03 {
    private static Mgr03 INSTANCE;

    public static Mgr03 getInstance(){
        if (INSTANCE == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
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
                    System.out.println(Mgr03.getInstance().hashCode());
                }
            }).start();
        }
    }

}
