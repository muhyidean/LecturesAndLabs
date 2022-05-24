package lesson6.lecture.menus.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author klevi, pcorazza 
 * @since Oct 22, 2004
 * <p>
 * Class Description: This class is responsible for building
 * the window for adding or editing a product. 
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
public class AddEditProduct extends JDialog implements ParentWindow {

	private Window parent;


	/** final value of label will be set in the constructor */
	private String mainLabel = " Product";
	private final String SAVE_BUTN = "Save";
	private final String BACK_BUTN = "Close";
	
	private JTextField productNameField;
	private JComboBox catalogGroupField;
	private JTextField pricePerUnitField;
	private JTextField mfgDateField;	
	private JTextField quantityField;
	
	/** group is "Books", "Clothes" etc */
	private String catalogGroup;
	
	/** value is "Add New" or "Edit" */
	private String addOrEdit = GuiControl.ADD_NEW;
	
	/** map of initial field values */
	private Properties fieldValues;
	

	//JPanels		
	JPanel mainPanel;
	JPanel upper, middle, lower;
	
	/**
	 * Constructor sets instance variables and builds gui. 
	 * @param addOrEdit - has value "add" or "edit", indicating which gui window will be built
	 * @param catalogGroup - has value "Books" or "Clothes"
	 * @param fieldValues - values to be set in data fields of gui
	 */
	public AddEditProduct(String addOrEdit, String catalogGroup, Properties fieldValues) {
		this.catalogGroup = catalogGroup;
		this.addOrEdit = addOrEdit;
		this.fieldValues = fieldValues;
		initializeWindow();
		defineMainPanel();
		getContentPane().add(mainPanel);
			
	}
	

	
	private void initializeWindow() {
		
		setSize(Math.round(.7f*GuiControl.SCREEN_WIDTH),
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
		
		JLabel mainLabel = new JLabel(finalMainLabelName());
		Font f = GuiControl.makeVeryLargeFont(mainLabel.getFont());
		f = GuiControl.makeBoldFont(f);
		mainLabel.setFont(f);
		upper.add(mainLabel);					
	}
	
	private String finalMainLabelName() {
		return addOrEdit+" "+mainLabel;
	}
	//table
	public void defineMiddlePanel(){
		middle = new JPanel();
		middle.setBackground(GuiControl.FILLER_COLOR);
		middle.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel gridPanel = new JPanel();
		gridPanel.setBackground(GuiControl.SCREEN_BACKGROUND);
		middle.add(gridPanel);
		GridLayout gl = new GridLayout(5,2);
		gl.setHgap(8);
		gl.setVgap(8);
		gridPanel.setLayout(gl);
		gridPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));


		//add fields
		String[] fldNames = DefaultData.FIELD_NAMES;
		
		String labelName = fldNames[DefaultData.PRODUCT_NAME_INT];
		makeLabel(gridPanel,labelName);
		productNameField = new JTextField(10);
		productNameField.setText(fieldValues.getProperty(labelName));
		gridPanel.add(productNameField);
		
		//catalog group is different from the other fields
		//because it plays a different role in MaintainCatalog
		//so it is set differently
		labelName = "Catalog";
		makeLabel(gridPanel,labelName);
		catalogGroupField = new JComboBox();
		catalogGroupField.addItem(DefaultData.BOOKS);
		catalogGroupField.addItem(DefaultData.CLOTHES);
		catalogGroupField.setSelectedItem(catalogGroup);
		gridPanel.add(catalogGroupField);
		
		labelName = fldNames[DefaultData.PRICE_PER_UNIT_INT];
		makeLabel(gridPanel,labelName);
		pricePerUnitField = new JTextField(10);
		pricePerUnitField.setText(fieldValues.getProperty(labelName));
		gridPanel.add(pricePerUnitField);		
		
		labelName = fldNames[DefaultData.MFG_DATE_INT];
		makeLabel(gridPanel,labelName);
		mfgDateField = new JTextField(10);
		mfgDateField.setText(fieldValues.getProperty(labelName));
		gridPanel.add(mfgDateField);
						
		labelName = fldNames[DefaultData.QUANTITY_INT];
		makeLabel(gridPanel,labelName);
		quantityField = new JTextField(10);
		quantityField.setText(fieldValues.getProperty(labelName));
		gridPanel.add(quantityField);
		

	}
	//buttons
	public void defineLowerPanel(){
		//proceed button
		JButton saveButton = new JButton(SAVE_BUTN);
		saveButton.addActionListener(new SaveListener());
		
		
		//back to cart button
		JButton backButton = new JButton(BACK_BUTN);
		backButton.addActionListener(new BackListener());
		

		
		//create lower panel
		JButton [] buttons = {saveButton,backButton};
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
	class SaveListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
				JOptionPane.showMessageDialog(AddEditProduct.this, 
										  "Need to write code for this!", 
										  "Information", 
										  JOptionPane.INFORMATION_MESSAGE); 
 
        }
	}
	class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	
        	if(parent != null) {
        		parent.setVisible(true);
        	}
        	dispose();

        }
	}
	
	public static void main(String[] args) {		
	}	
	private static final long serialVersionUID = 1L;	
}
