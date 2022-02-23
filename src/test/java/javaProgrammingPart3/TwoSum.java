package javaProgrammingPart3;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 7, 2, 2};
        int sum = 9;

//        int[] twoSum = getTwoSum(a, sum);
//        int[] twoSum = getTwoSum2(a, sum);
        int[] twoSum = getTwoSumIndicesUsingHashMap(a, sum);
//        int[] twoSum = usingHashMap(a, sum);
        System.out.println(twoSum[0] + ", " + twoSum[1]);
    }

    public static int[] getTwoSum(int[] a, int sum) {
        int[] sumArr = new int[2];

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j <= a.length; j++) {
                if (sum == a[i] + a[j]) {
                    sumArr[0] = a[i];
                    sumArr[1] = a[j];
                    return sumArr;
                }
            }
        }
        return sumArr;
    }

    public static int[] getTwoSum2(int[] a, int sum) {
        int[] sumArr = new int[2];

        for (int i = 0; i < a.length; i++) {
            int newTarget = sum - a[i];
            for (int j = i + 1; j <= a.length; j++) {
                if (a[j] == newTarget) {
                    sumArr[0] = a[i];
                    sumArr[1] = a[j];
                    return sumArr;
                }
            }
        }
        return sumArr;
    }

    public static int[] getTwoSumIndicesUsingHashMap(int[] a, int sum) {
        int[] sumArr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int newTarget = sum - a[i];

            if (map.containsKey(newTarget)) {
                sumArr[0] = a[i];
                sumArr[1] = newTarget;
                return sumArr;
            }
            map.put(a[i], i);
        }
        return null;
    }

    /*
    Popular Answer on the Internet to return indices of the 2 nos
     */
    public static int[] usingHashMap(int[] numbers, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            Integer requiredNum = (Integer) (target - numbers[i]);
            if (indexMap.containsKey(requiredNum)) {
                return new int[]{indexMap.get(requiredNum), i};
            }
            indexMap.put(numbers[i], i);
        }
        return null;
    }
}