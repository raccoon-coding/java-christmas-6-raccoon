package christmas.dto;

import christmas.model.Date;
import christmas.repository.SetFixDiscount;

import java.util.Objects;

public class SaveDiscount {
    public void saveDiscount() {
        Date date = Date.getInstance();
        String day = date.getDay();
        int nDays = date.getnDays();
        discountWeekday(day);
        discountWeekend(day);
        int christmasDiscount = discountChristmas(nDays);
        int specialDiscount = specialDiscount(day, nDays);
        saveDiscount(christmasDiscount, specialDiscount);
    }

    private void discountWeekday(String day) {
        if(!Objects.equals(day, "금요일") && !Objects.equals(day, "토요일")){
            SetFixDiscount setFixDiscount = new SetFixDiscount();
            setFixDiscount.setDessert(2023);
        }
    }

    private void discountWeekend(String day) {
        if (Objects.equals(day, "금요일") || Objects.equals(day, "토요일")) {
            SetFixDiscount setFixDiscount = new SetFixDiscount();
            setFixDiscount.setMainFood(2023);
        }
    }

    private int discountChristmas(int nDays){
        if(nDays > 25){
            return 0;
        }
        return (nDays - 1) * 100 + 1000;
    }

    private int specialDiscount(String day, int nDays) {
        if(Objects.equals(day, "일요일") || Objects.equals(nDays, 25)){
            return 1000;
        }
        return 0;
    }

    private void saveDiscount(int christmasDiscount, int specialDiscount) {
        Date date = Date.getInstance();
        date.setDiscount(christmasDiscount, specialDiscount);
    }
}
