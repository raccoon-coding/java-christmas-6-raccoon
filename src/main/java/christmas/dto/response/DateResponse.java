package christmas.dto.response;

import java.util.Map;

public record DateResponse(int day, String dayOfWeek, Map<String, String> weekDiscount) {
}
