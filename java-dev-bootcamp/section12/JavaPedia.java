package section12;

import java.util.Arrays;
import java.util.Scanner;

public class JavaPedia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many historical figures will you register?");
        int figures = scanner.nextInt();
        scanner.nextLine();
        System.out.println("You choose " + figures + " historical figures");

        String[][] database = new String[figures][3];
        System.out.println("Enter the details asked: ");
        for (int i = 0; i < figures; i++){
            System.out.println("Figure: " + (i+1));
            System.out.println("Name: ");
            database[i][0] = scanner.nextLine();
            System.out.println("Date of birth (dd/mm/yy: ");
            database[i][1] = scanner.nextLine();
            System.out.println("Occupation: ");
            database[i][2] = scanner.nextLine();
        }

        printDatabase(database);

        System.out.println("Enter name to search: ");
        String findName = scanner.nextLine();
        searchByName(findName, database);
    }

    public static void printDatabase(String[][] database){
        for (String[] j : database){
            System.out.println(Arrays.toString(j));
        }
    }

    public static void searchByName(String name, String[][] database){
        for(int i = 0; i < database.length; i++){
            if(database[i][0].equals(name)){
                System.out.println("Name: " + database[i][0]);
                System.out.println("Date of Birth: " + database[i][1]);
                System.out.println("Occupation: " + database[i][2]);
            }
            else{
                System.out.println("Data not found");
            }
        }
    }
}
