package com.jpmc.theater.discount;

import com.jpmc.theater.Showing;
import com.jpmc.theater.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountServiceTests {
  private final DiscountService discountService = DiscountService.getSingleton();

  @Test
  @DisplayName("Test discount for showing with a single applicable discount")
  void testSingleApplicableDiscount() {
    Showing testShowing = new Showing(
        TestHelper.sampleSpecialMovie,
        3,
        LocalDateTime.of(LocalDate.of(2023, 6, 9), LocalTime.of(18, 0))
    );
    assertEquals(0.2 * TestHelper.sampleSpecialMovie.getTicketPrice(), discountService.applyDiscounts(testShowing));
  }

  @Test
  @DisplayName("Test discount for showing with multiple applicable discounts")
  void testMultipleApplicableDiscount() {
    Showing testShowing = new Showing(
        TestHelper.sampleSpecialMovie,
        1,
        LocalDateTime.of(LocalDate.of(2023, 6, 7), LocalTime.of(12, 0))
    );
    assertEquals(3, discountService.applyDiscounts(testShowing));
  }

  @Test
  @DisplayName("Test discount for showing with no applicable discounts")
  void testNoApplicableDiscount() {
    Showing testShowing = new Showing(
        TestHelper.sampleMovie,
        3,
        LocalDateTime.of(LocalDate.of(2023, 6, 8), LocalTime.of(18, 0))
    );
    assertEquals(0, discountService.applyDiscounts(testShowing));
  }
}
