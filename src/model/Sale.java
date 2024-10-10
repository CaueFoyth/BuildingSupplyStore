package model;

import java.util.Date;

public class Sale {
    private int productCode;
    private int quantity;
    private double totalValue;
    private Date date;

    public Sale(int productCode, int quantity, double totalValue, Date date) {
        this.productCode = productCode;
        this.quantity = quantity;
        this.totalValue = totalValue;
        this.date = date;
    }

    public String toString() {
        return "Data: " + date + ", Código do Produto: " + productCode + ", Quantidade: " + quantity + ", Valor Total: " + totalValue;
    }

    public double getTotalValue() {
        return totalValue;
    }
}
