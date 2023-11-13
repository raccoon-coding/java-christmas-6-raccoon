package christmas.service.validation;

import christmas.constants.ErrorMessage;

import static christmas.constants.CovertConstant.IS_EMPTY;
import static java.lang.Integer.parseInt;

public class DataValidation {
    public int convertInt(String date) {
        try{
            return parseInt(date);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.ENTER_DATE.getMessage());
        }
    }

    public void validateDate(int date) {
        if(date <= IS_EMPTY || date > 31){
            throw new IllegalArgumentException(ErrorMessage.ENTER_DATE.getMessage());
        }
    }

    public void validateDay(String day){

    }
}
