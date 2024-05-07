/* Write a recursive method that converts a decimal number into a binary number as a string. The method header is: public static String dec2Bin(int value)
Write a test program that prompts the user to enter a decimal number and displays its binary equivalent.
 */
import java.util.*;

public class P10_1 {
    public static String dec2Bin(int value) {
        if (value == 0) return "0";
        else if(value == 1) return "1";
        String str = "";
        str += dec2Bin(value / 2) + value % 2;
        return str;
    }

    public static void main(String[] args) {
        System.out.println("Name: Nanecha Dipak Kishorbhai\t Enrollment NO.: 220170116023");
        Date t = new Date();
        System.out.println(t + "\n");
        Scanner se = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int d = se.nextInt();
        String str = dec2Bin(d);
        System.out.println("In binary: " + str);
        se.close();
    }
}

    /*public static String dec2Bin(double value) {
        if (value == 0)
            return "";
        String str = "";
        double binary = value * 2;
        if (binary >= 1) {
            str += 1;
        } else {
            str += 0;
        }
        str += dec2Bin(binary - (int) binary);
        return str;
    }*/
    /*if ((d - (int) d) != 0) {
        str += ".";
        str += dec2Bin(d - (int) d);
    }*/