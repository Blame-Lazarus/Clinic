import javax.swing.*;
import java.awt.*;

public class MainScreen extends BaseClinicGUI {
    public MainScreen(ClinicInfo clinic) {
        super(clinic);
    }

    protected void initComponents() {
        // Create a panel for the button (or other components for this screen)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(230, 237, 231));

        JButton button = new JButton("BOOK APPOINTMENT");
        button.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Appointment Booking Coming Soon!")
        );
        buttonPanel.add(button);

        // Add the panel to the content panel provided by the base class
        contentPanel.add(buttonPanel);
    }
}
