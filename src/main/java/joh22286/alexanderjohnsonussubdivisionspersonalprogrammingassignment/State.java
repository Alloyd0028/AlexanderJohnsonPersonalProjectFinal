package joh22286.alexanderjohnsonussubdivisionspersonalprogrammingassignment;

import java.util.ArrayList;

public class State extends Subdivisions {
    public String capital;
    public String stateMotto;
    public Integer yearAdmitted;

    // attributes of states
    public State(String subdivisionName, Float population, Float landArea, Float growthRate, String capital, String stateMotto, Integer yearAdmitted) {
        super(subdivisionName, population, landArea, growthRate);
        this.capital = capital;
        this.stateMotto = stateMotto;
        this.yearAdmitted = yearAdmitted;
    }

    // get the capital of the state
    public String getCapital(){
        return capital;
    }

    // get the state motto
    public String getStateMotto(){
        return stateMotto;
    }

    // get year admitted to the Union
    public Integer getYearAdmitted(){
        return yearAdmitted;
    }

    //Creates an ArrayList of Counties so we can count how many are in a state (In the database)
    private ArrayList<County> counties = new ArrayList<>();

    public void addCounty(County county) {
        counties.add(county);
    }

}

