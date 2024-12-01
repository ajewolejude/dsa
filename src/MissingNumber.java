import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//268. Missing Number
//Given an array nums containing n distinct numbers in the range [0, n],
// return the only number in the range that is missing from the array
//

//448. Find All Numbers Disappeared in an Array
//Given an array nums of n integers where nums[i] is in the range [1, n],
//return an array of all the integers in the range [1, n] that do not appear in nums.

//287. Find the Duplicate Number
//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//There is only one repeated number in nums, return this repeated number.
//You must solve the problem without modifying the array nums and using only constant extra space.
//return an array of all the integers in the range [1, n] that do not appear in nums.


public class MissingNumber {

    private static final Util util = new Util();

    public static void main(String[] args) {
        int[] nums = {0, 3, 5, 1, 4};
        int[] numsDisappeared = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] numsDuplicated = {3, 1, 3, 4, 2};


        System.out.println("missing number - cycleSortAlgorithm: " + missingNumber(nums));
        System.out.println("missing number list - cycleSortAlgorithm: " + findMissingNumbers(numsDisappeared));
        System.out.println("duplicate number - cycleSortAlgorithm: " + findDuplicate(numsDuplicated));
    }

    static int missingNumber(int[] nums) {

        // If the array is empty, return -1 as there is no valid number
        if (nums.length == 0) return -1;

        int i = 0;

        // Rearrange the array so that each number is at its "correct position"
        // For example, nums[i] should ideally be placed at index nums[i].
        while (i < nums.length) {
            int correctPos = nums[i]; // The index where nums[i] should be placed

            // Swap nums[i] with nums[correctPos] only if:
            // 1. nums[i] is less than nums.length (to avoid out-of-bound errors)
            // 2. nums[i] is not already in its correct position
            if (nums[i] < nums.length && nums[i] != nums[correctPos]) {
                util.swap(nums, i, correctPos); // Swap nums[i] to its correct position
            } else {
                i++; // Move to the next index if nums[i] is already in the correct position
            }
        }

        // Iterate through the rearranged array to find the first index
        // where the value does not match the index. This index is the missing number.
        for (int j = 0; j < nums.length; j++) {
            if (j != nums[j]) { // If the value at index j is not equal to j
                return j; // Return the index as the missing number
            }
        }

        // If all indices match their values, the missing number is nums.length
        return nums.length;
    }

    static List<Integer> findMissingNumbers(int[] nums) {

        // If the array is empty, return an empty list as there are no missing numbers
        if (nums.length == 0) return new ArrayList<>();

        int i = 0; // Start iterating through the array

        // Rearrange the array so that every number is placed at its "correct position"
        // For example, the number `n` should be at index `n - 1`.
        while (i < nums.length) {
            int correctPos = nums[i] - 1; // Calculate the correct index for nums[i]

            // Swap nums[i] with nums[correctPos] if nums[i] is not at its correct position
            // and nums[i] is not already in its correct spot.
            if (nums[i] != nums[correctPos]) {
                util.swap(nums, i, correctPos);
            } else {
                i++; // Move to the next index if nums[i] is already in the correct position
            }
        }

        // After rearranging, collect all indices where the value does not match the index
        List<Integer> disappearedNumbers = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) { // If the value at index `j` is not `j + 1`
                disappearedNumbers.add(j + 1); // Add the missing number to the list
            }
        }

        return disappearedNumbers; // Return the list of missing numbers
    }

    static int findDuplicate(int[] nums) {

        // If the array is empty, return -1 as no duplicate can exist.
        if (nums.length == 0) return -1;

        // Debug: Print the array before sorting
        System.out.println("before sort: " + Arrays.toString(nums));

        // Initialize the index i to 0 for the cyclic sort process
        int i = 0;

        // Start sorting using the cyclic sort approach
        while (i < nums.length) {
            // Calculate the correct position for the current number nums[i]
            int correctPos = nums[i] - 1;

            // If the current number is not at its correct position, swap it
            if (nums[i] != nums[correctPos]) {
                util.swap(nums, i, correctPos); // Swap the number to its correct position
            } else {
                i++; // If the number is already in the correct position, move to the next index
            }
        }

        // Debug: Print the array after sorting to see the final arrangement
        System.out.println("after sort: " + Arrays.toString(nums));

        // Since the duplicate number cannot be placed correctly, it will be at the end of the array
        return nums[nums.length - 1]; // Return the duplicate number found at the end
    }


}
