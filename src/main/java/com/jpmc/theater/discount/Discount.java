package com.jpmc.theater.discount;


import com.jpmc.theater.Showing;

public interface Discount {
  double applyDiscount(Showing showing);
}
