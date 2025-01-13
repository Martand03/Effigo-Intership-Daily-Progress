package section6;

import java.util.Scanner;

public class TriviaQuiz {
    public static void main(String[] args) {

        int score = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Which country held the 2016 Summer Olympics?");
        System.out.println("\ta) China\n\tb) Ireland\n\tc) Brazil\n\td) Italy\n");
        System.out.println("Enter option as your answer: ");
        String ans1 = scanner.nextLine();
        if(ans1.equals("c")){
            score += 5;
        }

        System.out.println("2. Which planet is the hottest?");
        System.out.println("a) Venus\n\tb) Saturn\n\tc) Mercury\n\td) Mars");
        String ans2 = scanner.nextLine();
        if(ans2.equals("a")){
            score += 5;
        }

        System.out.println("3. What is the rarest blood type?");
        System.out.println("a) O\n\tb) A\n\tc) B\n\td) AB-Negative");
        String ans3 = scanner.nextLine();
        if(ans3.equals("d")){
            score += 5;
        }

        System.out.println("4. Which one of these characters is friends with Harry Potter?");
        System.out.println("a) Ron Weasley\n\tb) Hermione Granger\n\tc) Draco Malfoy");
        String ans4 = scanner.nextLine();
        if(ans4.equals("d")){
            score += 5;
        }

        System.out.println("Your final score is:" + score + "/20");
        if(score >= 15){
            System.out.println("Wow, you know your stuff!");
        }else if(score >= 5){
            System.out.println("Not bad!");
        }
        else {
            System.out.println("Better luck next time.");
        }
    }
}
