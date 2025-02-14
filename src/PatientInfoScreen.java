import javax.swing.*;
import java.awt.*;

// No input verification checks yet
public class PatientInfoScreen extends BaseClinicGUI {
    private AppointmentData appointmentData;

    public PatientInfoScreen(ClinicInfo clinic, AppointmentData data) {
        super(clinic);
        this.appointmentData = data;
    }

    @Override
    protected void initComponents() {
        // Main container panel with vertical BoxLayout to show boxes, should be changed later
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(BACKGROUND_COLOR);

        // Title label
        JLabel titleLabel = new JLabel("Enter patient information");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(titleLabel);

        container.add(Box.createRigidArea(new Dimension(0, 20))); // Vertical spacing

        // Panel for Full Name
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.setBackground(BACKGROUND_COLOR);
        JLabel nameLabel = new JLabel("Full Name:");
        JTextField nameField = new JTextField(20);
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        container.add(namePanel);

        // Panel for DOB
        JPanel dobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dobPanel.setBackground(BACKGROUND_COLOR);
        JLabel dobLabel = new JLabel("DOB:");
        JTextField dobField = new JTextField(10);
        dobPanel.add(dobLabel);
        dobPanel.add(dobField);
        container.add(dobPanel);

        // Panel for Phone Number
        JPanel phonePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        phonePanel.setBackground(BACKGROUND_COLOR);
        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneField = new JTextField(15);
        phonePanel.add(phoneLabel);
        phonePanel.add(phoneField);
        container.add(phonePanel);

        // Panel for Email
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        emailPanel.setBackground(BACKGROUND_COLOR);
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);
        container.add(emailPanel);

        // Panel for Comments
        JPanel commentsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        commentsPanel.setBackground(BACKGROUND_COLOR);
        JLabel commentsLabel = new JLabel("Comments:");
        JTextArea commentsArea = new JTextArea(5, 20);
        JScrollPane commentsScroll = new JScrollPane(commentsArea);
        commentsPanel.add(commentsLabel);
        commentsPanel.add(commentsScroll);
        container.add(commentsPanel);

        // Submit button to update data and proceed
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(BACKGROUND_COLOR);
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            // Save the patient information to AppointmentData
            appointmentData.setPatientName(nameField.getText());
            appointmentData.setDob(dobField.getText());
            appointmentData.setPhone(phoneField.getText());
            appointmentData.setEmail(emailField.getText());
            appointmentData.setComments(commentsArea.getText());

            // Proceed to FinalScreen with the updated AppointmentData
            new FinalScreen(clinic, appointmentData);
            dispose();
        });
        buttonPanel.add(submitButton);
        container.add(buttonPanel);

        // Add container to the main content panel
        contentPanel.add(container);
    }
}