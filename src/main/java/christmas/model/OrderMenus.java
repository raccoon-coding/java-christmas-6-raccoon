package christmas.model;

import christmas.dto.OrderMenusRequest;
import christmas.model.constants.Menus;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class OrderMenus {
    private final EnumMap<Menus, Integer> orderMenus;

    private OrderMenus(Map<String, Integer> orders) {
        this.orderMenus = new EnumMap<>(Menus.class);
        orderMenus(orders);
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
        return orderMenus.entrySet().stream()
                .filter(entry -> entry.getKey().getMenuType().equals(menuType)).isParallel();
    }

    public int getTotalPrice() {
        return orderMenus.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getMenuPrice() * entry.getValue())
                .sum();
    }

    private void orderMenus(Map<String, Integer> orders) {
        orders.forEach(this::createOrders);
    }

    private void createOrders(String oneMenuName, int oneMenuCount) {
        Menus oneMenus = Menus.searchMenus(oneMenuName);
        if(Objects.equals(oneMenus.getMenuName(), "없음")){
            throw new IllegalArgumentException();
        }
        orderMenus.put(oneMenus, oneMenuCount);
    }
}
