package section20;

import java.util.ArrayList;
import java.util.List;

public class Arraylist {

    public static void main(String[] args) {

        List<String> cities = new ArrayList<>();
        cities.add("Pune");
        cities.add("Mumbai");
        System.out.println(cities);
        cities.add("Hyderabad");
        cities.add("UK");
        System.out.println(cities);
        cities.remove(3);
        System.out.println(cities);
        System.out.println(cities.size());
        System.out.println(cities.set(2, "UP"));
        System.out.println(cities.get(0));

    }
}
