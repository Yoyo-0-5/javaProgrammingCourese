package javaHomework.hw0527.L17;

public class Case17 {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota Altis", 1300, 5);
        car1.showCarInfo();
        car1.rent();
        car1.rent();
        car1.returnVehicle();
        car1.returnVehicle();
        System.out.println("---------- Bike ---------");
        Bike bike1 = new Bike("Giant A123", 200, "公路胎");
        bike1.showBikeInfo();
        bike1.rent();
        bike1.rent();
        bike1.returnVehicle();
        bike1.returnVehicle();
    }
}
