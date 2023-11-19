package christmas.Dto.Discount;

import java.util.ArrayList;
import java.util.List;

public class DiscountPolicy {
    private static List<EachDiscount> totalDiscounts;
    private static DiscountPolicy instance;

    private DiscountPolicy() {
        totalDiscounts = new ArrayList<>();
    }

    public static synchronized DiscountPolicy getInstance() {
        if (instance == null) {
            instance = new DiscountPolicy();
        }
        return instance;
    }

    public void addTotalDiscount(EachDiscount oneDiscount) {
        DiscountPolicy.totalDiscounts.add(oneDiscount);
    }

    public List<EachDiscount> requestTotalDiscountsContent() {
        return totalDiscounts;
    }

    public int requestTotalDiscount() {
        return totalDiscounts.stream()
                .flatMapToInt(discount -> discount.requestEachDiscount().values().stream().mapToInt(Integer::intValue))
                .sum();
    }
}
