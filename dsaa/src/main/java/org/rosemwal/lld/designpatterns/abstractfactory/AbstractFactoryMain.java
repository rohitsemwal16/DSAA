package org.rosemwal.lld.designpatterns.abstractfactory;

public class AbstractFactoryMain {

    public static void main(String[] args) {
        UniversityFactory factory = UniversityFactory.getUniversityFactory(120);
        Calculator fees = factory.getFees("Physics");

        System.out.println("Fees "+ fees.findFees());
        System.out.println("Factory "+ factory);
    }
}
