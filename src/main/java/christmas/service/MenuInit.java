package christmas.service;

public class MenuInit {
    private static MenuInit instance;

    private MenuInit() {

    }

    public static MenuInit getInstance() {
        if (instance == null) {
            instance = new MenuInit();
        }
        return instance;
    }
}
