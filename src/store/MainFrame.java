package store;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    private JPanel currentPanel;

    public MainFrame() {
        setSize(1100, 700);
        setLayout(null);
        setUndecorated(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\Simple AI\\shoes.png"));
        currentPanel = new JPanel();
        currentPanel.setBackground(Color.WHITE);

        JLabel user = new JLabel();
        user.setBounds(30, 3, 60, 60);
        user.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\Simple AI\\user.png"));
        add(user);
        JPopupMenu logoutMenu = new JPopupMenu();
        JMenuItem logoutItem = new JMenuItem("Logout");
        logoutItem.setBackground(Color.WHITE);
        logoutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logout actions here
                dispose();
            }
        });
        logoutMenu.add(logoutItem);

        user.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logoutMenu.show(user, -5, 75);
            }

            
//            public void mouseExited(MouseEvent e) {
//                logoutMenu.setVisible(false);
//            }
        });


        JLabel username = new JLabel("User");
        username.setBounds(40, 34, 60, 60);
        add(username);

        // Create buttons
        JButton homeButton = new JButton("HOME");
        JButton storeButton = new JButton("STORE");
        JButton aboutButton = new JButton("ABOUT US");
        JButton contactButton = new JButton("CONTACT US");
        JButton myCartButton = new JButton("MY CART");

        // Create panels
        HomePanel homePanel = new HomePanel();
        StorePanel storePanel = new StorePanel(); // Initialize storePanel
        AboutPanel aboutPanel = new AboutPanel();
        ContactPanel contactPanel = new ContactPanel();
        CartPanel cartPanel = new CartPanel();

        setCurrentPanel(homePanel);

        // Add action listeners to buttons
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentPanel(homePanel);
            }
        });

        storeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentPanel(storePanel);
            }
        });

        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentPanel(aboutPanel);
            }
        });

        contactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentPanel(contactPanel);
            }
        });
        myCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentPanel(cartPanel);
            }
        });
        

        // Set layout to null
        setLayout(null);
        setBackground(Color.WHITE);

        // Set bounds for buttons
        homeButton.setBounds(100, 0, 140, 80);
        storeButton.setBounds(240, 0, 140, 80);
        aboutButton.setBounds(380, 0, 140, 80);
        contactButton.setBounds(520, 0, 170, 80);
        myCartButton.setBounds(700, 0, 160, 80);

        homeButton.setBackground(Color.WHITE);
        homeButton.setForeground(Color.BLACK);
        homeButton.setBorderPainted(false);
        homeButton.setFocusPainted(false);
        homeButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));

        storeButton.setBackground(Color.WHITE);
        storeButton.setForeground(Color.BLACK);
        storeButton.setBorderPainted(false);
        storeButton.setFocusPainted(false);
        storeButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));

        aboutButton.setBackground(Color.WHITE);
        aboutButton.setForeground(Color.BLACK);
        aboutButton.setBorderPainted(false);
        aboutButton.setFocusPainted(false);
        aboutButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));

        contactButton.setBackground(Color.WHITE);
        contactButton.setForeground(Color.BLACK);
        contactButton.setBorderPainted(false);
        contactButton.setFocusPainted(false);
        contactButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));

        myCartButton.setBackground(Color.WHITE);
        myCartButton.setForeground(Color.BLACK);
        myCartButton.setBorderPainted(false);
        myCartButton.setFocusPainted(false);
        myCartButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));

        // Add buttons to the main frame
        add(homeButton);
        add(storeButton);
        add(aboutButton);
        add(contactButton);
        add(myCartButton);
       
        

        // Set bounds for current panel
        currentPanel.setBounds(0, 75, 1100, 700);
        // Add current panel to the content pane
        getContentPane().add(currentPanel);

        setVisible(true);
    }
    

    private void setCurrentPanel(JPanel panel) {
        currentPanel.removeAll();
        currentPanel.add(panel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
        
        
    }
   
}
