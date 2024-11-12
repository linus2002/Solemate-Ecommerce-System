package store;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

import store.ContactPanel.contactPanel;
public class AboutPanel extends JPanel {
	static aboutpanel cPanel;
    BufferedImage abs, shoes, eight;
    static JLabel linus, danilo;

    public AboutPanel() {

        abs = null;
        shoes = null;
        eight = null;

        setPreferredSize(new Dimension(1100, 625));
        setLayout(null);
        
        
        cPanel = new aboutpanel();
		add(cPanel);
		
		JScrollPane scrollPane = new JScrollPane(cPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(1100, 750));
        scrollPane.setBounds(0, 0, 1100, 700);

      
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(25);
        verticalScrollBar.setBlockIncrement(50);
       verticalScrollBar.setPreferredSize(new Dimension(20, 1100));

        add(scrollPane);
       
        
        cPanel = new aboutpanel();
        cPanel.setPreferredSize(new Dimension(1100, 1200));
        cPanel.setLayout(null);

        // Set the panel_scrollpane as the viewport for the scroll pane
        
        scrollPane.setViewportView(cPanel);
        
      


        try {
            abs = ImageIO.read(getClass().getResource("/Img/absract.png"));
            shoes = ImageIO.read(getClass().getResource("/Img/nikedes.png"));
            eight = ImageIO.read(getClass().getResource("/Img/eight.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }

    class aboutpanel extends JPanel{
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        Stroke stroke = new BasicStroke(5);
        
        Font font = new Font("Berlin Sans FB Demi", Font.BOLD, 28);
        Font font2 = new Font("Berlin Sans FB Demi", Font.BOLD, 18);
        
        linus = new JLabel();
        linus.setBounds(293, 690, 200, 230);
        linus.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\Simple AI\\aurin.png"));
        linus.setOpaque(false);
        add(linus);
        
        danilo = new JLabel();
        danilo.setBounds(663, 690, 200, 230);
        danilo.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\Simple AI\\dejesus.png"));
        danilo.setOpaque(false);
        add(danilo);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        GradientPaint circ = new GradientPaint(100, 500, Color.BLACK, 0, 0, Color.WHITE);
        GradientPaint gradient = new GradientPaint(0, 0, Color.white, getWidth(), getHeight(), Color.white);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.drawImage(abs, 60, 0, 1110, 600, null);

        g2d.setColor(Color.DARK_GRAY);
        g2d.setFont(new Font("Arial Black", Font.BOLD, 70));
        g2d.drawString("About", 40, 60);
        g2d.setFont(new Font("Arial Black", Font.BOLD, 70));
        g2d.drawString("Us", 40, 120);

        g2d.drawImage(shoes, 650, 80, 500, 500, null);
        g2d.drawImage(eight, 0, 825, 1100, 600, null);

        JLabel description = new JLabel();
        description.setBounds(40, 130, 600, 600);
        description.setFont(new Font("Arial", Font.PLAIN, 14));
        description.setForeground(Color.BLACK);
        description.setVerticalAlignment(SwingConstants.TOP);
        String htmlText = "<html><body style='text-align: justify; line-height: 1.5em;'>Welcome to Solemate, your ultimate destination for stylish footwear and sneakers from top brands such as Nike, Balenciaga, Fila, and Under Armour.<br><br>"
                + "At Solemate, we understand that shoes are not just a necessity but an expression of individual style and personality. With a curated collection of the most sought-after brands in the market, we strive to provide our customers with an unparalleled shopping experience."
                + "We take pride in offering a wide range of footwear options to cater to every taste and preference. Whether you're a sneakerhead, an athlete in search of high-performance gear, or simply someone looking for comfortable and fashionable shoes, we have something for everyone. From iconic Nike sneakers that blend functionality and style to the luxurious and avant-garde designs of Balenciaga, our selection represents the latest trends and classics that transcend time.<br><br>"
                + "Our commitment to quality and authenticity is unwavering. We source our products directly from authorized distributors and manufacturers, ensuring that every pair of shoes we carry is genuine and made to the highest standards. Your satisfaction and confidence in our products are our top priorities.<br><br>"
                + "With our knowledgeable and friendly staff, we are here to assist you in finding the perfect pair of shoes that not only fit well but also reflect your personal taste. We understand that every customer is unique, and we take the time to listen to your needs and guide you towards the best choice."
                + "Convenience and ease of shopping are important to us. That's why we offer a seamless online shopping experience, allowing you to browse our extensive catalog, check product details, and make secure purchases from the comfort of your home. We also have a physical store where you can try on the shoes and receive personalized assistance from our dedicated team.<br><br>"
                + "At Solemate, we believe in building lasting relationships with our customers. We strive to exceed your expectations with exceptional service, competitive prices, and a vast selection of top-notch footwear. Join us on the journey to find your perfect \"solemate\" and elevate your style to new heights.</body></html>";
        description.setText(htmlText);
        add(description);
        
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(230, 700, 300, 300);
        
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(600, 700, 300, 300);
        
        
        g2d.setPaint(circ);
        g2d.fillOval(298, 730, 160, 160);

        g2d.setPaint(circ);
        g2d.fillOval(668, 730, 160, 160);
        
        g2d.setColor(Color.WHITE);
        g2d.setFont(font);
        g2d.drawString("Linus D. Aurin", 293, 940);
        
        g2d.setColor(new Color(51, 153, 255));
        g2d.setFont(font2);
        g2d.drawString("Software Engineer", 305 , 960);
        
        g2d.setPaint(gradient);
        g2d.fillOval(105, 270, 160, 160);
        
        g2d.setColor(Color.WHITE);
        g2d.setFont(font);
        g2d.drawString("Danilo De Jesus", 656, 940);
        
        g2d.setFont(font);
        g2d.drawString("Developers", 500, 700);
        
        g2d.setColor(new Color(51, 153, 255));
        
        g2d.setFont(font2);
        g2d.drawString("Associate Software Engineer", 637, 960);
        g2d.setFont(font);
        g2d.drawString("DEVELOPERS", 485, 680);

    }

    private class CustomScrollBarUI extends BasicScrollBarUI {
        protected void configureScrollBarColors() {
            this.thumbColor = Color.GRAY;
        }
        
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            g.setColor(thumbColor);
            g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
        }
    }
    }
}
