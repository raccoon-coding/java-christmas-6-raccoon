package christmas.service.validation;

import christmas.constants.ErrorMessage;

import static christmas.constants.Covert.IS_EMPTY;
import static java.lang.Integer.parseInt;

public class DataValidation {
    public static final int LAST_DAY = 31;
    public int convertInt(String date) {
        try{
            return parseInt(date);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.ENTER_DATE.getMessage());
        }
    }

    public void validateDate(int date) {
        if(date <= IS_EMPTY || date > LAST_DAY){
            throw new IllegalArgumentException(ErrorMessage.ENTER_DATE.getMessage());
        }
    }

    public void validateDay(String day){

    }
}
