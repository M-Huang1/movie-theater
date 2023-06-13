package com.jpmc.theater.discount;

import com.jpmc.theater.Showing;

// Discount for movies shown at a sequence for the day
public class SequenceDiscount implements Discount{

  /**
   * The first and second movies shown during the day are given a discount.
   */
  @Override
  public double applyDiscount(Showing showing) {
    switch (showing.getSequenceOfTheDay()) {
      case 1:
        return 3;
      case 2:
        return 2;
      default:
        return 0;
    }
  }
}
