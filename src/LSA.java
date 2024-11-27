public class LSA {

    public static void main(String[] args) {

        int[] nums = {10, 1, 3, 4, 6, 7, 2, 8, 9};
        int[][] nums2D = {{10, 10, 3, 4, 6, 7, 2, 8, 9}, {55,66,3,1}};
        System.out.println("linearSearch, 6: " + linearSearch(nums, 6));
        System.out.println("linearSearch, 70: " + linearSearch(nums, 70));
        System.out.println("linearSearchInRange, 6: " + linearSearchInRange(nums, 6, 0, 3));
        System.out.println("linearSearchInRange, 7: " + linearSearchInRange(nums, 7, 0, 2));
        System.out.println("findMinimumElement: " + findMinimumElement(nums));
        System.out.println("findMinimumElementIn2D: " + findMinimumElementIn2D(nums2D));
        System.out.println("findMaximumElementIn2D: " + findMaximumElementIn2D(nums2D));


        String name = "adedamola";
        System.out.println("linearSearchString, a: " + linearSearchString(name, 'a'));
        System.out.println("linearSearchString, z: " + linearSearchString(name, 'z'));


        //return how many numbers are  with even number of digits
        int[] numbers = {101, 100, 3000, 49, 6000, 700000, 20, 8, 9};
        System.out.println("findNumberWithEvenNumbersOfDigit: " + findNumberWithEvenNumbersOfDigit(numbers));



    }



    static int linearSearch(int[] arr, int target) {

        if (arr.length == 0) return -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    static int linearSearchInRange(int[] arr, int target, int start, int end) {

        if (arr.length == 0) return -1;

        for (int i = start; i <= end; i++) {
            if (target == arr[i]) {
                return i;
            }
        }

        return -1;
    }

    static int linearSearchString(String word, char letter) {


        if (word.length() == 0) {
            return -1;
        }


        for (int i = 0; i < word.length(); i++) {
            if (letter == word.charAt(i)) {
                return i;
            }
        }

        return -1;
    }

    //find minimum element
    static int findMinimumElement(int[] arr) {
        if (arr.length == 0) return -1;

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int next = arr[i];
            if (min > next) {
                min = next;
            }
        }


        return min;
    }

    static int findMinimumElementIn2D(int[][] arr){

        if (arr.length == 0)return -1;

        int min = arr[0][0];
        for (int i = 0; i <arr.length; i ++){

            for(int j = 0; j<arr[i].length; j++){
                int next= arr[i][j];
                if(min>next){
                    min = next;
                }
            }
        }
        return min;
    }
    static int findMaximumElementIn2D(int[][] arr){

        if (arr.length == 0)return -1;

        int max = arr[0][0];
        for (int i = 0; i <arr.length; i ++){

            for(int j = 0; j<arr[i].length; j++){
                int next= arr[i][j];
                if(max<next){
                    max = next;
                }
            }
        }
        return max;
    }

    private static int findNumberWithEvenNumbersOfDigit(int[] numbers) {

        if(numbers.length == 0) return -1;

        int count = 0;
        for(int i = 0 ; i <numbers.length; i++){
            int number = numbers[i];
            if(isEven(number)) count++;
        }
        return count;
    }

    private static boolean isEven(int number) {
        if(numberOfDigits(number) % 2 == 0) {
            return true;
        }else {
            return false;

        }
    }

    private static int numberOfDigits(int number) {
        int count = 0;
        while (number>0){
            count++;
            number = number / 10;
        }
        return count;
    }

}
