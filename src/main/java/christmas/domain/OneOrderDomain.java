package christmas.domain;

import christmas.dto.request.OrderRequest;
import christmas.dto.response.MenusResponse;
import christmas.model.Menu;
import christmas.model.Menus;
import christmas.model.Order;

import java.util.Map;

public class OneOrderDomain {
    public Order createOneOrder(Menus menus, Map<String, Integer> order, String discountMenuType) {
        Map.Entry<String, Integer> oneOrder = order.entrySet().iterator().next();
        String menuName = oneOrder.getKey();
        int quantity = oneOrder.getValue();

        Menu menu = menus.searchMenu(new MenusResponse(menuName));
        validateOneOrder(menu);

        return Order.of(new OrderRequest(menu, quantity, discountMenuType));
    }

    private void validateOneOrder(Menu menu){
        ValidateOrders validateOrders = new ValidateOrders();
        validateOrders.validateOneOrder(menu);
    }
}
