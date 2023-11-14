package christmas.domain;

import christmas.constants.SevenDays;
import christmas.model.Date;
import christmas.service.validation.DataValidation;

public class ConvertDate {
    private static final int SEVEN_DAY = 7;
    public static final int DAYS_FACTOR = 3;
    DataValidation dataValidation;

    public ConvertDate() {
        this.dataValidation = new DataValidation();
    }

    public void convertDate(String date) {
        int nDay = convertNDay(date);
        String day = convertDay(nDay);
        saveDays(day, nDay);
    }

    private int convertNDay(String date) {
        int nDay = dataValidation.convertInt(date);
        dataValidation.validateDate(nDay);
        return nDay;
    }

    private String convertDay(int nDay) {
        int index = (nDay + DAYS_FACTOR) % SEVEN_DAY;
        String day = SevenDays.returnDays(index);
        dataValidation.validateDay(day);
        return day;
    }

    private void saveDays(String day, int nDay) {
        Date date = Date.getInstance();
        date.setDay(day, nDay);
    }
}
