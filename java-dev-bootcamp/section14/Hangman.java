package section14;

import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's play Hangman: ");
        System.out.println(gallows[0]);

        // comp selection for word
        int option = (int)((Math.random() * 65) + 1);
        System.out.println(option);
        String selectedWord = words[option];
        System.out.println(selectedWord);
        char[] displayWord = new char[selectedWord.length()];
        Arrays.fill(displayWord, '_');
        System.out.print("Words: ");
        for (char c : displayWord) {
            System.out.print(" " + c);
        }
        System.out.println();

        // guesses from user
        int chances = 0;
        char[] misses = new char[6];
        Arrays.fill(misses, '_');

        while(chances < 6 && (new String(displayWord).contains("_"))){
            System.out.println("Guess a letter: ");
            char input = scanner.nextLine().charAt(0);
            boolean correctGuess = false;

            for(int j=0; j<selectedWord.length(); j++){
                if(selectedWord.charAt(j) == input && displayWord[j] == '_') {
                    displayWord[j] = input;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                misses[chances] = input;
                chances++;
            }

            System.out.println(gallows[chances]);

            System.out.print("Word: ");
            for(char c: displayWord){
                System.out.print(c + " ");
            }
            System.out.println();
            System.out.print("Misses: ");
            for(char l: misses){
                System.out.print(l + " ");
            }
            System.out.println();
        }

        // final result

        if (!new String(displayWord).contains("_")) {
            System.out.println("Congratulations!!! You guessed the word: " + selectedWord);
        } else {
            System.out.println("You lost :( The word was: " + selectedWord);
        }

    }
    public static String[] words = {
            "ant", "baboon", "badger", "bat", "bear","beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer", "dog", "donkey", "duck",
            "eagle", "ferret", "fox", "frog", "goat", "goose", "hawk", "lion", "lizard", "llama",
            "mole", "monkey", "moose", "mouse", "mule", "newt", "otter", "owl", "panda", "parrot",
            "pigeon", "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal", "shark",
            "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan", "tiger", "toad", "trout",
            "turkey","turtle", "weasel", "whale", "wolf", "wombat", "zebra"
    };

    public static String[] gallows = {
            "+---+\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +   //if the user didn't miss any guesses.
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +   //if the user missed one guess.
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +    //if the user missed two guesses.
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +   //if the user missed three guesses.
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n"+   //if the user missed four guesses.
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +  //if the user missed five guesses.
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +   //if the user missed six guesses.
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n"
    };
}
