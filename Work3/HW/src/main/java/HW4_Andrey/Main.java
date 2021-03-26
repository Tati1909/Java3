package HW4_Andrey;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final Object key = new Object();
    private static volatile char curChar = 'A';

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (key) {
                        while (curChar != 'A') {
                            key.wait();
                        }
                        System.out.print('A');
                        curChar = 'B';
                        key.notifyAll();
                    }

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (key) {
                        while (curChar != 'B') {
                            key.wait();
                        }
                        System.out.print('B');
                        curChar = 'C';
                        key.notifyAll();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (key) {
                        while (curChar != 'C') {
                            key.wait();
                        }
                        System.out.print('C');
                        curChar = 'A';
                        key.notifyAll();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
