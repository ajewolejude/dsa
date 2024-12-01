public class Util {

    public Util(){}


    // Utility method to swap elements in the array
    void swap(int[] nums, int i, int correctPos) {
        int temp = nums[i]; // Store the current value at index i in a temporary variable
        nums[i] = nums[correctPos]; // Place the value at correctPos into index i
        nums[correctPos] = temp; // Place the value from the temporary variable into correctPos
    }
}
