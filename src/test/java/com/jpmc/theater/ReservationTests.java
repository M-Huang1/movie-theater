package com.jpmc.theater;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationTests {

    @Test
    @DisplayName("Test calculating total fee for a reservation")
    void totalFee() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", "Some Desc", Duration.ofMinutes(90), 12.5, true),
                1,
                LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 0))
        );
        // Greatest discount is 25% of 12.5 = 3.125. 9.375 * 3 = 28.125, rounded up = 28.13
        assertEquals(28.13, new Reservation(customer, showing, 3).totalFee());
    }
}
