package com.jpmc.theater.discount;

import com.jpmc.theater.Showing;

import java.time.LocalTime;

// Discount for movie showings at specific times
public class TimeDiscount implements Discount {

  /**
   * Movies shown between 11 AM and 4 PM are given a 25% discount.
   */
  @Override
  public double applyDiscount(Showing showing) {
    LocalTime showingLocalTime = showing.getStartTime().toLocalTime();
    if (showingLocalTime.isAfter(LocalTime.of(10, 59, 59))
        && showingLocalTime.isBefore(LocalTime.of(16, 1))) {
      return 0.25 * showing.getMovie().getTicketPrice();
    }
    return 0;
  }
}
