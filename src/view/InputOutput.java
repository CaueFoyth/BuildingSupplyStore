package view;

import javax.swing.*;
import model.Product;
import model.Sale;
import model.Stock;

import java.util.List;

public class InputOutput {

    public static int showOptions(String[] options) {
        JComboBox<String> menu = new JComboBox<>(options);
        JOptionPane.showConfirmDialog(null, menu, "Escolha uma opção", JOptionPane.OK_CANCEL_OPTION);
        return menu.getSelectedIndex();
    }

    public static int askProductCode() {
        return Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto:"));
    }

    public static String askProductDescription() {
        return JOptionPane.showInputDialog("Digite a descrição do produto:");
    }

    public static double askProductPrice() {
        return Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto:"));
    }

    public static int askProductQuantity() {
        return Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade:"));
    }

    public static void showProducts(List<Product> products) {
        StringBuilder output = new StringBuilder("Produtos cadastrados:\n");
        for (Product product : products) {
            output.append(product).append("\n");
        }
        JOptionPane.showMessageDialog(null, output.toString());
    }

    public static void showStock(Stock stock) {
        List<Product> products = stock.listProducts();
        StringBuilder output = new StringBuilder("Produtos em estoque:\n");
        for (Product product : products) {
            int quantity = stock.getProductQuantity(product.getCode());
            output.append("Código: ").append(product.getCode())
                  .append(", Descrição: ").append(product.getDescription())
                  .append(", Preço: ").append(product.getPrice())
                  .append(", Quantidade: ").append(quantity)
                  .append("\n");
        }
        JOptionPane.showMessageDialog(null, output.toString());
    }
    

    public static void showSales(List<Sale> sales) {
        StringBuilder output = new StringBuilder("Cupons de Venda:\n");
        for (Sale sale : sales) {
            output.append(sale).append("\n");
        }
        JOptionPane.showMessageDialog(null, output.toString());
    }

    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
