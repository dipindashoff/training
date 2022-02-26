package javaProgrammingPart3;

public class PushZeroesToLeft {

    public static void main(String[] args) {
        int a[] = {1, 0, 3, 0, 7, 4, 3, 0, 4};
//        int a[] = {1, 2, 3, 0, 0, 7, 0, 9};
        pushZeroesToLeft(a);

        for (int i : a)
            System.out.print(i + " ");
    }

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
}
