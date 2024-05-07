/* Store pairs of 10 states and its capital in a map. Your program should prompt 
the user to enter a state and should display the capital for the state. */
import java.util.*;

public class P11_3 {
    public static String toTitleCase(String s) {
        if (Character.isLowerCase(s.toCharArray()[0])) 
            s = s.substring(0, 1).toUpperCase() + s.substring(1);
        if (s.contains(" ")){
            int index = s.indexOf((int)' ');
            s = s.substring(0, index + 1) + toTitleCase(s.substring(index + 1));
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println("Name: Nanecha Dipak Kishorbhai\t Enrollment NO.: 220170116023");
        Date t = new Date();
        System.out.println(t + "\n");
        Scanner se = new Scanner(System.in);
        
        HashMap<String, String> map = new HashMap<>();
        map.put("Gujarat", "Gandhinagar");
        map.put("Andhra Pradesh", "Amaravati");
        map.put("Arunachal Pradesh", "Itanagar");
        map.put("Assam", "Dispur");
        map.put("Bihar", "Patna");
        map.put("Chhattisgarh", "Raipur");
        map.put("Goa", "Panaji");
        map.put("Haryana", "Chandigarh");
        map.put("Himachal Pradesh", "Shimla");
        map.put("Jharkhand", "Ranchi");

        System.out.print("Enter a state: ");
        String state = toTitleCase(se.nextLine());
        String capital = map.get(state);
        // String capital = map.get(toTitleCase(state));

        if (capital != null) 
            System.out.println("The capital of " + state + " is " + capital);
        else 
            System.out.println("Capital not found for the " + state + " state.");
        se.close();
    }
}