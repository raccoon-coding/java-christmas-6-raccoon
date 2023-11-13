package christmas.domain;

import christmas.repository.UpdateMenuRepository;

import java.util.HashMap;
import java.util.Map;

import static christmas.constants.CovertConstant.MAPPER;
import static christmas.constants.CovertConstant.SEPARATOR;

public class ConvertMenu {
    public void convertMenu(String input) {
        Map<String, Integer> menu = new HashMap<>();
        String[] menus = input.split(SEPARATOR);

        for (String oneMenu : menus) {
            String[] menuParts = oneMenu.split(MAPPER);
            String menuName = menuParts[0];
            int quantity = Integer.parseInt(menuParts[1]);
            menu.put(menuName, quantity);
        }

        saveMenu(menu);
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
