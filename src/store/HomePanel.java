package store;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HomePanel extends JPanel {
    
	private JPanel contentPane;
   
    private static JPanel panel;
    static JButton shopnow;
    static JScrollPane scrollPane;
    private static String currentPanel = "homePanel";

    
    static JButton homeBtn, storeBtn, aboutBtn, contactBtn;

    String[] labelTexts = { "Home", "Gallery", "Store", "About Us", "Contact Us" };
    String[] images = { "/Img/menu.png", "/Img/shoes.png"};
    String[] pictures = {"/Img/jordan.png"};
    String[] textHome = { "BIG SALE", "BIG SALE"};
    
    BufferedImage img , chunky , retro, dots, box, box2, box3, boxxx, fila, logo, whiteDots;

    Color color = (new Color(255, 255, 255));
    
   
    private static Map<String, String> panelMap = new HashMap<>();

    public HomePanel() {
    	
    	  panelMap.put("home", "homePanel");
          panelMap.put("store", "storePanel");
          panelMap.put("about", "aboutPanel");
          panelMap.put("contact", "contactPanel");
    	
    	
    	chunky = null;
    	img = null;
    	dots = null;
    	box = null;
    	box2 = null;
    	box3 = null;
    	boxxx = null;
    	fila = null;
    	logo = null;
    	whiteDots = null;
    	
    	
        
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.WHITE);
        
        contentPane.setLayout(null);

        panel = new GradientPanel();
        panel.setPreferredSize(new Dimension(1100, 700));
     

        scrollPane = new JScrollPane();
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(1100, 750));
        scrollPane.setBounds(0, 75, 1100, 700);

      
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(25);
        verticalScrollBar.setBlockIncrement(50);
        verticalScrollBar.setPreferredSize(new Dimension(20, 100));

        add(scrollPane);
        
        panel = new GradientPanel();
        panel.setPreferredSize(new Dimension(1100, 2100));
        panel.setLayout(null);

        // Set the panel_scrollpane as the viewport for the scroll pane
        scrollPane.setViewportView(panel);

       

