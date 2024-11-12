package store;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PumaPanel extends JPanel {
	
	BufferedImage nikeone ,niketwo, nikethree, nikefour, nikefive, nikesix, nikeseven, nikeeight;

    

    	    public PumaPanel() {
    	     
    	try {
    		nikeone = null;
    		niketwo = null;
    		nikethree = null;
    		nikefour = null;
    		nikefive = null;
    		nikesix = null;
    		nikeseven = null;
			// Load images
			nikeone = ImageIO.read(getClass().getResource("/Itm/nike1.png"));
			niketwo = ImageIO.read(getClass().getResource("/Itm/nike2.png"));
			nikethree = ImageIO.read(getClass().getResource("/Itm/nike3.png"));
			nikefour = ImageIO.read(getClass().getResource("/Itm/nike4.png"));       
			nikefive = ImageIO.read(getClass().getResource("/Itm/nike5.png"));
			nikesix = ImageIO.read(getClass().getResource("/Itm/nike6.png"));
			nikeseven = ImageIO.read(getClass().getResource("/Itm/nike7.png"));
			nikeeight = ImageIO.read(getClass().getResource("/Itm/nike8.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        GradientPaint gradient = new GradientPaint(700, 0, Color.BLACK, getWidth(), getHeight(), Color.RED);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
       
        //1st set of items
        g2d.setColor(Color.WHITE);
        g2d.fillRect(50,  30, 150, 200);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(230,  30, 150, 200);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(410,  30, 150, 200);
        
        g2d.setColor(Color.WHITE);
        g2d.fillRect(590,  30, 150, 200);
        //second set of items

        g2d.setColor(Color.WHITE);
        g2d.fillRect(50,  300, 150, 200);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(230,  300, 150, 200);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(410,  300, 150, 200);
        
        g2d.setColor(Color.WHITE);
        g2d.fillRect(590,  300, 150, 200);
        
       
//        g2d.drawString("Chunky Retro", 351, 463);
//        g2d.drawString("Fila Tracer", 539, 463);
        //set of picture 1st
        g2d.drawImage(nikeone, 55,  35, 140, 150, null);
        g2d.drawImage(niketwo, 235,  35, 140, 150, null);
        g2d.drawImage(nikethree, 415,  35, 140, 150, null);
        g2d.drawImage(nikefour, 595,  35, 140, 150, null);
       
        //set of picture 2nd      
        g2d.drawImage(nikefive, 55,  305, 140, 150, null);
        g2d.drawImage(nikesix, 235,  305, 140, 150, null);
        g2d.drawImage(nikeseven, 415,  305, 140, 150, null);
        g2d.drawImage(nikeeight, 595,  305, 140, 150, null);
        
        g2d.setColor(Color.DARK_GRAY);
        g2d.setFont(new Font("Arial Black", Font.BOLD, 11));
        //1ST SET OF ITEM NAMES
        g2d.drawString("Nike Air Force 1 '07", 65, 200);
        g2d.drawString("Nike Air Max III", 255, 200);
        g2d.drawString("Nike Air Max Pulse", 427, 200);
        g2d.drawString("Nike Air Max 90", 615, 200);
        
        //SEC SET
        g2d.drawString("Nike Court Air 3", 75, 468);
        g2d.drawString("Nike Invisible 3", 255, 468);
        g2d.drawString("Blazer", 465, 468);
        g2d.drawString("Air Max Plus", 625, 468);
        
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Arial Black", Font.BOLD, 13));
        //1ST SET OF ITEM NAMES
        g2d.drawString("PHP. 350.00", 78, 220);
        g2d.drawString("PHP. 430.00", 260, 220);
        g2d.drawString("PHP. 200.00", 437, 220);
        g2d.drawString("PHP. 700.00", 622, 220);
        
        //SEC SET
        g2d.drawString("PHP. 650.00", 80, 490);
        g2d.drawString("PHP. 500.00", 262, 490);
        g2d.drawString("PHP. 200.00", 445, 490);
        g2d.drawString("PHP. 360.00", 622, 490);
        
        JButton nikeBtnOne = new JButton();
        nikeBtnOne.setBounds(50, 515, 150, 30);
        nikeBtnOne.setBackground(Color.white);
        nikeBtnOne.setText("ADD TO CART");
        nikeBtnOne.setFocusPainted(false);
        nikeBtnOne.setFont(new Font("Arial Black", Font.BOLD, 13));
        nikeBtnOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JPanel itemHolder = new JPanel();
            	itemHolder.setBounds(10, 10, 250, 180);
            	itemHolder.setBackground(Color.WHITE);
            	itemHolder.setLayout(null);

            	JLabel shoesname = new JLabel();
            	shoesname.setText("Nike Court Air");
            	shoesname.setFont(new Font("Arial Black", Font.BOLD, 10));
            	shoesname.setBounds(78, 110, 150, 35);
            	itemHolder.add(shoesname);

            	JLabel shoesprice = new JLabel();
            	shoesprice.setText("PHP. 650.00");
            	shoesprice.setForeground(Color.RED);
            	shoesprice.setFont(new Font("Arial Black", Font.BOLD, 15));
            	shoesprice.setBounds(70, 120, 150, 50);
            	itemHolder.add(shoesprice);

            	JLabel qtyLabel = new JLabel("Qty:");
            	qtyLabel.setBounds(20, 10, 30, 20);
            	itemHolder.add(qtyLabel);

            	SpinnerNumberModel qtyModel = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
            	JSpinner qtySpinner = new JSpinner(qtyModel);
            	qtySpinner.setBounds(55, 10, 50, 20);
            	itemHolder.add(qtySpinner);

            	JLabel sizeLabel = new JLabel("Size:");
            	sizeLabel.setBounds(130, 10, 30, 20);
            	itemHolder.add(sizeLabel);

            	SpinnerNumberModel sizeModel = new SpinnerNumberModel(6, 6, Integer.MAX_VALUE, 1);
            	JSpinner sizeSpinner = new JSpinner(sizeModel);
            	sizeSpinner.setBounds(165, 10, 50, 20);
            	itemHolder.add(sizeSpinner);
            	
            	qtySpinner.addChangeListener(evt -> {
                    int quantity = (int) qtySpinner.getValue();
                    double price = 650.00 * quantity;
                    shoesprice.setText("PHP. " + price);
                    CartPanel.updateTotal();
                });

            	JLabel leni = new JLabel();
            	leni.setBounds(70, 20, 120, 125);
            	leni.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\projectpictures\\nike5.jpg"));
            	itemHolder.add(leni);

            	CartPanel.itemPanel.add(itemHolder);
            }        
        });
        add(nikeBtnOne);

        JButton nikeBtnTwo = new JButton();
        nikeBtnTwo.setBounds(230, 515, 150, 30 );
        nikeBtnTwo.setBackground(Color.white);
        nikeBtnTwo.setText("ADD TO CART");
        nikeBtnTwo.setFocusPainted(false);
        nikeBtnTwo.setFont(new Font("Arial Black", Font.BOLD, 13));
        add(nikeBtnTwo);
        
        JButton nikeBtnThree = new JButton();
        nikeBtnThree.setBounds(410, 515, 150, 30 );
        nikeBtnThree.setBackground(Color.white);
        nikeBtnThree.setText("ADD TO CART");
        nikeBtnThree.setFocusPainted(false);
        nikeBtnThree.setFont(new Font("Arial Black", Font.BOLD, 13));
        add(nikeBtnThree);
        
        JButton nikeBtnFour = new JButton();
        nikeBtnFour.setBounds(590, 515, 150, 30 );
        nikeBtnFour.setBackground(Color.white);
        nikeBtnFour.setText("ADD TO CART");
        nikeBtnFour.setFocusPainted(false);
        nikeBtnFour.setFont(new Font("Arial Black", Font.BOLD, 13));
        nikeBtnFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JPanel itemHolder = new JPanel();
            	itemHolder.setBounds(280, 10, 250, 180);
            	itemHolder.setBackground(Color.WHITE);
            	itemHolder.setLayout(null);

            	JLabel shoesname = new JLabel();
            	shoesname.setText("Air Max Plus");
            	shoesname.setFont(new Font("Arial Black", Font.BOLD, 10));
            	shoesname.setBounds(78, 110, 150, 35);
            	itemHolder.add(shoesname);

            	JLabel shoesprice = new JLabel();
            	shoesprice.setText("PHP. 360.00");
            	shoesprice.setForeground(Color.RED);
            	shoesprice.setFont(new Font("Arial Black", Font.BOLD, 15));
            	shoesprice.setBounds(70, 120, 150, 50);
            	itemHolder.add(shoesprice);

            	JLabel qtyLabel = new JLabel("Qty:");
            	qtyLabel.setBounds(20, 10, 30, 20);
            	itemHolder.add(qtyLabel);

            	SpinnerNumberModel qtyModel = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
            	JSpinner qtySpinner = new JSpinner(qtyModel);
            	qtySpinner.setBounds(55, 10, 50, 20);
            	itemHolder.add(qtySpinner);

            	JLabel sizeLabel = new JLabel("Size:");
            	sizeLabel.setBounds(130, 10, 30, 20);
            	itemHolder.add(sizeLabel);

            	SpinnerNumberModel sizeModel = new SpinnerNumberModel(6, 6, Integer.MAX_VALUE, 1);
            	JSpinner sizeSpinner = new JSpinner(sizeModel);
            	sizeSpinner.setBounds(165, 10, 50, 20);
            	itemHolder.add(sizeSpinner);
            	
            	qtySpinner.addChangeListener(evt -> {
                    int quantity = (int) qtySpinner.getValue();
                    double price = 360.00 * quantity;
                    shoesprice.setText("PHP. " + price);
                    CartPanel.updateTotal();
                });

            	JLabel leni = new JLabel();
            	leni.setBounds(70, 20, 120, 125);
            	leni.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\projectpictures\\nike8.jpg"));
            	itemHolder.add(leni);

            	CartPanel.itemPanel.add(itemHolder);
            }        
        });
        add(nikeBtnFour);
        
        JButton nikeBtnFive = new JButton();
        nikeBtnFive.setBounds(590, 245, 150, 30 );
        nikeBtnFive.setBackground(Color.white);
        nikeBtnFive.setText("ADD TO CART");
        nikeBtnFive.setFocusPainted(false);
        nikeBtnFive.setFont(new Font("Arial Black", Font.BOLD, 13));
        add(nikeBtnFive);
        
        JButton nikeBtnSix = new JButton();
        nikeBtnSix.setBounds(50, 245, 150, 30 );
        nikeBtnSix.setBackground(Color.white);
        nikeBtnSix.setText("ADD TO CART");
        nikeBtnSix.setFocusPainted(false);
        nikeBtnSix.setFont(new Font("Arial Black", Font.BOLD, 13));
        add(nikeBtnSix);
        
        JButton nikeBtnSeven = new JButton();
        nikeBtnSeven.setBounds(230, 245, 150, 30 );
        nikeBtnSeven.setBackground(Color.white);
        nikeBtnSeven.setText("ADD TO CART");
        nikeBtnSeven.setFocusPainted(false);
        nikeBtnSeven.setFont(new Font("Arial Black", Font.BOLD, 13));
        add(nikeBtnSeven);
        
        JButton nikeBtnEight = new JButton();
        nikeBtnEight.setBounds(410, 245, 150, 30 );
        nikeBtnEight.setBackground(Color.white);
        nikeBtnEight.setText("ADD TO CART");
        nikeBtnEight.setFocusPainted(false);
        nikeBtnEight.setFont(new Font("Arial Black", Font.BOLD, 13));
        add(nikeBtnEight);
        
        
        
        g2d.dispose();
        
        
    }
    public Component getNikeButtons() {
		// TODO Auto-generated method stub
		return null;
	}

}
