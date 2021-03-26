package HW4_Thread;

public class WaitAndNotify {

    public void waitNotify() throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                writeLetters();
                wait();
            }
            System.out.println("End");
        }
    }

    public void writeLetters() throws InterruptedException {
        System.out.println("Нить " + Thread.currentThread().getName() + " выводит A");
        System.out.println("Нить " + Thread.currentThread().getName() + " выводит B");
        System.out.println("Нить " + Thread.currentThread().getName() + " выводит C");
    }

    public void notifyThread() {
        synchronized (this) {
            notifyAll();
        }

    }
}
