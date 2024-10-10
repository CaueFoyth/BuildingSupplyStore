package controller;

import java.util.Date;

import model.Product;
import model.Sale;
import model.Stock;
import view.InputOutput;

public class Controller {
    private Stock stock = new Stock();

    public void startApp() {
        while (true) {
            int option = InputOutput.showOptions(new String[]{
                "Cadastrar Produto", 
                "Listar Produtos", 
                "Entrada no Estoque", 
                "Vender Produto", 
                "Listar Produtos em Estoque", 
                "Visualizar Cupons de Venda", 
                "Calcular Valor Total dos Cupons", 
                "Sair"
            });

            switch (option) {
                case 0: // Cadastrar Produto
                    int code = InputOutput.askProductCode();
                    String description = InputOutput.askProductDescription();
                    double price = InputOutput.askProductPrice();
                    Product product = new Product(code, description, price);
                    stock.addProduct(product);
                    InputOutput.showMessage("Produto cadastrado com sucesso!");
                    break;

                case 1: // Listar Produtos
                    InputOutput.showProducts(stock.listProducts());
                    break;

                case 2: // Entrada no Estoque
                    int stockCode = InputOutput.askProductCode();
                    int quantity = InputOutput.askProductQuantity();
                    stock.updateStock(stockCode, quantity);
                    break;

                case 3: // Vender Produto
                    int saleCode = InputOutput.askProductCode();
                    int saleQty = InputOutput.askProductQuantity();
                    if (stock.sellProduct(saleCode, saleQty)) {
                        double totalValue = saleQty * stock.getProductPrice(saleCode);
                        Sale sale = new Sale(saleCode, saleQty, totalValue, new Date());
                        stock.addSale(sale);
                        InputOutput.showMessage("Venda realizada com sucesso!");
                    } else {
                        InputOutput.showError("Quantidade insuficiente no estoque.");
                    }
                    break;

                case 4: // Listar Produtos em Estoque
                    InputOutput.showStock(stock.listAvailableStock());
                    break;

                case 5: // Visualizar Cupons de Venda
                    InputOutput.showSales(stock.listSales());
                    break;

                case 6: // Calcular Valor Total dos Cupons
                    double totalSales = stock.calculateTotalSales();
                    InputOutput.showMessage("Valor Total dos Cupons: R$" + totalSales);
                    break;

                case 7: // Sair
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }
    }
}
