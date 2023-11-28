package christmas.model;

import christmas.dto.request.MenuRequest;

public class Menu {
    private String menuName;
    private int menuPrice;
    private MenuType menuType;

    public static Menu of(MenuRequest menuRequest){
        Menu oneMenu = new Menu();
        oneMenu.menuName = menuRequest.menuName();
        oneMenu.menuPrice = menuRequest.menuPrice();
        oneMenu.menuType = MenuType.getMenuType(menuRequest.menuType());
        return oneMenu;
    }

    public String requestMenuName() {
        return this.menuName;
    }
    public int requestMenuPrice() {
        return this.menuPrice;
    }
    public MenuType requestMenuType() {
        return this.menuType;
    }
}
