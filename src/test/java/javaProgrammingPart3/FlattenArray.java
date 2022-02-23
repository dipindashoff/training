package javaProgrammingPart3;

import java.util.Arrays;

public class FlattenArray {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5}, {6}};
        int[] result;

        result = returnAllElementsFromArrays(array);
//        result = returnAllElementsFromArraysUsingJava8(array);

        for (int i : result)
            System.out.print(i + " ");
    }

    public static int[] returnAllElementsFromArrays(int[][] array) {

        int result[];
        int size = 0, k = 0;

        // Get sum of total elements in each array
        for (int[] item : array)
            size = size + item.length;
        result = new int[size];

        for (int[] item : array) {
            for (int i : item) {
                result[k++] = i;
            }
        }
        return result;
    }

    public static int[] returnAllElementsFromArraysUsingJava8(int[][] array) {
        int[] result = Arrays.stream(array)
                .flatMapToInt(Arrays::stream)
                .toArray();

        return result;
    }

}
