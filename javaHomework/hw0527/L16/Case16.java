package javaHomework.hw0527.L16;

public class Case16 {
    public static void main(String[] args) {
        DigitalProduct ebook = new DigitalProduct("A123", "電子書", 1500, 100, 3);
        ebook.showInfo();
        ebook.download();
        ebook.download();
        ebook.download();
        ebook.download();
        System.out.println("----------------------");
        PhysicalProduct phone = new PhysicalProduct("P123", "手機", 25000, 50, 75);
        phone.showInfo();
        phone.showShippingFee();
        phone.setPrice(20000);
        phone.setStock(30);
        phone.showInfo();
    }
}
