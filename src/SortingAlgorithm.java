import java.util.Arrays;

public class SortingAlgorithm {

    /*ALGO : WHENEVER I HAVE A SORTED ARRAY THINK BINARY SEARCH FIRST
     * 1. lets say you are looking a number in a sorted array
     * 2.you sum the index of first and last and divide by 2. s+e/2
     * 3. middle is the integer division result
     * 4. you check if target is equal to middle, thats your value,
     * 5. if not you check if target is less than middle, hence s remains s and e becomes middle - 1.
     * 5. if not you check if target is greater than middle, hence e remains e and s becomes middle + 1.
     * 6. then you repeat the same step from 2-4
     * */

    private static final Util util = new Util();

    public static void main(String[] args) {

        int[] nums = {10, 1, 3, 4, 6, 7, 2, 8, 9};
        int[] nums5 = {3,5,2,1,4};
        int[] sortedNums = {1, 3, 4, 6, 7, 8, 9, 10, 13, 14, 18, 19, 20, 28, 29};
        int[] sortedNumsDesc = {9, 8, 7, 6, 5, 4, 3};
        int[][] nums2D = {{10, 10, 3, 4, 6, 7, 2, 8, 9}, {55, 66, 3, 1}};

        System.out.println("bubbleSortAlgorithm: " + Arrays.toString(bubbleSortAlgorithm(nums)));
        System.out.println("cycleSortAlgorithm: " + Arrays.toString(cycleSortAlgorithm(nums5)));


    }

    private static int[] bubbleSortAlgorithm(int[] nums) {
        if (nums.length == 0) return new int[]{-1};
        for (int i = 0; i < nums.length; i++) {
            boolean swapped = false;
            for (int j = 1; j < nums.length - i; j++) {

                if(nums[j] < nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    swapped = true;
                }

                if(!swapped) break;

            }
        }

        return nums;


    }

    private static int[] cycleSortAlgorithm (int[] nums){

        if (nums.length == 0) return new int[]{-1};
        int i = 0;
        while (i < nums.length){
            int correctPos = nums[i] - 1;
            if(nums[i] != nums[correctPos]){
                util.swap(nums, i, correctPos);
            }else {
                i++;
            }
        }
        return nums;
    }


}
