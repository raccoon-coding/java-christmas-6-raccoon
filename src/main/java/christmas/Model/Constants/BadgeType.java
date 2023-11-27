package christmas.Model.Constants;

import java.util.Arrays;

public enum BadgeType {
    Default("없음"),
    FirstBadge("산타"),
    SecondBadge("트리"),
    ThirdBadge("별");
    private String badgeName;

    BadgeType(String badgeName) {
        this.badgeName = badgeName;
    }

    public String searchBadgeType() {
        return this.badgeName;
    }

    public static BadgeType getBadgeType(String badgeType) {
        return Arrays.stream(BadgeType.values())
                .filter(type -> type.searchBadgeType().equalsIgnoreCase(badgeType))
                .findFirst()
                .orElse(null);
    }
}
