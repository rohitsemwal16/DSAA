package org.rosemwal.lld.designpatterns.strategy;

import org.rosemwal.lld.designpatterns.strategy.vehicle.PassengerVan;
import org.rosemwal.lld.designpatterns.strategy.vehicle.SportsCar;
import org.rosemwal.lld.designpatterns.strategy.vehicle.Vehicle;

public class StrategyMain {

    public static void main(String[] args)  {

        Vehicle vehicle = new SportsCar();
        vehicle.drive();

        Vehicle passengerVehicle = new PassengerVan();
        passengerVehicle.drive();
    }
}
