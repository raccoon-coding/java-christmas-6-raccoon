package christmas.domain;

import christmas.Dto.Date;
import christmas.service.validation.DataValidation;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ConvertDate {
    public DataValidation dataValidation;

    public ConvertDate() {
        this.dataValidation = new DataValidation();
    }

    public void convertDate(String date) {
        int day = convertNDay(date);
        DayOfWeek dayOfWeek = LocalDate.of(2023, 12, day).getDayOfWeek();
        saveDays(dayOfWeek, day);
    }

    private int convertNDay(String date) {
        int nDay = dataValidation.convertInt(date);
        dataValidation.validateDate(nDay);
        return nDay;
    }

    private void saveDays(DayOfWeek dayOfWeek, int day) {
        Date date = Date.getInstance();
        date.reservationDate(dayOfWeek,day);
    }
}
