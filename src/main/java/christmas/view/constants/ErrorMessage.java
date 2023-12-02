package christmas.view.constants;

public enum ErrorMessage {
    PREFIX("[ERROR] "),
    IS_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    IS_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}