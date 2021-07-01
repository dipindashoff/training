package method.overloading;

public class MethodOverloading {
	
	public static void method() {
		System.out.println("Nothing");
	}
	
	public static void method(String a) {
		System.out.println("One String Argument: "+a);
	}
	
	public static void main(String... args) {
		method();
		method("apple");
		
	}

}
