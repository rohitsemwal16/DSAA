package org.rosemwal.lld.designpatterns.creational.strategy.drivingStrategy;

public class NormalSpeedVehicle implements DrivingStrategy {

    @Override
    public void drive() {
        System.out.println("Normal Speed Strategy");
    }
}
