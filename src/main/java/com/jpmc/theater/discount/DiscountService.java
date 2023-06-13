package com.jpmc.theater.discount;

import com.jpmc.theater.Showing;

import java.util.ArrayList;
import java.util.List;

// Service to apply discounts for movie showings
public class DiscountService {
  private final List<Discount> discountList;

  private static DiscountService singleton;

  private DiscountService() {
      discountList = new ArrayList<>();
      discountList.add(new SpecialMovieDiscount());
      discountList.add(new SequenceDiscount());
      discountList.add(new TimeDiscount());
      discountList.add(new DateDiscount());
  }

  /**
   * Applies all discounts to a showing and returns the highest discount
   */
  public double applyDiscounts(Showing showing) {
    double maxDiscount = 0;
    for (Discount discount: discountList) {
      maxDiscount = Math.max(discount.applyDiscount(showing), maxDiscount);
    }
    return maxDiscount;
  }

  /**
   * Retrieve discountService singleton instance
   */
  public static DiscountService getSingleton() {
    if (singleton == null) {
      singleton = new DiscountService();
    }
    return singleton;
  }
}
