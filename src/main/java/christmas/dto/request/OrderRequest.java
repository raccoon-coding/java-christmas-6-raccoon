package christmas.dto.request;

import christmas.model.Menu;

public record OrderRequest(Menu orderMenu, int quantity, String menuType) {
}
