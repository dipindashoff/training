
package javaProgrammingPart3;

public class MoveZeroes {

    public static void main(String[] args) {
        int a[] = {1, 0, 3, 0, 7, 4, 3, 0, 4};
//        int a[] = {1, 2, 3, 0, 0, 7, 0, 9};
        pushZeroesToLeft(a);
//        pushZeroesToRight(a);
//        moveZeroesToRight(a);
//        moveZeroesToLeft(a);

        for (int i : a)
            System.out.print(i + " ");
    }

    /*
    My Logic
     */
    public static void pushZeroesToLeft(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                int x, y;
                x = a[0];
                for (int j = 0; j <= i; j++) {
                    y = a[j];
                    a[j] = x;
                    x = y;
                }
                a[0] = 0;
            }
        }
    }

    public static void pushZeroesToRight(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 0) {
                int x, y;
                x = a[a.length - 1];
                for (int j = a.length - 1; j >= i; j--) {
                    y = a[j];
                    a[j] = x;
                    x = y;
                }
                a[a.length - 1] = 0;
            }
        }
    }


    /*
    EASIER SOLUTION!!!
    Leetcode Solution
    Push Zeroes to the end

    1 0 3 0 7 0 0 4 0 3
    1 0 3 0 7 0 0 4 0 3 i=0, count=0
    1 0 3 0 7 0 0 4 0 3 i=1, count=0
    1 3 3 0 7 0 0 4 0 3 i=2, count=1
    1 3 3 0 7 0 0 4 0 3 i=3, count=2
    1 3 3 7 7 0 0 4 0 3 i=4, count=3
    1 3 3 7 7 0 0 4 0 3 i=5, count=4
    1 3 3 7 7 0 0 4 0 3 i=6, count=4
    1 3 3 7 4 0 0 4 0 3 i=7, count=4
    1 3 3 7 4 0 0 4 0 3 i=8, count=5
    1 3 3 7 4 3 0 4 0 3 i=9, count=5

    if 'i'th element is non-zero, replace the item with the same index & number
    if 'i'th element is zero, replace this index with the NEXT non-zero i.e. 'i'th element
     */

    public static void moveZeroesToRight(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        while (count < nums.length) {
            nums[count++] = 0;
        }
    }

    public static void moveZeroesToLeft(int[] nums) {
        int count = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                nums[count--] = nums[i];
            }
        }
        while (count >= 0) {
            nums[count--] = 0;
        }
    }

}
