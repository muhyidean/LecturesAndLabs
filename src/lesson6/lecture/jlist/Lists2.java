package lesson6.lecture.jlist;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * This is the same as Lists1 except a second JList is created
 * that used the same list model. Shows one of the advantages
 * of model-view separation.
 * @author pcorazza
 *
 */
public class Lists2 extends JFrame {
	private List<String> defaultList = new ArrayList<>();
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel listCopyPanel;
	private JList<String> listCopy;
	private JList<String> mainList;
	private JScrollPane mainScroll;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JLabel label;
	private JButton removeSelectedButton, addItemButton;
	private JTextField addField;
	public Lists2() {
		initializeWindow();
		initializeDefaultList();
		initializeModel(defaultList);
		mainPanel = new JPanel();
		defineTopPanel();
		defineMiddlePanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(middlePanel, BorderLayout.CENTER);	
		getContentPane().add(mainPanel);
	}
	private void initializeDefaultList() {
		defaultList.add("Red");
		defaultList.add("Blue");
		defaultList.add("Yellow");
	}
	private void defineMiddlePanel(){
		middlePanel=new JPanel();
		middlePanel.setLayout(new BorderLayout());
		mainList = createJList();
		mainList.setFixedCellWidth(70);
		mainScroll = new JScrollPane(mainList);
//		mainScroll.setPreferredSize(
//			new Dimension(mainScroll.getWidth() + 1, mainScroll.getHeight()));
		JPanel jListPanel = new JPanel();
		jListPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		jListPanel.add(mainScroll);
		
		//remove item components
		JPanel removeItemPanel = new JPanel();
		removeItemPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		removeSelectedButton = new JButton("Remove Selected");
		removeItemPanel.add(removeSelectedButton);
		
		
		//add item components
		JPanel addItemPanel = new JPanel();
		addItemPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		addItemButton = new JButton("Add Item");
		addField = new JTextField(10);
		addItemPanel.add(addItemButton);
		addItemPanel.add(addField);
		
		//arrange in middlePanel
		middlePanel.add(jListPanel, BorderLayout.NORTH);
		middlePanel.add(removeItemPanel, BorderLayout.CENTER);
		middlePanel.add(addItemPanel, BorderLayout.SOUTH);
		
		removeSelectedButton.addActionListener(new RemoveListener());
		addItemButton.addActionListener(new AddItemListener());		
	}
	
	private void initializeModel(List<String> vals) {
		for(String s : vals){
			listModel.addElement(s);
		}
	}
	private JList<String> createJList() {
		JList<String> ret = new JList<String>(listModel);
		ret.setVisibleRowCount(4);
		return ret;
	}
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("List Example 2");	
		centerFrameOnDesktop(this);
		//setSize(320,160); 
		setResizable(true);
	}
	public static Font makeSmallFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()-2));
    }

	
	public static void centerFrameOnDesktop(Component f) {
	        final int SHIFT_AMOUNT = 0;
	        Toolkit toolkit = Toolkit.getDefaultToolkit();
	        int height = toolkit.getScreenSize().height;
	        int width  = toolkit.getScreenSize().width;
	        int frameHeight = f.getSize().height;
	        int frameWidth  = f.getSize().width;
	        f.setLocation(((width-frameWidth)/2)-SHIFT_AMOUNT, (height-frameHeight)/3);    
	    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				Lists2 mf = new Lists2();
				mf.pack();
				mf.setVisible(true);
			}
		});
	}
	
	class AddItemListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			String newVal = addField.getText();
			listModel.addElement(newVal);
			System.out.println(listModel);
			addField.setText("");
		}
	}
	
	class RemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			List<String> selected = mainList.getSelectedValuesList();
			for(String s: selected) {
				listModel.removeElement(s);
				System.out.println(listModel);
				defaultList.remove(s);
			}
			
			
			/* use if list is made single-select
			String s = mainList.getSelectedValue();
			listModel.removeElement(s);
			*/
			
		}
	}

	private void defineTopPanel() {
		topPanel = new JPanel();
		defineCopyPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		topPanel.add(listCopyPanel);
		
	}
	private void defineCopyPanel() {
		
		JPanel topVal = new JPanel();
		JPanel bottomVal = new JPanel();
		topVal.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomVal.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
		listCopy = createJList();
		listCopy.setFont(makeSmallFont(listCopy.getFont()));
		label = new JLabel("List Copy");
		label.setFont(makeSmallFont(label.getFont()));
		topVal.add(listCopy);
		bottomVal.add(label);
		
		listCopyPanel = new JPanel();
		listCopyPanel.setLayout(new BorderLayout());
		listCopyPanel.add(topVal,BorderLayout.NORTH);
		listCopyPanel.add(bottomVal,BorderLayout.CENTER);
	}
	
	private static final long serialVersionUID = 3618976789175941431L;
}
