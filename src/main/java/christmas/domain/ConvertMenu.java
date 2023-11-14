package christmas.domain;

import christmas.repository.UpdateMenuRepository;
import christmas.service.validation.MenuConvertValidation;
import christmas.service.validation.MenuNameValidation;

import java.util.HashMap;
import java.util.Map;

public class ConvertMenu {
    MenuConvertValidation menuConvertValidation;
    MenuNameValidation menuNameValidation;
    public ConvertMenu() {
        this.menuConvertValidation = new MenuConvertValidation();
        this.menuNameValidation = new MenuNameValidation();
    }

    public void convertMenu(String input) {
        Map<String, Integer> menu = new HashMap<>();
        String[] menus = menuConvertValidation.separateMenu(input);

        separateMenu(menu, menus);
        menuNameValidation.otherMenu(menu);
        saveMenu(menu);
    }

    private void separateMenu(Map<String, Integer> menu, String[] menus) {
        int totalQuantity = 0;

        for (String oneMenu : menus) {
            String[] menuParts = menuConvertValidation.convertOneMenu(oneMenu);
            menuConvertValidation.notSeparate(menuParts);
            totalQuantity += oneMenuSeparate(menuParts, menu);
        }

        menuNameValidation.underCount(totalQuantity);
    }

    private int oneMenuSeparate(String[] menuParts, Map<String, Integer> menu) {
        String menuName = menuParts[0];
        int quantity = menuConvertValidation.convertMenuQuantity(menuParts[1]);
        menuNameValidation.validateMenu(menuName, quantity);
        menuNameValidation.sameMenu(menu, menuName);
        menu.put(menuName, quantity);
        return quantity;
    }

    private void saveMenu(Map<String, Integer> menu){
        UpdateMenuRepository updateMenuRepository = UpdateMenuRepository.getInstance();

        for (Map.Entry<String, Integer> menuEntry : menu.entrySet()) {
            String menuName = menuEntry.getKey();
            int menuQuantity = menuEntry.getValue();
            updateMenuRepository.updateQuantity(menuName, menuQuantity);
        }
    }
}
