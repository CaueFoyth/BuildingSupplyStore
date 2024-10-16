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

    public int getCode() { 
        return this.code; 
    }
    
    public String getDescription() { 
        return this.description; 
    }
    
    public double getPrice() { 
        return this.price; 
    }

    @Override
    public String toString() {
        return "Código: " + code + ", Descrição: " + description + ", Preço: R$" + price;
    }
}
