package javaProgrammingPart1;

public class SumOfEachDigits {

	public static void main(String[] args) {

		int n = 0, r = 0, sum = 0;

		for (int i = 100; i <= 200; i++) {
			n = i;
			
			System.out.println("number="+i);

			while (n > 0) {
				
				r = n % 10;
				n = n / 10;

				System.out.println("r=" + r + " n = " + n);

				sum = sum + r;
				System.out.println("sum="+sum);
				System.out.println("-------------");
			}
			
			if (sum == 7)
				System.out.println(i + " is 3 digit number whose sum of digits equals 7");
			
			sum = 0;
			r = 0;

		}
	}
	
//			number=100
//			r=0 n = 10
//			sum=0
//			-------------
//			r=0 n = 1
//			sum=0
//			-------------
//			r=1 n = 0
//			sum=1
//			-------------

}
