package com.jpmc.theater;

import java.time.Duration;

public class TestHelper {
  public static Movie sampleMovie = new Movie("SampleMovie", "Some Desc", Duration.ofMinutes(90), 10, false);
  public static Movie sampleSpecialMovie = new Movie("SampleSpecialMovie", "Some Desc", Duration.ofMinutes(90), 10, true);
}
