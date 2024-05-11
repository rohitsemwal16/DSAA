package org.rosemwal.lld.designpatterns.creational.strategy.vehicle;

import org.rosemwal.lld.designpatterns.creational.strategy.drivingStrategy.NormalSpeedVehicle;

public class PassengerVan extends Vehicle {


    PassengerVan() {
        super(new NormalSpeedVehicle());
    }
}
