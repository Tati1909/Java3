package HW4_Thread;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        WaitAndNotify wn = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    wn.waitNotify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    wn.waitNotify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    wn.waitNotify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread4 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <6 ; i++) {
                    System.out.println("********" + i + " цикл ********");
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    wn.notifyThread();
                }

            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }
}
