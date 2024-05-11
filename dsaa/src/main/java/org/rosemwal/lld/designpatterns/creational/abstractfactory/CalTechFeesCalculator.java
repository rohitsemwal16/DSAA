package org.rosemwal.lld.designpatterns.creational.abstractfactory;

public class CalTechFeesCalculator implements Calculator {

    @Override
    public Long findFees() {
        return 5000L;
    }
}
