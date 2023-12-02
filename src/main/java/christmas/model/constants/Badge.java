package christmas.model.constants;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Badge {
    DEFAULT("", discount -> discount < 5_000),
    THIRD("별", discount -> discount >= 5_000 && discount < 10_000),
    SECOND("트리", discount -> discount >= 10_000 && discount < 20_000),
    FIRST("산타", discount -> discount >= 20_000);
    private final String badge;
    private final Predicate<Integer> discountPredicate;

    Badge(String badge, Predicate<Integer> pricePredicate) {
        this.badge = badge;
        this.discountPredicate = pricePredicate;
    }

    public static Badge getBadge(int discount) {
        return Arrays.stream(Badge.values())
                .filter(badge -> badge.discountPredicate.test(discount))
                .findFirst()
                .orElse(DEFAULT);
    }

    public String getBadgeName() {
        return badge;
    }
}
