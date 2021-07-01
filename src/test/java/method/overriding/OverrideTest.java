package method.overriding;

public class OverrideTest {
	
	//Overriding is also called Runtime Polymorphism

	public static void main(String[] args) {

		BaseClass bc = new ChildClass();
		bc.doSomething("override");

	}

}
