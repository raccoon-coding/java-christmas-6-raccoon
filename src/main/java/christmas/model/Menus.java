package christmas.model;

import christmas.dto.request.MenuRequest;
import christmas.dto.response.MenusResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Menus {
    private List<Menu> menus;
    private static Menus instance;

    private Menus() {
        menus = new ArrayList<>();
        menus.add(Menu.of(new MenuRequest("없음", 0,"없음")));
        initAppetizer();
        initMainMenu();
        initDessert();
        initDrink();
    }

    public static Menus getInstance() {
        if (instance == null) {
            instance = new Menus();
        }
        return instance;
    }

    public Menu searchMenu(MenusResponse menusResponse) {
        Optional<Menu> foundMenu = menus.stream()
                .filter(oneMenu -> oneMenu.requestMenuName().equalsIgnoreCase(menusResponse.menuName()))
                .findFirst();
        return foundMenu.orElse(null);
    }
    private void initAppetizer(){
        menus.add(Menu.of(new MenuRequest("양송이수프", 6_000,"Appetizer")));
        menus.add(Menu.of(new MenuRequest("타파스", 5_500,"Appetizer")));
        menus.add(Menu.of(new MenuRequest("시저샐러드", 8_000,"Appetizer")));
    }

    private void initMainMenu(){
        menus.add(Menu.of(new MenuRequest("티본스테이크", 55_000,"MainMenu")));
        menus.add(Menu.of(new MenuRequest("바비큐립", 54_000,"MainMenu")));
        menus.add(Menu.of(new MenuRequest("해산물파스타", 35_000,"MainMenu")));
        menus.add(Menu.of(new MenuRequest("크리스마스파스타", 25_000,"MainMenu")));
    }

    private void initDessert(){
        menus.add(Menu.of(new MenuRequest("초코케이크", 15_000,"Dessert")));
        menus.add(Menu.of(new MenuRequest("아이스크림", 5_000,"Dessert")));
    }

    private void initDrink(){
        menus.add(Menu.of(new MenuRequest("제로콜라", 3_000,"Drink")));
        menus.add(Menu.of(new MenuRequest("레드와인", 60_000,"Drink")));
        menus.add(Menu.of(new MenuRequest("샴페인", 25_000,"Drink")));
    }
}
