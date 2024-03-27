import java.util.ArrayList;
import java.util.List;

public class RideShareAppTest {
    public static void main(String[] args) {
        // Create riders
        Rider rider1 = new Rider("Bob");
        Rider rider2 = new Rider("Eve");

        // Test case 1: Create a ride and calculate fare (non-preferred rider)
        rider1.createRide(1, 50, 60, 1);
        int fareAmount = rider1.closeRide();
        System.out.println("Test Case 1: Fare Amount = " + fareAmount + ", Rider = " + rider1.getName() + ", Ride ID = " + rider1.currentRide.getId() + ", Origin = " + rider1.currentRide.getOrigin() + ", Destination = " + rider1.currentRide.getDestination() + ", Seats = " + rider1.currentRide.getNumOfSeats());

        // Test case 2: Create a ride and calculate fare (non-preferred rider, multiple seats)
        rider1.createRide(2, 50, 60, 2);
        fareAmount = rider1.closeRide();
        System.out.println("Test Case 2: Fare Amount = " + fareAmount + ", Rider = " + rider1.getName() + ", Ride ID = " + rider1.currentRide.getId() + ", Origin = " + rider1.currentRide.getOrigin() + ", Destination = " + rider1.currentRide.getDestination() + ", Seats = " + rider1.currentRide.getNumOfSeats());

        // Test case 3: Create and update a ride
        rider2.createRide(3, 10, 20, 1);
        rider2.updateRide(3, 15, 25, 1);
        fareAmount = rider2.closeRide();
        System.out.println("Test Case 3: Fare Amount = " + fareAmount + ", Rider = " + rider2.getName() + ", Ride ID = " + rider2.currentRide.getId() + ", Origin = " + rider2.currentRide.getOrigin() + ", Destination = " + rider2.currentRide.getDestination() + ", Seats = " + rider2.currentRide.getNumOfSeats());

        // Test case 4: Withdraw a ride
        rider2.createRide(4, 30, 40, 2);
        rider2.withdrawRide(4);
        // No output expected

        // Test case 5: Preferred rider fare calculation
        List<Ride> completedRides = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            rider1.createRide(i + 5, 50, 60, 1);
            completedRides.add(rider1.currentRide);
            fareAmount = rider1.closeRide();
            System.out.println("Test Case 5: Fare Amount = " + fareAmount + ", Rider = " + rider1.getName() + ", Ride ID = " + rider1.currentRide.getId() + ", Origin = " + rider1.currentRide.getOrigin() + ", Destination = " + rider1.currentRide.getDestination() + ", Seats = " + rider1.currentRide.getNumOfSeats());
        }
        rider1.createRide(16, 50, 60, 1);
        fareAmount = rider1.closeRide();
        System.out.println("Test Case 5: Fare Amount = " + fareAmount + ", Rider = " + rider1.getName() + ", Ride ID = " + rider1.currentRide.getId() + ", Origin = " + rider1.currentRide.getOrigin() + ", Destination = " + rider1.currentRide.getDestination() + ", Seats = " + rider1.currentRide.getNumOfSeats());

        rider1.createRide(17, 50, 60, 2);
        fareAmount = rider1.closeRide();
        System.out.println("Test Case 6: Fare Amount = " + fareAmount + ", Rider = " + rider1.getName() + ", Ride ID = " + rider1.currentRide.getId() + ", Origin = " + rider1.currentRide.getOrigin() + ", Destination = " + rider1.currentRide.getDestination() + ", Seats = " + rider1.currentRide.getNumOfSeats());
    }
}