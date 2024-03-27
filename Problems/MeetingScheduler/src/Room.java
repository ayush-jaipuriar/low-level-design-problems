import java.util.Calendar;
import java.util.List;

/* The Room class has two private member variables:
name of type String to store the name of the room.
calendar of type Vector<Meeting> to keep track of the meetings booked in the room.
The class has a parameterized constructor Room(String name) that takes the room name as a parameter and assigns it to the name member variable. It also initializes the calendar vector.
The getName() function is a getter method that returns the name of the room.
The book(int start, int end) function is the main method for booking a meeting in the room. It takes two parameters: start and end, representing the start and end times of the meeting to be scheduled.
Inside the book() function, we iterate over every meeting m in the calendar using a for-each loop.
For each meeting m, we check if there is a clash in timings with the meeting to be scheduled. The conditions for a clash are:
m.getStart() < end: The start time of the existing meeting m is less than the end time of the meeting to be scheduled.
start < m.getEnd(): The start time of the meeting to be scheduled is less than the end time of the existing meeting m.
If both conditions are satisfied, it means there is a clash, and we return false to indicate that the meeting cannot be scheduled.
If there are no clashes with any existing meeting in the calendar, we create a new Meeting object with the given start and end times and the current Room object (this).
We add the newly created Meeting object to the calendar using the add() method.
Finally, we return true to indicate that the meeting has been successfully scheduled. */

public class Room {
    private String name;
    private List<Meeting> meetings;

    public Room(String name, List<Meeting> meetings) {
        this.name = name;
        this.meetings = meetings;
    }

    public boolean book(int start, int end) {
        // Logic to check if there are any conflicting meetings in this time interval
        for (Meeting meeting : meetings) {
            if (meeting.getStart() < end && start < meeting.getEnd()) {
                return false;
            }
        }
        // By now the meeting is successfully booked
        Meeting meeting = new Meeting(start, end, this);
        meetings.add(meeting);
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

}
