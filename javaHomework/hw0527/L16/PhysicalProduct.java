package javaHomework.hw0527.L16;

public class PhysicalProduct extends Product {
    private int shippingFee;

    public PhysicalProduct(String id, String name, int price, int stock, int shippingFee) {
        super(id, name, price, stock);
        setShippingFee(shippingFee);
    }

    public void setShippingFee(int fee) {
        this.shippingFee = fee;
    }

    public int getShippingFee() {
        return shippingFee;
    }

    public void showShippingFee() {
        System.out.println(getName() + " 運費資訊: " + getShippingFee());
    }
}
