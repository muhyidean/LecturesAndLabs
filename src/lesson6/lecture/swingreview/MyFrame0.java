package lesson6.lecture.swingreview;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * This version of MyFrame illustrates some initialization, including
 * centering on the desktop and configuring window closing. It does
 * not add any components to the content pane.
 *
 */
public class MyFrame0 extends JFrame {

	public MyFrame0() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hello World");
		setResizable(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				MyFrame0 mf = new MyFrame0();				
				mf.setVisible(true);
			}
		});
	}

	private static final long serialVersionUID = 3618976789175941431L;
}
