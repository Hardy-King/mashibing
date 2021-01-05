package com.mashibing.singleton;

public class Mgr02 {
    private static final Mgr02 INSTANCE;
    static {
        INSTANCE = new Mgr02();
    }
    public static Mgr02 getInstance(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return INSTANCE;
    }

    public static void m(){
        System.out.println("m");
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr07.getInstance().hashCode());
            }).start();
        }
        Mgr02 m1 = Mgr02.getInstance();
        Mgr02 m2 = Mgr02.getInstance();
        System.out.println(m1 == m2);
    }

}
