import javax.swing.*;
import java.awt.*;

public class ServiceScreen extends BaseClinicGUI {
    public ServiceScreen(ClinicInfo clinic) {
        super(clinic);
    }

    @Override
    protected void initComponents() {
        // Label for message
        JLabel titleLabel = new JLabel("Select a service");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // BoxLayout to center the label
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // FlowLayout for a horizontal row
        JPanel servicePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        servicePanel.setBackground(new Color(230, 237, 231));

        // Three buttons for three services
        JButton rhinoplasty = new JButton("Rhinoplasty");
        JButton facelift = new JButton("Facelift");
        JButton botox = new JButton("Botox");

        // Redirect each service button to DatePickerScreen and save data
        rhinoplasty.addActionListener(e -> {
            AppointmentData data = new AppointmentData();
            data.setService("Rhinoplasty");     // All choices are saved in the AppointmentData class
            new DatePickerScreen(clinic, data); // All options redirect to the same next screen
            dispose();
        });

        facelift.addActionListener(e -> {
            AppointmentData data = new AppointmentData();
            data.setService("Facelift");
            new DatePickerScreen(clinic, data);
            dispose();
        });

        botox.addActionListener(e -> {
            AppointmentData data = new AppointmentData();
            data.setService("Botox");
            new DatePickerScreen(clinic, data);
            dispose();
        });

        // Add the buttons to the service panel.
        servicePanel.add(rhinoplasty);
        servicePanel.add(facelift);
        servicePanel.add(botox);

        // Container panel with boxlayout
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(new Color(230, 237, 231));

        // Add label and button panel to container
        container.add(titleLabel);

        // Spacing
        container.add(Box.createRigidArea(new Dimension(0, 20)));
        container.add(servicePanel);

        // Add the container panel to content panel
        contentPanel.add(container);
    }
}