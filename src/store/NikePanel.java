package store;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NikePanel extends JPanel {
    public NikePanel() {
        // Add Nike-specific components or customize the panel here
    	setPreferredSize(new Dimension(400, 300));
    	setBackground(Color.WHITE);
    	
    	
    }
    public void paintComponent(Graphics g) {
    	
    	
    	Graphics2D g2d = (Graphics2D) g;
		Stroke stroke = new BasicStroke(5);
		

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    	
    	g2d.setColor(Color.BLACK);
		g2d.fillRect(20,  50, 200, 220);
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(100,  50, 200, 220);
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(180,  50, 200, 220);
    	
    }
}