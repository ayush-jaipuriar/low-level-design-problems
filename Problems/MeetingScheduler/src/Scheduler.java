import java.util.List;
import java.util.Optional;

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
