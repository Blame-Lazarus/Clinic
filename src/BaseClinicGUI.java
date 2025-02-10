import javax.swing.*;
import java.awt.*;

public abstract class BaseClinicGUI extends JFrame {

    protected ClinicInfo clinic;
    protected JPanel contentPanel;

    // General attributes
    protected static final int FRAME_WIDTH = 500;                                         // Frame width
    protected static final int FRAME_HEIGHT = 500;                                        // Frame height
    protected static final Color BACKGROUND_COLOR = new Color(230, 237, 231);    // GUI Background color

    // Constructor
    public BaseClinicGUI(ClinicInfo clinic) {
        this.clinic = clinic;
        setTitle("Clinic Appointment System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocation(40, 50);
        setLayout(new BorderLayout());

        // Initialize UI components
        initUI(clinic);

        // Custom components for each screen
        initComponents();

        setVisible(true);
    }


    // Initialize UI components
    private void initUI(ClinicInfo clinic) {
        // Background panel
        JPanel backgroundPanel = new JPanel(new BorderLayout());
        backgroundPanel.setBackground(BACKGROUND_COLOR);

        // Header with logo
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(BACKGROUND_COLOR);
        headerPanel.add(createLogoLabel());
        backgroundPanel.add(headerPanel, BorderLayout.NORTH);

        // Content panel
        contentPanel = new JPanel();
        contentPanel.setBackground(BACKGROUND_COLOR);
        backgroundPanel.add(contentPanel, BorderLayout.CENTER);

        // Set the main content panel
        setContentPane(backgroundPanel);
    }

    private JLabel createLogoLabel() {
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

    protected abstract void initComponents();
}
