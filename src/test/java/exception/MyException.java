package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;

//An Exception is checked, and a RuntimeException is unchecked.

//Checked means that the compiler requires that you handle the exception in a catch, 
// or declare your method as throwing it (or one of its superclasses).
//E.g. FileNotFoundException 

//an unchecked exception if it is something the caller would not normally be able to handle
//E.g. arithmetic exceptions, such as dividing by zero
// ArrayIndexOutOfBoundException, NullpointerException

// 1. Create a class & make it extend Exception class
// 2. Define a constructor which accepts String argument 
// & call the parent constructor using super keyword which accepts the String argument 

public class MyException extends Exception {

	public MyException(String str) {
		super(str);
	}

	// Checked -- if you remove try-catch, compiler will throw an error
	public static void checkedException() {
		try {
			FileReader file = new FileReader("somefile.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Unchecked Exception: caller would not normally be able to handle -- no throws
	// or try-catch necessary
	// E.g. arithmetic exceptions, such as dividing by zero
	public static void execute() {
		throw new RuntimeException("Runtime");
	}

	// Checked Exception: compiler requires that you handle the exception in a
	// catch,
	// or declare your method as throwing it
	public void process() throws MyException {
		throw new MyException("Checked");
	}

	public static void main(String... strings) {

		// Unchecked
//		execute();
		// Not necessarily to be put in a try-catch block
		// as it's not wrapped inside try-catch block, it will stop execution progress

		try {
//			// Unchecked -- Not necessarily to be put in a try-catch block
			// if put in a try=-catch block, execution will proceed after the exception is
			// caught
			// otherwise it will stop execution progress.
			execute();

			// Checked
			throw new MyException("custom exception");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// this line will be executed even after an exception (checked or unchecked) is
		// caught (because it's caught in try-catch block; if not JVM will terminate the program)
		System.out.println("Out of try-catch block");

	}

}
