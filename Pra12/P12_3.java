import java.util.*;

public class P12_3 {
    private static Integer sum = 0;
    private static Integer synSum = 0;
    private static Object lock = new Object();

    public static void main(String[] args) {
        System.out.println("Name: Nanecha Dipak Kishorbhai\t Enrollment NO.: 220170116023");
        Date t = new Date();
        System.out.println(t + "\n");

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        sum++;
                    }
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("without synchronization: " + sum);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        synchronized (lock) {
                            synSum++;
                        }
                    }
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("with synchronization: " + synSum);
    }
}