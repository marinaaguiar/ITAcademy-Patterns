package org.example;

public class StockManager implements Observer {
    private String name;
    private String stockStatus;

    public StockManager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getStockStatus() {
        System.out.println("Stock status: " + name + " - " + stockStatus);
        return stockStatus;
    }

    @Override
    public void update(String stockStatus) {
        this.stockStatus = stockStatus;
        System.out.println("Stock Manager " + name + " received update: " + stockStatus);
    }
}
