public class BSA {

    /*ALGO : WHENEVER I HAVE A SORTED ARRAY THINK BINARY SEARCH FIRST
     * 1. lets say you are looking a number in a sorted array
     * 2.you sum the index of first and last and divide by 2. s+e/2
     * 3. middle is the integer division result
     * 4. you check if target is equal to middle, thats your value,
     * 5. if not you check if target is less than middle, hence s remains s and e becomes middle - 1.
     * 5. if not you check if target is greater than middle, hence e remains e and s becomes middle + 1.
     * 6. then you repeat the same step from 2-4
     * */

    public static void main(String[] args) {

        int[] nums = {10, 1, 3, 4, 6, 7, 2, 8, 9};
        int[] sortedNums = {1, 3, 4, 6, 7, 8, 9};
        int[] sortedNumsDesc = {9, 8, 7, 6, 5, 4, 3};
        int[][] nums2D = {{10, 10, 3, 4, 6, 7, 2, 8, 9}, {55, 66, 3, 1}};

        System.out.println("binarySearch: " + binarySearch(sortedNums, 9));
        System.out.println("orderAgnosticBinarySearch: " + orderAgnosticBinarySearch(sortedNumsDesc, 6));

        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        System.out.println("returnCeiling, 15: " + returnCeiling(arr, 15));
        System.out.println("returnCeiling, 9: " + returnCeiling(arr, 9));
        System.out.println("returnFloor, 15: " + returnFloor(arr, 15));
        System.out.println("returnFloor, 9: " + returnFloor(arr, 9));


    }

    static int binarySearch(int[] arr, int target) {
        if (arr.length == 0) return -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (target < arr[middle]) {
                end = middle - 1;
            } else if (target > arr[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    static int orderAgnosticBinarySearch(int[] arr, int target) {
        if (arr.length == 0) return -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (target > arr[middle]) {
                end = middle - 1;
            } else if (target < arr[middle]) {
                start = middle + 1;

            } else return middle;
        }

        return -1;
    }


    /*CEILING OF A NUMBER
    arr = [2, 3, 5, 9, 14, 16, 18] , target = 15. because of the sorted array i will think BS first.
    ceiling = smallest element in the array greater or equal to target
    ceiling (arr, 15) = 16
    ceiling (arr, 4) = 5
    ceiling (arr, 9) = 9
    *
    *

    this is because the loop breaks eventually
    because the value cannot be found and at that point it is already like e---s, SO WE take that greater value
    for FLOR of number we take the opposite e,
    *  */

    static int returnCeiling(int[] arr, int target) {

        if (arr.length == 0) return -1;

        int start = 0;
        int end = arr.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start;

    }

    static int returnFloor(int[] arr, int target) {

        if (arr.length == 0) return -1;

        int start = 0;
        int end = arr.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return end;

    }


    public char nextGreatestLetter(char[] letters, char target) {
        if (letters.length == 0) return '\0';


        int start = 0;
        int end = letters.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // After the loop, `start` is the index of the smallest character greater than `target`
        // If `start` is out of bounds, wrap around to the first character
        return letters[start % letters.length];

    }


    //34. Find First and Last Position of Element in Sorted Array


    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums.length == 0) return ans;

        ans[0] = search(nums, target, true);
        ans[1] = search(nums, target, false);
        return ans;

    }

    int search(int[] nums, int target, boolean firstIndexSearch) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                // potential answer was found
                ans = mid;
                if (firstIndexSearch) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }

        return ans;
    }

    //34. Find Position of Element in an infinite Sorted Array
}
