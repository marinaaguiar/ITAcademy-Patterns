package org.example;

public interface Observable {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void update();
}
