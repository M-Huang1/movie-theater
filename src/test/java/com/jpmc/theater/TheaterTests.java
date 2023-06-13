package com.jpmc.theater;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheaterTests {
    private final Theater sampleTheater = new Theater(List.of(
        new Showing(
            TestHelper.sampleMovie,
            1,
            LocalDateTime.of(LocalDate.of(2023, 6, 8), LocalTime.of(9, 0))),
        new Showing(
            TestHelper.sampleSpecialMovie,
            2,
            LocalDateTime.of(LocalDate.of(2023, 6, 8), LocalTime.of(10, 0))))
    );

    @Test
    @DisplayName("Test calculating total fee when creating a reservation")
    void totalFeeForCustomer() {
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = sampleTheater.reserve(john, 2, 4);
        assertEquals(32, reservation.totalFee());
    }

    @Test
    @DisplayName("Test printing movie schedule")
    void printMovieSchedule() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        sampleTheater.printSchedule();
        assertEquals("2023-06-13\n" +
            "===================================================\n" +
            "{\n" +
            "  {\n" +
            "    \"Sequence Of The Day\": \"1\",\n" +
            "    \"Start Time\": \"2023-06-08T09:00\",\n" +
            "    \"Title\": \"SampleMovie\",\n" +
            "    \"Running Time\": \"1 hour 30 minutes\",\n" +
            "    \"Movie Fee\": \"$10.0\"\n" +
            "  }\n" +
            "  {\n" +
            "    \"Sequence Of The Day\": \"2\",\n" +
            "    \"Start Time\": \"2023-06-08T10:00\",\n" +
            "    \"Title\": \"SampleSpecialMovie\",\n" +
            "    \"Running Time\": \"1 hour 30 minutes\",\n" +
            "    \"Movie Fee\": \"$10.0\"\n" +
            "  }\n" +
            "}\n" +
            "===================================================\n", outputStreamCaptor.toString());
    }
}
