package lesson6.lecture.menus.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JWindow;

/**
 * 
 * @author klevi, pcorazza 
 * @since Oct 22, 2004
 * <p>
 * Class Description: This class displays all available products
 * for a particular catalog group. When a catalog group is selected,
 * the table is updated to display the products in this group. 
 * The screen provides Add, Edit and Delete buttons for modifying
 * the choices of products.
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
 * <tr>
 * 		<td>Jan 19, 2005</td>
 *      <td>klevi</td>
 *      <td>modifed the readdata comments</td>
 * </tr>
 * </table>
 *
 */
public class MaintainProductCatalog extends JWindow implements ParentWindow {
	private Window parent;
	CustomTableModel model;
	JTable table;
	JScrollPane tablePane;
	
	//JPanels
	JPanel mainPanel;
	JPanel upper, middle, comboPanel, lower;
	
	//widgets
	JComboBox catalogTypeCombo;	
	
	//catalog type (books, clothes, etc); set default to Books
	String catalogType = DefaultData.BOOKS;
	
	//constants
	private final boolean USE_DEFAULT_DATA = true;

    private final String NAME = "Name";
    private final String PRICE = "Unit Price";
    private final String MFG_DATE = "Mfg. Date";
    private final String QUANTITIES = "Quantities";
    
    private final String MAIN_LABEL = "Maintain Product Catalog";
    
    //widget labels
    private final String CAT_GROUPS = "Catalog Groups";
    private final String ADD_BUTN = "Add";
    private final String EDIT_BUTN = "Edit";
    private final String DELETE_BUTN = "Delete";
    private final String SEARCH_BUTN = "Search";
    private final String BACK_TO_MAIN = "Back to Main";
    
    
    //table config
	private final String[] DEFAULT_COLUMN_HEADERS = {NAME,PRICE,MFG_DATE,QUANTITIES};
	private final int TABLE_WIDTH = GuiControl.SCREEN_WIDTH;
    private final int DEFAULT_TABLE_HEIGHT = Math.round(0.75f*GuiControl.SCREEN_HEIGHT);

    //these numbers specify relative widths of the columns -- they  must add up to 1
    private final float [] COL_WIDTH_PROPORTIONS =
    	{0.4f, 0.2f, 0.2f, 0.2f};

    	
    	
