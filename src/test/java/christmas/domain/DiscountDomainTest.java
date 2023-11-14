package christmas.domain;

import christmas.constants.SevenDays;
import christmas.model.Date;
import christmas.model.TotalPrice;
import christmas.repository.SaveDiscount;
import christmas.repository.UpdateMenuRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.constants.DiscountConstant.CHRISTMAS;
import static christmas.constants.DiscountConstant.SPECIAL;
import static christmas.constants.DiscountConstant.WEEKDAY;
import static christmas.constants.DiscountConstant.WEEKEND;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiscountDomainTest {
    private static DiscountDomain discountDomain;
    private static Date date;
    private static TotalPrice totalPrice;
    private static SaveDiscount saveDiscount;
    private static UpdateMenuRepository updateMenuRepository;

    @BeforeAll
    public static void testSetUp() {
        discountDomain = new DiscountDomain();
        date = Date.getInstance();
        totalPrice = TotalPrice.getInstance();
        saveDiscount = new SaveDiscount();
        updateMenuRepository = UpdateMenuRepository.getInstance();
    }

    @AfterEach
    public void testEnd() {
        totalPrice.setTotalPrice(0);
        totalPrice.setTotalEvent(0);
        date.setDay(null,0);
        date.setDiscount(0,0);
        updateMenuRepository.updateQuantity("티본스테이크", 0);
        updateMenuRepository.updateQuantity("바비큐립", 0);
        updateMenuRepository.updateQuantity("초코케이크", 0);
        updateMenuRepository.updateQuantity("제로콜라", 0);
    }

    @DisplayName("크리스마스 디데이 할인이 제대로 적용되어야 한다.")
    @Test
    public void christmasDiscount() {
        date.setDay(SevenDays.Wednesday.getDays(), 20);
        totalPrice.setTotalPrice(100_000);
        saveDiscount.saveDiscount();
        discountDomain.calculateDiscount(date, totalPrice);
        assertTrue(totalPrice.getDiscount().containsKey(CHRISTMAS));
    }

    @DisplayName("특정 요일에는 특별 할인이 들어가야 한다.")
    @Test
    public void specialDiscount() {
        date.setDay(SevenDays.Monday.getDays(),25);
        totalPrice.setTotalPrice(100_000);
        saveDiscount.saveDiscount();
        discountDomain.calculateDiscount(date, totalPrice);
        assertTrue(totalPrice.getDiscount().containsKey(SPECIAL));
    }

    @DisplayName("주중에는 디저트 메뉴가 할인이 들어가야 한다.")
    @Test
    public void weekdayDiscount() {
        updateMenuRepository.updateQuantity("티본스테이크", 1);
        updateMenuRepository.updateQuantity("바비큐립", 1);
        updateMenuRepository.updateQuantity("초코케이크", 2);
        updateMenuRepository.updateQuantity("제로콜라", 1);
        totalPrice.setTotalPrice(142_000);
        date.setDay(SevenDays.Thursday.getDays(), 7);
        saveDiscount.saveDiscount();
        discountDomain.calculateDiscount(date, totalPrice);
        assertTrue(totalPrice.getDiscount().containsKey(WEEKDAY));
    }

    @DisplayName("주말에는 메인 메뉴가 할인이 들어가야 한다.")
    @Test
    public void weekendDiscount() {
        updateMenuRepository.updateQuantity("티본스테이크", 1);
        updateMenuRepository.updateQuantity("바비큐립", 1);
        updateMenuRepository.updateQuantity("초코케이크", 2);
        updateMenuRepository.updateQuantity("제로콜라", 1);
        totalPrice.setTotalPrice(142_000);
        date.setDay(SevenDays.Friday.getDays(), 15);
        saveDiscount.saveDiscount();
        discountDomain.calculateDiscount(date, totalPrice);
        assertTrue(totalPrice.getDiscount().containsKey(WEEKEND));
    }
}
