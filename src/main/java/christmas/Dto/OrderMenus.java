package christmas.Dto;

import java.util.ArrayList;
import java.util.List;

public class OrderMenus {
    private static List<OrderMenu> menuItems;
    private static String Badge;
    private static OrderMenu SpecialPromotion;
    private static OrderMenus instance;

    private OrderMenus() {
        menuItems = new ArrayList<>();
        Badge = "없음";
        SpecialPromotion = new OrderMenu("없음", 0);
    }

    public static synchronized OrderMenus getInstance() {
        if (instance == null) {
            instance = new OrderMenus();
        }
        return instance;
    }

    public void addOrderItem(String menuName, int quantity) {
        OrderMenu menuItem = new OrderMenu(menuName, quantity);
        OrderMenus.menuItems.add(menuItem);
    }

    public void setBadge(String Badge) {
        OrderMenus.Badge = Badge;
    }

    public String requestBadge() {
        return OrderMenus.Badge;
    }

    public void updateMenuDiscount(String menuType, int discount) {
        menuItems.forEach(menuItem -> menuItem.updateDiscount(menuType, discount));
    }

    public int calculateTotalPrice() {
        return menuItems.stream()
                .mapToInt(menuItem -> (menuItem.requestMenuPrice() * menuItem.requestQuantity()))
                .sum();
    }

    public int calculateDiscount() {
        return menuItems.stream()
                .mapToInt(menuItem -> (menuItem.requestDiscount() * menuItem.requestQuantity()))
                .sum();
    }

    public void givePromotion() {
        SpecialPromotion = new OrderMenu("샴페인", 1);
    }
    public OrderMenu requestPromotion() {
        return SpecialPromotion;
    }

    public List<OrderMenu> requestOrderMenu() {
        return OrderMenus.menuItems;
    }
}
