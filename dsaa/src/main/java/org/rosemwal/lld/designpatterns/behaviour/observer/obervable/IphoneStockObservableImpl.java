package org.rosemwal.lld.designpatterns.behaviour.observer.obervable;

import org.rosemwal.lld.designpatterns.behaviour.observer.observer.INotificationsAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservableImpl implements IStockObservable{

    public List<INotificationsAlertObserver> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void addObserver(INotificationsAlertObserver notificationsAlertObserver) {

        observerList.add(notificationsAlertObserver);
    }

    @Override
    public void removeObserver(INotificationsAlertObserver notificationsAlertObserver) {

        observerList.remove(notificationsAlertObserver);
    }

    @Override
    public void notifyObservers() {

        for (INotificationsAlertObserver observer : observerList)  {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStocksAdded) {
        
        if (stockCount == 0)    {
            notifyObservers();
        }
        stockCount += newStocksAdded;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
