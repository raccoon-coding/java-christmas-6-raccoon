package christmas.domain;

import christmas.model.TotalPrice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.domain.EventBadge.SANTA;
import static christmas.domain.EventBadge.STAR;
import static christmas.domain.EventBadge.TREE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventBadgeDomainTest {
    private static TotalPrice totalPrice;
    private static EventBadge eventBadgeDomain;

    @BeforeAll
    public static void testSetUp() {
        totalPrice = TotalPrice.getInstance();
        eventBadgeDomain = new EventBadge();
    }

    @AfterEach
    public void testEnd() {
        totalPrice.refresh();
    }

    @DisplayName("산타 뱃지가 제대로 부여되는지 확인")
    @Test
    public void santaTest() {
        totalPrice.setTotalEvent(-20_000);
        eventBadgeDomain.eventBadge();
        assertEquals(SANTA, totalPrice.getBadge());
    }

    @DisplayName("트리 뱃지가 제대로 부여되는지 확인")
    @Test
    public void treeTest() {
        totalPrice.setTotalEvent(-10_000);
        eventBadgeDomain.eventBadge();
        assertEquals(TREE, totalPrice.getBadge());
    }

    @DisplayName("별 뱃지가 제대로 부여되는지 확인")
    @Test
    public void starTest() {
        totalPrice.setTotalEvent(-5_000);
        eventBadgeDomain.eventBadge();
        assertEquals(STAR, totalPrice.getBadge());
    }
}
