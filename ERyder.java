public class ERyder {
    private static final String COMPANY_NAME = "ERyder";
    private static final double BASE_FARE = 1.0;
    private static final double PER_MINUTE_FARE = 0.5;
    
    private final String linkedAccount;
    private final String linkedPhone;
    
    private int bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;
    private int totalMinutes;
    private double totalFare;

    public ERyder(int id, int battery, boolean available, double km, String account, String phone) {
        bikeID = id;
        batteryLevel = battery;
        isAvailable = available;
        kmDriven = km;
        linkedAccount = account;
        linkedPhone = phone;
    }

    public ERyder(int id, int battery, boolean available, double km, String account, String phone, int minutes, double fare) {
        bikeID = id;
        batteryLevel = battery;
        isAvailable = available;
        kmDriven = km;
        linkedAccount = account;
        linkedPhone = phone;
        totalMinutes = minutes;
        totalFare = fare;
    }

    public void ride() {
        if (batteryLevel > 0 && isAvailable) {
            System.out.println("The bike is available.");
        } else {
            System.out.println("The bike is not available.");
        }
    }

    public void printBikeDetails() {
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Available: " + isAvailable);
        System.out.println("Distance Travelled: " + kmDriven + " km");
    }

    public void printRideDetails(int minutes) {
        totalMinutes = minutes;
        totalFare = BASE_FARE + (PER_MINUTE_FARE * minutes);
        
        System.out.println("Linked Account: " + linkedAccount);
        System.out.println("Linked Phone: " + linkedPhone);
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Usage in Minutes: " + totalMinutes);
        System.out.println("Total Fare: " + totalFare);
    }

    private double calculateFare(int minutes) {
        return BASE_FARE + (PER_MINUTE_FARE * minutes);
    }

    public void setBatteryLevel(int level) {
        if (level >= 0 && level <= 100) {
            batteryLevel = level;
        } else {
            System.out.println("Invalid battery level. Must be between 0 and 100.");
        }
    }

    public static void main(String[] args) {
        ERyder bike1 = new ERyder(101, 85, true, 12.5, "user123", "555-0101");
        bike1.printRideDetails(30);
        
        System.out.println();
        
        ERyder bike2 = new ERyder(102, 92, true, 8.3, "user456", "555-0202", 0, 0.0);
        bike2.printRideDetails(45);
    }
}
