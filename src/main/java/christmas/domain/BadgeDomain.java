package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class BadgeDomain {
    private final String DEFAULT = "없음";
    private final String FIRST = "산타";
    private final String SECOND = "트리";
    private final String THIRD = "별";

    private Map<Integer, String> badgeMap;

    public BadgeDomain() {
        this.badgeMap = new HashMap<>();
        this.badgeMap.put(20_000, FIRST);
        this.badgeMap.put(10_000, SECOND);
        this.badgeMap.put(5_000, THIRD);
    }

    public String giveBadge(int totalPrice) {
        return this.badgeMap.entrySet().stream()
                .filter(entry -> totalPrice > entry.getKey())
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(DEFAULT);
    }
}
