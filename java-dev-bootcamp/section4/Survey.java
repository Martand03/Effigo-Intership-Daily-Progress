package section4;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Survey {
    public static void main(String[] args) {

        System.out.println("Welcome. Please Take the below survey");
        Scanner scanner = new Scanner(System.in);

        // questions
        System.out.println("------------------");
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("What is your age?");
        int age = scanner.nextInt();
        System.out.println("What is your coffee expense?");
        double price = scanner.nextDouble();

        // responses
        System.out.println("----------------------");
        System.out.println(name + " : Thank-you for taking the survey");
        System.out.println("Your age is: " + age);
        System.out.println("Your coffee expense is: " + price);
    }
}
