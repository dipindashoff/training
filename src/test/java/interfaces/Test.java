package interfaces;

public class Test {

	public static void main(String[] args) {
		
		Fly bird = new Bird();
		Fly plane = new Airplane();
		Fly man = new Superman();
		
		Airport airport = new Airport();
		airport.ready(bird);
		System.out.println();
		airport.ready(plane);
		System.out.println();
		airport.ready(man);
		
		System.out.println();
		// Here, you never know what object is returned
		Fly fly = airport.report();
		fly.takeOff();
		
		

	}

}
