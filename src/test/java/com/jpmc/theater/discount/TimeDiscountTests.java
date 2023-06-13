package com.jpmc.theater.discount;

import com.jpmc.theater.Showing;
import com.jpmc.theater.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeDiscountTests {
  @Test
  @DisplayName("Test discount for a showing shown between 11 AM and 4 PM")
  void testTimeDiscountBetween11AMAnd4PM()  {
    TimeDiscount timeDiscount = new TimeDiscount();
    Showing testShowing = new Showing(
        TestHelper.sampleMovie,
        1,
        LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 0))
    );
    assertEquals(0.25 * TestHelper.sampleMovie.getTicketPrice(), timeDiscount.applyDiscount(testShowing));
  }

  @Test
  @DisplayName("Test discount for a showing not shown between 11 AM and 4 PM")
  void testTimeDiscountNotBetween11AMAnd4PM()  {
    TimeDiscount timeDiscount = new TimeDiscount();
    Showing testShowing = new Showing(
        TestHelper.sampleMovie,
        1,
        LocalDateTime.of(LocalDate.now(), LocalTime.of(18, 0))
    );
    assertEquals(0, timeDiscount.applyDiscount(testShowing));
  }

  @Test
  @DisplayName("Test discount for a showing at 11 AM")
  void testTimeDiscountAt11AM()  {
    TimeDiscount timeDiscount = new TimeDiscount();
    Showing testShowing = new Showing(
        TestHelper.sampleMovie,
        1,
        LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0))
    );
    assertEquals(0.25 * TestHelper.sampleMovie.getTicketPrice(), timeDiscount.applyDiscount(testShowing));
  }

  @Test
  @DisplayName("Test discount for a showing at 4 PM")
  void testTimeDiscountAt4PM()  {
    TimeDiscount timeDiscount = new TimeDiscount();
    Showing testShowing = new Showing(
        TestHelper.sampleMovie,
        1,
        LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 0))
    );
    assertEquals(0.25 * TestHelper.sampleMovie.getTicketPrice(), timeDiscount.applyDiscount(testShowing));
  }
}
