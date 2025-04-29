package joh22286.alexanderjohnsonussubdivisionspersonalprogrammingassignment;

public class SubdivisionPresenter implements MVPContract.Presenter{

    // Maybe ArrayList to store the made States?
    private MVPContract.View view;
    private State s;
    private County c;
    // possibility for more subdivisions

    public SubdivisionPresenter(MVPContract.View view) {
        this.view = view;

        //States
        this.s = new State("Minnesota", 5_700_000f, 87_000f, 0.005f, "Saint Paul", "L'Etoile du Nord", 1858);
        // make more states

        //Counties
        this.c = new County("St. Louis County", 200_000f, 6_860f, 0.0004f, "Duluth", false, "Minnesota");
        // make more counties
    }

// Make Sure it Works For Counties Too!!!
    public void onPopulationChecked() {
        view.showPopulation(s.getPopulation());
    }

    public void onLandAreaChecked() {
        view.showLandArea(s.getLandArea());
    }

    public void onPopulationDensityChecked() {
        view.showPopulationDensity(s.calculatePopulationDensity(), s.calculatePopulationDensity()); // same thing twice for parameters
    }

    public void onGrowthRateChecked() {
        view.showGrowthRate(s.getGrowthRate());
    }

    public void onProjectedPopulationChecked() {
        view.showProjectedPopulation(s.calculateFuturePopulation(),s.calculateFuturePopulation());
    }
    public void onCapitalChecked() {
        view.showCapital(s.getCapital());
    }
    public void onStateMottoChecked() {
        view.showStateMotto(s.getStateMotto());
    }
    public void onYearAdmittedChecked() {
        view.showYearAdmitted(s.getYearAdmitted());
    }



    /**
    public PersonPresenter(IMVPContract.View aView) {
        this.theActualView = aView;
        this.personDB = new PersonDB_Mem();
    }

    @Override
    public void addPersonToDB( String name, String age, String lastName ) {
        Integer pAge = (Integer) Integer.parseInt( age );
        Person p = new Person( name, pAge );
        personDB.addPerson( p );

        // All "Views" must implement this interface to update
        // the information on the screen about the number in the DB.
        theActualView.updateNumberInDB( personDB.numInDB() );
    }

    @Override
    public void isPersonInTheDB(String name) {

    }*/
}

