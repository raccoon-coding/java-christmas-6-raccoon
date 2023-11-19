package christmas.view.OutputView;

import java.text.DecimalFormat;

import static christmas.view.OutputView.OutputConstants.LINE_SEPARATOR;
import static christmas.view.OutputView.OutputConstants.PREDICT_PRICE;
import static christmas.view.OutputView.OutputConstants.PRICE_FORMAT;
import static christmas.view.OutputView.OutputConstants.TOTAL_DISCOUNT;

public class TotalDiscountView {
    public void runUI(int totalDiscount, int predictPrice){
        totalDiscountUI(totalDiscount);
        System.out.printf(LINE_SEPARATOR);
        predictPriceUI(predictPrice);
        System.out.printf(LINE_SEPARATOR);
    }

    private void totalDiscountUI(int totalDiscount) {
        System.out.println(TOTAL_DISCOUNT);
        System.out.printf(PRICE_FORMAT, totalDiscount);
        System.out.printf(LINE_SEPARATOR);
    }

    private void predictPriceUI(int predictPrice) {
        System.out.println(PREDICT_PRICE);
        System.out.printf(PRICE_FORMAT, predictPrice);
        System.out.printf(LINE_SEPARATOR);
    }
}
