/*Write a program to create a thread extending Thread class and demonstrate the use 
of slip() method. */
import java.util.*;

class ThreadClass extends Thread {
    ThreadClass(String name) {
        super(name);
    }

    public void run() {
        System.out.println(getName() + " is started");
        for (int i = 0; i < 3; i++) {
            System.out.println(getName() + " working: " + (i + 1));
            try {
                sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(getName() + " is finished");
    }
}

public class P12_1 {
    public static void main(String[] args) {
        System.out.println("Name: Nanecha Dipak Kishorbhai\t Enrollment NO.: 220170116023");
        Date t = new Date();
        System.out.println(t + "\n");

        ThreadClass th1 = new ThreadClass("Thread_1");
        ThreadClass th2 = new ThreadClass("Thread_2");
        th1.run();
        th2.run();
        try {
            th1.join();
            th2.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}