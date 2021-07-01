package interfaces;

public class Bird implements Fly{

	@Override
	public void takeOff() {
		System.out.println("Bird takes off");
		
	}

	@Override
	public void land() {
		System.out.println("Bird lands");		
	}

}
