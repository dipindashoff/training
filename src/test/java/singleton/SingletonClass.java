package singleton;

public class SingletonClass {

	// What's a Singleton class?
	// Class where only one instance of the class should be created
	// i.e. only one object should be created; it should not allow to create any
	// other instances of the same class.

//	Singleton Class Diagram
//
//	Static member : This contains the instance of the singleton class.
//	Private constructor : This will prevent anybody else to instantiate the Singleton class.
//	Static public method : This provides the global point of access to the Singleton object and 
// returns the instance to the client calling class.

	// STEPS:
	// 1. Stop other classes from creating an instance of SingletonClass by making
	// its constructor private
	// 2. Create a method inside Singleton class that will return a static instance
	// of this class
	// (because the same instance of the class should be returned every time this
	// method is called).
	// 3. Static also helps to call this method by static reference i.e
	// Classname.methodname
	// avoiding the need to create an object of SingletonClass

	static SingletonClass obj = new SingletonClass();

	private SingletonClass() {

	}

	public static SingletonClass getInstance() {
		return obj;
	}

}
