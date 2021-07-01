package arrays;

public class TestArrays {

	public static void main(String[] args) {

		int[] a = new int[4];

		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;

		int [] b = new int[] { 1, 2, 3, 4 };
		int c[] = { 1, 2, 3, 4 }; // anonymous array

		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);

	}

}
