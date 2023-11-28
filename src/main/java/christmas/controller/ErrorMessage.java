package christmas.controller;

public enum ErrorMessage {
    Default("[ERROR]"),
    DateError("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    OrderError("유효하지 않은 주문입니다. 다시 입력해 주세요.");
    private String error;
    ErrorMessage(String error) {
        this.error = error;
    }

    public String printErrorMessage() {
        return Default.getError() + " " + error;
    }

    public String getError() {
        return error;
    }
}
