package section12;

import java.util.Arrays;

public class RefTrap {
    public static void main(String[] args) {
        String[] lastYear = {"Tony", "Joe", "Shark"};
        System.out.println(Arrays.toString(lastYear));


        String[] newYear = lastYear;
        newYear[1] = "Harry";
        System.out.println(Arrays.toString(newYear));
        System.out.println(Arrays.toString(lastYear));
    }
}
