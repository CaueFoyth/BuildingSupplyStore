package model;

import java.util.ArrayList;

public class Stock {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Integer> stockQuantities = new ArrayList<>();
    private ArrayList<Sale> sales = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        stockQuantities.add(0);
    }

    public void updateStock(int code, int qty) {
        int index = findProductIndex(code);
        if (index != -1) {
            int newQuantity = stockQuantities.get(index) + qty;
            stockQuantities.set(index, newQuantity);
        }
    }

    public boolean sellProduct(int code, int qty) {
        int index = findProductIndex(code);
        if (index != -1 && stockQuantities.get(index) >= qty) {
            stockQuantities.set(index, stockQuantities.get(index) - qty);
            return true;
        }
        return false;
    }

    public ArrayList<Product> listProducts() {
        return products;
    }

    public ArrayList<Product> listAvailableStock() {
        ArrayList<Product> available = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (stockQuantities.get(i) > 0) {
                available.add(products.get(i));
            }
        }
        return available;
    }

    public double getProductPrice(int code) {
        int index = findProductIndex(code);
        if (index != -1) {
            return products.get(index).getPrice();
        }
        return 0.0;
    }

    public void addSale(Sale sale) {
        sales.add(sale);
    }

    public ArrayList<Sale> listSales() {
        return sales;
    }

    public double calculateTotalSales() {
        double total = 0;
        for (Sale sale : sales) {
            total += sale.getTotalValue();
        }
        return total;
    }

    private int findProductIndex(int code) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCode() == code) {
                return i;
            }
        }
        return -1;
    }

    public int getProductQuantity(int code) {
        int index = findProductIndex(code);
        if (index != -1) {
            return stockQuantities.get(index);
        }
        return 0;
    }
}
