package section16;

public class Main {
    public static void main(String[] args) {

        Car nissan = new Car();
        nissan.name = "GTR";
        nissan.price = 10000;
        nissan.year = 1996;
        nissan.color = "Black";

        Car tata = new Car();
        tata.name = "Punch";
        tata.price = 19872;
        tata.year = 2023;
        tata.color = "White";

        System.out.println("Nissan: " + nissan.name +" " + nissan.price + " "+ nissan.year + " "+ nissan.color);
        System.out.println("Tata: " + tata.name + " "+ tata.price + " "+ tata.year + " "+ tata.color);
    }
}
