package org.rosemwal.lld.designpatterns.strategy.vehicle;

import org.rosemwal.lld.designpatterns.strategy.drivingStrategy.HighSpeedStrategy;

public class SportsCar extends Vehicle {

    SportsCar() {
        super(new HighSpeedStrategy());
    }
}
