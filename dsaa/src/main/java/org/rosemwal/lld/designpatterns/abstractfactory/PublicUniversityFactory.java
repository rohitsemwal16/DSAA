package org.rosemwal.lld.designpatterns.abstractfactory;

public class PublicUniversityFactory extends UniversityFactory {


    @Override
    public AdmitCard getAdminCard(String course) {
        if (course.equals("Chemistry"))  {
            return new MitAdmitCard();
        }   else if (course.equals("Hindi"))  {
            return new CalTechAdmitCard();
        } else {
            return null;
        }    }

    @Override
    public Calculator getFees(String course) {
        return null;
    }

}
