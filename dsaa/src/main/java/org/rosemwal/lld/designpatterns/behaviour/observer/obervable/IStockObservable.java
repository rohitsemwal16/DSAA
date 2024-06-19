package org.rosemwal.lld.designpatterns.behaviour.observer.obervable;

import org.rosemwal.lld.designpatterns.behaviour.observer.observer.INotificationsAlertObserver;

public interface IStockObservable {

    void addObserver(INotificationsAlertObserver notificationsAlertObserver);

    void removeObserver(INotificationsAlertObserver notificationsAlertObserver);

    void notifyObservers();

    void setStockCount(int newStocksAdded);

    int getStockCount();
}
