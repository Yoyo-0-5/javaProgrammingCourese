package algorithm.Problem.Knapsack;

public class Product {
    private String name;
    private double weight = 0.0d;
    private double value = 0.0d;

    public Product() {

    }

    public Product(String name, double weight, double value) {
        setName(name);
        setWeight(weight);
        setValue(value);
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
