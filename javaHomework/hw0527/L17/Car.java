package javaHomework.hw0527.L17;

public class Car extends Vehicle {
    private int seatCount = 0;

    public Car(String model, double rentCost, int seatCount) {
        super(model, rentCost);
        setSeatCount(seatCount);
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void showCarInfo() {
        showStatus();
        System.out.println("座位數: " + seatCount);
    }
}
