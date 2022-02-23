package javaProrgrammingPart2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        mostDuplicate();
    }

    public static void mostDuplicate() {

        int a[] = {1, 2, 1, 3, 5, 6, 3, 4, 5, 6, 2, 2, 2, 2, 2, 5, 5, 5, 5, 5, 5, 5};

        Arrays.sort(a);

        int max = 0, count = 1, res = 0;

        for (int i = 0; i < a.length-1; i++) {
            if (a[i] == a[i + 1])
                count++;
            else if (count > max) {
                max = count;
                res = a[i];
                count = 1;
            }
        }

        System.out.println("Max is " + res);

    }
}
