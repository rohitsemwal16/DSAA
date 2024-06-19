package org.rosemwal.lld.designpatterns.behaviour.observer.observer;

import org.rosemwal.lld.designpatterns.behaviour.observer.obervable.IStockObservable;

public class MobileAlertObserverImpl  implements INotificationsAlertObserver {

    String userName; // Phone
    IStockObservable observable;

    public MobileAlertObserverImpl(String userName, IStockObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendNotification(userName, "Hello, Iphone is back up");
    }

    private void sendNotification(String userName, String msg) {
        System.out.println("Notification send to "+ userName);
        // Email Send Method
    }
}
