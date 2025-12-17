package algorithm.DE;

public class Product {

	private String productName = "";
	private double weight = 0.0d;
	private double value = 0.0d;
	
	public Product() {
		
	}
	
	public Product(String productName, double weight, double value) {
		setProductName(productName);
		setWeight(weight);
		setValue(value);
	}
	
	public void setProductName(String name) {
		productName = name;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}
	
}
