package joh22286.alexanderjohnsonussubdivisionspersonalprogrammingassignment;

public abstract class Subdivisions {
    public Float population;
    // public Float populationDensity; Might not use, might "Make my own" population density instead (pop/area).
    public Float landArea;
    public Float growthRate;
    String subdivisionName;

    // attributes all subdivisions have
    public Subdivisions( String subdivisionName, Float population, Float landArea, Float growthRate){
        this.subdivisionName = subdivisionName;
        this.population = population;
        this.landArea = landArea;
        this.growthRate = growthRate;

    }

    public Float getPopulation() {
        return population;

    }

    /**
     * Didn't want to remove this in case I need it because my calculations didn't work.
     * public Float getPopulationDensity(Float populationDensity){
     * this.populationDensity = populationDensity;
     * return populationDensity;
     * }
     */

    //Get Land Area
    public Float getLandArea() {
        return landArea;
    }

    // Get the Growth Rate
    public Float getGrowthRate() {
        return growthRate;
    }

    // Get the subdivision's name
    public String getSubdivisionName() {
        return subdivisionName;
    }

    // Calculate the population density of the subdivision. "My Own"
    public Float calculatePopulationDensity() {
        return landArea/population;
    }

    public Float calculateFuturePopulation() {
        return growthRate * population * 50 + population;
        // *50 to represent 50 years in the future
    }
}




