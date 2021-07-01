package interfaces;

public class Superman implements Fly{

	@Override
	public void takeOff() {
		System.out.println("Superman takes off");
		
	}

	@Override
	public void land() {
		System.out.println("Superman lands");
		
	}


}
