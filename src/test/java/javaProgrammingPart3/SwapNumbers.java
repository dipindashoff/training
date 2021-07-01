package javaProgrammingPart3;

import org.testng.annotations.Test;

public class SwapNumbers {

    @Test
    // swap two numbers

    // TIP: Use a temp var to store one value
    public void swapNumbers(){
        int no1 = 1;
        int no2 = 2;

        System.out.println("Before Swap: no1 = "+ no1 + ", no2 = " + no2);

        int temp = 0;
        temp = no1;
        no1 = no2;
        no2 = temp;

        System.out.println("After Swap: no1 = "+ no1 + ", no2 = " + no2);
    }

    @Test
    // swap two  without using a temp variable
    // TIP: a,b -> sum = a+b, a = sum - a and b = sum - a
    public void swapNumbersWithoutTempVar(){
        int no1 = 1;
        int no2 = 2;

        System.out.println("Before Swap: no1 = "+ no1 + ", no2 = " + no2);

        no2 = no1 + no2; //3
        no1 = no2 - no1; // 3-1=2
        no2 = no2 - no1; //3-2=1

        System.out.println("After Swap: no1 = "+ no1 + ", no2 = " + no2);
    }
}
