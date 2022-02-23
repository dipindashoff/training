package javaProgrammingPart3;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};

//        findTripletsWithDuplicates(a).forEach(System.out::println);
        findTripletsWITHOUTDuplicates(a).forEach(System.out::println);
    }

    public static List<List<Integer>> findTripletsWithDuplicates(int[] a) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.length - 2; i++) {
            for (int j = i + 1; j < a.length - 1; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (i != j && i != k && j != k && a[i] + a[j] + a[k] == 0) {
                        result.add(Arrays.asList(a[i], a[j], a[k]));
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> findTripletsWITHOUTDuplicates(int[] a) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (i != j && i != k && j != k && a[i] + a[j] + a[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(a[i]);
                        temp.add(a[j]);
                        temp.add(a[k]);
                        Collections.sort(temp);
                        result.add(Arrays.asList(a[i], a[j], a[k]));
                    }
                }
            }
        }
        result = new ArrayList<>(new HashSet<>(result));
        return result;
    }

}
