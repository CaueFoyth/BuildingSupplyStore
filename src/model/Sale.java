package model;

import java.text.SimpleDateFormat;
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

    public double getTotalValue() {
        return totalValue;
    }

    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Data: " + dateFormat.format(date) + 
               ", Código do Produto: " + productCode + 
               ", Quantidade: " + quantity + 
               ", Valor Total: R$" + totalValue;
    }
}
