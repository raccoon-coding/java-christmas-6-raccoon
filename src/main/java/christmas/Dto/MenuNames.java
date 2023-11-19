package christmas.Dto;

import java.util.Arrays;

public enum MenuNames {
    Default ("없음", 0, requestDefaultType()),
    MushroomSoup("양송이수프", 6_000, requestAppetizerType()),
    Tapas("타파스", 5_500, requestAppetizerType()),
    CaesarSalad("시저샐러드", 8_000, requestAppetizerType()),
    TBoneSteak("티본스테이크", 55_000, requestMainMenuType()),
    BBQLip("바비큐립", 54_000, requestMainMenuType()),
    SeafoodPasta("해산물파스타", 35_000, requestMainMenuType()),
    ChristmasPasta("크리스마스파스타", 25_000, requestMainMenuType()),
    ChocolateCake("초코케이크", 15_000, requestDessertType()),
    IceCream("아이스크림", 5_000, requestDessertType()),
    ZeroCoke("제로콜라", 3_000, requestDrinkType()),
    RedWine("레드와인", 60_000, requestDrinkType()),
    Champagne("샴페인", 25_000, requestDrinkType());

    private final String name;
    private final int price;
    private final String type;

    MenuNames(String name, int price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String requestName() {
        return name;
    }

    public int requestPrice() {
        return price;
    }
    public String requestType() {
        return type;
    }

    public static MenuNames requestMenuNamesByName(String menuName) {
        return Arrays.stream(MenuNames.values())
                .filter(menu -> menu.name.equals(menuName))
                .findFirst()
                .orElse(Default);
    }

    public static String requestMenuName(String menuName) {
        return Arrays.stream(MenuNames.values())
                .filter(menu -> menu.name.equals(menuName))
                .findFirst()
                .map(MenuNames::requestName)
                .orElse(Default.name);
    }

    private static String requestDefaultType(){
        return MenuType.Default.requestType();
    }
    private static String requestAppetizerType(){
        return MenuType.Appetizer.requestType();
    }
    private static String requestMainMenuType(){
        return MenuType.MainMenu.requestType();
    }
    private static String requestDessertType(){
        return MenuType.Dessert.requestType();
    }
    private static String requestDrinkType(){
        return MenuType.Drink.requestType();
    }
}
