package christmas.view.OutputView;

import christmas.Dto.OrderMenu;

import java.util.List;

import static christmas.view.OutputView.OutputConstants.LINE_SEPARATOR;
import static christmas.view.OutputView.OutputConstants.ORDER_MENU;
import static christmas.view.OutputView.OutputConstants.ORDER_MENU_COUNT;

public class OrderedMenuView {
    public void runUI(List<OrderMenu> orderedMenus) {
        System.out.println(ORDER_MENU);
        orderedMenus(orderedMenus);
        System.out.printf(LINE_SEPARATOR);
    }

    private void orderedMenus(List<OrderMenu> orderedMenus) {
        orderedMenus.forEach(menu -> {
            System.out.printf(ORDER_MENU_COUNT, menu.requestMenuName(), menu.requestQuantity());
            System.out.printf(LINE_SEPARATOR);
        });
    }
}
