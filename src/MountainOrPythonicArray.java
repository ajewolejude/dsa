public class MountainOrPythonicArray {


    /*ALGO : WHENEVER I HAVE A MOUNTAIN OR BYONIC ARRAY
     * 1. so we use bsa
     * 2. part of array is asc while second is desc
     * 3. find middle
     * 4. then check if arr[mid] is less or equal to  arr[mid+1], then we are in the asc area
     * 5. so move to the other side, so start = mid + 1
     * 5. else, we might have found our answer so we set answer to mid,
     * but then there is the "==" part, so we need to set mid - 1;
     * 6. then you repeat the same step from 2-4
     * */


    public static void main(String[] args) {

        int[] nums = {10, 1, 3, 4, 6, 7, 2, 8, 9};
        int[] sortedNums = {1, 3, 4, 6, 7, 8, 9, 10,4, 3, 2, 1};
        int[] sortedNumsDesc = {9, 8, 7, 6, 5, 4, 3};
        int[][] nums2D = {{10, 10, 3, 4, 6, 7, 2, 8, 9}, {55, 66, 3, 1}};

        System.out.println("peakIndexInMountainArray: " + peakIndexInMountainArray(sortedNums));
        System.out.println("peakIndexInMountainArray: " + sortedNums[peakIndexInMountainArray(sortedNums)]);



    }

    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]) {
                // you are in dec part of array
                // this may be the ans, but look at left
                // this is why end != mid - 1
                end = mid;
            } else {
                // you are in asc part of array
                start = mid + 1; // because we know that mid+1 element > mid element
            }
        }
        // in the end, start == end and pointing to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        // more elaboration: at every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining, hence cuz of above line that is the best possible ans
        return start; // or return end as both are =
    }
}
