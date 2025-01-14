package section9;

import java.util.Scanner;

public class RockPaperScissor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's play Rock-Paper-Scissors");
        System.out.println("When I say shoot, Choose: rock, paper, scissors");
        System.out.println("Are you ready? Write 'yes' or 'no' ");
        String opinion = scanner.nextLine();
        if(opinion.equals("yes")){
            System.out.println("Great..!");
            System.out.println("rock-paper-scissors-shoot");
            String userChoice = scanner.nextLine();
            System.out.println("You choose: " + userChoice);

            String compChoice = computerChoice();
            System.out.println("Computer chooses: " + compChoice);

            if(userChoice.equals("rock") && compChoice.equals("scissors") ){
                System.out.println("User wins...");
            }
            else if(userChoice.equals("scissors") && compChoice.equals("paper")){
                System.out.println("User wins...");
            }
            else if(userChoice.equals("paper") && compChoice.equals("rock")){
                System.out.println("User wins...");
            }
            else{
                System.out.println("Computer wins...");
            }
        }
        else{
            System.out.println("Darn, some other time...!");
        }
    }

    public static String computerChoice(){
        double x =  Math.random() * 3;
        int choice =  (int)x + 1;
        return switch (choice) {
            case 1 -> "paper";
            case 2 -> "rock";
            case 3 -> "scissors";
            default -> "";
        };
    }
}
