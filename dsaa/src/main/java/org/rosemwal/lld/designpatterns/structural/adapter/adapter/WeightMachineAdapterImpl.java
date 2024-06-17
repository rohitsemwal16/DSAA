package org.rosemwal.lld.designpatterns.structural.adapter.adapter;

import org.rosemwal.lld.designpatterns.structural.adapter.adaptee.IWeightMachine;

public class WeightMachineAdapterImpl implements IWeightMachineAdapter{

    IWeightMachine weightMachine;

    public WeightMachineAdapterImpl(IWeightMachine weightMachine)   {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKgs() {

        return weightMachine.getWeightInPounds() * 0.45;
    }
}
