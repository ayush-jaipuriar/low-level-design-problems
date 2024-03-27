import java.util.ArrayList;
import java.util.List;

public class MeetingSchedulerTest {
    private static List<Room> rooms;
    private static Scheduler scheduler;

    public static void resetRooms() {
        // Create rooms
        Room room1 = new Room("Atlas");
        Room room2 = new Room("Nexus");
        Room room3 = new Room("Holycow");

        // Create a new list of rooms
        rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        // Create a new scheduler with the reset rooms
        scheduler = new Scheduler(rooms);
    }

    public static void main(String[] args) {
        // Test case 1: bookRoom a single meeting
        System.out.println("Test case 1:");
        resetRooms();
        System.out.println(scheduler.bookRoom(2, 5));

        // Test case 2: bookRoom multiple non-overlapping meetings in the same room
        System.out.println("\nTest case 2:");
        resetRooms();
        System.out.println(scheduler.bookRoom(2, 5));
        System.out.println(scheduler.bookRoom(6, 8));
        System.out.println(scheduler.bookRoom(9, 11));

        // Test case 3: bookRoom multiple meetings in different rooms
        System.out.println("\nTest case 3:");
        resetRooms();
        System.out.println(scheduler.bookRoom(2, 5));
        System.out.println(scheduler.bookRoom(3, 6));
        System.out.println(scheduler.bookRoom(4, 7));

        // Test case 4: bookRoom overlapping meetings
        System.out.println("\nTest case 4:");
        resetRooms();
        System.out.println(scheduler.bookRoom(2, 5));
        System.out.println(scheduler.bookRoom(4, 7));

        // Test case 5: bookRoom a meeting when no rooms are available
        System.out.println("\nTest case 5:");
        resetRooms();
        System.out.println(scheduler.bookRoom(2, 5));
        System.out.println(scheduler.bookRoom(3, 6));
        System.out.println(scheduler.bookRoom(4, 7));
        System.out.println(scheduler.bookRoom(5, 8));

        // Test case 6: bookRoom meetings with the same start and end times
        System.out.println("\nTest case 6:");
        resetRooms();
        System.out.println(scheduler.bookRoom(2, 5));
        System.out.println(scheduler.bookRoom(2, 5));

        // Test case 7: bookRoom meetings with start time equal to end time
        System.out.println("\nTest case 7:");
        resetRooms();
        System.out.println(scheduler.bookRoom(4, 4));

        // Test case 8: bookRoom meetings with end time before start time (invalid
        // input)
        System.out.println("\nTest case 8:");
        resetRooms();
        System.out.println(scheduler.bookRoom(6, 4));

        // Test case 9: bookRoom a meeting with a large time range
        System.out.println("\nTest case 9:");
        resetRooms();
        System.out.println(scheduler.bookRoom(1, 100));

        // Test case 10: bookRoom a meeting with negative start or end times (invalid
        // input)
        System.out.println("\nTest case 10:");
        resetRooms();
        System.out.println(scheduler.bookRoom(-2, 5));

        // Test case 11: bookRoom a meeting with non-integer start or end times (invalid
        // input)
        // System.out.println("\nTest case 11:");
        // System.out.println(scheduler.bookRoom(2.5, 6)); // This will cause a
        // compilation error

        // Test case 12: bookRoom meetings in a specific order to test room assignment
        // priority
        System.out.println("\nTest case 12:");
        resetRooms();
        System.out.println(scheduler.bookRoom(2, 5));
        System.out.println(scheduler.bookRoom(3, 6));
        System.out.println(scheduler.bookRoom(4, 7));
        System.out.println(scheduler.bookRoom(5, 8));
        System.out.println(scheduler.bookRoom(6, 9));
    }
}
