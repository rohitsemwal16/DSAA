package org.rosemwal.lld.designpatterns.structural.adapter.adaptee;

public class WeightMachineForBabies implements IWeightMachine {

    @Override
    public double getWeightInPounds() {
        return 30;
    }
}
