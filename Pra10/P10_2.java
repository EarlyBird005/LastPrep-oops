/*Write the following method that returns a new ArrayList. The new list contains the non-duplicate elements from the original list.
public static <E>ArrayList<E>removeDuplicates(ArrayList<E> list)
 */
import java.util.*;

public class P10_2 {
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> temp = new ArrayList<>();
        for (E e : list) {
            if (!temp.contains(e)) temp.add(e);
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println("Name: Nanecha Dipak Kishorbhai\t Enrollment NO.: 220170116023");
        Date t = new Date();
        System.out.println(t + "\n");        
        Scanner se = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter numbers in arraylist:");
        System.out.println("Enter -1 for stop");
        int num;
        while (true) {
            num = se.nextInt();
            if(num == -1) break;
            arr.add(num);
        }
        
        ArrayList<Integer> list = removeDuplicates(arr);
        System.out.println("\nAfter removing duplicates: " + list);
        se.close();
    }
}

// for (Integer e : list) {
//     System.out.print(e + " ");
// }
// System.out.println("List: ");
// for (Integer e : arr) {
//     System.out.print(e + " ");
// }