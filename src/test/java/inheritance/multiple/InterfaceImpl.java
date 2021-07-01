package inheritance.multiple;

public class InterfaceImpl implements InterfaceA, InterfaceB, InterfaceC {

	public static void main(String[] args) {
		
		
		InterfaceA intA = new InterfaceImpl();
		InterfaceA intB = new InterfaceImpl();
		InterfaceA intC = new InterfaceImpl();
		
		
		intA.doSomething("A");
		intA.doSomething("B");
		intA.doSomething("C");

	}

	@Override
	public void doSomething(String a) {
		System.out.println(a);		
	}

}
