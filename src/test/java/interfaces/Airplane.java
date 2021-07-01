package interfaces;

public class Airplane implements Fly{

	@Override
	public void takeOff() {
		System.out.println("Airplane takes off");
		
	}

	@Override
	public void land() {
		System.out.println("Airplane lands");
		
	}

}
