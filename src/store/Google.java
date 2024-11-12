package store;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class Google extends JFrame implements ActionListener {
	
    private JLabel emailLabel, passLabel, terms, x;
    private JButton loginBtn;
    private JTextField email, pass;
    private JCheckBox checkBox;
    private Color defaultColor = Color.BLACK;
    private Color hoverColor = new Color(63, 67, 84);
    
    private  Color[] colors = {Color.BLUE, Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.RED};

    public Google() {
        setSize(500, 700);
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\Simple AI\\googlde.png"));
        setUndecorated(true);
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(100, 110, 350, 490, 60, 60));
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        
        emailLabel = new JLabel("Email or phone:");
        emailLabel.setBounds(137, 290, 180, 20);
        emailLabel.setForeground(Color.BLUE);
        getContentPane().add(emailLabel);
    
        
        email = new JTextField();
        email.setFont(new Font("Arial", Font.PLAIN, 15));
        email.setBounds(142, 310, 260, 30);
        email.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, (colors)[0])); 
        email.setOpaque(false); 
        getContentPane().add(email);

        pass = new JTextField();
        pass.setFont(new Font("Arial", Font.PLAIN, 15));
        pass.setBounds(142, 370, 260, 30);
        pass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, (colors)[0])); 
        pass.setOpaque(false);
        getContentPane().add(pass);
        
        passLabel = new JLabel("Password:");
        passLabel.setBounds(137, 350, 100, 20);
        passLabel.setForeground(Color.BLUE);
        getContentPane().add(passLabel);

        checkBox = new JCheckBox();
        checkBox.setBounds(140, 509, 20, 20);
        getContentPane().add(checkBox);
        
        terms = new JLabel("<html><body> I accept the Terms of Service "
        		+ "and Privacy Policy. By clicking 'Sign in',"
        		+ " I agree to the processing "
        		+ "of my personal data in accordance with Google's "
        		+ "Privacy Policy.</body></html>");
        terms.setBounds(160, 497, 250, 80);
        terms.setFont(new Font("Arial", Font.PLAIN, 10));
        getContentPane().add(terms);
        
        
        loginBtn = new JButton("Sign In");
        loginBtn.setBackground(new Color(63, 67, 84));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setBounds(220, 470, 106, 30);
        getContentPane().add(loginBtn);
        loginBtn.addActionListener(e -> {
          
        	if (email.getText().isEmpty() || pass.getText().isEmpty()) {
        	    if (email.getText().isEmpty()) {
        	        emailLabel.setForeground(Color.RED);
        	    }
        	    if (pass.getText().isEmpty()) {
        	        passLabel.setForeground(Color.RED);
        	    }
        	} else {
        	   
        	}

        });
        
        x = new JLabel("X");
        x.setBounds(410, 130, 50, 25);
        x.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 21));
        x.setForeground(defaultColor);
        x.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                x.setForeground(hoverColor);
            }
            public void mouseClicked(MouseEvent e) {
            	
            	dispose();
            }

            public void mouseExited(MouseEvent e) {
                x.setForeground(defaultColor);
            }
        });
        getContentPane().add(x);
    
        
        JPanel googlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                BasicStroke stroke = new BasicStroke(2);
                	
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                Font font = new Font("Times New Roman", Font.BOLD, 38);
                Font font2 = new Font("Arial", Font.PLAIN, 23);
               
                g2d.setFont(font);

                int totalWidth = 0;
                for (int i = 0; i < "Google".length(); i++) {
                    char c = "Google".charAt(i);
                    int charWidth = g2d.getFontMetrics().charWidth(c);
                    totalWidth += charWidth;
                }

                int startX = (getWidth() - totalWidth) / 2 + 30;
                int y = 170;

                for (int i = 0; i < "Google".length(); i++) {
                    char c = "Google".charAt(i);
                    g2d.setColor(colors[i]);
                    int charWidth = g2d.getFontMetrics().charWidth(c);
                    g2d.drawString(Character.toString(c), startX, y);
                    startX += charWidth;

                }
                g2d.setColor(Color.BLACK);
                g2d.setFont(font2);
                g2d.drawString("Sign in", 240, 235);

                g2d.setColor(Color.BLACK);
                g2d.setFont(new Font("Arial", Font.PLAIN, 15));
                g2d.drawString("Use your Google Account", 197, 270);
                
                g2d.setColor(Color.BLUE);
                g2d.setStroke(stroke);
                g2d.drawRoundRect(137, 310, 270, 30, 20, 20); 

                g2d.setColor(Color.BLUE);
                g2d.setStroke(stroke);
                g2d.drawRoundRect(137, 370, 270, 30, 20, 20); 
                
                g2d.setColor(new Color(63, 67, 84));
                g2d.fillRoundRect(207, 470, 130, 30, 20, 20); 
                
                g2d.setColor(Color.BLACK);
                g2d.setFont(new Font("Arial", Font.PLAIN, 12));
                g2d.drawString("Not your computer? Use Guest mode to sign in ", 140, 430);
                g2d.drawString("privately.", 140, 444);
                
                g2d.setColor(Color.BLUE);
                g2d.drawString("Learn more.", 188, 444);
                
            }
        };
        add(googlePanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Google();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}
