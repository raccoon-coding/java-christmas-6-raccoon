package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    private List<Menu> menus;
    public Menus() {
        menus = new ArrayList<>();
    }

    public void addMenus(Menus otherMenus) {
        for (Menu menu : otherMenus.getMenus()) {
            addMenu(menu);
        }
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public List<Menu> getMenus() {
        return List.copyOf(menus);
    }
}
