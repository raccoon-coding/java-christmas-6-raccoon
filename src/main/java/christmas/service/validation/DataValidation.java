package christmas.service.validation;

import static java.lang.Integer.parseInt;

public class DataValidation {
    public int convertInt(String date) {
        try{
            return parseInt(date);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public void validateDate(int date) {

    }

    public void validateDay(String day){

    }
}
