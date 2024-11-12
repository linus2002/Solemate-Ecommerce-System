package store;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class LoginForm extends JFrame implements ActionListener {

    private static final int IMAGE_WIDTH = 400;
    private static final int IMAGE_HEIGHT = 600;
    private static final int TIMER_DELAY = 2000; // 2 seconds

    static JTextField txtField;
    private JTextField textfield, textfield2,  txtField2, textfield3, textfield4, textfield5;
    private JButton loginButton, fb, google, loginBtn;

    private Color defaultColor = Color.WHITE;
    private Color hoverColor = new Color(63, 67, 84);
    private static JLabel showLabel;

    private JPasswordField passwordField;
    private JRadioButton radioButton;
    private String usernamePlaceholder = "Username";
    private String passwordPlaceholder = "Password";
    private JLabel label, labelTwo, labelOne, email, password, text, signup, sole, mates, text2;
    static JPanel panel, ad;
    private BufferedImage[] images;
    private int currentImageIndex;
    
    String[] labelTexts = { "Customer Name", "Address", "Number", "Username", "Password", "Create", "Account."};

    // Store registered usernames and passwords
    private HashMap<String, String> registeredAccounts;

    public LoginForm() {

        setUndecorated(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\Simple AI\\shoes.png"));

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);

        sole = new JLabel();
        sole.setBounds(595, 80, 100, 30);
        sole.setFont(new Font("Elephant", Font.BOLD, 18));
        sole.setText("Sole");
        panel.add(sole);

        mates = new JLabel();
        mates.setBounds(595, 100, 100, 30);
        mates.setFont(new Font("Elephant", Font.BOLD, 18));
        mates.setText("mates");
        panel.add(mates);
        	
        labelOne = new JLabel();
        labelOne.setBounds( 540, 50 , 200, 100);
        labelOne.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\Simple AI\\shoes.png"));
        panel.add(labelOne);
        
        label = new JLabel();
        label.setBounds(460, 170, 200, 30);
        label.setFont(new Font("Arial Bold", Font.BOLD, 28));
        label.setText("Welcome back");
        panel.add(label);

        labelOne = new JLabel();
        labelOne.setBounds(460, 190, 300, 30);
        labelOne.setFont(new Font("Arial", Font.PLAIN, 13));
        labelOne.setText("Welcome back! Please enter your details");
        panel.add(labelOne);

        textfield = new JTextField();
        textfield.setBounds(460, 240, 265, 30);
        textfield.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        textfield.setOpaque(false);
        textfield.setFont(new Font("Arial", Font.PLAIN, 14));
        textfield.setForeground(Color.BLACK);
        textfield.setText(usernamePlaceholder); // set placeholder text
        panel.add(textfield);
        textfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textfield.getText().equals(usernamePlaceholder)) {
                    textfield.setText("");
                    textfield.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textfield.getText().isEmpty()) {
                    textfield.setText(usernamePlaceholder);
                    textfield.setForeground(new Color(150, 150, 150));
                }
            }
        });

        passwordField = new JPasswordField();
        passwordField.setBounds(460, 310, 265, 30);
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        passwordField.setOpaque(false);
        passwordField.setForeground(Color.BLACK);
        passwordField.setText(passwordPlaceholder);
        passwordField.setEchoChar((char) 0);
        panel.add(passwordField);
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

        showLabel = new JLabel("Show Password");
        showLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        showLabel.setForeground(Color.black);
        showLabel.setBounds(485, 343, 100, 25);
        panel.add(showLabel);

        radioButton = new JRadioButton();
        radioButton.setBounds(460, 345, 20, 20);
        radioButton.setBackground(Color.WHITE);
        panel.add(radioButton);
        radioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (radioButton.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            }
        });

        loginButton = new JButton("Login");
        loginButton.setBounds(460, 380, 265, 40);
        loginButton.setFocusable(false);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        Border thickBorder = BorderFactory.createLineBorder(Color.white, 2);
        loginButton.setBorder(thickBorder);
        panel.add(loginButton);
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(new Color(51, 153, 255));
                loginButton.setForeground(new Color(63, 67, 84));
            }

            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(Color.BLACK);
                loginButton.setForeground(Color.WHITE);
            }

            public void mouseClicked(MouseEvent e) {
                String username = textfield.getText();
                String password = String.valueOf(passwordField.getPassword());

                if (validateLogin(username, password)) {
                    JOptionPane.showMessageDialog(LoginForm.this, "Login Successful!");
                    
                    MainFrame open = new MainFrame();
                    open.main(null);
                    
                } else {
                    JOptionPane.showMessageDialog(LoginForm.this, "Wrong username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        text = new JLabel();
        text.setText("Dont have an account?");
        text.setFont(new Font("Arial", Font.PLAIN, 12));
        text.setForeground(Color.black);
        text.setBounds(500, 550, 200, 25);
        panel.add(text);

        text2 = new JLabel();
        text2.setText("or Sign in with");
        text2.setFont(new Font("Arial Black", Font.PLAIN, 12));
        		 text2.setForeground(Color.black);
        		text2.setBounds(550, 420, 200, 25);
        		panel.add(text2);
        		
        	    fb = new JButton("Sign in with facebook");
        	    fb.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\Simple AI\\facebook.png"));
        	    fb.setBounds(460, 450, 265, 40);
        	    fb.setFocusable(false);
        	    fb.setBackground(Color.BLACK);
        	    fb.setForeground(Color.WHITE);
        	    fb.setFont(new Font("Arial", Font.BOLD, 12));
        	    Border tb = BorderFactory.createLineBorder(Color.white, 2);
        	    fb.setBorder(tb);
        	    panel.add(fb);
        	    fb.addMouseListener(new MouseAdapter() {
        	    	public void mouseClicked(MouseEvent e) {
        	    		
        	    		Facebook open = new Facebook();
        	    		open.main(null);
        	    		
        	    	}
        	    	
        	        public void mouseEntered(MouseEvent e) {
        	            fb.setBackground(new Color(51, 153, 255));
        	            fb.setForeground(new Color(63, 67, 84));
        	        }

        	        public void mouseExited(MouseEvent e) {

        	            fb.setBackground(Color.BLACK);
        	            fb.setForeground(Color.WHITE);
        	        }
        	    });

        	    google = new JButton("Sign in with Google");
        	    google.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\Simple AI\\googlde.png"));
        	    google.setBounds(460, 495, 265, 40);
        	    google.setFocusable(false);
        	    google.setBackground(Color.BLACK);
        	    google.setForeground(Color.WHITE);
        	    google.setFont(new Font("Arial", Font.BOLD, 12));
        	    Border tb1 = BorderFactory.createLineBorder(Color.white, 2);
        	    google.setBorder(tb1);
        	    panel.add(google);
        	    google.addMouseListener(new MouseAdapter() {
        	    	
            	    	public void mouseClicked(MouseEvent e) {
            	    		
            	    		Google open = new Google();
            	    		open.main(null);
            	    		
            	    	}
        	        public void mouseEntered(MouseEvent e) {
        	            google.setBackground(new Color(51, 153, 255));
        	            google.setForeground(new Color(63, 67, 84));
        	        }

        	        public void mouseExited(MouseEvent e) {

        	            google.setBackground(Color.BLACK);
        	            google.setForeground(Color.WHITE);
        	        }
        	    });

        	    ad = new AdPanel();
        	    ad.setBounds(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        	    panel.add(ad);

        	    try {
        	        images = new BufferedImage[6];
        	        images[0] = ImageIO.read(getClass().getResource("/Img/ad1.jpg"));
        	        images[1] = ImageIO.read(getClass().getResource("/Img/ad2.jpg"));
        	        images[2] = ImageIO.read(getClass().getResource("/Img/ad3.jpg"));
        	        images[3] = ImageIO.read(getClass().getResource("/Img/ad4.jpg"));
        	        images[4] = ImageIO.read(getClass().getResource("/Img/ad5.jpg"));
        	        images[5] = ImageIO.read(getClass().getResource("/Img/ad6.jpg"));
        	    } catch (Exception e) {
        	        e.printStackTrace();
        	    }

        	    currentImageIndex = 0;

        	    Timer timer = new Timer(TIMER_DELAY, this);
        	    timer.start();

        	    signup = new JLabel();
        	    signup.setText("Sign Up");
        	    signup.setFont(new Font("Arial", Font.PLAIN, 12));
        	    signup.setForeground(Color.BLUE);
        	    signup.setBounds(630, 550, 80, 25);
        	    panel.add(signup);
        	    signup.addMouseListener(new MouseAdapter() {
        	        public void mouseClicked(MouseEvent e) {

        	            JPanel insidePanel = new JPanel();

        	            JFrame signFrame = new JFrame();
        	            signFrame.setBounds(683, 64, 400, 600);
        	            signFrame.setUndecorated(true);

        	            signFrame.add(insidePanel);
        	            insidePanel.setLayout(null);

        	            insidePanel.setBackground(Color.BLACK);

        	            txtField = new JTextField();
        	            txtField.setBounds(65, 150, 250, 30);
        	            txtField.setFont(new Font("Arial Black", Font.BOLD, 20));
        	            txtField.setBackground(Color.BLACK);
        	            txtField.setForeground(Color.WHITE);
        	            txtField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        	            txtField.setOpaque(true);
        	            txtField.setForeground(new Color(150, 150, 150));
        	            insidePanel.add(txtField);

        	            txtField2 = new JTextField();
        	            txtField2.setBounds(65, 210, 250, 30);
        	            txtField2.setFont(new Font("Arial Black", Font.BOLD, 20));
        	            txtField2.setBackground(Color.BLACK);
        	            txtField2.setForeground(Color.WHITE);
        	            txtField2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        	            txtField2.setOpaque(true);
        	            insidePanel.add(txtField2);

        	            textfield3 = new JTextField();
        	            textfield3.setBounds(65, 270, 250, 30);
        	            textfield3.setBackground(Color.BLACK);
        	            textfield3.setFont(new Font("Arial Black", Font.BOLD, 20));
        	            textfield3.setForeground(Color.WHITE);
        	            textfield3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        	            textfield3.setOpaque(true);
        	            insidePanel.add(textfield3);

        	            textfield4 = new JTextField();
        	            textfield4.setBounds(65, 330, 250, 30);
        	            textfield4.setBackground(Color.BLACK);
        	            textfield4.setForeground(Color.WHITE);
        	            textfield4.setFont(new Font("Arial Black", Font.BOLD, 20));
        	            textfield4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        	            textfield4.setOpaque(true);
        	            insidePanel.add(textfield4);

        	            textfield5 = new JTextField();
        	            textfield5.setFont(new Font("Arial Black", Font.BOLD, 20));
        	            textfield5.setBounds(65, 390, 250, 30);
        	            textfield5.setBackground(Color.BLACK);
        	            textfield5.setForeground(Color.WHITE);
        	            textfield5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        	            textfield5.setOpaque(true);
        	            insidePanel.add(textfield5);

        	            loginBtn = new JButton("Create Account");
        	            loginBtn.setFont(new Font("Arial Black", Font.BOLD, 14));
        	            loginBtn.setBackground(Color.white);
        	            loginBtn.setForeground(Color.black);
        	            loginBtn.setBounds(65, 440, 250, 40);
        	            loginBtn.setFocusPainted(false);
        	            loginBtn.setBorderPainted(false);
        	            insidePanel.add(loginBtn);

        	            JLabel[] labels = new JLabel[labelTexts.length];
        	            for (int i = 0; i < labelTexts.length; i++) {
        	                labels[i] = new JLabel(labelTexts[i]);

        	                if (i == 0) {
        	                    labels[i].setBounds(65, 120, 140, 30);
        	                    labels[i].setFont(new Font("Arial Black", Font.BOLD, 14));
        	                    labels[i].setForeground(Color.WHITE);
        	                } else if (i == 1) {
        	                    labels[i].setBounds(65, 180, 140, 30);
        	                    labels[i].setFont(new Font("Arial Black", Font.BOLD, 14));
        	                    labels[i].setForeground(Color.WHITE);
        	                } else if (i == 2) {
        	                    labels[i].setBounds(65, 240, 140, 30);
        	                    labels[i].setFont(new Font("Arial Black", Font.BOLD, 14));
        	                    labels[i].setForeground(Color.WHITE);
        	                } else if (i == 3) {
        	                    labels[i].setBounds(65, 300, 140, 30);
        	                    labels[i].setFont(new Font("Arial Black", Font.BOLD, 14));
        	                    labels[i].setForeground(Color.WHITE);
        	                } else if (i == 4) {
        	                labels[i].setBounds(65, 360, 140, 30);
        	                labels[i].setFont(new Font("Arial Black", Font.BOLD, 14));
        	                labels[i].setForeground(Color.WHITE);
        	                } else if (i == 5) {
        	                labels[i].setBounds(65, 35, 250, 40);
        	                labels[i].setFont(new Font("Arial Black", Font.BOLD, 25));
        	                labels[i].setForeground(Color.WHITE);
        	                } else if (i == 6) {
        	                labels[i].setBounds(65, 60, 250, 40);
        	                labels[i].setFont(new Font("Arial Black", Font.BOLD, 30));
        	                labels[i].setForeground(Color.WHITE);
        	                }
        	                insidePanel.add(labels[i]);
        	            }

        	            loginBtn.addActionListener(new ActionListener() {
        	                @Override
        	                public void actionPerformed(ActionEvent e) {
        	                    String username = textfield4.getText();
        	                    String password = textfield5.getText();

        	                    if (username.isEmpty() || password.isEmpty()) {
        	                        JOptionPane.showMessageDialog(signFrame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        	                    } else {
        	                        // Check if the username is already registered
        	                        if (registeredAccounts.containsKey(username)) {
        	                            JOptionPane.showMessageDialog(signFrame, "Username already exists. Please choose a different username.", "Error", JOptionPane.ERROR_MESSAGE);
        	                        } else {
        	                            // Register the new account
        	                            registeredAccounts.put(username, password);
        	                            JOptionPane.showMessageDialog(signFrame, "Account created successfully!");
        	                            signFrame.dispose(); // Close the signup frame
        	                        }
        	                    }
        	                }
        	            });

        	            signFrame.setVisible(true);
        	        }

        	        public void mouseEntered(MouseEvent e) {
        	            signup.setFont(new Font("Arial", Font.BOLD, 13));
        	        }

        	        public void mouseExited(MouseEvent e) {
        	            signup.setFont(new Font("Arial", Font.PLAIN, 12));
        	        }
        	    });

        	    // Initialize the registered accounts map
        	    registeredAccounts = new HashMap<>();

        	}

        	public static void main(String[] args) {
        	    LoginForm loginForm = new LoginForm();
        	    loginForm.setVisible(true);
        	}

        	@Override
        	public void actionPerformed(ActionEvent e) {
        	    if (e.getSource() instanceof Timer) {
        	        currentImageIndex = (currentImageIndex + 1) % images.length;
        	        ad.repaint();
        	    }
        	}

        	class AdPanel extends JPanel {

        	    @Override
        	    protected void paintComponent(Graphics g) {
        	        super.paintComponent(g);
        	        Graphics2D g2d = (Graphics2D) g;

        	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        	        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        	        BufferedImage currentImage = images[currentImageIndex];
        	        g2d.drawImage(currentImage, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT, null);

        	    }
        	}

        	private boolean validateLogin(String username, String password) {
        	    // Check if the username and password match a registered account
        	    return registeredAccounts.containsKey(username) && registeredAccounts.get(username).equals(password);
        	}
}

