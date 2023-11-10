package christmas.model;

public class Date {
    private static Date instance;
    private String day;
    private int nDays;
    private int christmasDiscount;
    private int specialDiscount;

    private Date() {}

    public static synchronized Date getInstance(){
        if (instance == null) {
            instance = new Date();
        }
        return instance;
    }

    public void setDay(String day, int nDays) {
        this.day = day;
        this.nDays = nDays;
    }

    public String getDay() {
        return day;
    }

    public int getnDays() {
        return nDays;
    }

    public void setDiscount(int christmasDiscount, int specialDiscount) {
        this.christmasDiscount = christmasDiscount;
        this.specialDiscount = specialDiscount;
    }
    public int getChristmasDiscount() {
        return christmasDiscount;
    }


    public int getSpecialDiscount() {
        return specialDiscount;
    }

}
