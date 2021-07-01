package exception;

public class TryCatchFinally {
	
	// only try block is mandatory while catch and finally blocks are optional. 
	// With a try block, we can use either a catch block or finally block as needed
	
	// Use of finally:
	// we can close a resource with finally 
	// Alterantive to try-finally is try with resources, see TreyWithResources class file

	public static void main(String[] args) {

		// try-catch
		System.out.println("***try-catch***");
		try {
			System.out.println("try block");
			throw new NullPointerException();
		} catch (Exception e) {
			System.out.println("catch block");
			e.printStackTrace();
		}

		System.out.println("***try-finally***");

		// try-finally
		try {
			System.out.println("try block");
		} finally {
			System.out.println("finally block");
		}

		System.out.println("***try-catch-finally***");

		// try-catch-finally
		try {
			System.out.println("try block");
			throw new NullPointerException();
		} catch (Exception e) {
			System.out.println("catch block");
			e.printStackTrace();
		} finally {
			System.out.println("finally block");
		}

		System.out.println("***try-finally (with exception)***");

		// try-finally
		try {
			System.out.println("try block");
			throw new NullPointerException();
		} finally {
			System.out.println("finally block");
		}

	}

}
