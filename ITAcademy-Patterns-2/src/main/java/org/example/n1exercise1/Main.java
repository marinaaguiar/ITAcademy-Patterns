package org.example.n1exercise1;

public class Main {
    public static void main(String[] args) {
        StockExchange storeExchange1 = new StockExchange("Store 1");
        StockManager store1 = new StockManager("Store 1");

        StockExchange storeExchange2 = new StockExchange("Store 2");
        StockManager store2 = new StockManager("Store 2");

        StockExchange storeExchange3 = new StockExchange("Store 3");
        StockManager store3 = new StockManager("Store 3");

        storeExchange1.subscribe(store1);
        storeExchange2.subscribe(store2);
        storeExchange3.subscribe(store3);

        storeExchange1.setStockStatus("Stock is full.");
        storeExchange2.setStockStatus("Stock is empty.");
        storeExchange3.setStockStatus("Waiting for products.");

        storeExchange3.unsubscribe(store3);
        System.out.println("\n" + store3.getName() + " unsubscribed.\n");

        // In this example the Stock Exchange for store 3 is unsubscribed, for this reason it will not update accurately.
        storeExchange3.setStockStatus("Stock is full.");

        store1.getStockStatus();
        store2.getStockStatus();
        store3.getStockStatus();
    }
}