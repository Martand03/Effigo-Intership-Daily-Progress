package section34;

import java.math.BigDecimal;

public class Decimals {

    public static void main(String[] args) {

        double x = 0.1;
        System.out.println(x);
        double y = 0.2;
        System.out.println(y);
        System.out.println("x+y= " + (x+y));
        BigDecimal a = new BigDecimal("0.1");
        System.out.println(a);
        BigDecimal b = new BigDecimal("0.2");
        System.out.println(b);
        System.out.println("a+b= " + a.add(b));
    }
}
