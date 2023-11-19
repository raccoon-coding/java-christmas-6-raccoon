package christmas.Dto.Discount;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EachDiscount {
    private Map<String, Integer> eachDiscount;

    public EachDiscount(String menuType, int discount) {
        eachDiscount = new HashMap<>();
        eachDiscount.put(menuType, discount);
    }

    public static EachDiscount createOneDiscount(String menuType, int discount) {
        return new EachDiscount(menuType, discount);
    }

    public Map<String, Integer> requestEachDiscount() {
        return eachDiscount;
    }

    public String getDiscountName() {
        return eachDiscount.entrySet().iterator().next().getKey();
    }

    public int getDiscountPrice() {
        return eachDiscount.entrySet().iterator().next().getValue();
    }
}
