/* Create two priority queues, {"George", "Jim", "John", "Blake", "Kevin", "Michael"} and 
{"George", "Katie", "Kevin", "Michelle", "Ryan"}, and 
find their union, difference, and intersection. */
import java.util.*;

public class P11_2 {
    public static String print(PriorityQueue<String> queue) {
        String str = "[";
        PriorityQueue<String> temp = new PriorityQueue<>(queue);
        while (!temp.isEmpty()) {
            str += temp.poll() + ", ";
        }
        return str += queue.isEmpty()? "]" : "\b\b]";
    }

    public static void main(String[] args) {
        System.out.println("Name: Nanecha Dipak Kishorbhai\t Enrollment NO.: 220170116023");
        Date t = new Date();
        System.out.println(t + "\n");

        String[] list1 = {"George", "Jim", "John", "Blake", "Kevin", "Michael"};
        String[] list2 = {"George", "Katie", "Kevin", "Michelle", "Ryan"};
        PriorityQueue<String> que1 = new PriorityQueue<>();
        PriorityQueue<String> que2 = new PriorityQueue<>();
        for (String str: list1)
            que1.add(str);
        for (String str : list2) 
            que2.add(str);
        System.out.println("que1: " + print(que1) + "\nque2: " + print(que2));

        // union
        PriorityQueue<String> union = new PriorityQueue<>(que1);
        for (String str : que2) {
            if (!union.contains(str)) 
                union.add(str);
        }
        System.out.println("\nUnion: " + print(union));
        
        // Difference (que1 - que2)
        PriorityQueue<String> difference1 = new PriorityQueue<>(que1);
        difference1.removeAll(que2);
        System.out.println("\nque1-que2: " + print(difference1));
        
        // Difference (queue2 - queue1)
        PriorityQueue<String> difference2 = new PriorityQueue<>(que2);
        difference2.removeAll(que1);
        System.out.println("\nque2-que1: " + print(difference2));

        // Intersection
        PriorityQueue<String> intersection = new PriorityQueue<>(que1);
        intersection.retainAll(que2);
        System.out.println("\nIntersection: " + print(intersection));
    }
}