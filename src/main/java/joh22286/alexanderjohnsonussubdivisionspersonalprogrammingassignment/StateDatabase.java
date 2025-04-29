package joh22286.alexanderjohnsonussubdivisionspersonalprogrammingassignment;

import java.util.HashMap;
import java.util.Map;

public class StateDatabase {

    // Makes a hashmap with a string (name) and the state object.
    private Map<String, State> stateDB;

    public StateDatabase() {
        //Hashmap! THese things are cool
        stateDB = new HashMap<>();

        // Add states to the database
        stateDB.put("Minnesota", new State("Minnesota", 5_700_000f, 87_000f, 0.005f, "Saint Paul", "L'Étoile du Nord", 1858));
       // Add More states eventually
    }

    public State findStateByName(String subdivisionName) {
        return stateDB.get(subdivisionName);
    }
}