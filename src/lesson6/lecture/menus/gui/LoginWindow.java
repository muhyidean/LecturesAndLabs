package lesson6.lecture.menus.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//import LoginControl;

/**
 * 
 * @author klevi, pcorazza 
 * @since Oct 22, 2004
 * <p>
 * Class Description: This window provides textfields to enter
 * information for payment by credit card. If the user clicks
 * the Proceed With Checkout button, the Terms and Conditions window
 * appears before the Final Order is displayed.
 * <p>
 * <table border="1">
 * <tr>
 * 		<th colspan="3">Change Log</th>
 * </tr>
 * <tr>
 * 		<th>Date</th> <th>Author</th> <th>Change</th>
 * </tr>
 * <tr>
 * 		<td>Oct 22, 2004</td>
 *      <td>klevi, pcorazza</td>
 *      <td>New class file</td>
 * </tr>
 * </table>
 *
 */
public class LoginWindow extends JDialog implements ParentWindow {
	private Window parent;
	private final String MAIN_LABEL = "Login";
	private final String SUBMIT_BUTN = "Submit";
	private final String CANCEL_BUTN = "Cancel";
	
	private final String CUST_ID = "Customer Id";
	private final String PASSWORD = "Password";

	
	private JTextField custIdField;
	private JPasswordField pwdField;
	

	//JPanels
		
	JPanel mainPanel;
	JPanel upper, middle, lower;
	
	public LoginWindow() {
		initializeWindow();
		defineMainPanel();
		getContentPane().add(mainPanel);
			
	}
	private void initializeWindow() {
		
		setSize(Math.round(.7f*GuiControl.SCREEN_WIDTH),
				Math.round(.4f*GuiControl.SCREEN_HEIGHT));		
		GuiControl.centerFrameOnDesktop(this);
		
	}
	
	private void defineMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(GuiControl.FILLER_COLOR);
		mainPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));
		defineUpperPanel();
		defineMiddlePanel();
		defineLowerPanel();
		mainPanel.add(upper,BorderLayout.NORTH);
		mainPanel.add(middle,BorderLayout.CENTER);
		mainPanel.add(lower,BorderLayout.SOUTH);
			
	}
	//label
	public void defineUpperPanel(){
		upper = new JPanel();
		upper.setBackground(GuiControl.FILLER_COLOR);
		upper.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel mainLabel = new JLabel(MAIN_LABEL);
		Font f = GuiControl.makeVeryLargeFont(mainLabel.getFont());
		f = GuiControl.makeBoldFont(f);
		mainLabel.setFont(f);
		upper.add(mainLabel);					
	}
	//table
	public void defineMiddlePanel(){
		middle = new JPanel();
		middle.setBackground(GuiControl.FILLER_COLOR);
		middle.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel gridPanel = new JPanel();
		gridPanel.setBackground(GuiControl.SCREEN_BACKGROUND);
		middle.add(gridPanel);
		GridLayout gl = new GridLayout(2,2);
		gl.setHgap(8);
		gl.setVgap(8);
		gridPanel.setLayout(gl);
		gridPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));



		//add fields
		makeLabel(gridPanel,CUST_ID);
		custIdField = new JTextField(10);
		gridPanel.add(custIdField);
		
		makeLabel(gridPanel,PASSWORD);
		pwdField = new JPasswordField(10);
		gridPanel.add(pwdField);
		
				
	}
	//buttons
	public void defineLowerPanel(){
		//submit button
		JButton submitButton = new JButton(SUBMIT_BUTN);
		submitButton.addActionListener(new SubmitListener());
		
		
		//cancel button
		JButton cancelButton = new JButton(CANCEL_BUTN);
		cancelButton.addActionListener(new CancelListener());
		

		
		//create lower panel
		JButton [] buttons = {submitButton,cancelButton};
		lower = GuiControl.createStandardButtonPanel(buttons);
	}
	
	private void makeLabel(JPanel p, String s) {
		JLabel l = new JLabel(s);
		p.add(leftPaddedPanel(l));
	}
	private JPanel leftPaddedPanel(JLabel label) {
		JPanel paddedPanel = new JPanel();
		paddedPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		paddedPanel.add(GuiControl.createHBrick(1));
		paddedPanel.add(label);
		paddedPanel.setBackground(GuiControl.SCREEN_BACKGROUND);
		return paddedPanel;		
	}

	public void setParentWindow(Window parentWindow) {
		parent = parentWindow;
	}
	
	public Window getParentWindow() {
		return parent;
	}					
	class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	setVisible(false);
        	String id = custIdField.getText();
        	char[] pwdAsChars = pwdField.getPassword();
			String pwd = new String(pwdAsChars);
			System.out.println(pwd);
        	
        	//revise this 
        	boolean authenticated = true;
        	
        	//LoginControl control = new LoginControl();
        	//boolean authenticated = control.authenticate(id,pwd);
        	if(authenticated) {
        	    dispose();
        	}
        	else {
        		String errMsg = "Login failed.";
        		JOptionPane.showMessageDialog(LoginWindow.this,         									          
        									          errMsg,
        									          "Error", 
        									          JOptionPane.ERROR_MESSAGE);

        	}
        	
             	    
        	
        }
	}
	class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	
        	if(parent != null) {
        		parent.setVisible(true);
        	}
        	LoginWindow.this.dispose();

        }
	}
	
	public static void main(String[] args) {
		
		(new LoginWindow()).setVisible(true);
	}

	private static final long serialVersionUID = 3258408422029144633L;
	
}
