package christmas.domain;

import christmas.Dto.OrderMenus;
import christmas.service.validation.MenuConvertValidation;
import christmas.service.validation.MenuNameValidation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConvertMenu {
    public MenuConvertValidation menuConvertValidation;
    public MenuNameValidation menuNameValidation;

    public ConvertMenu() {
        this.menuConvertValidation = new MenuConvertValidation();
        this.menuNameValidation = new MenuNameValidation();
    }

    public void convertMenu(String input) {
        Map<String, Integer> menu = new HashMap<>();
        String[] menus = menuConvertValidation.separateMenu(input);

        separateMenu(menu, menus);
        saveMenu(menu);
    }

    private void separateMenu(Map<String, Integer> menu, String[] menus) {
        int totalQuantity = Arrays.stream(menus)
                .mapToInt(oneMenu -> {
                    String[] menuParts = menuConvertValidation.convertOneMenu(oneMenu);
                    menuConvertValidation.notSeparate(menuParts);
                    return oneMenuSeparate(menuParts, menu);
                })
                .sum();

        menuNameValidation.underCount(totalQuantity);
    }

    private int oneMenuSeparate(String[] menuParts, Map<String, Integer> menu) {
        String menuName = menuParts[0];
        int quantity = menuConvertValidation.convertMenuQuantity(menuParts[1]);

        menuNameValidation.validateMenuName(menuName);
        menuNameValidation.validateMenuQuantity(quantity);
        menuNameValidation.sameMenu(menu, menuName);

        menu.put(menuName, quantity);
        return quantity;
    }

    private void saveMenu(Map<String, Integer> menu){
        OrderMenus orderMenus = OrderMenus.getInstance();

        menu.forEach(orderMenus::addOrderItem);
    }
}
