package store;

import javax.swing.border.EmptyBorder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



import java.awt.*;
import java.awt.event.*;

public class testing extends JFrame{
	
	static JFrame frame;
	private BackgroundPanel contentPane;
	private JLabel emailLabel, passLabel;
	private JTextField email, pass;
	private  Color[] colors = {Color.BLUE, Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.RED};
	 private String usernamePlaceholder = "Username";
	    private String passwordPlaceholder = "Password";
	    private Color defaultColor = Color.WHITE;
	    private Color hoverColor = new Color(63, 67, 84);
	
	testing(){
		
		setSize(750, 550);
		
	contentPane = new BackgroundPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	 getContentPane().setLayout(null);
	
	 emailLabel = new JLabel("Email or phone:");
     emailLabel.setBounds(424, 170, 180, 20);
     emailLabel.setForeground(Color.BLUE);
     getContentPane().add(emailLabel);
 
     
     email = new JTextField();
     email.setFont(new Font("Arial", Font.PLAIN, 15));
     email.setBounds(424, 194, 260, 30);
     email.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, (colors)[0])); 
     email.setOpaque(false); 
     getContentPane().add(email);

//     pass = new JTextField();
//     pass.setFont(new Font("Arial", Font.PLAIN, 15));
//     pass.setBounds(424, 257, 260, 30);
//     pass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, (colors)[0])); 
//     pass.setOpaque(false);
//     getContentPane().add(pass);
     
     passLabel = new JLabel("Password:");
     passLabel.setBounds(424, 245, 180, 20);
     passLabel.setForeground(Color.BLUE);
     getContentPane().add(passLabel);
     
     JPasswordField passwordField = new JPasswordField();
     passwordField.setBounds(424, 269, 260, 30);
     passwordField.setBackground(Color.gray);
     passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(51, 153, 255))); 
     passwordField.setOpaque(false); 
     passwordField.setForeground(new Color(150, 150, 150));
     passwordField.setText(passwordPlaceholder); 
     passwordField.setEchoChar((char) 0);
     contentPane.add(passwordField);
     passwordField.addFocusListener(new FocusAdapter() {
         @Override
         public void focusGained(FocusEvent e) {
             if (String.valueOf(passwordField.getPassword()).equals(passwordPlaceholder)) {
                 passwordField.setText("");
                 passwordField.setEchoChar('*');
                 
             }
         }
         @Override
         public void focusLost(FocusEvent e) {
             if (String.valueOf(passwordField.getPassword()).isEmpty()) {
                 passwordField.setText(passwordPlaceholder);
                 passwordField.setEchoChar((char) 0);
                 passwordField.setForeground(new Color(150, 150, 150));
             }
         }
     });


     JLabel showLabel = new JLabel("Show Password");
     showLabel.setFont(new Font("Arial", Font.PLAIN, 12));
     showLabel.setForeground(Color.black);
     showLabel.setBounds(450, 305, 100, 25);
     contentPane.add(showLabel);

     JRadioButton radioButton = new JRadioButton();
     radioButton.setBounds(424, 305, 20, 20);
     radioButton.setBackground(Color.white);
     contentPane.add(radioButton);
     radioButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 if (radioButton.isSelected()) {
                     passwordField.setEchoChar((char) 0);
                 } else {
                     passwordField.setEchoChar('*');
                 }
             }
         });
     
	
	
	}

	 public void main(String[] args) {
	    	frame = new testing();
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
	            BasicStroke stroke = new BasicStroke(2);
            	
	    
	            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	            
	            g2d.setColor(Color.BLACK);
	            g2d.fillRect(0, 0, 375, 550);
	            
	            g2d.setColor(Color.BLUE);
                g2d.setStroke(stroke);
                g2d.drawRoundRect(419, 194, 270, 30, 20, 20); 

                g2d.setColor(Color.BLUE);
                g2d.setStroke(stroke);
                g2d.drawRoundRect(419, 269, 270, 30, 20, 20); 
		        
	        }
	 }
}
