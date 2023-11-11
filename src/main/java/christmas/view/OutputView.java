package christmas.view;

import christmas.model.Menu;
import christmas.model.MenuManager;
import christmas.model.TotalPrice;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static christmas.constants.Output.ORDER_MENU;

public class OutputView {
    public void printMenu() {
        System.out.println("<주문 메뉴>");
        MenuManager menuManager = MenuManager.getInstance();
        List<Menu> menus = menuManager.getAllMenuItems();
        for(Menu menu : menus){
            if(menu.getQuantity() > 0) {
                System.out.printf(ORDER_MENU, menu.getName(), menu.getQuantity());
            }
        }
    }

    public void printPrice(double totalPrice){
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(new DecimalFormat("###,###,###원").format(totalPrice));
    }

    public void givenEvent(){
        System.out.println("<증정 메뉴>");
        System.out.println("샴페인 1개");
    }

    public void totalDiscount() {
        TotalPrice totalPrice = TotalPrice.getInstance();
        if (!totalPrice.getDiscount().isEmpty()) {
            System.out.println("<혜택 내역>");
            for (Map.Entry<String, Integer> discount : totalPrice.getDiscount().entrySet()) {
                System.out.printf("%s : -%d\n", discount.getKey(), discount.getValue());
            }
        } else {
            System.out.println("<혜택 내역>");
            System.out.println("없음");
        }
        System.out.println("<총혜택 금액>");
        System.out.println(totalPrice.getTotalDiscount());
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(totalPrice.getTotalPrice());
    }
}
