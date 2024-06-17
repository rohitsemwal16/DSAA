package org.rosemwal.lld.designpatterns.structural.adapter.client;

import org.rosemwal.lld.designpatterns.structural.adapter.adaptee.WeightMachineForBabies;
import org.rosemwal.lld.designpatterns.structural.adapter.adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String[] args)  {
        WeightMachineAdapterImpl adapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(adapter.getWeightInKgs());
    }
}
