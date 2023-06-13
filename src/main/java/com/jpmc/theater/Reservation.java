package com.jpmc.theater;

import com.jpmc.theater.discount.DiscountService;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;

    public Reservation(Customer customer, Showing showing, int audienceCount) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
    }

    public double totalFee() {
        double totalFee = (showing.getMovieFee() - DiscountService.getSingleton().applyDiscounts(showing)) * audienceCount;
        // Round up
        return (double)Math.round(totalFee * 100d) / 100d;
    }
}