package com.jpmc.theater.discount;

import com.jpmc.theater.Showing;
import com.jpmc.theater.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialMovieDiscountTests {
  @Test
  @DisplayName("Test discount for a showing of a special movie")
  void testSpecialMovieDiscount()  {
    SpecialMovieDiscount specialMovieDiscount = new SpecialMovieDiscount();
    Showing testShowing = new Showing(
        TestHelper.sampleSpecialMovie,
        1,
        LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0))
    );
    assertEquals(TestHelper.sampleSpecialMovie.getTicketPrice() * 0.2, specialMovieDiscount.applyDiscount(testShowing));
  }

  @Test
  @DisplayName("Test discount for a showing of a non special movie")
  void testNonSpecialMovieDiscount()  {
    SpecialMovieDiscount specialMovieDiscount = new SpecialMovieDiscount();
    Showing testShowing = new Showing(
        TestHelper.sampleMovie,
        1,
        LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0))
    );
    assertEquals(0, specialMovieDiscount.applyDiscount(testShowing));
  }
}
