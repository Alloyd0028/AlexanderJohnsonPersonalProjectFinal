package joh22286.alexanderjohnsonussubdivisionspersonalprogrammingassignment;

import java.util.HashMap;
import java.util.Map;

public class CountyDatabase {

    // Makes a hashmap with a string (name) and the county object.
    private Map<String, County> countyDB;

    public CountyDatabase() {
        //Hashmap! These things are cool
        countyDB = new HashMap<>();

        //THis is where states are added
        // Add counties to the database, Data from 2020 US Census
        countyDB.put("St. Louis County", new County("St. Louis County", 200_000f, 6_860f, 0.0004f, "Duluth", false, "Minnesota"));
        // Add More Counties eventually
    }

    public County findCountyByName(String subdivisionName) {
        return countyDB.get(subdivisionName);
    }
}