package joh22286.alexanderjohnsonussubdivisionspersonalprogrammingassignment;

import java.util.ArrayList;

public class County extends Subdivisions{
    public String countySeat;
    public boolean isUrban;
    public String parentState;

    public County(String subdivisionName, Float population, Float landArea, Float growthRate, String countySeat, boolean isUrban, String parentState) {
        super(subdivisionName, population, landArea, growthRate);
        this.countySeat = countySeat;
        this.isUrban = isUrban;
        this.parentState = parentState;
    }

    public boolean isUrban(Float population) {
        // We are defining urban as any county with a population over 500,000 people.
        if (population > 500000f){
        return true;}
        else{
        return false;
        }
    }
    // get county seat, the "capital" of a county
    public String getCountySeat() {
        return countySeat;
    }
    // Urban is defined as a population of 500,000 or more.
    public boolean getIsUrban(){
        return isUrban;
    }

    // might not be necessary
    public String getParentState(){
        return parentState;
    }
}
