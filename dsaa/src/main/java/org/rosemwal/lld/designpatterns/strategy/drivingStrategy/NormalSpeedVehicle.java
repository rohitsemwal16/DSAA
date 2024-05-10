package org.rosemwal.lld.designpatterns.strategy.drivingStrategy;

import org.rosemwal.lld.designpatterns.strategy.drivingStrategy.DrivingStrategy;

public class NormalSpeedVehicle implements DrivingStrategy {

    @Override
    public void drive() {
        System.out.println("Normal Speed Strategy");
    }
}
