import java.util.Calendar;
import java.util.List;

public class Room {
    private String name;
    private List<Calendar> calendars;

    public boolean book(int start, int end) {
        // Logic to check if there are any conflicting meetings in this time interval

        // By now the meeting is successfully booked

        return true;
    }

    public Room(String name, List<Calendar> calendars) {
        this.name = name;
        this.calendars = calendars;
    }

    public Room() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Calendar> getCalendars() {
        return calendars;
    }

    public void setCalendars(List<Calendar> calendars) {
        this.calendars = calendars;
    }
}
