package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {
    private List<Product> products = new ArrayList<>();
    private Map<Integer, Integer> stock = new HashMap<>();
    private List<Sale> sales = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        stock.put(product.getCode(), 0);
    }

    public void updateStock(int code, int qty) {
        stock.put(code, stock.getOrDefault(code, 0) + qty);
    }

    public boolean sellProduct(int code, int qty) {
        if (stock.getOrDefault(code, 0) >= qty) {
            stock.put(code, stock.get(code) - qty);
            return true;
        }
        return false;
    }

    public List<Product> listProducts() {
        return products;
    }

    public List<Product> listAvailableStock() {
        List<Product> available = new ArrayList<>();
        for (Product product : products) {
            if (stock.getOrDefault(product.getCode(), 0) > 0) {
                available.add(product);
            }
        }
        return available;
    }

    public double getProductPrice(int code) {
        return products.stream().filter(p -> p.getCode() == code).findFirst().orElse(null).getPrice();
    }

    public void addSale(Sale sale) {
        sales.add(sale);
    }

    public List<Sale> listSales() {
        return sales;
    }

    public double calculateTotalSales() {
        return sales.stream().mapToDouble(Sale::getTotalValue).sum();
    }
}
