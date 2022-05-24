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

import javax.swing.JButton;
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
 * Class Description: This class displays a list of all the
 * customer's addresses on record (on initial creation, just
 * one address is displayed, from fake data in DefaultData).
 * This class is invoked by ShippingBillingWindow as a means
 * to fill in the shipping address on its screen.  
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
public class ShipAddressesWindow extends JWindow implements ParentWindow {
	private Window parent;
	private ShippingBillingWindow shipBillWindow;
	CustomTableModel model;
	JTable table;
	JScrollPane tablePane;
	
	//JPanels
	JPanel mainPanel;
	JPanel upper, middle, lower;
	
	//constants
	private final boolean USE_DEFAULT_DATA = true;

    private final String STREET = "Street";
    private final String CITY = "City";
    private final String STATE = "State";
    private final String ZIP = "ZIP";
    private final String MAIN_LABEL = "Shipping Addresses";
    
    //button labels
    private final String SELECT_BUTN = "Select";
    private final String CANCEL = "Cancel";
    
    
    //table config
	private final String[] DEFAULT_COLUMN_HEADERS = {STREET,CITY,STATE, ZIP};
	private final int TABLE_WIDTH = Math.round(0.75f*GuiControl.SCREEN_WIDTH);
    private final int DEFAULT_TABLE_HEIGHT = Math.round(0.75f*GuiControl.SCREEN_HEIGHT);

    //these numbers specify relative widths of the columns -- they  must add up to 1
    private final float [] COL_WIDTH_PROPORTIONS =
    	{0.4f, 0.2f, 0.2f, 0.2f};

    	
    	
	public ShipAddressesWindow(ShippingBillingWindow s) {
		shipBillWindow = s;
		initializeWindow();
		defineMainPanel();
		getContentPane().add(mainPanel);
		
		
			
	}
	private void initializeWindow() {
		
		setSize(GuiControl.SCREEN_WIDTH,
				Math.round(GuiControl.SCREEN_HEIGHT));		
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
		createTableAndTablePane();
		GuiControl.createCustomColumns(table, 
		                               TABLE_WIDTH,
		                               COL_WIDTH_PROPORTIONS,
		                               DEFAULT_COLUMN_HEADERS);
		                   		
		middle = GuiControl.createStandardTablePanePanel(table,tablePane);
				
	}
	//buttons
	public void defineLowerPanel(){
		//proceed button
		JButton selectButton = new JButton(SELECT_BUTN);
		selectButton.addActionListener(new SelectListener());
		
		
		//continue button
		JButton cancelButton = new JButton(CANCEL);
		cancelButton.addActionListener(new CancelListener());
		
		
		//create lower panel
		JButton [] buttons = {selectButton,cancelButton};
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
		if(model == null) {
	        model = new CustomTableModel();
    	    
		}
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
			theData = dd.getShipAddresses();
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
	
	
	final String ERROR_MESSAGE = "Please select a row.";
	final String ERROR = "Error";
		

	class SelectListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
         	
        	int selectedRow = table.getSelectedRow();
        	if(selectedRow >= 0) {
        		setVisible(false);
        		if(parent instanceof ShippingBillingWindow && shipBillWindow != null) {
	        		
	        		 
	        		shipBillWindow.setShippingAddress(null,
	        										  (String)model.getValueAt(selectedRow,DefaultData.STREET_INT),
	        										  (String)model.getValueAt(selectedRow,DefaultData.CITY_INT),
	        										  (String)model.getValueAt(selectedRow,DefaultData.STATE_INT),
	        										  (String)model.getValueAt(selectedRow,DefaultData.ZIP_INT));
					shipBillWindow.setVisible(true);	        										  
        		}
   		
        	}
        	else {
       			JOptionPane.showMessageDialog(ShipAddressesWindow.this,         									          
        									  ERROR_MESSAGE,
        									  ERROR, 
        									  JOptionPane.ERROR_MESSAGE);
        		
        	}       	

        }
	}
	class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	if(parent != null) {
	        	parent.setVisible(true);
        	}
        	dispose();

        }
	}
	

	private static final long serialVersionUID = 3256442521008944436L;

}
