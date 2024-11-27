public class SearchingInMatrix {

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
        int[] sortedNums = {1, 3, 4, 6, 7, 8, 9, 10, 13, 14, 18, 19, 20, 28, 29};
        int[] sortedNumsDesc = {9, 8, 7, 6, 5, 4, 3};
        int[][] nums2D = {{10, 10, 3, 4, 6, 7, 2, 8, 9}, {55, 66, 3, 1}};




    }

    private static int searchingInMatrix (int[] sortedNums, int target) {

        int start = 0;
        int CHUNK_SIZE = 2;
        int end = 1;
        while (target >= sortedNums[end]){

            int temp = end + 1;
            //end  = previous end +  size of box * 2
            end = end + (end - start +1) *2;
            start = temp;

        }

        while(start <= end){
            int mid = start + (end - start)/2;
            if(target<sortedNums[mid]){
                end = mid -1;
            } else if(target>sortedNums[mid]){
                start = mid +1;
            }else return mid;
        }

        return -1;


    }


    //34. Find Position of Element in an infinite Sorted Array
}
