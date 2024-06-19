package org.rosemwal.lld.designpatterns.behaviour.observer.observer;

import org.rosemwal.lld.designpatterns.behaviour.observer.obervable.IStockObservable;

public class EmailAlertObserverImpl implements INotificationsAlertObserver {

    String emailId;
    IStockObservable observable;

    public EmailAlertObserverImpl(String emailId, IStockObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail();
    }

    private void sendEmail() {
        System.out.println("Email Sent to "+ emailId);
        // Email Send Method
    }
}
