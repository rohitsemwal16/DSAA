package org.rosemwal.lld.designpatterns.creational.abstractfactory;

public class MitFeesCalculator implements Calculator {


    @Override
    public Long findFees() {
        return 4000L;
    }
}
