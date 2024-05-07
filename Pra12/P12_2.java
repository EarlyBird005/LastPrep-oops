/* Write a program to create a thread implementing Runnable interface and 
demonstrate the use of join() method. */
import java.util.*;

class ThreadRunnable implements Runnable {
    private String name;
    private long delay;
    
    ThreadRunnable(String name, long delay) {
        this.name = name;
        this.delay = delay;
    }
    
    public void run() {
        System.out.println(name + " is started");
        System.out.println(name + " will sleep for " + delay + " seconds");
        try {
            Thread.sleep((delay * 1000)); // millisecond*1000
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " is finished");
    }
}

public class P12_2 {
    public static void main(String[] args) {
        System.out.println("Name: Nanecha Dipak Kishorbhai\t Enrollment NO.: 220170116023");
        Date t = new Date();
        System.out.println(t + "\n");

        Thread th1 = new Thread(new ThreadRunnable("Th1", 5));
        Thread th2 = new Thread(new ThreadRunnable("Th2", 2));
        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}