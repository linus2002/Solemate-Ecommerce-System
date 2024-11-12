package store;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class SplashScreen extends JFrame  {

	JProgressBar jb;
	JLabel eduzone, logo, quote;
	
	int i=0, num=0;
	
	
	public SplashScreen () {
		
		jb = new JProgressBar(0, 2000);
		jb.setBounds(0,285, 502, 35);
		jb.setValue(0);
		jb.setStringPainted(true);
		jb.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jb.setForeground(Color.BLACK);
		jb.setBackground(Color.GRAY);
		add(jb);
		
	
		setSize(502, 320);
		setLayout(null);
		
		eduzone = new JLabel();
		eduzone.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 60));
		eduzone.setText("SoleMate");
		eduzone.setBounds(174, 108, 251, 79);
		eduzone.setForeground(Color.gray);
		add(eduzone);
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\Simple AI\\solemate.png"));
		logo.setBounds(76, 99, 94, 100);
		add(logo);
		
		quote = new JLabel("Find your sole's perfect mate");
		quote.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		add(quote);
		
	}
	public void iterate() {
	    while (i <= 2000) {
	        jb.setValue(i);
	        i = i + 20;

	        int progress = jb.getValue();
	        if (progress == jb.getMaximum()) {
	            eduzone.setForeground(Color.BLACK);
	        } 
	        else if (progress > (jb.getMaximum() / 4)) {
	            eduzone.setForeground(Color.DARK_GRAY);
	        }
	        
	        if (progress >= (jb.getMaximum() * 0.35) && num == 0) {
	            num++;
	        	quote.setBounds(520, 172, 255, 27);
	        	add(quote);

	        	try {
	        	    File soundFile = new File("C:\\Users\\Admin\\Desktop\\Simple AI\\tagline.wav");
	        	    Clip clip = AudioSystem.getClip();
	        	    clip.open(AudioSystem.getAudioInputStream(soundFile));
	        	    clip.start();
	        	    File bg = new File("C:\\Users\\Admin\\Desktop\\Simple AI\\bg.wav");
	        	    Clip bgClip = AudioSystem.getClip();
	        	    bgClip.open(AudioSystem.getAudioInputStream(bg));
	        	    bgClip.start();
	        	} catch (Exception e) {
	        	    e.printStackTrace();
	        	}
	        }

	        if (num == 1) {
	            quote.setLocation(quote.getX() - 5, quote.getY());
	        }
	        try {
	            Thread.sleep(50);
	        } 
	        catch (Exception e) {}
	    }
	       if (jb.getValue() == jb.getMaximum()) {
	       
	       LoginForm open = new LoginForm();
	       open.main(null);
	       
	        this.dispose();
	    }
	}
		
	public static void main(String[]args) {
		
		SplashScreen m = new SplashScreen();
		m.setLocationRelativeTo(null);
		m.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\Simple AI\\solemate.png"));
		m.setUndecorated(true);
		m.setVisible(true);
		m.iterate();

	}
}
