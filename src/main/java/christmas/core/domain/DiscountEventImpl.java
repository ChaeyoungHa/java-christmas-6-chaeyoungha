package christmas.core.domain;

import christmas.util.Calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public enum DiscountEventImpl implements DiscountEvent {
    CHRISTMAS_DDAY_DISCOUNT("크리스마스 디데이 할인", Calendar.generateDatesUntilChristmas()) {
        @Override
        public int calculateDiscountAmount(Reservation reservation) {
            return 1000 + reservation.calculateDifferenceFromFirstDay() * 100;
        }
    },
    WEEKDAY_DISCOUNT("평일 할인",
            Calendar.generateAllDatesWithDayOfWeek(List.of(DayOfWeek.SUNDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY))) {
        @Override
        public int calculateDiscountAmount(Reservation reservation) {
            return reservation.filterMenusByCategory(MenuCategory.DESSERT).values().stream()
                    .mapToInt(count -> count * 2023)
                    .sum();
        }
    },
    WEEKEND_DISCOUNT("주말 할인", Calendar.generateAllDatesWithDayOfWeek(List.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY))) {
        @Override
        public int calculateDiscountAmount(Reservation reservation) {
            return reservation.filterMenusByCategory(MenuCategory.MAIN).values().stream()
                    .mapToInt(count -> count * 2023)
                    .sum();
        }
    },
    SPECIAL_DISCOUNT("특별 할인", Calendar.generateDates(List.of(3, 10, 17, 24, 25, 31))) {
        @Override
        public int calculateDiscountAmount(Reservation reservation) {
            return 1000;
        }
    },
    GIVEAWAY_DISCOUNT("증정 이벤트", Calendar.generateAllDates()) {
        @Override
        public int calculateDiscountAmount(Reservation reservation) {
            if(reservation.calculatePriceBeforeDiscount() >= 120000) {
                return 25000;
            }

            return 0;
        }
    };

    private final String name;
    private final List<LocalDate> targetDates;

    DiscountEventImpl(String name, List<LocalDate> targetDates) {
        this.name = name;
        this.targetDates = targetDates;
    }

    public String getName() {
        return name;
    }

    public List<LocalDate> getTargetDates() {
        return targetDates;
    }

    public boolean containsDateOf(Reservation reservation) {
        return targetDates.contains(reservation.getDate());
    }
}
