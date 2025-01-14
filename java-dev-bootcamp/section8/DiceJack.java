package section8;

import java.util.Map;
import java.util.Scanner;

import static java.lang.Math.abs;

public class DiceJack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three numbers: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        int userSum = addition(num1, num2, num3);

        int d1 = diceRoll();
        int d2 = diceRoll();
        int d3 = diceRoll();
        System.out.println("Three numbers by dice are: " + d1 + " " + d2 + " " + d3 );
        int diceRollSum = addition(d1, d2, d3);
        int diff = abs(userSum - diceRollSum);
        if(diceRollSum < userSum && diff < 3){
            System.out.println("User wins !!!");
        }
        else{
            System.out.println("User loses;");
        }

    }

    private static int diceRoll(){
        double random = Math.random() * 6;
        random += 1;
        return (int)random;
    }

    public static int addition(int a, int b, int c){
        return a+b+c;
    }
}
