package section12;

public class IntroToArray {
    public static void main(String[] args){

//        String kingdom1 = "Maheshmati";
//        String kingdom2 = "Salaar";
//        String kingdom3 = "Bharat";

        String[] kingdoms = {"Maheshmati", "Salaar", "Bharat"};
        System.out.println(kingdoms[0]);
        System.out.println(kingdoms[1]);
        System.out.println(kingdoms[2]);

        int[] num = {1, 2, 3, 4, 5};

        for (int j : num) {
            System.out.println(j);
        }
    }
}