//      Object[][]  btn = { { "Home", 100, 0, 30, 15, color, 0 }, { "Store", 220, 0, 30, 15, color, 1 },
//                { "About Us", 337, 0, 30, 15, color, 2 }, { "Gallery", 457, 0, 30, 15, color, 3 },
//                { "Contact Us", 582, 0, 35, 15, color, 4 }
//
//        };

   
      
      
        
        JLabel[] img = new JLabel[images.length];
        for (int x = 0; x < images.length; x++) {
            img[x] = new JLabel();

            if (x == 0) {
                URL resourceUrl = getClass().getResource(images[0]);
                img[x].setIcon(new ImageIcon(resourceUrl));
                img[x].setBounds(1045, 15, 50, 30);
            }
            if (x == 1) {
                URL resourceUrl = getClass().getResource(images[1]);
                img[x].setIcon(new ImageIcon(resourceUrl));
                img[x].setBounds(30, -10, 100, 100);
            }
            
           contentPane.add(img[x]);
        }
        try {
        	
        	whiteDots = ImageIO.read(getClass().getResource("/Img/whiteDots.png"));
        }
        catch(Exception e ) {
        	e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new HomePanel();
    }

   
    class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            Stroke stroke = new BasicStroke(7);
            
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   	     	g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            
            int width = getWidth();
            int height = getHeight();
            
            GradientPaint gradient = new GradientPaint(0, 0, Color.BLACK, 0, height, Color.WHITE);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, width, height);
            
            
            g2d.setColor(Color.BLACK);
            g2d.fillRect(74, 366, 220, 50);
            
            
            int midpoint = 700 / 2;
            GradientPaint colorRect = new GradientPaint(
            	    200, 0, Color.BLUE,
            	    200, midpoint, Color.WHITE
            	);

            	g2d.setPaint(colorRect);
            	g2d.fillRect(430, 0, 270, height);
            
            g2d.drawImage(whiteDots, 750, 400, 150, 150, null);
            
	        g2d.setColor(new Color(100, 149,237));
	        g2d.setFont(new Font("Arial Black", Font.BOLD, 100));
	        g2d.drawString("50", 775, 520);
	        g2d.setFont(new Font("Arial Black", Font.BOLD, 30));
	        g2d.drawString("%", 915, 465);
	        g2d.setColor(Color.WHITE);
	        g2d.setFont(new Font("Arial Black", Font.BOLD, 50));
	        g2d.drawString("OFF", 915, 515);
	        
	        g2d.fillRect(915, 560, 200, 50);
	        
	        g2d.setColor(new Color(21, 69, 252));
	        g2d.setFont(new Font("Arial Black", Font.BOLD, 20));
	        g2d.drawString("BEST SELLER", 918, 590);
	        
            shopnow = new JButton();
            shopnow.setFont(new Font("Calibre", Font.BOLD, 20));
            shopnow.setText("S H O P   N O W");
            shopnow.setBounds(65, 350, 220, 50);
            shopnow.setBackground(new Color(100, 149,237));
            shopnow.setForeground(Color.BLACK);
            shopnow.setFocusPainted(false);
            shopnow.setBorderPainted(false);
            shopnow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                }
            });
            add(shopnow);
           

            
        
        
            //Pictures
            JLabel[] icons = new JLabel[pictures.length];
            for (int x = 0; x < pictures.length; x++) {
                icons[x] = new JLabel();

                 if (x == 0) {
                    URL resourceUrl = getClass().getResource(pictures[0]);
                    icons[x].setIcon(new ImageIcon(resourceUrl));
                    icons[x].setBounds(270, -10, 564, 710);
                }
                 else if (x == 1) {
                     URL resourceUrl = getClass().getResource(pictures[1]);
                     icons[x].setIcon(new ImageIcon(resourceUrl));
                     icons[x].setBounds(270, -10, 564, 710);
                 }
                 add(icons[x]);
        }
            //Labels
            JLabel[] text = new JLabel[textHome.length];
            for (int i = 0; i < textHome.length; i++) {
                text[i] = new JLabel(textHome[i]);
                
                if (i == 0) {
                    text[i].setBounds(50, 210, 320, 80);
                    text[i].setFont(new Font("Arial Black", Font.BOLD, 55));
                    text[i].setForeground(Color.WHITE);
                }
                else if (i == 1) {
                    text[i].setBounds(50, 260, 320, 80);
                    text[i].setFont(new Font("Arial Black", Font.BOLD, 55));
                    text[i].setForeground(Color.BLACK);
                }
                add(text[i]);
    }
            
            SecPanel secPanel = new SecPanel();
            secPanel.setBounds(0, 700, 1110, 700);
            //secPanel.setOpaque(false);
            secPanel.setLayout(null);   
              
            try {
            	img = ImageIO.read(getClass().getResource("/Img/retro.png"));
            	chunky = ImageIO.read(getClass().getResource("/Img/chunky.png"));
            	dots = ImageIO.read(getClass().getResource("/Img/dots.png"));
            	box = ImageIO.read(getClass().getResource("/Img/box.png"));
            	box2 = ImageIO.read(getClass().getResource("/Img/box.png"));
            	box3 = ImageIO.read(getClass().getResource("/Img/box.png"));
            	boxxx = ImageIO.read(getClass().getResource("/Img/boxxx.png"));
            	fila = ImageIO.read(getClass().getResource("/Img/fila.png"));
            	logo = ImageIO.read(getClass().getResource("/Img/sole.png"));
            }
            catch(Exception e ) {
            	e.printStackTrace();
            }
            
            JButton shopNow = new JButton();
            shopNow.setFont(new Font("Calibre", Font.BOLD, 16));
            shopNow.setText("SHOP NOW");
            shopNow.setBounds(378, 490, 150, 30);
            shopNow.setBackground(new Color(60, 0, 100));
            shopNow.setForeground(Color.white);
            shopNow.setBorderPainted(false);
            shopNow.setFocusPainted(false);
            secPanel.add(shopNow);
            
            add(secPanel);
            
            thirdPanel last = new thirdPanel();
            last.setBounds(0, 1400, 1110, 700);
            //secPanel.setOpaque(false);
            last.setLayout(null);
            
            add(last);
            
        }
        
        class SecPanel extends JPanel {
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		Graphics2D g2 = (Graphics2D)g;
        		Stroke stroke = new BasicStroke(7);
        		
        		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        	    g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        		
        		g2.setPaint(new GradientPaint(0,0, new Color(254, 52, 126), 1110, 700, Color.PINK));
        		g2.fillRect(0, 0, 1110, 700);
        		//blue rect half of the frame
        		g2.setColor(new Color(165, 229, 255 ));
        		g2.fillRect(0, 0, 600, 460);
        		//design at the top
        		g2.setColor(new Color(0, 171, 240));
        		g2.fillRect(0, 0, 150, 150);
        		
        		g2.setColor(new Color(60, 0 ,100));
        		g2.setFont(new Font("Arial Black", Font.PLAIN, 35));
        		g2.drawString("Clearance", 40, 200);
        		       		
        		g2.setColor(new Color(254, 52, 126));
        		g2.setFont(new Font("Elephant", Font.BOLD, 60));
        		g2.drawString("S A L E", 40, 250);
        		
        		g2.setColor(Color.WHITE);
        		g2.setFont(new Font("Arial Black", Font.BOLD, 87));
        		g2.drawString("60%", 120, 320);
        		
        		g2.setColor(new Color(254, 52, 126));
        		g2.setFont(new Font("Calibre", Font.BOLD, 18));
        		g2.drawString("ONLY THIS WEEKEND", 123, 343);
        	 		
        		g2.setColor(Color.WHITE);
        		g2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 45));
        		g2.drawString("Sole", 10, 70);
        		g2.drawString("Mates", 10, 103);
        		
        		g2.setFont(new Font("Arial Black", Font.BOLD, 25));
        		g2.drawString("RETRO", 620, 120);
        		g2.drawString("CHUNKY", 750, 120);
        		g2.drawString("SNEAKER", 903, 120);
        		
        		g2.drawImage(img, 600, 170, 530, 540,null);
        		
        		g2.setStroke(stroke);
        		g2.setColor(new Color(60, 0, 100));
        		g2.drawLine(950, 50, 603, 50);
        		
        		g2.setStroke(stroke);
        		g2.drawLine(730, 545, 600, 545);
        		
        		g2.drawImage(dots, 795, 530, 270, 200, null);
        		
        		//bg of shoes back of brown
        		g2.setColor(Color.WHITE);
        		g2.fillRect(375, 165, 330, 310);
        		//bg of shoes
        		g2.setColor(new Color(233, 166, 117));
        		g2.fillRect(390, 180, 300, 280);
        		
        		 float transparency = 0.5f;
        	        
        	        // Set color with transparency
        	        Color rectColor = new Color(0, 171, 240, (int) (255 * transparency));	        
        	        // Set alpha composite
        	        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency));
        	        // Draw transparent rectangle
        	        g2.setColor(rectColor);
        	        g2.fillRect(305, 85, 130, 130);
        	        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        	        
        		//design at the bottom rect violet
        		g2.setColor(new Color(60, 0, 100));
        		g2.fillRect(0, 640, 250, 50);
        		//SHOE NAME
        		g2.setColor(Color.WHITE);
        		g2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
        		g2.drawString("www.solemate.com", 18, 670);
        		
        		String text = "Upper: Cow Leather + Nylon Mesh\n"
        	            + "Lining: 100% Stretch Fabric\n"
        	            + "Insole: 100% Pigskin\n"
        	            + "Outsole: TPU + PU\n"
        	            + "Sole Thic	kness: 6.5 cm\n"
        	            + "Weight: 1kg";

        	String[] lines = text.split("\n");
        	int lineHeight = g2.getFontMetrics().getHeight();
        	int x = 45;
        	int y = 485;

        	for (String line : lines) {
        		g2.setFont(new Font("Arial", Font.BOLD, 14));
        	    g2.drawString(line, x, y);
        	    y += lineHeight;
        	}

        		g2.drawImage(chunky, 400, 190, 300, 270,null);        		
        		g2.drawImage(box, 25, 300, 150, 150, null);
        		g2.drawImage(boxxx, 240, 510, 150, 150, null);
           	}
        }
        
        class thirdPanel extends JPanel {
        	public void paint(Graphics graphics) {
        		super.paint(graphics);
        		
        		Graphics2D graph = (Graphics2D)graphics;
        		Stroke stroke = new BasicStroke(5);
        		
        		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        	    graph.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        		
        	    graph.setPaint(new Color(186, 0, 0));
        		graph.fillRect(0, 0, 1100, 700);
        		
        		float transparency = 0.10f;
     	        Font font = new Font("Elephant", Font.BOLD, 250);
     	        graph.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency));
     	        // Draw transparent rectangle
     	        graph.setColor(Color.WHITE);
     	        graph.setFont(font);
     	        graph.drawString("SHOES", -5, 195);
     	        graph.drawString("SHOES", -5, 425);
     	        graph.drawString("SHOES", -5, 650);
     	        graph.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));	
     	        
     	        graph.setStroke(stroke);
     	        graph.fillOval(253, 270, 600,600);
     	        graph.drawOval(235, 255, 635, 635);
     	        
     	        graph.drawImage(fila, 323, 15, 520, 650, null);
     	        
     	       graph.setColor(Color.BLACK);
     	       graph.fillRoundRect(48, 498, 140, 35, 20, 20); 
     	       
     	       graph.setColor(Color.white);
     	       graph.setFont(new Font("Arial Black", Font.BOLD, 20));
     	       graph.drawString("SHOP NOW", 53, 524);
     	       
     	       graph.setColor(Color.BLACK);
     	       graph.setStroke(new BasicStroke(15));
     	       graph.drawLine(7, 450, 7, 130);
     	      graph.drawLine(1072, 450, 1072, 130);
     	      
     	      graph.drawImage(logo, 20, 20, 60, 60, null);
     	      
     	      graph.setColor(Color.WHITE);
     	      graph.setFont(new Font("Arial", Font.BOLD, 45));
     	graph.drawString("LIMITED", 40, 125);
     	graph.drawString("EDITION", 40, 165);
     	graph.setFont(new Font("Helvetica", Font.BOLD, 18));
     	graph.drawString("Look great with", 40, 205);
    	graph.drawString("our best prices", 40, 225);
    	     
    	String text = "FILA shoes: the perfect blend of fashion and\n"
     	+ "function, elevating your style while providing\n"
     	+ "unparalleled comfort with each stride.\n";

     	String[] lines = text.split("\n");
     	int lineHeight = graph.getFontMetrics().getHeight();
     	int x = 40;
     	int y = 270;

     	for (String line : lines) {
     		graph.setFont(new Font("Arial", Font.BOLD, 12));
     	    graph.drawString(line, x, y);
     	    y += lineHeight;
     	}
     	 graph.setStroke(new BasicStroke(1));
     	 graph.drawOval(980, 210, 30, 30);
     	 graph.drawOval(980, 250, 30, 30);
     	 graph.drawOval(980, 290, 30, 30);
     	 graph.drawOval(980, 330, 30, 30);
     	 
     	 graph.setFont(new Font("Arial Black", Font.BOLD, 18));
     	 graph.drawString("F", 990, 231);
     	 graph.drawString("I", 990, 271);
     	 graph.drawString("L", 990, 311);
     	 graph.drawString("A", 989, 351);
     	 
        	}
    
        }
    }
    
    
}