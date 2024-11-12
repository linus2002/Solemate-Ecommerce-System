package store;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.lang.*;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class ContactPanel extends JPanel {
    
static contactPanel cPanel;
	
	private static JScrollPane scrollPane;
	
	BufferedImage phone, loc, gmail;
	BufferedImage fb, google, ig ,twitter;
	
 BufferedImage des ,map, des2;
	ContactPanel() {
	   des = null;
	   phone = null;
	   loc = null;
	   gmail = null;
	   fb = null;
	   google = null;
	   ig = null;
	   twitter = null;
	   map = null;
	   des2 = null;
	   
	  
	   
	    setBounds(0, 0, 1100, 700);
	   
	    
		cPanel = new contactPanel();
	    setBounds(0, 75, 1100, 700);
		add(cPanel);
		
		scrollPane = new JScrollPane(cPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(1100, 750));
        scrollPane.setBounds(0, 75, 1100, 700);

      
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(25);
        verticalScrollBar.setBlockIncrement(50);
       verticalScrollBar.setPreferredSize(new Dimension(20, 1200));

        add(scrollPane);
        
        cPanel = new contactPanel();
        cPanel.setPreferredSize(new Dimension(1100, 2660));
        cPanel.setLayout(null);

        // Set the panel_scrollpane as the viewport for the scroll pane
        scrollPane.setViewportView(cPanel);



        
		
        try {
            des = ImageIO.read(getClass().getResource("/Img/des.jpg"));
            phone = ImageIO.read(getClass().getResource("/Img/phone.png"));
            loc = ImageIO.read(getClass().getResource("/Img/location.png"));
            gmail = ImageIO.read(getClass().getResource("/Img/googlde.png"));

            changeImageColor(phone, 149, 159, 138);
            changeImageColor(loc, 149, 159, 138);
            changeImageColor(gmail, 149, 159, 138);
            
            fb = ImageIO.read(getClass().getResource("/Img/facebook.png"));
            google = ImageIO.read(getClass().getResource("/Img/googlde.png"));
            ig = ImageIO.read(getClass().getResource("/Img/instagram.png"));
            twitter = ImageIO.read(getClass().getResource("/Img/twitter.png"));
            map = ImageIO.read(getClass().getResource("/Img/maps.png"));
            des2 = ImageIO.read(getClass().getResource("/Img/des2.png"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    
	
	}
	

    private void changeImageColor(BufferedImage image, int red, int green, int blue) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                int alpha = (rgb >> 24) & 0xFF;
                int newRGB = (alpha << 24) | (red << 16) | (green << 8) | blue;
                image.setRGB(x, y, newRGB);
            }
        }
    }

	class contactPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            Stroke stroke = new BasicStroke(5);
           
            
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   	     	g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            
            GradientPaint gradient = new GradientPaint(0, 0, Color.BLACK, getWidth(), getHeight(), Color.BLACK);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            
            g2d.setColor(Color.white);
            g2d.setFont(new Font("Arial", Font.BOLD, 18));
            g2d.drawString("www.solemate.com", 54, 50);

            float transparency = 0.5f;
 	 
 	        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency));
            g2d.drawImage(des, 55, 30, 990, 500, null);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            
            g2d.setColor(Color.WHITE);
            g2d.setStroke(stroke);
            g2d.drawRect(440, 220, 300, 60);
            
            g2d.setFont(new Font("Arial", Font.BOLD, 40));
            g2d.drawString("CONTACT US", 459, 263);
            
            g2d.setColor(new Color(149, 159, 138));
            g2d.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 28));
            g2d.drawString("Get in touch with us !", 425, 610);
            
            g2d.drawLine(400, 870, 400, 700);
            g2d.drawLine(715, 870, 715, 700);
                     
            g2d.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 15));
            g2d.drawString("EMAIL", 838, 800);
            g2d.drawString("ADDRESS", 525, 800);
            g2d.drawString("PHONE", 225 , 800);
            
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Times Roman", Font.BOLD, 11));
            g2d.drawString("PHONE +639705201284", 190, 835); 
            g2d.drawString("PHONE +639496034871", 190, 857);
            
            g2d.drawString("CX7J+4G5, Sampaguita, Bacoor, Cavite", 450, 845);
            
            g2d.drawString("solemates@gmail.com", 795, 835);
            g2d.drawString("linusaurin@gmail.com", 795, 857);
            
            g2d.drawImage(phone, 220, 730, 50, 50,  null);
            g2d.drawImage(loc, 530, 730, 50, 50,  null);
            g2d.drawImage(gmail, 832, 730, 50, 50,  null);
           
            g2d.setColor(new Color(149, 159, 138));
            g2d.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 15));
            g2d.drawString("IF YOU GOT ANY QUESTIONS", 468, 980);
            g2d.drawString("PLEASE DO NOT HESITATE TO SEND US A MESSAGE", 395, 1005);
            
            g2d.setColor(new Color(149, 159, 138));
            g2d.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 28));
            g2d.drawString("Connect with us !", 465, 1480);
            g2d.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 24));
            g2d.drawString("Find Us on Google Maps", 438, 1640);
            
            g2d.drawImage(fb, 385, 1540, 50, 50,  null);
            g2d.drawImage(google, 485, 1540, 50, 50,  null);
            g2d.drawImage(ig, 585, 1540, 50, 50,  null);
            g2d.drawImage(twitter, 685, 1540, 50, 50,  null);
            g2d.drawImage(map, 57, 1675, 970, 400,  null);
            g2d.drawImage(des2, 57, 2110, 970, 400,  null);
            
            
            
            
            JTextField name = new JTextField();
            name.setBounds(335, 1030, 450, 40);
            name.setBackground(new Color(44, 44, 44));
            name.setForeground(Color.GRAY);
            name.setBorder(BorderFactory.createEmptyBorder());
            add(name);

            name.addFocusListener(new FocusListener() {
                private final String placeholder = "Name";

                @Override
                public void focusGained(FocusEvent e) {
                    if (name.getText().equals(placeholder)) {
                        name.setText("");
                        name.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (name.getText().isEmpty()) {
                        name.setText(placeholder);
                        name.setForeground(Color.GRAY);
                    }
                }
            });

            JTextField email = new JTextField();
            email.setBounds(335, 1090, 450, 40);
            email.setBackground(new Color(44, 44, 44));
            email.setForeground(Color.GRAY);
            email.setBorder(BorderFactory.createEmptyBorder());
            add(email);

            email.addFocusListener(new FocusListener() {
                private final String placeholder = "Email";

                @Override
                public void focusGained(FocusEvent e) {
                    if (email.getText().equals(placeholder)) {
                        email.setText("");
                        email.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (email.getText().isEmpty()) {
                        email.setText(placeholder);
                        email.setForeground(Color.GRAY);
                    }
                }
            });


            JTextField subject = new JTextField();
            subject.setBounds(335, 1150, 450, 40);
            subject.setBackground(new Color(44, 44, 44));
            subject.setForeground(Color.GRAY);
            subject.setBorder(BorderFactory.createEmptyBorder());
            add(subject);

            subject.addFocusListener(new FocusListener() {
                private final String placeholder = "Subject";

                @Override
                public void focusGained(FocusEvent e) {
                    if (subject.getText().equals(placeholder)) {
                        subject.setText("");
                        subject.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (subject.getText().isEmpty()) {
                        subject.setText(placeholder);
                        subject.setForeground(Color.GRAY);
                    }
                }
            });

            JTextField message = new JTextField();
            message.setBounds(335, 1210, 450, 100);
            message.setBackground(new Color(44, 44, 44));
            message.setForeground(Color.GRAY);
            message.setBorder(BorderFactory.createEmptyBorder());
            add(message);

            message.addFocusListener(new FocusListener() {
                private final String placeholder = "Message";

                @Override
                public void focusGained(FocusEvent e) {
                    if (message.getText().equals(placeholder)) {
                        message.setText("");
                        message.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (message.getText().isEmpty()) {
                        message.setText(placeholder);
                        message.setForeground(Color.GRAY);
                    }
                }
            });


            JButton send = new JButton();
            send.setBounds(490,  1350, 150, 50);
            send.setBackground(new Color(149, 159, 138));
            send.setFont(new Font("Arial Black", Font.BOLD, 13));
            send.setText("SEND MESSAGE");
            send.setForeground(Color.BLACK);
            send.setBorderPainted(false);
            send.setFocusPainted(false);
            add(send);
            
            
            

            
        }
        
	
	public static void main(String [] args ) {
		new ContactPanel();
	}
	}
}

        
        
    