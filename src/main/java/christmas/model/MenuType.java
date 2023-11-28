package christmas.model;

import java.util.Arrays;

public enum MenuType {
    Default("없음"),
    MainMenu("MainMenu"),
    Appetizer("Appetizer"),
    Drink("Drink"),
    Dessert("Dessert");

    private String menuType;

    MenuType(String menuType) {
        this.menuType = menuType;
    }

    public String searchMenuType() {
        return this.menuType;
    }

    public static MenuType getMenuType(String menuType) {
        return Arrays.stream(MenuType.values())
                .filter(type -> type.searchMenuType().equalsIgnoreCase(menuType))
                .findFirst()
                .orElse(null);
    }
}
