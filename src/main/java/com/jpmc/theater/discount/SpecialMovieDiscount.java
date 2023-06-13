package com.jpmc.theater.discount;

import com.jpmc.theater.Showing;

// Discount for a movie labeled special
public class SpecialMovieDiscount implements Discount {

  /**
   * Special movies are given a 20% discount.
   */
  @Override
  public double applyDiscount(Showing showing) {
      return showing.getMovie().isSpecialDiscount() ? 0.2 * showing.getMovie().getTicketPrice() : 0;
  }
}
