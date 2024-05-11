package org.rosemwal.lld.designpatterns.creational.strategy.vehicle;

import org.rosemwal.lld.designpatterns.creational.strategy.drivingStrategy.HighSpeedStrategy;

public class SportsCar extends Vehicle {

    public SportsCar() {
        super(new HighSpeedStrategy());
    }
}
