package javaProgrammingPart3;

import java.util.HashMap;
import java.util.Map;

public class RotationOfNumbers {

    public static void main(String[] args) {
        int[] a = {15, 18, 2, 3, 6, 12};
//        int[] a = {7,9,11,12,5};
//        int[] a = {1,2,3,4};
//        int[] a = {4,1,2,3};
//        int[] a = {3, 4, 1, 2};
        System.out.println("No. of rotation (clockwise): " + getNoOfRotation(a));
    }

    public static int getNoOfRotation(int[] a) {
        int[] smallestInteger = getSmallestInteger(a);
        return smallestInteger[1];
    }

    public static int[] getSmallestInteger(int[] a) {
        int min, index;
        min = a[0];
        index = 0;
        for (int i = 1; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
                index = i;
            }
        }
        System.out.println("min=" + min + ", index:" + index);
        return new int[]{min, index};
    }
}
