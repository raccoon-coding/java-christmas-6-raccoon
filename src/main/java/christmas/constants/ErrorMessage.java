package christmas.constants;

public enum ErrorMessage {
    PREFIX ("[ERROR] "),
    ENTER_DATE (PREFIX.getMessage() + "유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ENTER_MENU (PREFIX.getMessage() + "유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message =  message;
    }

    public String getMessage() {
        return message;
    }
}
