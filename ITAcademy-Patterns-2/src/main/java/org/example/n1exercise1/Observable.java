package org.example.n1exercise1;

public interface Observable {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void update();
}
