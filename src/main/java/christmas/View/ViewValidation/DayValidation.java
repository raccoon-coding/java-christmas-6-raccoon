package christmas.View.ViewValidation;

import static java.lang.Integer.parseInt;

public class DayValidation {
    public int enterDayIsInt(String enterDay) {
        try{
            return parseInt(enterDay);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
