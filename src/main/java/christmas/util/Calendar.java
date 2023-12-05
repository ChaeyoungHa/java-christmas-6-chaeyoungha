package christmas.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calendar {
    public static final int DEFAULT_YEAR = 2023;
    public static final int DEFAULT_MONTH = 12;
    public static final int CHRISTMAS_DAY = 25;
    public static final int FIRST_DAY = 1;
    public static final int LAST_DAY = 31;

    public static List<LocalDate> generateDatesUntilChristmas() {
        return generateDates(FIRST_DAY, CHRISTMAS_DAY);
    }

    public static List<LocalDate> generateAllDates() {
        return generateDates(FIRST_DAY, LAST_DAY);
    }

    public static List<LocalDate> generateAllDatesWithDayOfWeek(List<DayOfWeek> dayOfWeek) {
        return generateDates(FIRST_DAY, LAST_DAY, dayOfWeek);
    }

    public static List<LocalDate> generateDates(List<Integer> days) {
        return days.stream()
                .map(Calendar::generateDate)
                .collect(Collectors.toList());
    }

    public static LocalDate generateDate(int day) {
        return LocalDate.of(DEFAULT_YEAR, DEFAULT_MONTH, day);
    }

    private static List<LocalDate> generateDates(int start, int end) {
        int dayCount = end - start + 1;

        return IntStream.iterate(0, i -> i + 1)
                .limit(dayCount)
                .mapToObj(generateDate(start)::plusDays)
                .collect(Collectors.toList());
    }

    private static List<LocalDate> generateDates(int start, int end, List<DayOfWeek> dayOfWeek) {
        return generateDates(start, end).stream()
                .filter(date -> dayOfWeek.contains(date.getDayOfWeek()))
                .collect(Collectors.toList());
    }
}
