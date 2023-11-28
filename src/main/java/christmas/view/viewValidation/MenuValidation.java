package christmas.view.viewValidation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class MenuValidation {
    public List<Map<String, Integer>> enterOrderMenuIsFormat(String enterOrder) {
        List<String> menuItems = Arrays.asList(enterOrder.split(","));

        return menuItems.stream()
                .map(item -> {
                    String[] parts = item.split("-");
                    if (parts.length != 2) {
                        throw new IllegalArgumentException("Invalid format for menu item: " + item);
                    }
                    String menuName = parts[0];
                    int quantity = quantityIsInt(parts[1]);
                    return Map.of(menuName, quantity);
                })
                .collect(Collectors.toList());
    }

    private int quantityIsInt(String quantity) {
        try{
            return parseInt(quantity);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
