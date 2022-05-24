package lesson5.labs.prob3.callback.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.*;

import lesson5.labs.prob3.callback.control.Control;


@SuppressWarnings("serial")
public class Grades extends JFrame {
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	private JLabel heading;
	private JTextArea gradesData;
	public void setHeading(String s) {
		heading.setText(s);
	}
	public void setGrades(String text) {
		gradesData.setText(text);
	}
	public Grades() {
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
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		heading = new JLabel("Grades for Joe");
		heading.setForeground(Color.BLUE.darker().darker());
		heading.setFont(new Font("Tahoma", Font.BOLD, 16));
		topPanel.add(heading);
		
	}
	private void defineMiddlePanel(){
		middlePanel=new JPanel();
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		gradesData = new JTextArea(25,25);
		String text = "Joe is bad\nSo bad\nI don't know what is wrong with him";
		gradesData.setText(text);
		middlePanel.add(gradesData);
		
	}
		
	

	public void defineLowerPanel() {
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton butn = new JButton("Back to Start");
		butn.addActionListener(evt -> Control.INSTANCE.backToStart(this));
		lowerPanel.add(butn);
	}
	
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Grades");	
		centerFrameOnDesktop(this);
		setSize(400,280); 
		setResizable(false);
	}
	public static Font makeSmallFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()-2));
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
				Grades g = new Grades();
				g.setVisible(true);
			}
		});
	}
	
	
}
