package store;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class DeliveryStatusFrame extends JFrame {
    private JLabel deliveryStatusLabel , deliveryStatusLabel2;
    private JLabel selectedCheckboxLabel;
    private JButton okButton;

    public DeliveryStatusFrame() {
        setTitle("Delivery Status");
        getContentPane().setBackground(new Color(1,11,19));
        setUndecorated(true);
        setSize(400, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        deliveryStatusLabel = new JLabel("Your parcel");
        deliveryStatusLabel2 = new JLabel("is our for delivery");
        
        deliveryStatusLabel.setBounds(20, 40, 360, 30);
        deliveryStatusLabel2.setBounds(20, 80, 360, 38);
        
        deliveryStatusLabel.setFont(new Font("Arial Black", Font.BOLD, 30));
        add(deliveryStatusLabel);
        
        deliveryStatusLabel2.setFont(new Font("Arial Black", Font.BOLD, 35));
        add(deliveryStatusLabel2);

        selectedCheckboxLabel = new JLabel();
        selectedCheckboxLabel.setBounds(20, 40, 100, 30);
        add(selectedCheckboxLabel);

        okButton = new JButton("OK");
        okButton.setBackground(Color.WHITE);
        okButton.setBounds(0, 155, 410, 40);
        okButton.setFocusPainted(false);
        okButton.setBorderPainted(false);
        okButton.setFont(new Font("Arial Black", Font.BOLD, 18));
        add(okButton);

        okButton.addActionListener(e -> dispose());
    }

    public void setSelectedCheckboxLabelText(String text) {
        selectedCheckboxLabel.setText(text);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DeliveryStatusFrame frame = new DeliveryStatusFrame();
            
            frame.setVisible(true);

            // Example usage of setting the selected checkbox label text
            String selectedCheckboxText = CartPanel.getSelectedCheckboxText();
            frame.setSelectedCheckboxLabelText(selectedCheckboxText);
        });
    }
}

