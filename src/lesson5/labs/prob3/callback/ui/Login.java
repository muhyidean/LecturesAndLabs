package lesson5.labs.prob3.callback.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import lesson5.labs.prob3.callback.control.Control;

@SuppressWarnings("serial")
public class Login extends JFrame {
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	private JLabel label;
	private JTextArea gradesData;
	private JTextField userText;
	private JTextField pwdText;
	public void setMessage(String s) {
		label.setText(s);
	}
	public String getUserName() {
		return userText.getText();
	}
	public String getPassword() {
		return pwdText.getText();
	}
	public Login() {
		initializeWindow();
		JPanel mainPanel = new JPanel();
		defineTopPanel();
		defineMiddlePanel();
		defineLowerPanel();
		mainPanel.setLayout(new BorderLayout(12,12));
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(middlePanel, BorderLayout.CENTER);
		mainPanel.add(lowerPanel, BorderLayout.SOUTH);
		getContentPane().add(mainPanel);
	}
	private void defineTopPanel() {
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		label = new JLabel("Login");
		label.setForeground(Color.BLUE.darker().darker());
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		topPanel.add(label);
		
	}
	private void defineMiddlePanel(){
		middlePanel=new JPanel();
		middlePanel.setLayout(new BorderLayout());
		JPanel upper = new JPanel();
		JPanel lower = new JPanel();
		upper.setLayout(new FlowLayout(FlowLayout.LEFT,15,4));
		lower.setLayout(new FlowLayout(FlowLayout.LEFT,15,4));
		JLabel username = new JLabel("Username");
		JLabel password = new JLabel("Password");
		password.setPreferredSize(username.getPreferredSize());
		userText = new JTextField(11);
		pwdText = new JTextField(11);
		upper.add(username);
		upper.add(userText);
		lower.add(password);
		lower.add(pwdText);
		middlePanel.add(upper, BorderLayout.NORTH);
		middlePanel.add(lower, BorderLayout.CENTER);
		
		
	}
		
	

	public void defineLowerPanel() {
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new BorderLayout(8,8));
		JPanel upper = new JPanel();
		JPanel lower = new JPanel();
		upper.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton signin = new JButton("Sign in");
		signin.addActionListener(Control.INSTANCE.getSubmitLoginListener());
		JButton back = new JButton("Back");
		back.addActionListener(evt -> Control.INSTANCE.backToStart(this));
		upper.add(signin);
		upper.add(back);
		lower.setLayout(new FlowLayout(FlowLayout.RIGHT));
		label = new JLabel("  ");
		lower.add(label);
		lowerPanel.add(upper, BorderLayout.NORTH);
		lowerPanel.add(lower, BorderLayout.CENTER);
	}
	
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Grades");	
		centerFrameOnDesktop(this);
		setSize(320,240); 
		setResizable(false);
	}
	
	public static void centerFrameOnDesktop(Component f) {
	        final int SHIFT_AMOUNT = 0;
	        Toolkit toolkit = Toolkit.getDefaultToolkit();
	        int height = toolkit.getScreenSize().height;
	        int width  = toolkit.getScreenSize().width;
	        int frameHeight = f.getSize().height;
	        int frameWidth  = f.getSize().width;
	        f.setLocation(((width-frameWidth)/2)-SHIFT_AMOUNT, (height-frameHeight)/3);    
	    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				Login l = new Login();
				l.setVisible(true);
			}
		});
	}
	
	
}
