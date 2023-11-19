package christmas.domain.Discount;

import christmas.Dto.Date;
import christmas.Dto.Discount.DiscountPolicy;
import christmas.Dto.Discount.EachDiscount;

import static christmas.constants.Covert.CHRISTMAS_DAY;
import static christmas.constants.Discount.CHRISTMAS;

public class ChristmasDiscount {
    public void haveChristmasDiscount() {
        Date date = Date.getInstance();
        int day = date.requestDay();
        if(day > CHRISTMAS_DAY){
            return;
        }
        addChristmasDiscount(day);
    }

    private void addChristmasDiscount(int day) {
        DiscountPolicy discountPolicy = DiscountPolicy.getInstance();
        EachDiscount eachDiscount = EachDiscount.createOneDiscount(CHRISTMAS, (day - 1) * 100 + 1000);
        discountPolicy.addTotalDiscount(eachDiscount);
    }
}
