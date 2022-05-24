package lesson6.lecture.menus.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JWindow;

/**
 * 
 * @author klevi, pcorazza 
 * @since Oct 22, 2004
 * <p>
 * Class Description: This class provides detailed information
 * about a selected product. When the user clicks the Browse button
 * on the ProductListWindow screen, the product details for the selected
 * product appear on this screen. In this screen the user has the option
 * to add the product, whose detailed description is given here, to
 * the shopping cart (and if this option is chosen, the CartItemsWindow
 * is invoked).
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
public class ProductDetailsWindow extends JWindow implements ParentWindow {
	//////////////constants
	private final String MAIN_LABEL = "Product Details";
	private final String ITEM = "Item:";
	private final String PRICE = "Price:";
	private final String QUANTITY = "Quantity Available:";
	private final String REVIEW = "Review:";
	
	private final String ADD_TO_CART = "Add To Cart";
	private final String BACK_TO_CATALOG = "Back To Catalog";
	
	private String item;
	private double price;
	private int quantity;
	private String review;
	
	private Window parent;
	//JPanels
	private JPanel mainPanel;
	private JPanel upperSubpanel;
	private JPanel middleSubpanel;
	private JPanel lowerSubpanel;	

	public ProductDetailsWindow(String[] params) {
		if(params != null && params.length >= 4) {
			item = params[0];
			price = (new Double(params[1])).doubleValue();
			quantity = (new Integer(params[2])).intValue();
			review = params[3];
		}
		
		initializeWindow();
		defineMainPanel();
		getContentPane().add(mainPanel);
		
		//pack();
			
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
		mainPanel.add(upperSubpanel,BorderLayout.NORTH);
		mainPanel.add(middleSubpanel,BorderLayout.CENTER);
		mainPanel.add(lowerSubpanel,BorderLayout.SOUTH);
			
	}
	private JPanel leftPaddedPanel(JLabel label) {
		JPanel paddedPanel = new JPanel();
		paddedPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		paddedPanel.add(GuiControl.createHBrick(1));
		paddedPanel.add(label);
		paddedPanel.setBackground(GuiControl.SCREEN_BACKGROUND);
		return paddedPanel;		
	}

		
	
	
	private void defineUpperPanel() {
		upperSubpanel = new JPanel();
		upperSubpanel.setBackground(GuiControl.FILLER_COLOR);
		upperSubpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel mainLabel = new JLabel(MAIN_LABEL);
		Font f = GuiControl.makeVeryLargeFont(mainLabel.getFont());
		f = GuiControl.makeBoldFont(f);
		mainLabel.setFont(f);
		upperSubpanel.add(mainLabel);		
	}
	private void defineMiddlePanel() {		
		middleSubpanel = new JPanel();
		
		middleSubpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		middleSubpanel.setBackground(GuiControl.FILLER_COLOR);
		JPanel gridPanel = new JPanel();
		gridPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));
		gridPanel.setBackground(GuiControl.SCREEN_BACKGROUND);
		
		GridLayout gl = new GridLayout(4,2);
		gl.setHgap(1);
		gridPanel.setLayout(gl);
		
		middleSubpanel.add(gridPanel);
		
		JPanel paddedPanel = null;
		
		//load up the gridPanel
		JLabel itemLabel = new JLabel(ITEM);
		paddedPanel = leftPaddedPanel(itemLabel);
		gridPanel.add(paddedPanel);
		
		
		JTextArea itemValue = new JTextArea(3,20);
		itemValue.setText(item);
		itemValue.setBackground(GuiControl.SCREEN_BACKGROUND);
		gridPanel.add(itemValue);				
		
		JLabel priceLabel = new JLabel(PRICE);
		paddedPanel = leftPaddedPanel(priceLabel);
		gridPanel.add(paddedPanel);
		

		JTextArea priceValue = new JTextArea(3,20);
		priceValue.setText((new Double(price)).toString());
		priceValue.setBackground(GuiControl.SCREEN_BACKGROUND);
		gridPanel.add(priceValue);		
		
		JLabel quantityLabel = new JLabel(QUANTITY);
		paddedPanel = leftPaddedPanel(quantityLabel);
		gridPanel.add(paddedPanel);
		
		JTextArea quantityValue = new JTextArea(3,20);
		quantityValue.setText((new Integer(quantity)).toString());
		quantityValue.setBackground(GuiControl.SCREEN_BACKGROUND);
		gridPanel.add(quantityValue);
		
		JLabel reviewLabel = new JLabel(REVIEW);
		paddedPanel = leftPaddedPanel(reviewLabel);
		gridPanel.add(paddedPanel);
		
		
		JTextArea reviewValue = new JTextArea(3,20);
		reviewValue.setLineWrap(true);
		reviewValue.setWrapStyleWord(true);		
		reviewValue.setText(review);
		reviewValue.setBackground(GuiControl.SCREEN_BACKGROUND);
		gridPanel.add(reviewValue);
		
		
		
		
	}
	private void defineLowerPanel() {
		//browse button
        
		JButton addToCardButton = new JButton(ADD_TO_CART);
		addToCardButton.addActionListener(new AddToCartListener());
		
		
		//back button
		JButton backToCatalogButton = new JButton(BACK_TO_CATALOG);
		backToCatalogButton.addActionListener(new BackToCatalogListener());
		
		
		//create lower panel
		JButton [] buttons = {addToCardButton,backToCatalogButton};
		lowerSubpanel = GuiControl.createStandardButtonPanel(buttons);
        
				
	}	
	public void setParentWindow(Window parentWindow) {
		parent = parentWindow;
	}
	
	public Window getParentWindow() {
		return parent;
	}
	
	class AddToCartListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	setVisible(false);
            QuantityWindow win = new QuantityWindow();
        	//CartItemsWindow win = new CartItemsWindow();
        	win.setVisible(true);
        	win.setParentWindow(ProductDetailsWindow.this);

        }
	}
	
	class BackToCatalogListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ParentWindow pw = ((ParentWindow)getParentWindow());
			if(pw != null){
			    pw.setVisible(true);
			}
		    setVisible(false);			
		}
	}
	
	public static void main(String[] args) {
		String[] params = {"Pants","20.00","5","The best!"};
		
		ProductDetailsWindow pd = new ProductDetailsWindow(params);
		
		pd.setVisible(true);
	}

	private static final long serialVersionUID = 3904678297307919673L;
	
}
