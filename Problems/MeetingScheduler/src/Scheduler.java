import java.util.List;
import java.util.Optional;
import java.util.Vector;

/*
    * Explanation:
    * The Scheduler class acts as an interface to the outside world. The user can
    * only call the public APIs of this class.
    * The class has a private member variable rooms of type Vector<Room> to keep
    * track of all the available rooms for booking. Since we don't need access to
    * this variable from outside the class, getters and setters are not provided.
    * The class has a parameterized constructor Scheduler(Vector<Room> rooms) that
    * takes a list of rooms available for booking as a parameter and initializes
    * the rooms member variable.
    * The book(int start, int end) function is the main API of the Scheduler class.
    * It takes two integers, start and end, as parameters, representing the
    * duration of the booking. The function returns a String indicating the name of
    * the room booked or a message if no room is available.
    * Inside the book() function, we iterate over the available rooms using a
    * for-each loop. For each room, we call the book(start, end) function of the
    * Room class to check if the room is available for the given time slot.
    * If a room is successfully booked (i.e., room.book(start, end) returns true),
    * we return the name of the room using room.getName().
    * If no room is available for the given time slot after iterating through all
    * the rooms, we return the message "No room available for the given time slot."
    */

public class Scheduler {
    private List<Room> rooms;

    public Scheduler(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String bookRoom(int start, int end) {
        Optional<Room> bookedRoom = rooms.stream().filter(room -> room.book(start, end)).findFirst();
        if (bookedRoom.isPresent()) {
            return bookedRoom.get().getName();
        }
        return "No room available for the given slot";
    }

}
