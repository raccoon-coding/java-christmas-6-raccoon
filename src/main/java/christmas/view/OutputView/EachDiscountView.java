package christmas.view.OutputView;

import java.util.Map;

import static christmas.view.OutputView.OutputConstants.DISCOUNT_CONTEXT;
import static christmas.view.OutputView.OutputConstants.DISCOUNT_CONTEXT_INIT;
import static christmas.view.OutputView.OutputConstants.LINE_SEPARATOR;

public class EachDiscountView {
    public void runUI(Map<String, Integer> discount) {
        haveDiscount(discount);
        System.out.printf(LINE_SEPARATOR);
    }

    private void haveDiscount(Map<String, Integer> discount) {
        System.out.println(DISCOUNT_CONTEXT_INIT);
        discount.forEach((key, value) -> System.out.printf(DISCOUNT_CONTEXT,
                key, value));
    }
}
