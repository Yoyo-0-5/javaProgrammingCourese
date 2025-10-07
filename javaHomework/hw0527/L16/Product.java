package javaHomework.hw0527.L16;

public class Product {
    private String id;
    private String name;
    private int price;
    private int stock;

    public Product(String id, String name, int price, int stock) {
        setId(id);
        setName(name);
        setPrice(price);
        setStock(stock);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
        System.out.println(name + " 價格已更新為 " + price);
    }

    public int getPrice() {
        return price;
    }

    public void setStock(int stock) {
        this.stock = stock;
        System.out.println(name + " 庫存已更新為 " + stock);
    }

    public int getStock() {
        return stock;
    }

    public void showInfo() {
        System.out.println("產品ID: " + getId());
        System.out.println("產品名稱: " + getName());
        System.out.println("價格: " + getPrice());
        System.out.println("庫存: " + getStock());
    }
}
