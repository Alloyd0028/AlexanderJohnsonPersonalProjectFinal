package joh22286.alexanderjohnsonussubdivisionspersonalprogrammingassignment;

public interface MVPContract {


    // The presenter's interface for this "contract"
    // Currently just add's person to the DB
    interface Presenter {
        //void addStateToDB( String name, String age, String lastName );
        //void isPersonInTheDB(String name);
    }

    // The view's interface for this "contract".  Allows
    // the presenter to update the information in the view's
    // display.
    interface View {
        void showPopulation(Float population);
        void showLandArea(Float landArea);
        void showPopulationDensity(Float population, Float landArea);
        void showGrowthRate(Float growthRate);
        void showProjectedPopulation(Float population, Float growthRate);
        void showCapital(String capital);
        void showStateMotto(String stateMotto);
        void showYearAdmitted(Integer yearAdmitted);

    }
}