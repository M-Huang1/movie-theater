package com.jpmc.theater;

import java.time.Duration;
import java.util.Objects;

public class Movie {
    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private boolean specialDiscount;

    public Movie(String title, String description,  Duration runningTime, double ticketPrice, boolean specialDiscount) {
        this.title = title;
        this.description = description;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialDiscount = specialDiscount;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public boolean isSpecialDiscount() {
        return specialDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(specialDiscount, movie.specialDiscount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialDiscount);
    }
}