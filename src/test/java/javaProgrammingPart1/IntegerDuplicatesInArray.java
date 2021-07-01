package javaProgrammingPart1;

import java.util.*;

public class IntegerDuplicatesInArray {

    /*
    Given an array of integers where each value 1 <= x <= len(array),
    write a function that finds all the duplicates in the array.
     */

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 2, 3};
        int[] arr2 = {2,1,2,3,5,1,5};
        System.out.println(findDuplicatesInAnArrayBruteForce(arr2));
        System.out.println(findDuplicatesEfficient(arr1));
    }

    /*
    Return list of duplicates in an integer array
     */
    public static Set<Integer> findDuplicatesInAnArrayBruteForce(int[] arr) {
        // Sort the arr
        Arrays.sort(arr);

        // Create a result set
        Set<Integer> resultSet = new HashSet<>();

        // Compare i & i+1
        for(int i=0; i < arr.length-1; i++){
            for(int j= i+1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    resultSet.add(arr[i]);
                    continue;
                }
            }
        }
        return resultSet;
    }


    /* Return a list of duplicates in the array. To avoid using extra space,
    we flag which elements we've seen before by negating the value at
    indexed at that value in the array */
    public static List<Integer> findDuplicatesEfficient(int[] arr) {
        // Use a set for results to avoid duplicates
        Set<Integer> resultSet = new HashSet<Integer>();

        for (int i = 0; i < arr.length; i++) {
            // Translate the value into an index (1 <= x <= len(arr))
            int index = Math.abs(arr[i]) - 1;

            // If the value at that index is negative, then we've already seen
            // that value so it's a duplicate. Otherwise, negate the value at
            // that index so we know we've seen it
            if (arr[index] < 0) {
                resultSet.add(Math.abs(arr[i]));
            } else {
                arr[index] = -arr[index];
            }
        }

        // Return the array to it's original state
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i]);
        }
        return new ArrayList(resultSet);
    }
}
