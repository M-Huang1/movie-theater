package com.jpmc.theater.discount;

import com.jpmc.theater.Showing;

// Discount for movie showings at specific date
public class DateDiscount implements Discount {

  /**
   * Movies shown during the 7th day of the month is given a discount.
   */
  @Override
  public double applyDiscount(Showing showing) {
    return showing.getStartTime().toLocalDate().getDayOfMonth() == 7 ? 1 : 0;
  }
}
