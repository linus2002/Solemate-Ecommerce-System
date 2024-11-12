package store;

import javax.swing.*;
import java.awt.*;

public class PanelTwo extends JPanel {
    public PanelTwo() {
        setBounds(280, 20, 810, 580);
        setBackground(Color.WHITE);
        setLayout(null);
    }

    public void showBrandPanel(JPanel brandPanel) {
        removeAll();
        brandPanel.setBounds(0, 0, getWidth(), getHeight());
        add(brandPanel);
        revalidate();
        repaint();
    }
}
