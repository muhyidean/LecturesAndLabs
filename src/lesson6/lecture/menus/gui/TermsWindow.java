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
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 
 * @author klevi, pcorazza 
 * @since Oct 22, 2004
 * <p>
 * Class Description: The TermsWindow class displays the terms
 * under which products are sold and shipped. The implementation
 * is a TextArea widget containing the terms information.
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
 *  <tr>
 * 		<td>Oct 26, 2004</td>
 *      <td>pcorazza</td>
 *      <td>Made the TextArea object non-modifiable.</td>
 * </tr>
 * </table>
 *
 */
public class TermsWindow extends JDialog implements ParentWindow {
	private Window parent;


	private final String MAIN_LABEL = "Terms and Conditions";
	private final String PROCEED_BUTN = "Accept Terms And Conditions";
	private final String EXIT_BUTN = "Exit E-Bazaar";
	private final String TERMS_MESSAGE = "Any Items purchased from this site adhere to the terms and "+
										  "conditions depicted in this document. You will have to accecpt "+
										  "the Terms and Conditions depicted here inorder to purchase " +
										  "anything from this site.";
	
	
	
	private JTextArea termsText;
	
	

	//JPanels
		
	JPanel mainPanel;
	JPanel upper, middle, lower;
	public TermsWindow() {
		initializeWindow();
		defineMainPanel();
		getContentPane().add(mainPanel);
		
			
	}
	private void initializeWindow() {
		setTitle("Terms and Conditions");
		setSize(GuiControl.SCREEN_WIDTH,
				Math.round(.6f*GuiControl.SCREEN_HEIGHT));		
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
		GridLayout gl = new GridLayout(1,1);
		gridPanel.setLayout(gl);
		gridPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));

		//add text area
		termsText = new JTextArea(8,30);
		termsText.setBackground(GuiControl.SCREEN_BACKGROUND);
		termsText.setFont(GuiControl.makeDialogFont(termsText.getFont()));
		termsText.setText(TERMS_MESSAGE);
		termsText.setLineWrap(true);
		termsText.setWrapStyleWord(true);
		termsText.setEditable(false);
		gridPanel.add(termsText);
	}
	
	//buttons
	public void defineLowerPanel(){
		//proceed button
		JButton proceedButton = new JButton(PROCEED_BUTN);
		proceedButton.addActionListener(new ProceedListener());
		
		
		//back to cart button
		JButton backToCartButton = new JButton(EXIT_BUTN);
		backToCartButton.addActionListener(new ExitButtonListener(this));
		
		//create lower panel
		JButton [] buttons = {proceedButton,backToCartButton};
		lower = GuiControl.createStandardButtonPanel(buttons);
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
        	FinalOrderWindow f = new FinalOrderWindow();
        	f.setParentWindow(TermsWindow.this);
        	f.setVisible(true);
 
        }
	}

	
	public static void main(String[] args) {
		
		(new TermsWindow()).setVisible(true);
	}		


	private static final long serialVersionUID = 3258412811485853745L;

}
