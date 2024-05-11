package org.rosemwal.lld.designpatterns.creational.strategy.vehicle;

import org.rosemwal.lld.designpatterns.creational.strategy.drivingStrategy.NormalSpeedVehicle;

public class PassengerVan extends Vehicle {

    public PassengerVan() {
        super(new NormalSpeedVehicle());
    }
}
