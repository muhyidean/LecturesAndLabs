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
import lesson5.labs.prob3.callback.ui.*;

public class Start extends JFrame {
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	private JLabel label;
	private JLabel messageBar;
	public void setMessage(String s) {
		messageBar.setText(s);
	}
	public Start() {
		Control.INSTANCE.setStart(this);
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
		label = new JLabel("Options");
		label.setForeground(Color.BLUE.darker().darker());
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		topPanel.add(label);
		
	}
	private void defineMiddlePanel(){
		middlePanel=new JPanel();
		middlePanel.setLayout(new BorderLayout(8,8));
		JPanel upper = new JPanel();
		JPanel lower = new JPanel();
		upper.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 8));
		lower.setLayout(new FlowLayout(FlowLayout.LEFT, 8 , 8));
		JButton login = new JButton("Log In");
		JButton logout = new JButton("Log Out");
		JButton gradeReport = new JButton("Grade Report");
		JButton teacherRmks = new JButton("Teacher Remarks");
		login.setPreferredSize(teacherRmks.getPreferredSize());
		logout.setPreferredSize(teacherRmks.getPreferredSize());
		gradeReport.setPreferredSize(teacherRmks.getPreferredSize());
		logout.addActionListener(evt -> messageBar.setText("Logout successful"));
		login.addActionListener(Control.INSTANCE.getLoginListener());
		gradeReport.addActionListener(Control.INSTANCE.getGradesListener());
		teacherRmks.addActionListener(Control.INSTANCE.getRemarksListener());
		upper.add(login);
		upper.add(logout);
		lower.add(gradeReport);
		lower.add(teacherRmks);
		middlePanel.add(upper, BorderLayout.NORTH);
		middlePanel.add(lower, BorderLayout.CENTER);
		
		
	}
		
	

	public void defineLowerPanel() {
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 8,8));
		messageBar = new JLabel("  ");
		lowerPanel.add(messageBar);

	}
	
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Grades");	
		centerFrameOnDesktop(this);
		setSize(320,220); 
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
				Start st = new Start();
				st.setVisible(true);
			}
		});
	}
}
