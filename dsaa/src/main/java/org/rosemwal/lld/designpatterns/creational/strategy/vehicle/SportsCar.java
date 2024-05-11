package org.rosemwal.lld.designpatterns.creational.strategy.vehicle;

import org.rosemwal.lld.designpatterns.creational.strategy.drivingStrategy.HighSpeedStrategy;

public class SportsCar extends Vehicle {

    SportsCar() {
        super(new HighSpeedStrategy());
    }
}
