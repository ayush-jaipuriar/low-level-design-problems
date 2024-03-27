import java.util.ArrayList;
import java.util.List;

// The Rider class extends the Person class, representing a user who can create, update, withdraw, and close rides.
public class Rider extends Person {
    // A list to store all the rides created by the rider.
    private List<Ride> ridesList;
    // The current ride being created or managed by the rider.
    Ride currentRide;

    // Constructor for the Rider class, initializing the ridesList and setting the
    // name of the rider.
    public Rider(String name) {
        super(name);
        ridesList = new ArrayList<>();
    }

    // Method to create a new ride with the specified parameters.
    public void createRide(int id, int origin, int destination, int numOfSeats) {
        // Check if the origin is greater than the destination, which is not valid.
        if (origin > destination) {
            System.out.println("Wrong values of origin and destination provided");
            return;
        }

        // Initialize a new Ride object and set its properties.
        currentRide = new Ride();
        currentRide.setId(id);
        currentRide.setOrigin(origin);
        currentRide.setDestination(destination);
        currentRide.setNumOfSeats(numOfSeats);
        currentRide.setRideStatus(RideStatus.CREATED);
    }

    // Method to update the current ride with new parameters.
    public void updateRide(int id, int origin, int destination, int numOfSeats) {
        // Check if the ride can be updated based on its current status.
        if (currentRide.getRideStatus() == RideStatus.WITHDRAWN) {
            System.out.println("Cannot update ride since its already been withdrawn");
            return;
        } else if (currentRide.getRideStatus() == RideStatus.COMPLETED) {
            System.out.println("Cannot update ride since its already been cancelled");
            return;
        }
        // Update the ride with the new parameters.
        createRide(id, origin, destination, numOfSeats);
    }

    // Method to withdraw the current ride.
    public void withdrawRide(int id) {
        // Check if the provided id matches the current ride's id.
        if (currentRide.getId() != id) {
            System.out.println("Wrong ride id as input. Cant withdraw the current ride");
            return;
        }
        // Check if the ride is in a state that can be withdrawn.
        if (currentRide.getRideStatus() != RideStatus.CREATED) {
            System.out.println("Ride wasn't in progress. Cannot withdraw ride");
            return;
        }
        // Set the ride status to WITHDRAWN.
        currentRide.setRideStatus(RideStatus.WITHDRAWN);
    }

    // Method to close the current ride, calculate the fare, and return the value.
    public int closeRide() {
        // Check if the ride is in progress.
        if (currentRide.getRideStatus() != RideStatus.CREATED) {
            System.out.println("Ride wasn't in progress, cannot withdraw the ride");
            return -1;
        }
        // Set the ride status to COMPLETED.
        currentRide.setRideStatus(RideStatus.COMPLETED);
        // Add the completed ride to the ridesList.
        ridesList.add(currentRide);
        // Determine if the rider is a privileged user based on the number of rides
        // completed.
        boolean isPriviledgedUser = ridesList.size() >= 10;
        // Return the total calculated ride amount.
        return currentRide.calculateRideAmount(isPriviledgedUser);
    }

    // Getter for the rider's name.
    public String getName() {
        return name;
    }

    // Setter for the rider's name.
    public void setName(String name) {
        this.name = name;
    }
}