package abstractClass;

public abstract class AbstractClass {

	AbstractClass() {
		System.out.println("AbstractClass Constructor");
	}

	abstract void doSomething();

	// we can have an abstract class without any abstract method.
	// This allows us to create classes that cannot be instantiated, but can only be
	// inherited.
	
//	// An abstract class without any abstract method 
//	abstract class Base {    
//	    void fun() { System.out.println("Base fun() called"); } 
//	} 
//	   
//	class Derived extends Base { } 
//	   
//	class Main { 
//	    public static void main(String args[]) {  
//	        Derived d = new Derived(); 
//	        d.fun(); 
//	    } 
//	} 
	
	
//	Abstract classes can also have final methods (methods that cannot be overridden). 
// For example, the following program compiles and runs fine.

//	// An abstract class with a final method 
//	abstract class Base { 
//	    final void fun() { System.out.println("Derived fun() called"); } 
//	} 
//	   
//	class Derived extends Base {} 
//	   
//	class Main { 
//	    public static void main(String args[]) {  
//	       Base b = new Derived(); 
//	       b.fun(); 
//	    } 
//	}  

}
