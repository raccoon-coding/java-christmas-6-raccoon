package christmas.dto;

import camp.nextstep.edu.missionutils.Console;
import christmas.constants.SevenDays;
import christmas.model.Date;
import christmas.service.validation.DataValidation;

public class ConvertDate {
    private static final int SEVEN_DAY = 7;
    public static final int DAYS_FACTOR = 3;
    public void convertDate(String date) {
        DataValidation dataValidation = new DataValidation();
        int nDay = dataValidation.convertInt(date);
        dataValidation.validateDate(nDay);
        String day = convertDay(nDay);
        saveDays(day, nDay);
    }
    private String convertDay(int nDay) {
        int index = (nDay +  + DAYS_FACTOR) % SEVEN_DAY;
        return SevenDays.returnDays(index);
    }

    private void saveDays(String day, int nDay) {
        Date date = Date.getInstance();
        date.setDay(day, nDay);
    }
}
