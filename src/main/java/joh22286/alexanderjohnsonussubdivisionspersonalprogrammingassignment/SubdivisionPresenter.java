package joh22286.alexanderjohnsonussubdivisionspersonalprogrammingassignment;

public class SubdivisionPresenter implements MVPContract.Presenter{

    // Maybe ArrayList to store the made States?
    private MVPContract.View view;
    private State generalState;
    private StateDatabase stateDatabase;
    // Probably a good idea to make more hashmap databases

    private State s;
    private County c;
    // possibility for more subdivisions

    public SubdivisionPresenter(MVPContract.View view) {
        this.view = view;

        this.stateDatabase = new StateDatabase();

        //States
        this.s = new State("Minnesota", 5_700_000f, 87_000f, 0.005f, "Saint Paul", "L'Etoile du Nord", 1858);
        // make more states

        //Counties
        this.c = new County("St. Louis County", 200_000f, 6_860f, 0.0004f, "Duluth", false, "Minnesota");
        // make more counties
    }

    private State getState(String subdivisionName) {
        State state = stateDatabase.findStateByName(subdivisionName);
        if (state == null) {
            // Handle unknown state if name doesn't exist of isn't exact
            System.out.println("State not found: " + subdivisionName);
        }
        return state;
    }
// Make Sure it Works For Counties Too!!!

    @Override
    public void loadState(String stateName) {
        generalState = stateDatabase.findStateByName(stateName);
        if (generalState == null) {
            System.out.println("State not found.");
        }
    }

    public void onPopulationChecked() {
        if (generalState != null) {
            view.showPopulation(generalState.getPopulation());
        }
    }

    public void onLandAreaChecked() {

        if (generalState != null) {
            view.showLandArea(generalState.getLandArea());
        }
    }

    public void onPopulationDensityChecked() {
        if (generalState != null) {
            view.showPopulationDensity(generalState.getPopulation(), generalState.getLandArea());
        }

    }

    public void onGrowthRateChecked() {
        if (generalState != null) {
            view.showGrowthRate(generalState.getGrowthRate());
        }

    }

    public void onProjectedPopulationChecked() {
        if (generalState != null) {
            view.showProjectedPopulation(generalState.getPopulation(), generalState.getGrowthRate() *50 );
        }
    }

    public void onCapitalChecked() {
        if (generalState != null) {
            view.showCapital(generalState.getCapital());
        }
    }
    public void onStateMottoChecked() {
        if (generalState != null) {
            view.showStateMotto(generalState.getStateMotto());
        }
    }
    public void onYearAdmittedChecked() {
        if (generalState != null) {
            view.showYearAdmitted(generalState.getYearAdmitted());
        }
    }
}

