package christmas.domain;

import christmas.model.TotalPrice;
import christmas.repository.UpdateMenuRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.constants.DiscountConstant.GIFT_EVENT;
import static christmas.constants.DiscountConstant.GIFT_PRICE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationMenuDomainTest {
    CalculationMenuDomain calculationMenuDomain;

    public CalculationMenuDomainTest() {
        this.calculationMenuDomain = new CalculationMenuDomain();
    }

    @BeforeEach
    public void beforeTest() {
        UpdateMenuRepository updateMenuRepository = UpdateMenuRepository.getInstance();
        updateMenuRepository.updateQuantity("티본스테이크", 2);
        updateMenuRepository.updateQuantity("레드와인", 1);
        updateMenuRepository.updateQuantity("시저샐러드", 1);
        updateMenuRepository.updateQuantity("초코케이크", 1);
    }

    @AfterEach
    public void testEnd() {
        UpdateMenuRepository updateMenuRepository = UpdateMenuRepository.getInstance();
        updateMenuRepository.updateQuantity("티본스테이크", 0);
        updateMenuRepository.updateQuantity("레드와인", 0);
        updateMenuRepository.updateQuantity("시저샐러드", 0);
        updateMenuRepository.updateQuantity("초코케이크", 0);
    }

    @DisplayName("주문 가격 합산이 제대로 작동하는지 확인")
    @Test
    public void sumPriceTest() {
        calculationMenuDomain.calculationMenuDomain();
        TotalPrice totalPrice = TotalPrice.getInstance();

        assertEquals(193_000, totalPrice.getTotalPrice());
    }

    @DisplayName("샴페인 증정 이벤트가 제대로 작동하는지 확인")
    @Test
    public void givenEvent() {
        calculationMenuDomain.calculationMenuDomain();
        TotalPrice totalPrice = TotalPrice.getInstance();

        assertEquals(GIFT_PRICE, totalPrice.getDiscount().get(GIFT_EVENT));
    }
}
