package org.rosemwal.lld.designpatterns.behaviour.observer;

import org.rosemwal.lld.designpatterns.behaviour.observer.obervable.IStockObservable;
import org.rosemwal.lld.designpatterns.behaviour.observer.obervable.IphoneStockObservableImpl;
import org.rosemwal.lld.designpatterns.behaviour.observer.observer.EmailAlertObserverImpl;
import org.rosemwal.lld.designpatterns.behaviour.observer.observer.INotificationsAlertObserver;
import org.rosemwal.lld.designpatterns.behaviour.observer.observer.MobileAlertObserverImpl;

public class Main {

    public static void main(String[] args)  {

        IStockObservable iphoneObservable = new IphoneStockObservableImpl();

        INotificationsAlertObserver observer1 = new EmailAlertObserverImpl("abc@gmail.com", iphoneObservable);
        INotificationsAlertObserver observer2 = new EmailAlertObserverImpl("xyz@gmail.com", iphoneObservable);
        INotificationsAlertObserver observer3 = new MobileAlertObserverImpl("username", iphoneObservable);

        iphoneObservable.addObserver(observer1);
        iphoneObservable.addObserver(observer2);
        iphoneObservable.addObserver(observer3);

        iphoneObservable.setStockCount(5);
    }
}
