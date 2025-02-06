import javax.swing.*;
import java.awt.*;

public class ClinicGUI extends JFrame {

    // General attributes
    private static final int FRAME_WIDTH = 500;                                         // Frame width
    private static final int FRAME_HEIGHT = 500;                                        // Frame height
    private static final Color BACKGROUND_COLOR = new Color(230, 237, 231);    // GUI Background color

    // Constructor
    public ClinicGUI(ClinicInfo clinic) {
        setTitle("Clinic Appointment System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocation(40, 50);
        setLayout(new BorderLayout());

        // Initialize UI components
        initUI(clinic);

        setVisible(true);
    }


    // Initialize UI components
    private void initUI(ClinicInfo clinic) {
        // Background panel
        JPanel backgroundPanel = new JPanel(new BorderLayout());
        backgroundPanel.setBackground(BACKGROUND_COLOR);

        // Logo label
        JLabel logoLabel = createLogoLabel(clinic);

        // Panel to center the logo
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        logoPanel.setBackground(BACKGROUND_COLOR);
        logoPanel.add(logoLabel);

        // Panel for the "Book Appointment" button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(BACKGROUND_COLOR);
        JButton button = new JButton("BOOK APPOINTMENT");
        button.addActionListener(e -> JOptionPane.showMessageDialog(this, "Appointment Booking Coming Soon!"));
        buttonPanel.add(button);

        // Add components to background panel
        backgroundPanel.add(logoPanel, BorderLayout.NORTH);
        backgroundPanel.add(buttonPanel, BorderLayout.CENTER);

        // Set the main content panel
        setContentPane(backgroundPanel);
    }

    private JLabel createLogoLabel(ClinicInfo clinic) {
        ImageIcon logo = new ImageIcon("src/Logo.png");  // Load the logo image
        JLabel logoLabel = new JLabel(clinic.getName().toUpperCase(), logo, JLabel.CENTER);
        logoLabel.setVerticalTextPosition(JLabel.BOTTOM);  // Place text below the image
        logoLabel.setHorizontalTextPosition(JLabel.CENTER);  // Center text horizontally
        logoLabel.setForeground(Color.BLACK);  // Set text color
        logoLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));  // Set custom font
        logoLabel.setIconTextGap(-25);  // Reduce space between text and image
        logoLabel.setOpaque(false);  // Transparent background

        return logoLabel;
    }
}