	public MaintainProductCatalog() {
		initializeWindow();
		defineMainPanel();
		getContentPane().add(mainPanel);
		
		
			
	}
	private void initializeWindow() {
		
		setSize(GuiControl.SCREEN_WIDTH,GuiControl.SCREEN_HEIGHT);		
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
	

	//middle -- table and combo box
	public void defineMiddlePanel(){
		
		middle = new JPanel();
		middle.setLayout(new BorderLayout());
		
		defineComboPanel();
		middle.add(comboPanel,BorderLayout.NORTH);
		
		//table
		createTableAndTablePane();
		GuiControl.createCustomColumns(table, 
		                               TABLE_WIDTH,
		                               COL_WIDTH_PROPORTIONS,
		                               DEFAULT_COLUMN_HEADERS);
		                   		
		middle.add(GuiControl.createStandardTablePanePanel(table,tablePane),
				   BorderLayout.CENTER);
				
	}
	
	//upper middle -- the combo panel
	public void defineComboPanel() {
		comboPanel = new JPanel();
		comboPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//label
		JLabel comboLabel = new JLabel(CAT_GROUPS);
		comboPanel.add(comboLabel);
		
		//combo box
		catalogTypeCombo = new JComboBox();
		catalogTypeCombo.addItem(DefaultData.BOOKS);
		catalogTypeCombo.addItem(DefaultData.CLOTHES);
		catalogTypeCombo.addActionListener(new ComboBoxListener());
		comboPanel.add(catalogTypeCombo);

		
	}	
	
	//buttons
	public void defineLowerPanel(){
		//add button
		JButton addButton = new JButton(ADD_BUTN);
		addButton.addActionListener(new AddButtonListener());
		
		
		//edit button
		JButton editButton = new JButton(EDIT_BUTN);
		editButton.addActionListener(new EditButtonListener());
		
		//delete button
		JButton deleteButton = new JButton(DELETE_BUTN);
		deleteButton.addActionListener(new DeleteButtonListener());
		
		//search button
		JButton searchButton = new JButton(SEARCH_BUTN);
		searchButton.addActionListener(new SearchButtonListener());
		searchButton.setEnabled(false);
		
		//exit button
		JButton backToMainButton = new JButton(BACK_TO_MAIN);
		backToMainButton.addActionListener(new BackToMainButtonListener());		
		
		//create lower panel
		JButton [] buttons = {addButton,editButton,deleteButton,searchButton,backToMainButton};
		lower = GuiControl.createStandardButtonPanel(buttons);		
	}
	
	private void createTableAndTablePane() {
		updateModel();
		table = new JTable(model);
		tablePane = new JScrollPane();
		tablePane.setPreferredSize(new Dimension(TABLE_WIDTH, DEFAULT_TABLE_HEIGHT));
		tablePane.getViewport().add(table);
		
	}
	
	public void updateModel(List<String[]> list){
	    model = new CustomTableModel();
		model.setTableValues(list);		
	}
	
	/**
	 * If default data is being used, this method obtains it
	 * and then passes it to updateModel(List). If real data is
	 * being used, the public updateModel(List) should be called by
	 * the controller class.
	 */
	private void updateModel() {
		List<String[]> theData = new ArrayList<String[]>();
        if(USE_DEFAULT_DATA) {
			DefaultData dd = DefaultData.getInstance();
			theData = dd.getProductCatalogChoices(catalogType);
        }
		updateModel(theData);
 	}	

	
    private void updateTable() {
        
        table.setModel(model);
        table.updateUI();
        repaint();
        
    }	
	
	public void setParentWindow(Window parentWindow) {
		parent = parentWindow;
	}
	
	public Window getParentWindow() {
		return parent;
	}
	
	//data for Listeners
	
	final String ERROR_MESSAGE = "Please select a row.";
	final String ERROR = "Error";
	
	class ComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			catalogType = (String)catalogTypeCombo.getSelectedItem();
			updateModel();
			updateTable();
		}
	}
	class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	
       		//no field values need to be passed into AddEditProduct when adding a new product
       		//so we create an empty Properties instance
        	Properties emptyProductInfo = new Properties();
        		
        	AddEditProduct addProd = new AddEditProduct(GuiControl.ADD_NEW,catalogType, emptyProductInfo);
        	setVisible(false);
        	addProd.setParentWindow(MaintainProductCatalog.this);
        	addProd.setVisible(true);
        	
        }        	
 
	}
	
	
	class EditButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	
        	int selectedRow = table.getSelectedRow();
        	if(selectedRow >= 0) {
        		String[] fldNames = DefaultData.FIELD_NAMES;
        		Properties productInfo = new Properties();
        		
        		//index for Product Name
        		int columnIndex = DefaultData.PRODUCT_NAME_INT;
        		productInfo.setProperty(fldNames[columnIndex],
        								(String)model.getValueAt(selectedRow,columnIndex));
        								
         		//index for Price Per Unit
        		columnIndex = DefaultData.PRICE_PER_UNIT_INT;
        		productInfo.setProperty(fldNames[columnIndex],
        								(String)model.getValueAt(selectedRow,columnIndex));
        								       								
        		//index for Mfg Date
        		columnIndex = DefaultData.MFG_DATE_INT;
        		productInfo.setProperty(fldNames[columnIndex],
        								(String)model.getValueAt(selectedRow,columnIndex));
        								        								       								
        		//index for Quantity						
        		columnIndex = DefaultData.QUANTITY_INT;					
         		productInfo.setProperty(fldNames[columnIndex],
        								(String)model.getValueAt(selectedRow,columnIndex));
        								       														
        		AddEditProduct editProd = new AddEditProduct(GuiControl.EDIT,catalogType, productInfo);
        		editProd.setVisible(true);
        		
        		
        	}
        	else {
       			JOptionPane.showMessageDialog(MaintainProductCatalog.this,         									          
        									  ERROR_MESSAGE,
        									  ERROR, 
        									  JOptionPane.ERROR_MESSAGE);
        		
        	}
        		

        }
	}
	class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	int selectedRow = table.getSelectedRow();
        	if(selectedRow >= 0) {
 				// Students: code goes here.
        		
				JOptionPane.showMessageDialog(MaintainProductCatalog.this, 
										  "Need to write code for this!", 
										  "Information", 
										  JOptionPane.INFORMATION_MESSAGE);        		
        		
        	}
        	else {
       			JOptionPane.showMessageDialog(MaintainProductCatalog.this,         									          
        									  ERROR_MESSAGE,
        									  ERROR, 
        									  JOptionPane.ERROR_MESSAGE);
        		
        	}        	
        	

        }
	}	
	
	class SearchButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	//Students: code goes here
        	

        }
	}
	class BackToMainButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			if(parent != null) {
				parent.setVisible(true);
			}
		    dispose();		
		}
	}			
	
	public static void main(String[] args) {
		(new MaintainProductCatalog()).setVisible(true);
	}	
	private static final long serialVersionUID = 3257569511937880631L;
	
}
