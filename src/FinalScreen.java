import javax.swing.*;
import java.awt.*;

// This screen will show the final data and redirect to the initial screen, no appointment data will be carried to the next cycle

public class FinalScreen extends BaseClinicGUI {
    private AppointmentData appointmentData;

    public FinalScreen(ClinicInfo clinic, AppointmentData appointmentData) {
        // Overload constructor, it does not work with default
        super(clinic, false);
        this.appointmentData = appointmentData;
        initComponents();
        setVisible(true);
    }

    @Override
    protected void initComponents() {
        // Panel for content
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(BACKGROUND_COLOR);

        // Title
        JLabel verifiedLabel = new JLabel("Appointment verified!");
        verifiedLabel.setFont(new Font("Arial", Font.BOLD, 18));
        verifiedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(verifiedLabel);

        container.add(Box.createRigidArea(new Dimension(0, 20)));

        String service = appointmentData.getService();

        // Serice info
        JLabel serviceLabel = new JLabel("Service: " + (appointmentData.getService() != null ? appointmentData.getService() : ""));
        serviceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        serviceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(serviceLabel);

        // Switch statement requirement
        String serviceDescription;
        switch (service) {
            case "Rhinoplasty":
                serviceDescription = "Rhinoplasty: Nose job.";
                break;
            case "Facelift":
                serviceDescription = "Facelift: Tight your face.";
                break;
            case "Botox":
                serviceDescription = "Botox: Fill it.";
                break;
            default:
                serviceDescription = "Unknown service selected.";
                break;
        }

        // Display the service description computed from the switch statement
        JLabel serviceDescriptionLabel = new JLabel(serviceDescription);
        serviceDescriptionLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        serviceDescriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(serviceDescriptionLabel);

        JLabel dayLabel = new JLabel("Day: " + (appointmentData.getDay() != null ? appointmentData.getDay() : ""));
        dayLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        dayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(dayLabel);

        JLabel timeLabel = new JLabel("Time: " + (appointmentData.getTime() != null ? appointmentData.getTime() : ""));
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(timeLabel);

        // Format text with HTML
        String patientInfoText = "<html>Patient information:<br/>" +
                "Name: " + (appointmentData.getPatientName() != null ? appointmentData.getPatientName() : "") + "<br/>" +
                "DOB: " + (appointmentData.getDob() != null ? appointmentData.getDob() : "") + "<br/>" +
                "Phone: " + (appointmentData.getPhone() != null ? appointmentData.getPhone() : "") + "<br/>" +
                "Email: " + (appointmentData.getEmail() != null ? appointmentData.getEmail() : "") + "<br/>" +
                "Comments: " + (appointmentData.getComments() != null ? appointmentData.getComments() : "") +
                "</html>";
        JLabel patientInfoLabel = new JLabel(patientInfoText);
        patientInfoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        patientInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(patientInfoLabel);

        container.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel thanksLabel = new JLabel("Thanks for choosing " + clinic.getName() + ".");
        thanksLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        thanksLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(thanksLabel);

        container.add(Box.createVerticalGlue());

        // Done button redirects to the main screen
        JButton doneButton = new JButton("Done");
        doneButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        doneButton.addActionListener(e -> {
            // Go to main screen
            new MainScreen(clinic);
            // Dispose
            this.dispose();
        });
        container.add(doneButton);

        contentPanel.add(container);
    }
}
