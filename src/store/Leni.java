package store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Leni extends JPanel {

	public Leni() {
		
		
		 setPreferredSize(new Dimension(600, 200));
		 setLayout(null);
		 
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        GradientPaint circ = new GradientPaint(100, 500, Color.BLACK, 0, 0, Color.WHITE);
		
        
        
        
	}
	
}
