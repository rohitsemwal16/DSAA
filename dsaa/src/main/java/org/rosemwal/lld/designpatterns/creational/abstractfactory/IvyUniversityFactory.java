package org.rosemwal.lld.designpatterns.creational.abstractfactory;

public class IvyUniversityFactory extends UniversityFactory {

    @Override
    public AdmitCard getAdminCard(String course) {

        if (course.equals("Maths"))  {
            return new MitAdmitCard();
        }   else if (course.equals("Physics"))  {
            return new CalTechAdmitCard();
        } else {
            return null;
        }
    }

    @Override
    public Calculator getFees(String course) {
        if (course.equals("Maths"))  {
            return new MitFeesCalculator();
        }   else if (course.equals("Physics"))  {
            return new CalTechFeesCalculator();
        } else {
            return null;
        }
    }

}
