package org.rosemwal.lld.designpatterns.strategy.vehicle;

import org.rosemwal.lld.designpatterns.strategy.drivingStrategy.NormalSpeedVehicle;

public class PassengerVan extends Vehicle {


    PassengerVan() {
        super(new NormalSpeedVehicle());
    }
}
