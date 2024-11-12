package store;

import javax.swing.*;

import store.ContactPanel.contactPanel;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CartPanel extends JPanel {
	
	static JPanel itemCart, itemPanel;
	static JScrollPane scrollPane;
	static JLabel totalLabel;
	private static ArrayList<BufferedImage> itemImages;

	

	public CartPanel() {
		
		   setPreferredSize(new Dimension(1100, 625));
	        setLayout(null);
	        
	        itemPanel = new JPanel();
	        itemPanel.setBounds(40, 120, 820, 400);
	        itemPanel.setBackground(Color.GRAY);
	        itemPanel.setLayout(null);
	        add(itemPanel);
	        
	        JButton btn1 = new JButton();
	        btn1.setBounds(882, 465, 200, 40);
	        btn1.setText("Cancel Order");
	        btn1.setFont(new Font("Arial Black", Font.BOLD, 15));
	        btn1.setBackground(Color.WHITE);
	        btn1.setForeground(Color.BLACK);
	        btn1.setFocusPainted(false);
	        add(btn1);
	        btn1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                CartPanel.itemPanel.removeAll();
	                CartPanel.itemPanel.revalidate();
	                CartPanel.itemPanel.repaint();
	                updateTotal();
	            }
	        });

	        JButton btn2 = new JButton();
	        btn2.setBounds(882, 510, 200, 40);
	        btn2.setText("Checkout");
	        btn2.setFont(new Font("Arial Black", Font.BOLD, 15));
	        btn2.setBackground(Color.WHITE);
	        btn2.setForeground(Color.BLACK);
	        btn2.setFocusPainted(false);
	        btn2.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	              DeliveryStatusFrame open = new DeliveryStatusFrame();
	              open.main(null);
	              
	              
	              
	            }
	        });
	        add(btn2);
	        
	        totalLabel = new JLabel();
	        totalLabel.setBounds(980, 415, 200, 50);
	        totalLabel.setText("0.");
	        totalLabel.setForeground(Color.WHITE);
	        totalLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
	        add(totalLabel);
	        
	        
//	        JPanel leniPanel = new JPanel();
//	        leniPanel.setBounds(10, 10, 250, 150);
//	        leniPanel.setBackground(Color.WHITE);
//	        itemPanel.add(leniPanel);
	}
	public static void updateTotal() {
	    double total = 0;

	    Component[] components = itemPanel.getComponents();
	    for (Component component : components) {
	        if (component instanceof JPanel) {
	            JPanel itemHolder = (JPanel) component;

	            Component[] itemComponents = itemHolder.getComponents();
	            for (Component itemComponent : itemComponents) {
	                if (itemComponent instanceof JLabel) {
	                    JLabel label = (JLabel) itemComponent;
	                    String text = label.getText();
	                    if (text.startsWith("PHP.")) {
	                        double price = Double.parseDouble(text.substring(5));
	                        total += price;
	                    }
	                }
	            }
	        }
	    }

	    totalLabel.setText(String.format("%.2f", total));
	}


	        

	
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	        GradientPaint circ = new GradientPaint(100, 500, Color.BLACK, 0, 0, Color.WHITE);
	        GradientPaint gradient = new GradientPaint(0, 0, Color.WHITE, getWidth(), getHeight(), Color.BLACK);
	        g2d.setPaint(gradient);
	        g2d.fillRect(0, 0, getWidth(), getHeight());
	        
	        g2d.setColor(Color.BLACK);
	        g2d.setFont(new Font("Arial Black", Font.BOLD, 50));
	        g2d.drawString("My Cart", 30, 70);
	        
	        g2d.setColor(new Color (1, 11, 19));
	        g2d.fillRect(868, 0, 250, 700);
	        
	        g2d.setColor(Color.white);
	        g2d.setFont(new Font("Arial Black", Font.BOLD, 25));
	        g2d.drawString("Total: ", 882, 450);
	        
	        g2d.setColor(new Color(143, 143, 142));
	        g2d.fillRect(878, 120, 210, 287);

	        g2d.setColor(new Color(1, 11, 19));
	        g2d.setFont(new Font("Arial Black", Font.BOLD, 13));
	        g2d.drawString("Choose shipping mode", 897, 145);

	        JCheckBox checkBox1 = new JCheckBox("Store pickup [In 19 Hours]");
	        checkBox1.setBounds(880, 160, 200, 20);
	        checkBox1.setBackground(new Color(143, 143, 142));
	        add(checkBox1);

	        JCheckBox checkBox2 = new JCheckBox("Deliver at home [Under 4 days]");
	        checkBox2.setBounds(880, 185, 200, 20);
	        checkBox2.setBackground(new Color(143, 143, 142));
	        add(checkBox2);

	        
		
	
		
	}
	public static String getSelectedCheckboxText() {
		// TODO Auto-generated method stub
		return "";
	}
	
}













