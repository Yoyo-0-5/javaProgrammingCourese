package javaHomework.hw0527.L17;

public class Vehicle {
    private String model;
    private double rentCost;
    private boolean isRented = false;

    public Vehicle(String model, double rentCost) {
        setModel(model);
        setRentCost(rentCost);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public double getRentCost() {
        return rentCost;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rent() {
        if (isRented) {
            System.out.println(model + " 已被租出");
        } else {
            isRented = true;
            System.out.println(model + " 租賃成功，成本: " + rentCost);
        }
    }

    public void returnVehicle() {
        if (!isRented) {
            System.out.println(model + " 並未被租出，不需歸還");
        } else {
            isRented = false;
            System.out.println(model + " 歸還成功");
        }
    }

    public void showStatus() {
        System.out.println("車型: " + model);
        System.out.println("租賃成本: " + rentCost);
        System.out.print("租賃狀態: ");
        if (isRented) {
            System.out.println("已被租出");
        } else {
            System.out.println("可租賃");
        }
    }
}
