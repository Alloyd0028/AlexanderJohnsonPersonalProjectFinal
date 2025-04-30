package joh22286.alexanderjohnsonussubdivisionspersonalprogrammingassignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    //Tests if a State is made properly.
    @Test
    void stateTest() {
        State minnesota = new State("Minnesota", 5_700_000f, 87_000f, 0.005f,
                "Saint Paul", "L'Etoile du Nord", 1858);

        assertEquals("Minnesota", minnesota.getSubdivisionName());
        assertEquals(5_700_000f, minnesota.getPopulation());
        assertEquals(87_000f, minnesota.getLandArea());
        assertEquals(0.005f, minnesota.getGrowthRate());
        assertEquals("Saint Paul", minnesota.getCapital());
        assertEquals("L'Etoile du Nord", minnesota.getStateMotto());
        assertEquals(1858, minnesota.getYearAdmitted());
    }
}