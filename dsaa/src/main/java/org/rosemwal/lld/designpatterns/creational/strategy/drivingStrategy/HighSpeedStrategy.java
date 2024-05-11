package org.rosemwal.lld.designpatterns.creational.strategy.drivingStrategy;

public class HighSpeedStrategy implements DrivingStrategy {

    @Override
    public void drive() {
        System.out.println("HighSpeed Strategy");
    }
}
