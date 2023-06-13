package com.jpmc.theater;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MovieTests {
    private final Movie spiderMan = new Movie("Spider-Man: No Way Home", "Some Desc", Duration.ofMinutes(90),12.5, true);
    @Test
    @DisplayName("Test all getters in Movies")
    void testMovieGetters() {
        assertEquals(12.5, spiderMan.getTicketPrice());
        assertEquals(Duration.ofMinutes(90), spiderMan.getRunningTime());
        assertEquals("Spider-Man: No Way Home", spiderMan.getTitle());
    }

    @Test
    @DisplayName("Test equality in Movies")
    void testMovieEquality() {
        assertEquals(spiderMan, new Movie("Spider-Man: No Way Home", "Some Desc", Duration.ofMinutes(90), 12.5, true));
        assertNotEquals(spiderMan, new Movie("Spider-Man 2","Some Desc",  Duration.ofMinutes(90), 12.5, true));
    }
}
