package christmas.domain;

import christmas.constants.SevenDays;
import christmas.model.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertDateTest {
    String date;
    ConvertDate convertDate;

    @BeforeEach
    public void setUp() {
        this.date = "25";
        convertDate = new ConvertDate();
    }

    @AfterEach
    public void testEnd() {
        Date date = Date.getInstance();
        date.setDay(null, 0);
    }

    @DisplayName("숫자로 변환되는지 확인")
    @Test
    public void convertNDayTest() {
        convertDate.convertDate(date);
        Date date = Date.getInstance();
        assertEquals(date.getnDays(), 25);
    }

    @DisplayName("요일로 변환되는지 확인")
    @Test
    public void convertDaysTest() {
        convertDate.convertDate(date);
        Date date = Date.getInstance();
        assertEquals(date.getDay(), SevenDays.Monday.getDays());
    }
}
