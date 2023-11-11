package christmas.dto;

import christmas.repository.UpdateMenuRepository;

import java.util.HashMap;
import java.util.Map;

public class ConvertMenu {
    public void convertMenu(String input) {
        Map<String, Integer> menu = new HashMap<>();
        String[] items = input.split(",");
        for (String item : items) {
            String[] parts = item.split("-");
            String pastaType = parts[0];
            int quantity = Integer.parseInt(parts[1]);
            menu.put(pastaType, quantity);
        }
        saveMenu(menu);
    }

    private void saveMenu(Map<String, Integer> menu){
        UpdateMenuRepository updateMenuRepository = UpdateMenuRepository.getInstance();
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            String menuName = entry.getKey();
            int menuQuantity = entry.getValue();
            updateMenuRepository.updateQuantity(menuName, menuQuantity);
        }
    }
}
