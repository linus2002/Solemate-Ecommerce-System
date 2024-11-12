package store;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame{
	
	static JFrame frame;
	private BackgroundPanel contentPane;
	
	Login(){
		
		setSize(950, 550);
		
	contentPane = new BackgroundPanel();
	contentPane.setBackground(new Color(51, 153, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	
	}

	 public void main(String[] args) {
	    	frame = new Login();
	        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\Simple AI\\logo.png"));
	        frame.setLocationRelativeTo(null);
	        frame.setUndecorated(true);
	        frame.setVisible(true);
	    }
	
	 class BackgroundPanel extends JPanel {
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);

	            Graphics2D g2d = (Graphics2D) g.create();
	    
	            int width = getWidth();
		        int height = getHeight();

		        GradientPaint gradient = new GradientPaint(450, -200, new Color(51, 153, 255), width, height, new Color(63, 67, 84));

		        g2d.setPaint(gradient);
		        g2d.fillRect(0, 0, width, height);
	        }
	 }
}
