import java.util.*;

public class z {
    public static String toTitleCase(String s) {
        if (Character.isLowerCase(s.toCharArray()[0])) 
            s = s.substring(0, 1).toUpperCase() + s.substring(1);
        if (s.contains(" ")){
            int index = s.indexOf((int)' ');
            if (Character.isLowerCase(s.charAt(index + 1))) 
                s = s.substring(0, index + 1) + toTitleCase(s.substring(index + 1));
        }
        return s;
    }
    public static void main(String[] args) {
        Scanner se = new Scanner(System.in);
        String str = toTitleCase("dipsdf ksdfbn swerfgh");
        String str1 = toTitleCase("dipsdf ksdfbn");
        String str2 = toTitleCase("dipsdf");
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
        se.close();
    }
}