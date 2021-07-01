package javaProgrammingPart1;

import java.util.Arrays;

public class FindMissingNumber {

	public static void main(String[] args) {
		int[] numArray = {10, 6, 8, 2, 3, 5, 1, 4, 7, 9, 11, 14, 12, 15, 13, 16, 21, 22, 18, 23, 19, 24, 20, 27, 26, 25};
//		System.out.println(getMissingNumber(numArray));
//		System.out.println(getMissingNumberUsingBinarySearch(numArray));
		System.out.println(getMissingNoUsingSum(numArray, 26));
	}

	public static int getMissingNumber(int[] numArray) {

		Arrays.sort(numArray);

		int missedMe = 0;
		for (int i = 1; i <= numArray.length; i++) {

			if (i != numArray[i - 1]) {
				missedMe = i;
				break;
			}
		}
		return missedMe;
	}
	
	public static int getMissingNumberUsingBinarySearch(int[] numArray) {

		Arrays.sort(numArray);
		int missedMe = 0;
		for (int i = 1; i <= numArray.length; i++) {		

			if(Arrays.binarySearch(numArray, i) <0){
				missedMe = i;
				break;
			}
		}
		return missedMe;
	}
	
	public static int getMissingNoUsingSum(int a[], int n)
    {
        int i, total;
        total = (n + 1) * (n + 2) / 2;
        for (i = 0; i < n; i++)
            total -= a[i];
        return total;
    }
}
