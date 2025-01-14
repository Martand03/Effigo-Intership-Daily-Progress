package section12;

import java.util.Arrays;

public class UpdatingArray {

    public static void main(String[] args) {

        String[] menu = {"Espresso", "coffee", "milk"};

        String menuString = Arrays.toString(menu);

        System.out.println(menuString);

        menu[2] = "Latte";
        String menu1String = Arrays.toString(menu);
        System.out.println(menu1String);
    }
}
