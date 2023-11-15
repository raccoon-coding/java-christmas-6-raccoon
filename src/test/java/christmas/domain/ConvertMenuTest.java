package christmas.domain;

import christmas.repository.UpdateMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConvertMenuTest {
    private static ConvertMenu convertMenu;
    private static UpdateMenu updateMenuRepository;
    static String enterMenu;

    @BeforeAll
    public static void testSetUp() {
        convertMenu = new ConvertMenu();
        updateMenuRepository = UpdateMenu.getInstance();
    }

    @AfterEach
    public void testEnd() {
        updateMenuRepository.updateQuantity("티본스테이크", 0);
        updateMenuRepository.updateQuantity("바비큐립", 0);
        updateMenuRepository.updateQuantity("초코케이크", 0);
        updateMenuRepository.updateQuantity("제로콜라", 0);
    }

    @DisplayName("입력된 메뉴의 개수가 모델에 저장되는지 확인")
    @Test
    public void separateMenu() {
        enterMenu = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        convertMenu.convertMenu(enterMenu);
        assertEquals(updateMenuRepository.getMenuItemByName("티본스테이크").getQuantity(),1);
        assertEquals(updateMenuRepository.getMenuItemByName("바비큐립").getQuantity(),1);
        assertEquals(updateMenuRepository.getMenuItemByName("초코케이크").getQuantity(),2);
        assertEquals(updateMenuRepository.getMenuItemByName("제로콜라").getQuantity(),1);
    }

    @DisplayName("20개 이상 주문은 불가능하다.")
    @Test
    public void overQuantity() {
        enterMenu = "티본스테이크-10,바비큐립-3,초코케이크-4,제로콜라-4";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            convertMenu.convertMenu(enterMenu);
        });
        String expectedMessage = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("주문 메뉴 형식 중 메뉴를 나누는 구분자는 컴마로 해야 한다.")
    @Test
    public void enterMenuType() {
        enterMenu = "티본스테이크-2_바비큐립-3_초코케이크-4_제로콜라-4";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            convertMenu.convertMenu(enterMenu);
        });
        String expectedMessage = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("주문 메뉴 중 음료만 존재해서는 안된다.")
    @Test
    public void onlyDrinkMenu() {
        enterMenu = "제로콜라-4";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            convertMenu.convertMenu(enterMenu);
        });
        String expectedMessage = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("주문 메뉴 중 메뉴에 없는 주문은 안된다.")
    @Test
    public void otherMenuOrder() {
        enterMenu = "펩시제로-4,리조또-3";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            convertMenu.convertMenu(enterMenu);
        });
        String expectedMessage = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("주문 메뉴 중 메뉴와 개수 구분자는 '-'이어야 한다.")
    @Test
    public void separateMenuToQuantity() {
        enterMenu = "티본스테이크_2,바비큐립_3,초코케이크_4,제로콜라_4";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            convertMenu.convertMenu(enterMenu);
        });
        String expectedMessage = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("주문 메뉴 개수는 숫자이어야 한다.")
    @Test
    public void quantityIsInteger() {
        enterMenu = "티본스테이크-2,바비큐립-four,초코케이크-4,제로콜라-four";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            convertMenu.convertMenu(enterMenu);
        });
        String expectedMessage = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
