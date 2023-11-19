package christmas.view.OutputView;

import static christmas.constants.Covert.IS_EMPTY;
import static christmas.view.OutputView.OutputConstants.LINE_SEPARATOR;
import static christmas.view.OutputView.OutputConstants.FREE_MENU_INIT;
import static christmas.view.OutputView.OutputConstants.NULL_EVENT;
import static christmas.view.OutputView.OutputConstants.ORDER_MENU_COUNT;

public class ChristmasPromotionView {
    public void runUI(String givePromotion, int promotionQuantity) {
        System.out.println(FREE_MENU_INIT);
        havePromotion(givePromotion, promotionQuantity);
        emptyPromotion(promotionQuantity);
        System.out.printf(LINE_SEPARATOR);
    }

    private void havePromotion(String givePromotion, int promotionQuantity) {
        if(promotionQuantity > IS_EMPTY){
            System.out.printf(ORDER_MENU_COUNT, givePromotion, promotionQuantity);
            System.out.printf(LINE_SEPARATOR);
        }
    }

    private void emptyPromotion(int promotionQuantity) {
        if(promotionQuantity == IS_EMPTY){
            System.out.printf(NULL_EVENT);
            System.out.printf(LINE_SEPARATOR);
        }
    }
}
