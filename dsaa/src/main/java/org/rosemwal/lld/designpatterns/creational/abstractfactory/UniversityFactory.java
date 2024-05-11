package org.rosemwal.lld.designpatterns.creational.abstractfactory;

public abstract class UniversityFactory  {

    public static int cutOff = 109;

    public static UniversityFactory getUniversityFactory(int marks) {

        if(marks < cutOff)  {
            return new PublicUniversityFactory();
        }   else {
            return new IvyUniversityFactory();
        }
    }

    public abstract AdmitCard getAdminCard(String course);
    public abstract Calculator getFees(String course);
}
