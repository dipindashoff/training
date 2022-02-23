package javaProgrammingPart3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesInArray {

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 3, 3, 4, 5, 5, 6};

//        int[] result = returnUniqueArray(array);
//        for (int i : result)
//            if (i != 0)
//                System.out.print(i + " ");
//        System.out.println();
//        System.out.println(result.length);

//        findSizeOfNewArray(array);
        usingHashMap(array);

    }

    public static int[] returnUniqueArray(int[] array) {

        Arrays.sort(array);
        int[] result = new int[array.length];
        int k = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                result[k++] = array[i];
            }
        }
        return result;
    }

    public static void findSizeOfNewArray(int[] array) {
        Arrays.sort(array);
        int k = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                k++;
            }
        }
        System.out.println(k + 1);
    }

    public static void usingArrayList(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : array) {
            if (!list.contains(i))
                list.add(i);
        }

        list.forEach(System.out::print);
    }

    public static void usingHashMap(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i]))
                map.put(array[i], i);
        }

        map.forEach((k,v) -> System.out.print(k));

    }

}