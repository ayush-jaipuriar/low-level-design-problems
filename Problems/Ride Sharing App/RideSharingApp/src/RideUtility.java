public class RideUtility {
    static final int AMOUNT_PER_KM = 20;

    // Method to calculate the fare based on wheather the user is priviledged or not
    public static int calculateFare(boolean isPriviledgedUser, int distance, int seats) {
        if (seats < 2) {
            return (int) (distance * AMOUNT_PER_KM * (isPriviledgedUser ? 0.75 : 1));
        } else {
            return (int) (distance * seats * AMOUNT_PER_KM * (isPriviledgedUser ? 0.5 : 0.75));
        }
    }

}
