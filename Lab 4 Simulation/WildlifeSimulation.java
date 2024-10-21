
public class WildlifeSimulation {
	public static void main(String[] args) {
		int rows = 10;
		int cols = 10;
		double wolfDensity = 0.3;
		
		Wilderness wilderness = new Wilderness(rows, cols, wolfDensity);
		
		int steps = 10;
		for (int i = 0; i < steps; i++) {
			System.out.println("Step " + (i + 1) + ":");
			wilderness.display();
			wilderness.simulateStep();
		}
	}

}
