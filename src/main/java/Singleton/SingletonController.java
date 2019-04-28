package Singleton;

public class SingletonController {
    public void startAction() {

        final int SIZE = 1000;
        Thread t[] = new Thread[SIZE];

        for (int i = 0; i < SIZE; i++) {
            t[i] = new Thread(new R());
            t[i].start();
        }
        for (int i = 0; i < SIZE; i++) {
            try {
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Singleton.counter);
    }

    class R implements Runnable {
        public void run() {
            Singleton.getInstance();
        }
    }

    static class Singleton {

        private static volatile Singleton instance;
        public static int counter = 0;

        private Singleton() {
            counter++;
        }

        public static Singleton getInstance() {
            if (instance == null)
                synchronized (Singleton.class) {
                    if (instance == null)
                        instance = new Singleton();
                }
            return instance;
        }
    }
}
