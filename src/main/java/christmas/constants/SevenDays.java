package christmas.constants;

public enum SevenDays {
    Monday("월요일"),
    Tuesday("화요일"),
    Wednesday("수요일"),
    Thursday("목요일"),
    Friday("금요일"),
    Saturday("토요일"),
    Sunday("일요일");

    private final String value;

    SevenDays(String value){
        this.value = value;
    }

    public String getDays(){
        return value;
    }

    public static String returnDays(int index){
        if(index < 0 || index >= SevenDays.values().length){
            return null;
        }
        return SevenDays.values()[index].getDays();
    }
}
