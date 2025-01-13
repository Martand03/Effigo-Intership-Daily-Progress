package section8;

public class DocComments {

    public static void main(String[] args) {

    }

    /**
     * Function name greet:
     * 1. prints: 'Hi'
     * Inside the function
     */

    public static void greet(){
        System.out.println("Hi");
    }

    /**
     *
     * @param name (String)
     * @param age (String)
     *
     * Inside the function:
     * 1. prints the name and age as part of the text
     */
    public static void prinText(String name, String age){
        System.out.println("Hi, I'm " + name + ". My age is " + age);
    }
}
