package section20;

import java.util.HashMap;
import java.util.Map;

public class Hashmap {
    public static void main(String[] args) {
        Map<String , Double> fruits = new HashMap<>();

        fruits.put("Mango", 872.0);
        fruits.put("Banana", 822.0);
        fruits.put("Cherry", 82.0);

        System.out.println(fruits);

        System.out.println(fruits.get("Mango"));

    }
}
