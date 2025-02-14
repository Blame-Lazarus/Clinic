import javax.swing.*;
import java.awt.*;

public class MainScreen extends BaseClinicGUI {
    public MainScreen(ClinicInfo clinic) {
        super(clinic);
    }

    protected void initComponents() {
        // Panel for button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(230, 237, 231));
        JButton button = new JButton("BOOK APPOINTMENT");
        button.addActionListener(e -> {
            // Redirect to the services screen
            new ServiceScreen(clinic);
            // Remove MainScreen
            this.dispose();     // Dispose removes the current screen instance
        });
        buttonPanel.add(button);    // Add button to panel

        // Add the panel to the content panel
        contentPanel.add(buttonPanel);
    }
}
