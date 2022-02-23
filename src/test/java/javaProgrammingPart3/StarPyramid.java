package javaProgrammingPart3;

public class StarPyramid {

    public static void main(String[] args) {
        int n = 4;
//        System.out.println("Right Pyramid");
//        printHalfRIGHTPyramid(n);
//        System.out.println("Left Pyramid");
//        printHalfLEFTPyramid(n);
//        System.out.println("Fake Pyramid");
//        printFakePyramid(n);
//        System.out.println("The 'Real Slim Shady' Pyramid");
//        printFullPyramid(n);
//        System.out.println("Another Pyramid");
        printFullPyramidAnotherLogic(n);

    }

    /*(not recommended)*/
    public static void printHalfRIGHTPyramid(int n) {
        // Print * from 0 to i position
        //  logic since I'm omitting spaces
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printHalfLEFTPyramid(int n) {
        // Print * from (n-i) to n
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= n - i) {
                    System.out.print("*");
                } else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void printFakePyramid(int n) {
        // Print * from (n-i) to n
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= n - i) {
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void printFullPyramid(int n) {

        // How many total spaces?
        // eg n = 4, 7 spaces at bottom row i.e then 4*2-1 = 7

        // How many "*"s?
        // 0 --> 1 star, 1 --> 3 stars, 2 --> 5 stars...
        // How many stars is NOT the right approach instead determine the start and end
        // positions of the "*"

        // "*" start and end position? From n-i to n+i position
        // 0 --> 1 star, pos = 3rd index (middle index)
        // 1 --> 3 stars, pos = 2,3,4 indices
        // 2 --> 5 stars, pos = 1,2,3,4,5 indices
        // 3 --> 7 stars, pos = 0,1,2,3,4,5,6,7 indices

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n * 2 - 1; j++) {
                if (j >= n - i && j <= n + i) {
                    System.out.print("*");
                } else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void printFullPyramidAnotherLogic(int n) {

        // "*" start and end position? From n-i to n+i position
        // 0 --> 1 star, pos = 3rd index (middle index)
        // 1 --> 3 stars, pos = 2,3,4 indices
        // 2 --> 5 stars, pos = 1,2,3,4,5 indices
        // 3 --> 7 stars, pos = 0,1,2,3,4,5,6,7 indices

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n * 2 - 1; j++) {
                if (j == n - i) {
                    for (int k = 1; k <= i + (i + 1); k++)
                        System.out.print("*");
                } else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

}


