package section12;

import java.util.Arrays;

public class TDArray {
    public static void main(String[] args) {

        int[][] nums = new int[3][4];
        System.out.println("Harry: " + Arrays.toString(nums[0]));
        System.out.println("Tom: " + Arrays.toString(nums[1]));
        System.out.println("Jerry: " + Arrays.toString(nums[2]));

        nums[0][0] = 89;
        nums[0][1] = 83;
        nums[0][2] = 29;
        nums[0][3] = 49;

        System.out.println("Harry: " + Arrays.toString(nums[0]));
        System.out.println("Tom: " + Arrays.toString(nums[1]));
        System.out.println("Jerry: " + Arrays.toString(nums[2]));

        int[][] grades = {
                {1, 2, 3, 4},
                {4, 5, 6, 5},
                {7, 8, 9, 4}
        };

        for (int[] grade : grades) {
            System.out.println(Arrays.toString(grade));
        }
    }
}
