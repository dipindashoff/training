package interfaces;

public class Airport {

	// Write new methods that consumes 3 different objects

	void ready(Bird bird) {

		bird.takeOff();
		bird.land();
	}

	void ready(Airplane plane) {

		plane.takeOff();
		plane.land();
	}

	void ready(Superman man) {

		man.takeOff();
		man.land();
	}

	// OR simply write one method that takes in an interface reference variable
	void ready(Fly fly) {

		fly.takeOff();
		fly.land();
	}
	
	// Assign a Bird obj to a Fly ref
	Fly report() {
		return new Bird();
	}

}
