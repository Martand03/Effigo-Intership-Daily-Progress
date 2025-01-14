package section16;

public class Car {
    String name;
    double price;
    int year;
    String color;

    // constructor with parameters
    public Car(String name, double price, int year, String color) {
        this.name = name;
        this.price = price;
        this.year = year;
        this.color = color;
    }

    // constructor for non-parameterized
    public Car() {

    }

    // copy constructor
    public Car(Car source){
        this.name = source.name;
        this.price = source.price;
        this.year = source.year;
        this.color = source.color;
    }
}
