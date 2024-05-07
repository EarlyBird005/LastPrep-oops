import java.util.*;

public class x {
    public static String printPriorityQueue(PriorityQueue<String> queue) {
        String str = "";
        PriorityQueue<String> copyQueue = new PriorityQueue<>(queue);
        while (!copyQueue.isEmpty()) {
            str += copyQueue.poll() + " ";
        }
        return str+= "";
    }

    //might be not necessary
    public static void copyQueue(PriorityQueue<String> queue, PriorityQueue<String> list) {
        PriorityQueue<String> copyQueue = new PriorityQueue<>(list);
        while (!copyQueue.isEmpty()) {
            queue.add(copyQueue.poll());
        }
    }

    public static void main(String[] args) {
        String[] list1 = {"George", "Jim", "John", "Blake", "Kevin", "Michael"};
        String[] list2 = {"George", "Katie", "Kevin", "Michelle", "Ryan"};
        PriorityQueue<String> que1 = new PriorityQueue<>();
        PriorityQueue<String> que2 = new PriorityQueue<>();

        for (String str: list1)
            que1.add(str);
        for (String str : list2) 
            que2.add(str);
        System.out.println("que1: " + printPriorityQueue(que1));
        System.out.println("que: " + printPriorityQueue(que2));


        PriorityQueue<String> union = new PriorityQueue<>(que1);
        for (String str : que2) {
            if (!union.contains(str)) 
                union.add(str);
        }
        System.out.print("\nunion: " + printPriorityQueue(union));

        PriorityQueue<String> difference1 = new PriorityQueue<>();
        difference1.addAll(que1);
        difference1.removeAll(que2);
        System.out.println("\nque1-que2: " + printPriorityQueue(difference1));
        
        PriorityQueue<String> difference2 = new PriorityQueue<>();
        difference2.addAll(que2);
        difference2.removeAll(que1);
        System.out.println("\nque2-que1: " + printPriorityQueue(difference2));
    }
}