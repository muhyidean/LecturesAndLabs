package lesson6.lecture.menus.gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.Box;
/**
 * 
 * @author klevi, pcorazza 
 * @since Oct 22, 2004
 * <p>
 * Class Description: This is a factory class that provides utilities
 * for creating various screen elements in a standardized way. Also,
 * all screen element constants, like color names and screen sizes,
 * are stored here. 
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
public class GuiControl {
	private static GuiControl control;
	
	private GuiControl() {
	}
	
	public static GuiControl getInstance() {
		if(control == null) {
			control = new GuiControl();
		}
		return control;
	}
	
	//location of files
	/** CURR_DIR is the current working directory, which is the directory of this project*/
	public static final String CURR_DIR = System.getProperty("user.dir");
	
	//if you do not use a "src" folder for source code, change the line below to this:
	//public static final String SPLASH_IMAGE = CURR_DIR+"\\src\\images\\logo.jpg";
	public static final String SPLASH_IMAGE = CURR_DIR+"\\src\\lesson6\\lecture\\menus\\gui\\logo.jpg";
	static {
		System.out.println(SPLASH_IMAGE);
	}
	public static int SCREEN_WIDTH = 640;
	public static int SCREEN_HEIGHT = 480;
	
	private static final int BOX_HEIGHT = 3;
	private static final int BOX_WIDTH = 3;
	
	public static final String EXIT_BUTN = "Exit E-Bazaar";
	
	public static final String ADD_NEW = "Add New";
	public static final String EDIT = "Edit";
	
	//pattern for formatting decimals so that they show only 2 decimal places
	public static final String DECIMAL_PATTERN = "0.00;-0.00";

	

	
	//colors
	//public static Color BROWN = new Color(0x9a7c46);
	//public static Color PALE_YELLOW = new Color(0xffface);
	//public static Color FAINT_YELLOW = new Color(0xffffe0);
	public static Color DARK_BLUE = Color.blue.darker();
	public static Color LIGHT_BLUE = new Color(0xf2ffff);
	public static Color DARK_GRAY = new Color(0xcccccc);
    public static Color APRICOT = new Color(0xfff2a9);
	
	public static Color MAIN_SCREEN_COLOR = LIGHT_BLUE;
	public static Color TABLE_BACKGROUND= LIGHT_BLUE;
	public static Color TABLE_PANE_BACKGROUND= LIGHT_BLUE;
	public static Color SCREEN_BACKGROUND = LIGHT_BLUE;
    public static Color QUANTITY_SCREEN_BGRND = APRICOT;
    public static Color QUANTITY_SCREEN_TEXT = DARK_BLUE;
	public static Color TABLE_HEADER_FOREGROUND = LIGHT_BLUE;
	public static Color TABLE_HEADER_BACKGROUND = DARK_BLUE;
	public static Color WINDOW_BORDER = DARK_BLUE;
	public static Color FILLER_COLOR = Color.white;
	
    public static void centerFrameOnDesktop(Component f) {
        final int SHIFT_AMOUNT = 0;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int height = toolkit.getScreenSize().height;
        int width  = toolkit.getScreenSize().width;
        int frameHeight = f.getSize().height;
        int frameWidth  = f.getSize().width;
        f.setLocation(((width-frameWidth)/2)-SHIFT_AMOUNT, (height-frameHeight)/3);    
    }
    
 	public static Font makeSmallFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()-2));
    }
    
    public static Font makeLargeFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()+2));
    }
    public static Font makeVeryLargeFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()+4));
    }
    
    public static Font makeBoldFont(Font f) {
        return new Font(f.getName(), Font.BOLD, f.getSize());
    }
    
    public static Font makeDialogFont(Font f) {
    	return new Font("Dialog", f.getStyle(), f.getSize());
    }
    
    public static JPanel createStandardTablePanePanel(JTable table, JScrollPane tablePane){
    	//configure header
        JTableHeader header = table.getTableHeader();
        header.setBackground(TABLE_HEADER_BACKGROUND);
        header.setForeground(TABLE_HEADER_FOREGROUND);
        Font f = header.getFont();
        f = GuiControl.makeBoldFont(f);
        header.setFont(f);        
        table.setTableHeader(header);  
        
        //set colors
		tablePane.getViewport().setBackground(TABLE_PANE_BACKGROUND);
		tablePane.setBorder(new WindowBorder(WINDOW_BORDER));
		table.setBackground(TABLE_BACKGROUND);
		
		//place inside a JPanel and return	
		JPanel tablePanePanel = new JPanel();
    	tablePanePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		tablePanePanel.add(tablePane);
		tablePanePanel.setBackground(FILLER_COLOR);
		
		return tablePanePanel;
    
    }
	/** table must be non-null. columnProportions is an array of fractions whose sum is 1 */    
    public static void createCustomColumns(JTable table, 
                                             int tableWidth, 
                                             float[] columnProportions,
                                             String[] columnHeaders) {
    
        table.setAutoCreateColumnsFromModel(false);
        int num = columnHeaders.length;
        for(int i = 0; i < num; ++i) {
            TableColumn column = new TableColumn(i);
            column.setHeaderValue(columnHeaders[i]);
            column.setMinWidth(Math.round(columnProportions[i]*tableWidth));
            table.addColumn(column);
        }
    }	
    
    	
	public static Box.Filler createVBrick(int numStackedVertically){
        int height = BOX_HEIGHT * numStackedVertically;
        Dimension d = new Dimension(BOX_WIDTH, height);
        return new Box.Filler(d,d,d);
    }
    public static Box.Filler createHBrick(int numStackedHorizontally) {
        int width = BOX_WIDTH * numStackedHorizontally;
        Dimension d = new Dimension(width, BOX_HEIGHT);
        return new Box.Filler(d,d,d);
    }    
    
    public static JPanel createStandardButtonPanel(JButton[] buttons) {
    	
    	
    	JPanel buttonPanel = new JPanel();
    	
    	buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));	
    	buttonPanel.setBackground(FILLER_COLOR);
    	if(buttons != null && buttons.length>0) {
    		for(int i = 0; i < buttons.length; ++i) {
    			buttonPanel.add(buttons[i]);	
    		}
    	}
    	return buttonPanel;
    	
    }
    public static JPanel createStandardButtonPanel(JButton[] buttons, Color backgroundColor) {
        
        
        JPanel buttonPanel = new JPanel();
        
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));   
        buttonPanel.setBackground(backgroundColor);
        if(buttons != null && buttons.length>0) {
            for(int i = 0; i < buttons.length; ++i) {
                buttonPanel.add(buttons[i]);    
            }
        }
        return buttonPanel;
        
    }    
    
    /** This method rounds decimals to two places. Return value is a BigDecimal.
     *  An alternative approach (see other method) is to return a String, obtained by creating
     *  an instance of DecimalFormat.
     * @param args
     * 
     */
    public static BigDecimal formatDouble(Double d) {
    	BigDecimal bd = new BigDecimal(d.doubleValue());
    	return bd.setScale(2,BigDecimal.ROUND_HALF_UP);
    }
    
    /**
     * This method converts a Double to a String, displaying
     * the Double so that it is truncated to 2 decimal places.
     * Should be used for presentation purposes
     */
    public static String formatDoubleToString(Double d) {
    	DecimalFormat p = new DecimalFormat(DECIMAL_PATTERN);
    	return p.format(d);
    
    }
    
    public static void main(String [] args) {
    	System.out.println(System.getProperty("user.dir"));	
    }	

}
