import javax.swing.*;
import java.awt.*;

public class DatePickerScreen extends BaseClinicGUI {
    private AppointmentData appointmentData;

    public DatePickerScreen(ClinicInfo clinic, AppointmentData data) {
        super(clinic);
        this.appointmentData = data;    // To save appointment data
    }

    @Override
    protected void initComponents() {
        // Main container for the date picker
        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(BACKGROUND_COLOR);

        // Five columns for days (Monday to Friday)
        JPanel daysPanel = new JPanel(new GridLayout(1, 5));
        daysPanel.setBackground(BACKGROUND_COLOR);
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        for (String day : days) {
            JLabel dayLabel = new JLabel(day, SwingConstants.CENTER);
            dayLabel.setFont(new Font("Arial", Font.BOLD, 14));
            daysPanel.add(dayLabel);
        }
        container.add(daysPanel, BorderLayout.NORTH);

        // Panel for time slots in one hour intervals
        int startHour = 8;    // 8 AM
        int endHour = 16;     // 4 PM in 24-hour format
        int rows = endHour - startHour + 1;
        JPanel timeSlotsPanel = new JPanel(new GridLayout(rows, 5, 5, 5));
        timeSlotsPanel.setBackground(BACKGROUND_COLOR);

        // Create a button for each time slot under each day
        for (int hour = startHour; hour <= endHour; hour++) {
            for (String day : days) {
                String timeString = formatHour(hour);
                JButton timeButton = new JButton(timeString);

                final String selectedDay = day;
                final String selectedTime = timeString;
                timeButton.addActionListener(e -> {
                    // Save the selected day and time into the AppointmentData
                    appointmentData.setDay(selectedDay);
                    appointmentData.setTime(selectedTime);
                    // Proceed to PatientInfoScreen, passing updated AppointmentData
                    new PatientInfoScreen(clinic, appointmentData);
                    dispose();
                });
                timeSlotsPanel.add(timeButton);
            }
        }

        container.add(timeSlotsPanel, BorderLayout.CENTER);
        contentPanel.add(container);
    }

    // This converts 24-hour time to 12-hour format with AM/PM
    private String formatHour(int hour24) {
        int hour12 = hour24;
        String period = "AM";

        if (hour24 == 0) {
            hour12 = 12;
        } else if (hour24 == 12) {
            period = "PM";
        } else if (hour24 > 12) {
            hour12 = hour24 - 12;
            period = "PM";
        }

        return hour12 + ":00 " + period;
    }
}
