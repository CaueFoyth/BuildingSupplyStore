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
                case 0:
                    int code = InputOutput.askProductCode();
                    String description = InputOutput.askProductDescription();
                    double price = InputOutput.askProductPrice();
                    while (price <= 0) {
                        InputOutput.showMessage("Preços devem ser maiores que 0.");
                        price = InputOutput.askProductPrice();
                    }
                    Product product = new Product(code, description, price);
                    stock.addProduct(product);
                    InputOutput.showMessage("Produto cadastrado com sucesso!");
                    break;

                case 1:
                    if (stock.listProducts().isEmpty()) {
                        InputOutput.showMessage("Nenhum produto encontrado.");
                    } else {
                        InputOutput.showProducts(stock.listProducts());
                    }
                    break;

                case 2:
                    if (stock.listProducts().isEmpty()) {
                        InputOutput.showMessage("Nenhum produto encontrado.");
                    } else {
                        int stockCode = InputOutput.askProductCode();
                        int quantity = InputOutput.askProductQuantity();
                        while (quantity <= 0) {
                            InputOutput.showMessage("Quantidade insuficiente no estoque.");
                            quantity = InputOutput.askProductQuantity();
                        }
                        stock.updateStock(stockCode, quantity);
                    }
                    break;

                case 3:
                    if (stock.listProducts().isEmpty()) {
                        InputOutput.showMessage("Nenhum produto encontrado.");
                    } else {
                        int saleCode = InputOutput.askProductCode();
                        int saleQty = InputOutput.askProductQuantity();
                        while (saleQty <= 0) {
                            InputOutput.showMessage("Quantidade insuficiente no estoque.");
                            saleQty = InputOutput.askProductQuantity();
                        }
                        if (stock.sellProduct(saleCode, saleQty)) {
                            double totalValue = saleQty * stock.getProductPrice(saleCode);
                            Sale sale = new Sale(saleCode, saleQty, totalValue, new Date());
                            stock.addSale(sale);
                            InputOutput.showMessage("Venda realizada com sucesso!");
                        } else {
                            InputOutput.showError("Quantidade insuficiente no estoque.");
                        }
                    }
                    break;

                case 4:
                    if (stock.listProducts().isEmpty()) {
                        InputOutput.showMessage("Nenhum produto encontrado.");
                    } else {
                        InputOutput.showStock(stock);
                    }
                    break;

                case 5:
                    if (stock.listSales().isEmpty()) {
                        InputOutput.showMessage("Nenhum cupom encontrado.");
                    } else {
                        InputOutput.showSales(stock.listSales());
                    }
                    break;

                case 6:
                    if (stock.listSales().isEmpty()) {
                        InputOutput.showMessage("Nenhum cupom encontrado.");
                    } else {
                        double totalSales = stock.calculateTotalSales();
                        InputOutput.showMessage("Valor Total dos Cupons: R$" + totalSales);
                    }
                    break;

                case 7:
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }
    }
}
