// Clinic information
public class ClinicInfo {
    // Variables
    private final String name;
    private final String hours;

    // Default constructor
    public ClinicInfo() {
        this.name = "Eterna";
        this.hours = "8:00 AM - 5 PM";
    }

    // Parameterized constructor for flexibility
    public ClinicInfo(String name, String hours) {
        this.name = name;
        this.hours = hours;
    }

    // Methods
    public String getName() {
        return name;
    }

    public String getHours() {
        return hours;
    }
}
