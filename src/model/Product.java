package model;

public class Product {
    private int code;
    private String description;
    private double price;

    public Product(int code, String description, double price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public int getCode() { return code; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }

    public String toString() {
        return "Código: " + code + ", Descrição: " + description + ", Preço: " + price;
    }
}
