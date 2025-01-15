package section31;

import section31.Inheritance.product.Shirt;

public class Main {
    public static void main(String[] args) {
        Shirt shirt = new Shirt();

        shirt.setSize(Shirt.Size.SMALL);
        shirt.setBrand("Polo");
        shirt.setPrice(927.0);
        shirt.setColor("Black");
        shirt.fold();
    }
}
