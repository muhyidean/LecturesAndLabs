package lesson6.lecture.swingreview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class MyButtonListener implements ActionListener {
	JTextField text;
	public MyButtonListener(JTextField text) {
		this.text = text;
	}
	public void actionPerformed(ActionEvent evt){
		String textVal = text.getText();
		final String prompt = "Type a string";
		final String youWrote = "You wrote: ";
		if(textVal.equals("") || 
				textVal.equals(prompt) || 
				textVal.startsWith(youWrote)){
			
			text.setText(prompt);
		}
		else {
			text.setText(youWrote+"\""+textVal+"\".");
		}
	}
	
}
