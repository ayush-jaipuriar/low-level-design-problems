public class Ride {
    int id;
    int origin;
    int destination;
    int numOfSeats;
    RideStatus rideStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public Ride() {
        id = 0;
        origin = 0;
        destination = 0;
        numOfSeats = 0;
        rideStatus = RideStatus.IDLE;
    }

    public Ride(int id, int origin, int destination, int numOfSeats, RideStatus rideStatus) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.numOfSeats = numOfSeats;
        this.rideStatus = rideStatus;
    }

}
