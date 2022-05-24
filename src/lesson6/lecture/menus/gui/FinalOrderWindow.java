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
 * Class Description: This window represents the user's final order.
 * It consists of a table that provide detailed information about
 * each of the user's selected products.
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
public class FinalOrderWindow extends JWindow implements ParentWindow {


	private Window parent;


	private final String MAIN_LABEL = "Final Order";
	private final String SUBMIT_BUTN = "Submit Order";
	private final String CANCEL_BUTN = "Cancel";
	
	private CustomTableModel model;
	private JTable table;
	private JScrollPane tablePane;
	
	
	//table
	private final boolean USE_DEFAULT_DATA = true;
		
	
   	private final String ITEM = "Item";
    private final String QUANTITY = "Quantity";
    private final String UNIT_PRICE = "Unit Price";
    private final String TOTAL = "Total Price";
	private final String[] DEFAULT_COLUMN_HEADERS = {ITEM,QUANTITY,UNIT_PRICE,TOTAL};
	private final int TABLE_WIDTH = Math.round(0.75f*GuiControl.SCREEN_WIDTH);
    private final int DEFAULT_TABLE_HEIGHT = Math.round(0.75f*GuiControl.SCREEN_HEIGHT);
    //these numbers specify relative widths of the columns -- they  must add up to 1
    private final float [] COL_WIDTH_PROPORTIONS =
    	{0.4f, 0.2f, 0.2f, 0.2f};
 
 		


	//JPanels
		
	JPanel mainPanel;
	JPanel upper, middle, lower;
	
	/**
	 * Constructor - builds the gui.
	 * 
	 */
	public FinalOrderWindow() {
		initializeWindow();
		defineMainPanel();
		getContentPane().add(mainPanel);
			
	}
	private void initializeWindow() {
		
		setSize(GuiControl.SCREEN_WIDTH,
				GuiControl.SCREEN_HEIGHT);		
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
		JButton submitButton = new JButton(SUBMIT_BUTN);
		submitButton.addActionListener(new SubmitListener());
		
		
		//back to cart button
		JButton cancelButton = new JButton(CANCEL_BUTN);
		cancelButton.addActionListener(new CancelListener());
		
		//create lower panel
		JButton [] buttons = {submitButton,cancelButton};
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
			theData = dd.getFinalOrderData();
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
						
	class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	setVisible(false);
        	String msg = "Thank You for Shopping at the Ebazaar. "+
        	             "We guarantee satisfaction and quality for our product.";
        	
        	JOptionPane.showMessageDialog(FinalOrderWindow.this,         									          
        									          msg,
        									          "E-Bazaar: Thank You", 
        									          JOptionPane.PLAIN_MESSAGE);

 
        }
	}
	class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	setVisible(false);
        	if(parent != null) {
        		parent.setVisible(true);
        	}

        }
	}
	
	public static void main(String[] args) {
		
		(new FinalOrderWindow()).setVisible(true);
	}

	private static final long serialVersionUID = 3906648600670122544L;
	
}
