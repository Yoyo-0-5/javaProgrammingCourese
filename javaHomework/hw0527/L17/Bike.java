package javaHomework.hw0527.L17;

public class Bike extends Vehicle {
    private String tireType = "";

    public Bike(String model, double rentCost, String tireType) {
        super(model, rentCost);
        setTireType(tireType);
    }

    public void setTireType(String tireType) {
        this.tireType = tireType;
    }

    public String getTireType() {
        return tireType;
    }

    public void showBikeInfo() {
        showStatus();
        System.out.println("輪胎類型: " + tireType);
    }
}
