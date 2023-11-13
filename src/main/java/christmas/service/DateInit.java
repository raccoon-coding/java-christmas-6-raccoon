package christmas.service;

import christmas.domain.ConvertDate;
import christmas.view.InputView;

public class DateInit {
    private static DateInit instance;

    private DateInit() {}

    public static synchronized DateInit getInstance() {
        if (instance == null) {
            instance = new DateInit();
        }
        return instance;
    }

    public void run() {
        while(true){
            try{
                String date = enterDate();
                convertDate(date);
                return ;
            }
            catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private String enterDate() {
        InputView inputView = new InputView();
        return inputView.readDate();
    }

    private void convertDate(String date) {
        ConvertDate convertDate = new ConvertDate();
        convertDate.convertDate(date);
    }
}
