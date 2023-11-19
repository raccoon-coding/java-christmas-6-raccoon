package christmas.domain.Discount;

import christmas.Dto.Date;
import christmas.Dto.Discount.DiscountPolicy;
import christmas.Dto.Discount.EachDiscount;

import java.util.Objects;

import static christmas.constants.Covert.SPECIAL_BADGE;
import static christmas.constants.Discount.SPECIAL;
import static christmas.constants.Discount.SPECIAL_DISCOUNT;

public class SpecialDiscount {
    public void haveSpecialDiscount() {
        Date date = Date.getInstance();
        addSpecailDiscount(date);
    }

    private void addSpecailDiscount(Date date) {
        date.equalSpecialDay();
        if(Objects.equals(date.requestSpecialDay(), SPECIAL_BADGE)){
            DiscountPolicy discountPolicy = DiscountPolicy.getInstance();
            EachDiscount eachDiscount = EachDiscount.createOneDiscount(SPECIAL, SPECIAL_DISCOUNT);
            discountPolicy.addTotalDiscount(eachDiscount);
        }
    }
}
