import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class PassengerAlertSystem extends JFrame {
    private JTextField currentField, destinationField;
    private JButton checkButton;

    // Predefined train route
    private final List<String> route = Arrays.asList(
            "Chennai", "Nellore", "Vijayawada", "Khammam", "Warangal", "Secunderabad"
    );

    public PassengerAlertSystem() {
        setTitle("Indian Railways - Passenger Alert System");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel currentLabel = new JLabel("Current Station:");
        currentLabel.setBounds(30, 30, 120, 25);
        add(currentLabel);

        currentField = new JTextField();
        currentField.setBounds(160, 30, 180, 25);
        add(currentField);

        JLabel destinationLabel = new JLabel("Destination Station:");
        destinationLabel.setBounds(30, 70, 120, 25);
        add(destinationLabel);

        destinationField = new JTextField();
        destinationField.setBounds(160, 70, 180, 25);
        add(destinationField);

        checkButton = new JButton("Check Alert");
        checkButton.setBounds(130, 110, 120, 30);
        add(checkButton);

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAlert();
            }
        });
    }

    private void checkAlert() {
        String current = currentField.getText().trim();
        String destination = destinationField.getText().trim();

        if (!route.contains(current) || !route.contains(destination)) {
            JOptionPane.showMessageDialog(this, "Invalid station entered!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int currentIndex = route.indexOf(current);
        int destIndex = route.indexOf(destination);

        if (currentIndex == destIndex) {
            JOptionPane.showMessageDialog(this, "You have arrived at your destination.");
        } else if (currentIndex + 1 == destIndex) {
            JOptionPane.showMessageDialog(this, "Your destination is the next stop. Please be ready!");
        } else if (currentIndex < destIndex) {
            int stopsLeft = destIndex - currentIndex;
            JOptionPane.showMessageDialog(this, stopsLeft + " stops remaining to reach your destination.");
        } else {
            JOptionPane.showMessageDialog(this, "You have already passed the destination!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PassengerAlertSystem().setVisible(true);
        });
    }
}