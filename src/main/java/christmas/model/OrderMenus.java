package christmas.model;

import christmas.dto.OrderMenusRequest;
import christmas.model.constants.ErrorMessage;
import christmas.model.constants.Menus;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

import static christmas.model.constants.ModelConstants.DONT_HAVE_MENU;
import static christmas.model.constants.ModelConstants.DONT_ORDER_ONLY_DRINK;
import static christmas.model.constants.ModelConstants.DONT_OVER_20;

public class OrderMenus {
    private final EnumMap<Menus, Integer> orderMenus;

    private OrderMenus(Map<String, Integer> orders) {
        this.orderMenus = new EnumMap<>(Menus.class);
        orderMenus(orders);
        onlyDrinkOrder();
    }

    public static OrderMenus from(OrderMenusRequest orderMenusRequest) {
        return new OrderMenus(orderMenusRequest.orders());
    }

    public EnumMap<Menus, Integer> getOrderMenus() {
        return this.orderMenus;
    }

    public int menuTypeCount(String menuType) {
        return orderMenus.entrySet().stream()
                .filter(entry -> entry.getKey().getMenuType().equals(menuType))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public boolean haveMenuType(String menuType) {
        return orderMenus.keySet().stream()
                .map(Menus::getMenuType)
                .anyMatch(type -> type.equals(menuType));
    }

    public int getTotalPrice() {
        return orderMenus.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getMenuPrice() * entry.getValue())
                .sum();
    }

    private void orderMenus(Map<String, Integer> orders) {
        overOrderCount20(orders);
        orders.forEach(this::createOrders);
    }

    private void createOrders(String oneMenuName, int oneMenuCount) {
        Menus oneMenus = Menus.searchMenus(oneMenuName);
        if (Objects.equals(oneMenus.getMenuName(), DONT_HAVE_MENU)) {
            throw new IllegalArgumentException();
        }
        orderMenus.put(oneMenus, oneMenuCount);
    }

    private void overOrderCount20(Map<String, Integer> orders) {
        int totalCount = orders.values().stream()
                .mapToInt(Integer::intValue)
                .sum();

        if (totalCount > DONT_OVER_20) {
            throw new IllegalArgumentException(ErrorMessage.IS_MENU.getErrorMessage());
        }
    }

    private void onlyDrinkOrder() {
        boolean hasNonDrinkOrder = orderMenus.entrySet().stream()
                .anyMatch(entry -> !entry.getKey().getMenuType().equals(DONT_ORDER_ONLY_DRINK));

        if (!hasNonDrinkOrder) {
            throw new IllegalArgumentException(ErrorMessage.IS_MENU.getErrorMessage());
        }
    }
}
