package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {
    @Test
    void specialMovieWith50PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        assertEquals(12.5, spiderMan.getTicketPrice());

        System.out.println(Duration.ofMinutes(90));
    }
}
