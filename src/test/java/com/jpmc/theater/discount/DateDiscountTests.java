package com.jpmc.theater.discount;

import com.jpmc.theater.Showing;
import com.jpmc.theater.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateDiscountTests {
  @Test
  @DisplayName("Test discount for a showing on the 7th of the month")
  void testDateDiscountForThe7th()  {
    DateDiscount dateDiscount = new DateDiscount();
    Showing testShowing = new Showing(
        TestHelper.sampleMovie,
        1,
        LocalDateTime.of(LocalDate.of(2023, 6, 7), LocalTime.of(9, 0))
    );
    assertEquals(1, dateDiscount.applyDiscount(testShowing));
  }

  @Test
  @DisplayName("Test discount for a showing not on the 7th of the month")
  void testDateDiscountNotForThe7th()  {
    DateDiscount dateDiscount = new DateDiscount();
    Showing testShowing = new Showing(
        TestHelper.sampleMovie,
        1,
        LocalDateTime.of(LocalDate.of(2023, 6, 8), LocalTime.of(9, 0))
    );
    assertEquals(0, dateDiscount.applyDiscount(testShowing));
  }

}
