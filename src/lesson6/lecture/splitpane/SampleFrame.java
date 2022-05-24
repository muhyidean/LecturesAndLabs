package lesson6.lecture.splitpane;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;


import java.awt.FlowLayout;
import java.util.ArrayList;

/**
 * This sample code illustrate several Swing techniques:
 * 
 * 1. Use of split panes
 * 2. Using the CardLayout to switch the view to different panels in the same space
 * 3. Using a JList to control the CardLayout
 * 
 * 
 * @author corazza
 *
 */
public class SampleFrame extends JFrame {
	
	String[] links;
	JList<String> linkList;
	//context for CardLayout
	JPanel cards;
	JPanel buttonBar;

	public SampleFrame() {

		setSize(300, 200);
		
		String[] items = {"Item 1", "Item 2", "Item 3"};
		linkList = new JList<String>(items);				
		createPanels();	
		// set up split panes
		JSplitPane splitPane = new JSplitPane(
			JSplitPane.HORIZONTAL_SPLIT, linkList, cards);
		splitPane.setDividerLocation(50);
		//default layout for JFrame is BorderLayout; add method 
		//adds to contentpane
		add(splitPane, BorderLayout.CENTER);
	}

	
	/* Organize panels into a CardLayout */
	public void createPanels() {

        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Item 1 Panel");
        panel1.add(label1);
        
        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("Item 2 Panel");
        panel2.add(label2);
        
        JPanel panel3 = new JPanel();
        JLabel label3 = new JLabel("Item 3 Panel");
        panel3.add(label3);
		cards = new JPanel(new CardLayout());
		cards.add(panel1, "Item 1");
		cards.add(panel2, "Item 2");
		cards.add(panel3, "Item 3");
		
		//connect JList elements to CardLayout panels
		linkList.addListSelectionListener(event -> {
			String value = linkList.getSelectedValue().toString();
			CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, value);
		});

	}
	private static final long serialVersionUID = -760156396736751840L;
	
}
