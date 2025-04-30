package joh22286.alexanderjohnsonussubdivisionspersonalprogrammingassignment;

public class SubdivisionPresenter implements MVPContract.Presenter{

    // Maybe ArrayList to store the made States?
    private MVPContract.View view;
    private State generalState;
    private County generalCounty;
    private StateDatabase stateDatabase;
    private CountyDatabase countyDatabase;
    // Probably a good idea to make more hashmap databases

    /** ----Not Used----
    private State s;
    private County c;
    // possibility for more subdivisions
    */

    public SubdivisionPresenter(MVPContract.View view) {
        this.view = view;

        this.stateDatabase = new StateDatabase();
        this.countyDatabase = new CountyDatabase();

        /** ----Unused---- Hashmap idea works better
        //States
        this.s = new State("Minnesota", 5_700_000f, 87_000f, 0.005f, "Saint Paul", "L'Etoile du Nord", 1858);
        // make more states
        //Counties
        this.c = new County("St. Louis County", 200_000f, 6_860f, 0.0004f, "Duluth", false, "Minnesota");
        // make more counties
         */
    }

    //looks through the hashmap for a key that matches a state. If there is one, it will use that state,
    // if not, prints "state not found". Always prints that even if you put in a county and there is a county.
    private State getState(String subdivisionName) {
        State state = stateDatabase.findStateByName(subdivisionName);
        if (state == null) {
            // Handle unknown state if name doesn't exist of isn't exact
            System.out.println("State not found: " + subdivisionName);
        }

        return state;
    }
    private County getCounty(String subdivisionName){
        County county = countyDatabase.findCountyByName(subdivisionName);
        if (county == null) {
            // Handle unknown state if name doesn't exist of isn't exact
            System.out.println("County not found: " + subdivisionName);
        }
        return county;

    }
    // Possibility for more subdivisions here.


    //These methods are implemented from the MVP Contract
    // Should probably generalize this method to include counties and other subdivisions
    @Override
    public void loadState(String stateName) {
        generalState = stateDatabase.findStateByName(stateName);
        if (generalState == null) {
            System.out.println("State not found.");
        }

    }
    @Override
    public void loadCounty(String countyName){
        generalCounty = countyDatabase.findCountyByName(countyName);
        if (generalCounty == null) {
            System.out.println("County not found.");
        }

    }

    public void onPopulationChecked() {
        if (generalState != null) {
            view.showPopulation(generalState.getPopulation());
        } else if (generalCounty != null) {
            view.showPopulation(generalCounty.getPopulation());
        } else{ view.showPopulation(0f);}
    }

    public void onLandAreaChecked() {

        if (generalState != null) {
            view.showLandArea(generalState.getLandArea());
        } else if (generalCounty != null) {view.showLandArea(generalCounty.getLandArea());

        } else{ view.showLandArea(0f);}
    }

    public void onPopulationDensityChecked() {
        if (generalState != null) {
            view.showPopulationDensity(generalState.getPopulation(), generalState.getLandArea());
        } else if (generalCounty != null) {
            view.showPopulationDensity(generalCounty.getPopulation(), generalCounty.getLandArea());
        } else{ view.showPopulationDensity(0f,0f);}

    }

    public void onGrowthRateChecked() {
        if (generalState != null) {
            view.showGrowthRate(generalState.getGrowthRate());
        } else if (generalCounty != null) {
            view.showGrowthRate(generalCounty.getGrowthRate());
        } else{ view.showGrowthRate(0f);}

    }

    public void onProjectedPopulationChecked() {
        if (generalState != null) {
            view.showProjectedPopulation(generalState.getPopulation(), generalState.getGrowthRate() *50 );
        } else if (generalCounty != null) {
            view.showProjectedPopulation(generalCounty.getPopulation(), generalCounty.getGrowthRate() *50 );
        }
        else{ view.showProjectedPopulation(0f, 0f);}


    }

    //State only, null otherwise

    public void onCapitalChecked() {
        if (generalState != null) {
            view.showCapital(generalState.getCapital());
        }
        else{ view.showCapital("Not a State");}
    }
    public void onStateMottoChecked() {
        if (generalState != null) {
            view.showStateMotto(generalState.getStateMotto());
        }

        else{ view.showStateMotto("Not a State");}
    }
    public void onYearAdmittedChecked() {
        if (generalState != null) {
            view.showYearAdmitted(generalState.getYearAdmitted());
        }
        else{ view.showYearAdmitted(0);}
    }
    //County Only

    @Override
    public void onCountySeatChecked() {
        if (generalCounty != null) {
            view.showCountySeat(generalCounty.getCountySeat());
        }
        else{ view.showCountySeat("Not a County");}
    }

    @Override
    public void onIsUrbanChecked() {
        if (generalCounty != null) {
            view.showIsUrban(generalCounty.getIsUrban());
        }
        else{ view.showIsUrban(false);} // automatic false if nonexistent

    }

    @Override
    public void onParentStateChecked() {
        if (generalCounty != null) {
            view.showParentState(generalCounty.getParentState());
        }
        else{ view.showParentState("Not a County");}
    }
}

