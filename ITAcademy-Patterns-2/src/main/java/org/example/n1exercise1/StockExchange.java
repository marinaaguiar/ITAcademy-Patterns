package org.example.n1exercise1;

import java.util.List;
import java.util.ArrayList;

public class StockExchange implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private String name;
    private String stockStatus;

    public StockExchange(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void update() {
        for (Observer observer : observers) {
            observer.update(stockStatus);
        }
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
        update();
    }
}
