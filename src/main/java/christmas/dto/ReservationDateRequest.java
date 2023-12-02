package christmas.dto;

public record ReservationDateRequest(int date) {
    public static ReservationDateRequest from(int date) {
        return new ReservationDateRequest(date);
    }
}
