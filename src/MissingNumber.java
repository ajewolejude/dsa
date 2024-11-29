import java.util.Arrays;


//268. Missing Number
//Given an array nums containing n distinct numbers in the range [0, n],
// return the only number in the range that is missing from the array
//


public class MissingNumber {



    public static void main(String[] args) {
        int[] nums = {0,3,5,1,4};

        System.out.println("missing number - cycleSortAlgorithm: " + missingNumber(nums));
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
                swap(nums, i, correctPos); // Swap nums[i] to its correct position
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

    // Utility method to swap elements in the array
    static void swap(int[] nums, int i, int correctPos) {
        int temp = nums[i]; // Store the current value at index i in a temporary variable
        nums[i] = nums[correctPos]; // Place the value at correctPos into index i
        nums[correctPos] = temp; // Place the value from the temporary variable into correctPos
    }
}
