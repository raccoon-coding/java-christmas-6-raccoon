package christmas.model.constants;

import java.util.Arrays;

public enum Menus {
    없음("없음", 0, MenuType.DEFAULT),
    양송이수프("양송이수프", 6_000, MenuType.APPETIZER),
    타파스("타파스", 5_500, MenuType.APPETIZER),
    시저샐러드("시저샐러드", 8_000, MenuType.APPETIZER),
    티본스테이크("티본스테이크", 55_000, MenuType.MAIN_MENU),
    바비큐립("바비큐립", 54_000, MenuType.MAIN_MENU),
    해산물파스타("해산물파스타", 35_000, MenuType.MAIN_MENU),
    크리스마스파스타("크리스마스파스타", 25_000, MenuType.MAIN_MENU),
    초코케이크("초코케이크", 15_000, MenuType.DESSERT),
    아이스크림("아이스크림", 5_000, MenuType.DESSERT),
    제로콜라("제로콜라", 3_000, MenuType.DRINK),
    레드와인("레드와인", 60_000, MenuType.DRINK),
    샴페인("샴페인", 25_000, MenuType.DRINK);

    private final String menuName;
    private final int menuPrice;
    private final MenuType menuType;

    Menus(String menuName, int menuPrice, MenuType menuType) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuType = menuType;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public int getMenuPrice() {
        return this.menuPrice;
    }

    public String getMenuType() {
        return this.menuType.getMenuType();
    }

    public static Menus searchMenus(String menuName) {
        return Arrays.stream(Menus.values())
                .filter(menu -> menu.getMenuName().equals(menuName))
                .findFirst()
                .orElse(없음);
    }
}
