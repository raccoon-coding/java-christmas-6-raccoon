package christmas.view.OutputView;

import static christmas.view.OutputView.OutputConstants.EMPTY_DISCOUNT_PRICE;
import static christmas.view.OutputView.OutputConstants.LINE_SEPARATOR;
import static christmas.view.OutputView.OutputConstants.PRICE_FORMAT;

public class TotalPriceView {
    public void runUI(int totalPrice) {
        System.out.println(EMPTY_DISCOUNT_PRICE);
        System.out.printf(PRICE_FORMAT, totalPrice);
        System.out.printf(LINE_SEPARATOR);
        System.out.printf(LINE_SEPARATOR);
    }
}
