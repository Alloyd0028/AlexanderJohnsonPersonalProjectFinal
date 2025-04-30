package joh22286.alexanderjohnsonussubdivisionspersonalprogrammingassignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountyTest {

    //Tests if a State is made properly.
    @Test
    void stateTest() {
        County StLouis = new County("St. Louis County", 200_000f, 6_860f, 0.004f,
                "Duluth", false, "Minnesota");

        assertEquals("St. Louis County", StLouis.getSubdivisionName());
        assertEquals(200_000f, StLouis.getPopulation());
        assertEquals(6_860f, StLouis.getLandArea());
        assertEquals(0.004f, StLouis.getGrowthRate());
        assertEquals("Duluth", StLouis.getCountySeat());
        assertEquals(false, StLouis.getIsUrban());
        assertEquals("Minnesota", StLouis.getParentState());
    }

}