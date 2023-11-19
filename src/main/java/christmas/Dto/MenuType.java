package christmas.Dto;

public enum MenuType {
    Default("없음"),
    Appetizer ("Appetizer"),
    MainMenu("MainMenu"),
    Dessert("Dessert"),
    Drink("Drink");

    private final String menuType;

    MenuType(String menuType) {
        this.menuType = menuType;
    }

    public String requestType() {
        return menuType;
    }
}
