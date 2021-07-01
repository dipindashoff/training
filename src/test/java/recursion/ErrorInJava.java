package recursion;

public class ErrorInJava {

	public static void test(int i) {
		if (i == 0)
			return;
		else
			// Call test method over & over again to throw error: Exception in thread "main"
			// java.lang.StackOverflowError
			test(i++);

	}

	public static void main(String... args) {

		test(5);
	}

}
