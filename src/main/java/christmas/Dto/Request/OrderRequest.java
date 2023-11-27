package christmas.Dto.Request;

import christmas.Model.Menu;

public record OrderRequest(Menu orderMenu, int quantity, int discount) {
}
