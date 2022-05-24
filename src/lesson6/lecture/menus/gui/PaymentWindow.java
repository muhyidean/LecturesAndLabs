package lesson6.lecture.menus.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author klevi, pcorazza 
 * @since Oct 22, 2004
 * <p>
 * Class Description: This window provides textfields to enter
 * information for payment by credit card. If the user clicks
 * the Proceed With Checkout button, the Terms and Conditions window
 * appears before the Final Order is displayed.<p>
 * <em>Reading values from the cardTypeField combo box:</em>
 * Use the following syntax to read item selected:
 * <code>String cardTypeSelected = 
 * 		(String)cardTypeField.getSelectedItem();</code>
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
public class PaymentWindow extends JDialog implements ParentWindow {


	private Window parent;


	private final String MAIN_LABEL = "Payment Method";
	private final String PROCEED_BUTN = "Proceed With Checkout";
	private final String BACK_TO_CART_BUTN = "Back To Cart";
	
	private final String FIRST_NAME = "First Name";
	private final String LAST_NAME = "Last Name";
	private final String NAME_ON_CARD = "Name on Card";
	private final String CARD_NUMBER = "Card Number";
	private final String CARD_TYPE = "Card Type";
	private final String EXPIRATION = "Expiration Date";
	
	
	private JTextField nameOnCardField;
	private JTextField cardNumberField;
	private JComboBox cardTypeField;
	private JTextField expirationField;
	

	//JPanels
		
	JPanel mainPanel;
	JPanel upper, middle, lower;
	
	public PaymentWindow() {
		initializeWindow();
		defineMainPanel();
		getContentPane().add(mainPanel);
			
	}
	/** loads the cardTypeField combo box */
	private void loadCardTypeField() {
		String[] types = DefaultData.CARD_TYPES;
		if(cardTypeField != null) {
			for(int i = 0; i < types.length; ++i) {
				cardTypeField.addItem(types[i]);
			}
		}
		
		
	}
	private void initializeWindow() {
		
		setSize(GuiControl.SCREEN_WIDTH,
				Math.round(.7f*GuiControl.SCREEN_HEIGHT));		
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
		GridLayout gl = new GridLayout(4,2);
		gl.setHgap(8);
		gl.setVgap(8);
		gridPanel.setLayout(gl);
		gridPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));

		//add fields
		makeLabel(gridPanel,NAME_ON_CARD);
		nameOnCardField = new JTextField(10);
		gridPanel.add(nameOnCardField);		
		
		makeLabel(gridPanel,CARD_NUMBER);
		cardNumberField = new JTextField(10);
		gridPanel.add(cardNumberField);		
		
		makeLabel(gridPanel,CARD_TYPE);
		cardTypeField = new JComboBox();
		cardTypeField.setBackground(GuiControl.SCREEN_BACKGROUND);
		loadCardTypeField();
		gridPanel.add(cardTypeField);
		
		makeLabel(gridPanel,EXPIRATION);
		expirationField = new JTextField(10);
		gridPanel.add(expirationField);		
	}
	//buttons
	public void defineLowerPanel(){
		//proceed button
		JButton proceedButton = new JButton(PROCEED_BUTN);
		proceedButton.addActionListener(new ProceedListener());
		
		
		//back to cart button
		JButton backToCartButton = new JButton(BACK_TO_CART_BUTN);
		backToCartButton.addActionListener(new BackToCartListener());
		

		
		//create lower panel
		JButton [] buttons = {proceedButton,backToCartButton};
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
	class ProceedListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	setVisible(false);
        	TermsWindow t = new TermsWindow();
        	t.setParentWindow(PaymentWindow.this);
        	t.setVisible(true);
 
        }
	}
	class BackToCartListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	setVisible(false);
        	if(parent != null) {
        		parent.setVisible(true);
        	}

        }
	}
	
	public static void main(String[] args) {
		
		(new PaymentWindow()).setVisible(true);
	}

	private static final long serialVersionUID = 3689071733583786041L;
	
}
