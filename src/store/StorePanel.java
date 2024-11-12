package store;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class StorePanel extends JPanel {
    static JPanel panelTwo;
    
	static BufferedImage one;

	BufferedImage two;

	BufferedImage three;

	BufferedImage four;

	BufferedImage five;

	BufferedImage six;

	static BufferedImage seven;

    public StorePanel() {
    	
    	one = null;
		two = null;
		three = null;
		four = null;
		five = null;
		six = null;
		seven = null;
    	
        setPreferredSize(new Dimension(1100, 625));
        setLayout(null);
        setBackground(Color.yellow);

        JPanel panelOne = new JPanel();
        panelOne.setBounds(20, 20, 230, 580);
        panelOne.setBackground(Color.WHITE);
        panelOne.setLayout(null);
        add(panelOne);

        panelTwo = new CustomPanelTwo();
        panelTwo.setBounds(280, 20, 810, 580);
        panelTwo.setBackground(Color.WHITE);
        panelTwo.setLayout(null);
        add(panelTwo);
       
        JButton catButton = new JButton("CATEGORIES");
        catButton.setBackground(Color.WHITE);
        catButton.setBounds(2, 2, 226, 50);
        catButton.setFont(new Font("Arial Black", Font.BOLD, 18));
        catButton.addActionListener(e -> showBrandPanel(new NikePanel()));
        catButton.setEnabled(false);
        panelOne.add(catButton);

        JButton pumaButton = new JButton("NIKE");
        pumaButton.setBackground(Color.WHITE);
        pumaButton.setBounds(2, 53, 226, 50);
        pumaButton.setFocusPainted(false);
        pumaButton.setFont(new Font("Arial Black", Font.BOLD, 18));
        pumaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showBrandPanel(new PumaPanel());
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                pumaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                pumaButton.setCursor(Cursor.getDefaultCursor());
            }
        });

        panelOne.add(pumaButton);


        JButton balenciagaButton = new JButton("BALENCIAGA");
        balenciagaButton.setBackground(Color.WHITE);
        balenciagaButton.setBounds(2, 104, 226, 50);
        balenciagaButton.setFocusPainted(false);
        balenciagaButton.setFont(new Font("Arial Black", Font.BOLD, 18));
        balenciagaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showBrandPanel(new BalenciagaPanel());
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
            	balenciagaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
            	balenciagaButton.setCursor(Cursor.getDefaultCursor());
            }
        });

        panelOne.add(balenciagaButton);

      

        JButton filaButton = new JButton("FILA");
        filaButton.setBackground(Color.WHITE);
        filaButton.setBounds(2, 157, 226, 50);
        filaButton.setFocusPainted(false);
        filaButton.setFont(new Font("Arial Black", Font.BOLD, 18));
        filaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showBrandPanel(new FilaPanel());
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
            	filaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
            	filaButton.setCursor(Cursor.getDefaultCursor());
            }
        });
        panelOne.add(filaButton);

        JButton underArmourButton = new JButton ("UNDERARMOUR");
        underArmourButton.setBackground(Color.WHITE);
        underArmourButton.setBounds(2, 208, 226, 50);
        underArmourButton.setFocusPainted(false);
        underArmourButton.setFont(new Font("Arial Black", Font.BOLD, 18));
        underArmourButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showBrandPanel(new UnderArmourPanel());
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
            	underArmourButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
            	underArmourButton.setCursor(Cursor.getDefaultCursor());
            }
        });
        panelOne.add(underArmourButton);
        
        
    }

    private void showBrandPanel(JPanel brandPanel) {
        panelTwo.removeAll();
        brandPanel.setBounds(0, 0, panelTwo.getWidth(), panelTwo.getHeight());
        panelTwo.add(brandPanel);
        panelTwo.revalidate();
        panelTwo.repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        GradientPaint gradient = new GradientPaint(700, 0, Color.BLACK, getWidth(), getHeight(), Color.RED);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.dispose();
    }

    private static class CustomPanelTwo extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Custom painting for panelTwo
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            
            try {
                BufferedImage seven = ImageIO.read(getClass().getResource("/Img/seven.jpg"));
                g2d.drawImage(seven, 0, 0, 850, 300, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            

            g2d.setColor(Color.WHITE);
            g2d.fillRect(145,  300, 150, 200);

            g2d.setColor(Color.WHITE);
            g2d.fillRect(325,  300, 150, 200);

            g2d.setColor(Color.WHITE);
            g2d.fillRect(505,  300, 150, 200);
            
            g2d.setColor(Color.DARK_GRAY);
            g2d.setFont(new Font("Arial Black", Font.BOLD, 13));
            g2d.drawString("Air Jordan 1", 177, 463);
            g2d.drawString("Chunky Retro", 351, 463);
            g2d.drawString("Fila Tracer", 539, 463);

            g2d.setColor(Color.RED);
            g2d.setFont(new Font("Arial Black", Font.BOLD, 15));
            g2d.drawString("PHP. 400.OO", 165, 485);
            g2d.drawString("PHP. 280.00", 355, 485);
            g2d.drawString("PHP. 310.00", 531, 485);
            
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 12));
            g2d.drawString("50% OFF", 150, 315);
            g2d.drawString("60% OFF", 330, 315);
            g2d.drawString("30% OFF", 510, 315);
            
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial Black", Font.BOLD, 40));
            g2d.drawString("BEST", 30, 220);
            g2d.setColor(Color.RED);
            g2d.drawString("2022", 170, 220);
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial Black", Font.BOLD, 65));
            g2d.drawString("SELLER", 30, 280);
            
            
            try {
                BufferedImage three = ImageIO.read(getClass().getResource("/Img/three.png"));
                g2d.drawImage(three, 160,340, 130 ,110, null);
                
                BufferedImage four = ImageIO.read(getClass().getResource("/Img/four.jpg"));
                g2d.drawImage(four, 325, 323, 150, 130, null);
                
                BufferedImage five = ImageIO.read(getClass().getResource("/Img/fila.png"));
                g2d.drawImage(five, 508, 323, 150, 135, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            JButton addOne = new JButton();
            addOne.setBounds(145, 515, 150, 30 );
            addOne.setBackground(Color.white);
            addOne.setText("ADD TO CART");
            addOne.setFocusPainted(false);
            addOne.setFont(new Font("Arial Black", Font.BOLD, 13));
            add(addOne);
            addOne.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	JPanel itemHolder = new JPanel();
                	itemHolder.setBounds(10, 10, 250, 180);
                	itemHolder.setBackground(Color.WHITE);
                	itemHolder.setLayout(null);

                	JLabel shoesname = new JLabel();
                	shoesname.setText("Air Jordan 1");
                	shoesname.setFont(new Font("Arial Black", Font.BOLD, 10));
                	shoesname.setBounds(88, 110, 150, 35);
                	itemHolder.add(shoesname);

                	JLabel shoesprice = new JLabel();
                	shoesprice.setText("PHP. 400.00");
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
                         double price = 400.00 * quantity;
                         shoesprice.setText("PHP. " + price);
                         CartPanel.updateTotal();
                     });

                	JLabel leni = new JLabel();
                	leni.setBounds(50, 10, 140, 125);
                	leni.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\projectpictures\\air.png"));
                	itemHolder.add(leni);

                	CartPanel.itemPanel.add(itemHolder);

                }
           
            });
            
            JButton addTwo = new JButton();
            addTwo.setBounds(325, 515, 150, 30 );
            addTwo.setBackground(Color.white);
            addTwo.setText("ADD TO CART");
            addTwo.setFocusPainted(false);
            addTwo.setFont(new Font("Arial Black", Font.BOLD, 13));
            add(addTwo);
            addTwo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	JPanel itemHolder = new JPanel();
                	itemHolder.setBounds(280, 10, 250, 180);
                	itemHolder.setBackground(Color.WHITE);
                	itemHolder.setLayout(null);

                	JLabel shoesname = new JLabel();
                	shoesname.setText("Chunky Retro");
                	shoesname.setFont(new Font("Arial Black", Font.BOLD, 10));
                	shoesname.setBounds(90, 110, 150, 35);
                	itemHolder.add(shoesname);

                	JLabel shoesprice = new JLabel();
                	shoesprice.setText("PHP. 280.00");
                	shoesprice.setForeground(Color.RED);
                	shoesprice.setFont(new Font("Arial Black", Font.BOLD, 15));
                	shoesprice.setBounds(80, 120, 150, 50);
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
                        double price = 280.00 * quantity;
                        shoesprice.setText("PHP. " + price);
                        CartPanel.updateTotal();
                    });

                	JLabel leni = new JLabel();
                	leni.setBounds(70, 10, 120, 125);
                	leni.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\projectpictures\\chunky.jpg"));
                	itemHolder.add(leni);

                	CartPanel.itemPanel.add(itemHolder);
                }        
            });
            
            JButton addThree = new JButton();
            addThree.setBounds(505, 515, 150, 30 );
            addThree.setBackground(Color.white);
            addThree.setText("ADD TO CART");
            addThree.setFocusPainted(false);
            addThree.setFont(new Font("Arial Black", Font.BOLD, 13));
            add(addThree);
            addThree.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	JPanel itemHolder = new JPanel();
                	itemHolder.setBounds(550, 10, 250, 180);
                	itemHolder.setBackground(Color.WHITE);
                	itemHolder.setLayout(null);

                	JLabel shoesname = new JLabel();
                	shoesname.setText("Fila Tracer");
                	shoesname.setFont(new Font("Arial Black", Font.BOLD, 10));
                	shoesname.setBounds(100, 110, 150, 35);
                	itemHolder.add(shoesname);

                	JLabel shoesprice = new JLabel();
                	shoesprice.setText("PHP. 310.00");
                	shoesprice.setForeground(Color.RED);
                	shoesprice.setFont(new Font("Arial Black", Font.BOLD, 15));
                	shoesprice.setBounds(75, 120, 150, 50);
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
                        double price = 310.00 * quantity;
                        shoesprice.setText("PHP. " + price);
                        CartPanel.updateTotal();
                    });

                	JLabel leni = new JLabel();
                	leni.setBounds(90, 10, 120, 125);
                	leni.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\projectpictures\\fila.png"));
                	itemHolder.add(leni);

                	CartPanel.itemPanel.add(itemHolder);
                }        
            });
            
            g2d.dispose();
        }
    }
}
  