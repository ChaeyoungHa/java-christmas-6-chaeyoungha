package christmas.core.domain;

import christmas.util.Calendar;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public enum DiscountEvent {
    CHRISTMAS_DDAY_DISCOUNT("크리스마스 디데이 할인", Calendar.generateDatesUntilChristmas(),
            new ChristmasDdayDiscountAmount()),

    WEEKDAY_DISCOUNT("평일 할인",
            Calendar.generateAllDatesWithDayOfWeek(
                    List.of(DayOfWeek.SUNDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                            DayOfWeek.THURSDAY)),
            new WeekdayDiscountAmount()),

    WEEKEND_DISCOUNT("주말 할인",
            Calendar.generateAllDatesWithDayOfWeek(List.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY)),
            new WeekendDiscountAmount()),

    SPECIAL_DISCOUNT("특별 할인", Calendar.generateDates(List.of(3, 10, 17, 24, 25, 31)),
            new SpecialDiscountAmount()),

    GIVEAWAY_DISCOUNT("증정 이벤트", Calendar.generateAllDates(), new GiveawayDiscountAmount());

    private final String name;
    private final List<LocalDate> targetDates;
    public final DiscountAmount discountAmount;


    DiscountEvent(String name, List<LocalDate> targetDates, DiscountAmount discountAmount) {
        this.name = name;
        this.targetDates = targetDates;
        this.discountAmount = discountAmount;
    }

    public String getName() {
        return name;
    }

    public boolean containsDateOf(LocalDate date) {
        return targetDates.contains(date);
    }
}
