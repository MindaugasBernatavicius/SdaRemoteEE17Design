package cf.mindaugas._01_principles;

public class _02_Kiss {
    public String getWeekDayComplex(int day) {
        if ((day < 1) || (day > 7))
            throw new IllegalArgumentException("day must be in range 1 to 7");
        String[] days = {
                "Monday", // 0
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday" // 6
        };
        return days[day - 1]; // 7
    }

    public String getWeekDaySimple(int day) {
        switch (day) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                throw new IllegalStateException("day must be in range 1 to 7");
        }
    }

    public static void main(String[] args) {
        // System.out.println(new _02_Kiss().getWeekDayComplex(5));
        assert "Friday".equals(new _02_Kiss().getWeekDaySimple(4)); // -ea
    }
}
