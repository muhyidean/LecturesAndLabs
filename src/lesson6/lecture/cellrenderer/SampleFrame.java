package lesson6.lecture.cellrenderer;

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



import java.awt.FlowLayout;
import java.util.ArrayList;

/**
 * This sample code is like splitpane example, but also illustrates:
 * 
 * 4. Using a Cell Renderer to control the colors of the list items 
 * 
 * @author corazza
 *
 */
public class SampleFrame extends JFrame {
	
	String[] links;
	JList<ListItem> linkList;
	JPanel cards;
	JPanel buttonBar;

	// list items which will be added to the ListModel for linkList
	ListItem item1 = new ListItem("Item1", true);
	ListItem item2 = new ListItem("Item2", true);
	ListItem item3 = new ListItem("Item3", true);

	ListItem[] group1 = { item1, item2 };
	ListItem[] group2 = { item1, item3 };

	public ListItem[] getGroup1Items() {
		return group1;
	}

	public ListItem[] getGroup2Items() {
		return group2;
	}

	public JList<ListItem> getLinkList() {
		return linkList;
	}

	public SampleFrame() {

		setSize(300, 300);

		createLinkLabels();
		createMainPanels();
		createButtonBar();

		linkList.addListSelectionListener(event -> {
			String value = linkList.getSelectedValue().getItemName();
			boolean allowed = linkList.getSelectedValue().highlight();
			System.out.println(value + " " + allowed);

			//System.out.println("selected = " + value);
			CardLayout cl = (CardLayout) (cards.getLayout());

			if (!allowed) {
				value = item1.getItemName();
				linkList.setSelectedIndex(0);
			}
			cl.show(cards, value);
		});

		// set up split panes

		JSplitPane innerPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
				linkList, cards);

		innerPane.setDividerLocation(60);
		JSplitPane outerPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
				innerPane, buttonBar);
		outerPane.setDividerLocation(200);
		add(outerPane, BorderLayout.CENTER);
	}

	public void createButtonBar() {
		buttonBar = new JPanel();
		JButton left = new JButton("Item1 and Item2");
		addLeftButtonListener(left);
		JButton right = new JButton("Item1 and Item3");
		addRightButtonListener(right);
		buttonBar.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonBar.add(left);
		buttonBar.add(right);
	}

	public void addLeftButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			updateList(group1);
			repaint();
		});
	}
	
	public void addRightButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			updateList(group2);
			repaint();
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void updateList(ListItem[] items) {
		DefaultListModel<ListItem> model = (DefaultListModel) linkList.getModel();
		int size = model.getSize();
		if (items != null) {
			java.util.List<Integer> indices = new ArrayList<>();
			for (ListItem item : items) {
				int index = model.indexOf(item);
				indices.add(index);
				ListItem next = (ListItem) model.get(index);
				next.setHighlight(true);

			}
			for (int i = 0; i < size; ++i) {
				if (!indices.contains(i)) {
					ListItem next = (ListItem) model.get(i);
					next.setHighlight(false);
				}
			}
		} else {
			for (int i = 0; i < size; ++i) {
				ListItem next = (ListItem) model.get(i);
				next.setHighlight(true);
			}
		}
	}

	@SuppressWarnings("serial")
	public void createLinkLabels() {
	    DefaultListModel<ListItem> model = new DefaultListModel<>();
		model.addElement(item1);
		model.addElement(item2);
		model.addElement(item3);
	
		linkList = new JList<ListItem>(model);
	    linkList.setCellRenderer(new DefaultListCellRenderer() {

			@SuppressWarnings("rawtypes")
			@Override
			public Component getListCellRendererComponent(JList list, 
					Object value, int index,
					boolean isSelected, boolean cellHasFocus) {
				Component c = super.getListCellRendererComponent(list, 
						value, index, isSelected, cellHasFocus);
				if (value instanceof ListItem) {
					ListItem nextItem = (ListItem) value;
					setText(nextItem.getItemName());
					if (nextItem.highlight()) {
						setForeground(Util.LINK_AVAILABLE);
					} else {
						setForeground(Util.LINK_NOT_AVAILABLE);
					}
					if (isSelected) {
						setForeground(Color.BLACK);
						setBackground(new Color(236,243,245));
					}
				} else {
					setText("illegal item");
				}
				return c;
			}

		});
	}

	public void createMainPanels() {
		// item1 panel
		Item1Panel p1 = new Item1Panel();
		JPanel panel1 = p1.getMainPanel();

		// item2 panel
		Item2Panel p2 = new Item2Panel();
		JPanel panel2 = p2.getMainPanel();

		// item3 panel
		Item3Panel p3 = new Item3Panel();
		JPanel panel3 = p3.getMainPanel();

		cards = new JPanel(new CardLayout());
		cards.add(panel1, item1.getItemName());
		cards.add(panel2, item2.getItemName());
		cards.add(panel3, item3.getItemName());

	}

	static class Item1Panel {
		JPanel mainPanel = new JPanel();
		JLabel item1Label = new JLabel("Item 1 Panel");

		Item1Panel() {
			mainPanel.add(item1Label);
		}

		JPanel getMainPanel() {
			return mainPanel;
		}

	}

	static class Item2Panel {
		JPanel mainPanel = new JPanel();
		JLabel item2Label = new JLabel("Item 2 Panel");

		Item2Panel() {
			mainPanel.add(item2Label);
		}

		JPanel getMainPanel() {
			return mainPanel;
		}

	}

	static class Item3Panel {
		JPanel mainPanel = new JPanel();
		JLabel item3Label = new JLabel("Item 3 Panel");

		Item3Panel() {
			mainPanel.add(item3Label);
		}

		JPanel getMainPanel() {
			return mainPanel;
		}

	}
	private static final long serialVersionUID = -7438493168871970597L;
}
