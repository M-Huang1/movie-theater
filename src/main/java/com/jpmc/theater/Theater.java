package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Theater {

    private final List<Showing> schedule;

    public Theater(List<Showing> schedule) {
        this.schedule = schedule;
    }

    public Reservation reserve(Customer customer, int sequence, int howManyTickets) {
        Showing showing;
        try {
            showing = schedule.get(sequence - 1);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw new IllegalStateException("not able to find any showing for given sequence " + sequence);
        }
        return new Reservation(customer, showing, howManyTickets);
    }

    public void printSchedule() {
        System.out.println(LocalDate.now());
        System.out.println("===================================================");
        System.out.println("{");
        schedule.forEach(s -> {
            System.out.println("  {");
            System.out.println("    \"Sequence Of The Day\": \"" + s.getSequenceOfTheDay() + "\",");
            System.out.println("    \"Start Time\": \"" + s.getStartTime().toString() + "\",");
            System.out.println("    \"Title\": \"" + s.getMovie().getTitle() + "\",");
            System.out.println("    \"Running Time\": \"" + humanReadableFormat(s.getMovie().getRunningTime()) + "\",");
            System.out.println("    \"Movie Fee\": \"$" + s.getMovieFee() + "\"");
            System.out.println("  }");
        });
        System.out.println("}");
        System.out.println("===================================================");
    }

    private String humanReadableFormat(Duration duration) {
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());

        return String.format("%s hour%s %s minute%s", hour, handlePlural(hour), remainingMin, handlePlural(remainingMin));
    }

    // (s) postfix should be added to handle plural correctly
    private String handlePlural(long value) {
        if (value == 1) {
            return "";
        }
        else {
            return "s";
        }
    }

    public static void main(String[] args) {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", "Some Desc", Duration.ofMinutes(90), 12.5, true);
        Movie turningRed = new Movie("Turning Red", "Some Desc", Duration.ofMinutes(85), 11, false);
        Movie theBatMan = new Movie("The Batman", "Some Desc", Duration.ofMinutes(95), 9, false);
        List<Showing>  schedule = List.of(
            new Showing(turningRed, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0))),
            new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0))),
            new Showing(theBatMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 50))),
            new Showing(turningRed, 4, LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 30))),
            new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 10))),
            new Showing(theBatMan, 6, LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 50))),
            new Showing(turningRed, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 30))),
            new Showing(spiderMan, 8, LocalDateTime.of(LocalDate.now(), LocalTime.of(21, 10))),
            new Showing(theBatMan, 9, LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 0)))
        );
        Theater theater = new Theater(schedule);
        theater.printSchedule();
    }
}
