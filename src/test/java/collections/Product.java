package collections;

public class Product {
	
	private int weight;
	
	public Product(int weight){
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Product [weight=" + weight + "]";
	}

}
