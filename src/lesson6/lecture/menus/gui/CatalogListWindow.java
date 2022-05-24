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




/**
 * Class Description: This screen presents the list of all E-Bazaar
 * catalogs. As of creation date, there were just two catalogs in the 
 * default data: Books
 * and Clothes. Clicking the Browse button when one of the catalogs
 * has been selected invokes an instance
 * of ProductListWindow, displaying the available items for the selected
 * catalog.
 * Students:  See the readdata method for where data is put into the table.
 */
public class CatalogListWindow extends javax.swing.JWindow implements ParentWindow {
	
	/** Parent is used to return to main screen */
	private Window parent;
	
	//should be set to 'false' if data for table is obtained from a database
	//or some external file
	private final boolean USE_DEFAULT_DATA = true;
	
	private final String MAIN_LABEL = "Browse Catalog";
	private final String BROWSE = "Browse";
	private final String BACK_TO_MAIN = "Back To Main";
	private final int TABLE_WIDTH = Math.round(0.75f*GuiControl.SCREEN_WIDTH);
    private final int DEFAULT_TABLE_HEIGHT = Math.round(0.75f*GuiControl.SCREEN_HEIGHT);
	private final String[] DEFAULT_COLUMN_HEADERS = {"Available Catalogs"};
	
    //these numbers specify relative widths of the columns -- they  must add up to 1
    private final float [] COL_WIDTH_PROPORTIONS =
    	{1.0f};

	//JPanels
	private JPanel mainPanel;
	private JPanel upperSubpanel;
	private JPanel lowerSubpanel;
	private JPanel labelPanel;
	
	//Other widgets
	private JScrollPane tablePane;
	private JTable table;
	private CustomTableModel model;
	 
    public static CatalogListWindow instance;
    
	public static CatalogListWindow getInstance() {
		//better if it's not a singleton -- as a singleton, it
		//doesn't refresh properly
		instance=new CatalogListWindow();
		return instance;
	}
	
	private CatalogListWindow() {
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
		defineLowerPanel();
		mainPanel.add(upperSubpanel,BorderLayout.NORTH);
		mainPanel.add(lowerSubpanel,BorderLayout.SOUTH);		
	}
	
	private void defineUpperPanel() {
		upperSubpanel = new JPanel();
		upperSubpanel.setLayout(new BorderLayout());
		upperSubpanel.setBackground(GuiControl.FILLER_COLOR);
		
		//create and add label
		createMainLabel();
		upperSubpanel.add(labelPanel,BorderLayout.NORTH);
		
		//create and add table
		createTableAndTablePane();
		GuiControl.createCustomColumns(table, 
                TABLE_WIDTH,
                COL_WIDTH_PROPORTIONS,
                DEFAULT_COLUMN_HEADERS);
		
		JPanel tablePanePanel = GuiControl.createStandardTablePanePanel(table,tablePane);
	
		upperSubpanel.add(tablePanePanel,BorderLayout.CENTER);	
		
	}
	
	private void createMainLabel() {
		JLabel mainLabel = new JLabel(MAIN_LABEL);
		Font f = GuiControl.makeVeryLargeFont(mainLabel.getFont());
		f = GuiControl.makeBoldFont(f);
		mainLabel.setFont(f);
		labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		labelPanel.setBackground(GuiControl.FILLER_COLOR);
		labelPanel.add(mainLabel);		
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
			theData = DefaultData.getCatalogTypes();
        }
		updateModel(theData);
 	}	
	
	
    private void updateTable() {
        
        table.setModel(model);
        table.updateUI();
        repaint();
        
    }	

	private void defineLowerPanel() {
		 
		//browse button
		JButton browseButton = new JButton(BROWSE);
		browseButton.addActionListener(new BrowseButtonListener());
		
		
		//back button
		JButton backButton = new JButton(BACK_TO_MAIN);
		backButton.addActionListener(new BackToMainButtonListener());
		
		
		//create lower panel
		JButton [] buttons = {browseButton,backButton};
		lowerSubpanel = GuiControl.createStandardButtonPanel(buttons);		
	}
	public void setParentWindow(Window parentWindow) {
		parent = parentWindow;
	}
	
	public Window getParentWindow() {
		return parent;
	}
		
	class BrowseButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	int selectedRow = table.getSelectedRow();
        	
        	if(selectedRow >= 0) {
        		String type = (String)table.getValueAt(selectedRow,0);
        		System.out.println(type);
        		
        		setVisible(false);
        		ProductListWindow c = new ProductListWindow(type);
        		c.setParentWindow(CatalogListWindow.this);
        		c.setVisible(true);
        		
        		
        	}
        	//value of selectedRow is -1, which means no row was selected
        	else {
        		String errMsg = "Please select a row.";
        		JOptionPane.showMessageDialog(CatalogListWindow.this,         									          
        									          errMsg,
        									          "Error", 
        									          JOptionPane.ERROR_MESSAGE);

        	}
        }
	}
	
	class BackToMainButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			if(parent != null) {
				parent.setVisible(true);
			}
		    setVisible(false);			
		}
	}
	
	public static void main(String[] args) {
		CatalogListWindow.getInstance().setVisible(true);	
	}	
		

	private static final long serialVersionUID = 3258411720664953398L;
	
}