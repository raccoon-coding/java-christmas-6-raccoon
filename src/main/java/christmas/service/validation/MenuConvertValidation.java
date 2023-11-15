package christmas.service.validation;

import christmas.constants.ErrorMessage;

import java.util.regex.PatternSyntaxException;

import static christmas.constants.Covert.MAPPER;
import static christmas.constants.Covert.SEPARATOR;

public class MenuConvertValidation {
    public String[] convertOneMenu(String oneMenu) {
        try{
            String[] one = oneMenu.split(MAPPER);
            return one;
        }
        catch (PatternSyntaxException e){
            throw new IllegalArgumentException(ErrorMessage.ENTER_MENU.getMessage());
        }
    }

    public String[] separateMenu(String input) {
        try{
            return input.split(SEPARATOR);
        }
        catch (PatternSyntaxException e){
            throw new IllegalArgumentException(ErrorMessage.ENTER_MENU.getMessage());
        }
    }

    public int convertMenuQuantity(String quantity) {
        try{
            return Integer.parseInt(quantity);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.ENTER_MENU.getMessage());
        }
    }

    public void notSeparate(String[] one) {
        if(one.length != 2){
            throw new IllegalArgumentException(ErrorMessage.ENTER_MENU.getMessage());
        }
    }
}
