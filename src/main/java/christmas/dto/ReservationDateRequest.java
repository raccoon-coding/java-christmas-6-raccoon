package christmas.dto;

public record ReservationDateRequest(int date) {
    public static ReservationDateRequest create(int date) {
        return new ReservationDateRequest(date);
    }
}
