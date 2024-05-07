/* Implement the following method using binary search.
public static <E extends Comparable<E>> int binarySearch(E list, E key)
 */
import java.util.*;

public class P10_3 {
    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        /*Arrays.sort(list);
        return Arrays.binarySearch(list, key);*/
        int lb = 0, ub = list.length - 1;
        while (lb <= ub) {
            int mid = (lb + ub) / 2;
            int temp = list[mid].compareTo(key);
            if (temp == 0) return mid;
            else if (temp < 0) lb = mid + 1;
            else if (temp > 0) ub = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Name: Nanecha Dipak Kishorbhai\t Enrollment NO.: 220170116023");
        Date t = new Date();
        System.out.println(t + "\n");
        Scanner se = new Scanner(System.in);

        Integer[] arr = { 5, 55, 33, 10, 2, 7, 88 };
        Arrays.sort(arr);
        for (Integer e : arr) {
            System.out.print(e + " ");
        }
        System.out.print("\nEnter the element which to find: ");
        int key = se.nextInt();
        int index = binarySearch(arr, key);
        if (index != -1) System.out.println("\nElement " + key + " found at index: " + index);
        else System.out.println("\nElement not found");
        se.close();
    }
}