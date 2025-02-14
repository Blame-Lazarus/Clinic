// Clinic information (More components can be added)
public class ClinicInfo {
    // Variables
    private final String name;                  // Store name
    private final String hours;                 // Store hours

    // Constructor
    public ClinicInfo() {
        this.name = "Eterna";
        this.hours = "8:00 AM - 5 PM";
    }

    // Methods
    public String getName() {
        return name;
    }

    public String getHours() {
        return hours;
    }
}
