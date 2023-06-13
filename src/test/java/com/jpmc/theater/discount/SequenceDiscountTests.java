package com.jpmc.theater.discount;

import com.jpmc.theater.Showing;
import com.jpmc.theater.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequenceDiscountTests {
  @Test
  @DisplayName("Test discount for the first movie shown in sequence")
  void testFirstSequenceDiscount()  {
    SequenceDiscount sequenceDiscount = new SequenceDiscount();
    Showing testShowing = new Showing(
        TestHelper.sampleMovie,
        1,
        LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0))
    );
    assertEquals(3, sequenceDiscount.applyDiscount(testShowing));
  }

  @Test
  @DisplayName("Test discount for the second movie shown in sequence")
  void testSecondSequenceDiscount()  {
    SequenceDiscount sequenceDiscount = new SequenceDiscount();
    Showing testShowing = new Showing(
        TestHelper.sampleMovie,
        2,
        LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0))
    );
    assertEquals(2, sequenceDiscount.applyDiscount(testShowing));
  }

  @Test
  @DisplayName("Test discount for movie shown in sequence pass the second")
  void testPastSecondSequenceDiscount()  {
    SequenceDiscount sequenceDiscount = new SequenceDiscount();
    Showing testShowing = new Showing(
        TestHelper.sampleMovie,
        3,
        LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0))
    );
    assertEquals(0, sequenceDiscount.applyDiscount(testShowing));
  }
}
