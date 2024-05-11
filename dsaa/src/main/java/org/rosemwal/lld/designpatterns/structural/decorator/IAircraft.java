package org.rosemwal.lld.designpatterns.structural.decorator;

public interface IAircraft {

    float baseWeight = 100;

    void fly();

    void land();

    float getWeight();

}