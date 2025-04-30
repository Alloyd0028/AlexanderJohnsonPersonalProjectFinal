package joh22286.alexanderjohnsonussubdivisionspersonalprogrammingassignment;

public interface MVPContract {


    // The presenter's interface for this "contract"
    // Currently just add's person to the DB
    interface Presenter {
        void loadState(String stateName);

        void loadCounty(String countyName) ;

        void onPopulationChecked();

        void onLandAreaChecked();

        void onPopulationDensityChecked();

        void onGrowthRateChecked();

        void onProjectedPopulationChecked();


        //State Specific
        void onCapitalChecked();

        void onStateMottoChecked();

        void onYearAdmittedChecked();

        // County Specific
        void onCountySeatChecked();

        void onIsUrbanChecked();

        void onParentStateChecked();
    }

    // The view is implemented by the presenter, so it can update the model's data
    interface View {
        void showPopulation(Float population);

        void showLandArea(Float landArea);

        void showPopulationDensity(Float population, Float landArea);

        void showGrowthRate(Float growthRate);

        void showProjectedPopulation(Float population, Float growthRate);

        void showCapital(String capital);

        void showStateMotto(String stateMotto);

        void showYearAdmitted(Integer yearAdmitted);

        void showCountySeat(String CountySeat);

        void showIsUrban(boolean isUrban);

        void showParentState(String parentState);
    }
}
