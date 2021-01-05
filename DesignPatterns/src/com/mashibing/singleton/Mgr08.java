package com.mashibing.singleton;

/**
 * 不进可以解决线程同步，还可以防止反序列化
 */
public enum  Mgr08 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            /*new Thread(()->{
                System.out.println(Mgr08.INSTANCE.hashCode());
            }).start();*/
            new Thread(new Runnable() {
                @Override
                public void run() {

                    System.out.println(Mgr08.INSTANCE.hashCode());
                }
            }).start();

        }
    }


}
