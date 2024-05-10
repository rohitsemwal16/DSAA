package org.rosemwal.lld.designpatterns.strategy.vehicle;

import org.rosemwal.lld.designpatterns.strategy.drivingStrategy.DrivingStrategy;

public class Vehicle {

    DrivingStrategy drivingStrategy;

    Vehicle(DrivingStrategy drivingStrategy)    {
        this.drivingStrategy = drivingStrategy;
    }

    public void drive() {
        drivingStrategy.drive();
    }

}
