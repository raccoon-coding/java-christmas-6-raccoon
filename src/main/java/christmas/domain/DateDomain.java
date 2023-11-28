package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Objects;

public class DateDomain {
    public String calculationDayOfWeek(int day) {
        LocalDate date = LocalDate.of(2023, 12, day);

        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());
    }
}
