import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public enum AnimalType {
	WOLF, DEER

}


class Animal {
	private AnimalType type;
	private int x, y;
	
	public Animal(AnimalType type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}
	
	public AnimalType getType() {
		return type;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void move(int newX, int newY) {
		this.x = newX;
		this.y = newY;
	}
}




class Wilderness {
	private Animal[][] grid;
	private List<Animal> animals;
	
	public Wilderness(int rows, int cols, double wolfDensity) {
		grid = new Animal[rows][cols];
		animals = new ArrayList<>();
		Random rand = new Random();
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (rand.nextDouble() < wolfDensity) {
					Animal wolf = new Animal(AnimalType.WOLF, i, j);
					grid[i][j] = wolf;
					animals.add(wolf);
				} 
				
				else {
					Animal deer = new Animal(AnimalType.DEER, i, j);
					grid[i][j] = deer;
					animals.add(deer);
				}
			}
		}
	}
	
	
	public void simulateStep() {
		List<Animal> toRemove = new ArrayList<>();
		
		for (Animal animal : animals) {
			int x = animal.getX();
			int y = animal.getY();
			int newX = x, newY = y;
			
			Random rand = new Random();
			switch (rand.nextInt(4)) {
			case 0: newX = (x + 1) % grid.length; break;
			case 1: newX = (x - 1 + grid.length) % grid.length; break;
			case 2: newY = (y + 1) % grid[0].length; break;
			case 3: newY = (y - 1 + grid[0].length) % grid[0].length; break;
			}
			
			
			if (grid[newX][newY] != null) {
				if (animal.getType() != grid[newX][newY].getType()) {
					toRemove.add(animal.getType() == AnimalType.WOLF ? grid[newX][newY] : animal);
				}
				
				else {
					newX = x;
					newY = y;
				}
			}
			
			
			animal.move(newX,  newY);
			grid[x][y] = null;
			grid[newX][newY] = animal;
		}
		
		for (Animal animal : toRemove) {
			grid[animal.getX()][animal.getY()] = null;
			animals.remove(animal);
		}
	}
	
	
	public void display() {
		for (Animal[] row : grid) {
			for (Animal cell : row) {
				if (cell != null) {
					System.out.print(cell.getType() == AnimalType.WOLF ? "W " : "D ");
				}
				else {
					System.out.print(". ");
				}
			}
			
			System.out.println();
		}
		
		System.out.println();
	}
}
